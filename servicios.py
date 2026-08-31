class Cuenta:
    def __init__(self, numero, saldo=0):
        self.numero = numero
        self._saldo = saldo

    def depositar(self, monto):
        if monto > 0:
            self._saldo += monto

    def debitar(self, monto):
        pass

    def obtenerSaldo(self):
        pass


class CuentaAhorros(Cuenta):
    def __init__(self, numero, saldo=0):
        super().__init__(numero, saldo)

    def debitar(self, monto):
        if 0 < monto <= self._saldo:
            self._saldo -= monto
            return True
        return False

    def obtenerSaldo(self):
        return self._saldo


class CuentaCorriente(Cuenta):
    def __init__(self, numero, saldo=0, sobregiro=200000):
        super().__init__(numero, saldo) 
        self.sobregiro = sobregiro

    def debitar(self, monto):
        total_disponible = self._saldo + self.sobregiro
        if 0 < monto <= total_disponible:
            self._saldo -= monto
            return True
        return False

    def obtenerSaldo(self):
        return self._saldo + self.sobregiro


class Factura:
    def __init__(self, numero, servicio, monto):
        self.numero = numero
        self.servicio = servicio
        self.monto = monto
        self.estado = "Pendiente"

    def pagar(self):
        self.estado = "Pagada"


class Pago:
    def __init__(self, id_pago, cuenta, facturas, monto):
        self.id_pago = id_pago
        self.cuenta = cuenta
        self.facturas = facturas
        self.monto = monto


class Cliente:
    def __init__(self, id_cliente, nombre):
        self.id_cliente = id_cliente
        self.nombre = nombre
        self.cuentas = []
        self.facturas = []
        self.pagos = []


contador_pagos = 1
def procesarPago(cliente, cuenta, facturas):
    global contador_pagos

    pendientes = [factura for factura in facturas if factura.estado == "Pendiente"]
    if not pendientes:
        print("No hay facturas pendientes.")
        return False

    total = sum(factura.monto for factura in pendientes)

    if cuenta.debitar(total):
        for factura in pendientes:
            factura.pagar()

        pago = Pago(f"PAG-{contador_pagos}", cuenta, pendientes, total)
        contador_pagos += 1
        cliente.pagos.append(pago)

        print(f"Pago realizado con exito por ${total}")
        return True
    else:
        print(f"Saldo insuficiente en la cuenta {cuenta.numero} para pagar ${total}")
        return False


def obtenerSaldoCuenta(cuenta):
    return cuenta.obtenerSaldo()


def obtenerPagosPorCliente(cliente):
    return cliente.pagos


def ObtenerFacturasPorCliente(cliente, solo_pendientes=False):
    if solo_pendientes:
        return [factura for factura in cliente.facturas if factura.estado == "Pendiente"]
    return cliente.facturas


if True:
    cliente = Cliente("1", "Carlos Perez")

    ahorros = CuentaAhorros("Ahorros-01", 100000)
    corriente = CuentaCorriente("Corriente-01", 50000, 150000)
    cliente.cuentas.extend([ahorros, corriente])

    f1 = Factura("Factura-1", "Luz", 60000)
    f2 = Factura("Factura-2", "Agua", 30000)
    f3 = Factura("Factura-3", "Gas", 70000)
    cliente.facturas.extend([f1, f2, f3])

    print(f"Saldo inicial Ahorros: ${obtenerSaldoCuenta(ahorros)}")
    print(f"Saldo inicial Corriente: ${obtenerSaldoCuenta(corriente)}")

    print("PROCESAR PAGO CON AHORROS")
    procesarPago(cliente, ahorros, [f1, f2])
    print(f"Saldo restante Ahorros: ${obtenerSaldoCuenta(ahorros)}")

    print("PROCESAR PAGO CON CORRIENTE")
    procesarPago(cliente, corriente, [f3])
    print(f"Saldo restante Corriente: ${obtenerSaldoCuenta(corriente)}")

    print("HISTORIAL DE PAGOS DEL CLIENTE")
    for pagar in obtenerPagosPorCliente(cliente):
        facs = ", ".join(factura.servicio for factura in pagar.facturas)
        print(f"ID: {pagar.id_pago} | Cuenta: {pagar.cuenta.numero} | Monto: ${pagar.monto} | Servicios: {facs}")

    print("ESTADO DE LAS FACTURAS")
    for factura in ObtenerFacturasPorCliente(cliente):
        print(f"{factura.servicio} (${factura.monto}) -> {factura.estado}")
