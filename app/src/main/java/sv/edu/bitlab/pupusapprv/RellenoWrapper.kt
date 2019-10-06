package sv.edu.bitlab.pupusapprv

data class RellenoWrapper (var rellenos: List<Relleno>) {
}

data class Relleno(var nombre: String, var id: Int)