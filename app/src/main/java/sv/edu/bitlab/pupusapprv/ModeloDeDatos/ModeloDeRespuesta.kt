package sv.edu.bitlab.pupusapprv.ModeloDeDatos

import sv.edu.bitlab.pupusapprv.Relleno

data class RellenoWrapper (var rellenos: List<Relleno>)
data class Relleno(var nombre: String, var id: Int)
data class OrdenPupusas(var relleno: sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno, var total: Int)
data class Orden(var id: Int,
                 var status: String,
                 var arroz: List<OrdenPupusas>,
                 var maiz: List<OrdenPupusas>,
                 var precio_unidad: Float,
                 var total: Float)
data class OrdenesWrapper (var page_size: Int, var page: Int, var ordenes: List<Orden>)
data class OrdenWrapper(var orden: Orden)