package sv.edu.bitlab.pupusapprv.ModeloDeDatos

// Modelo de datos

class ModeloDeDatos (nombreArroz: String, precioArroz: Int, cantidadArroz: Int, nombreMaiz: String, precioMaiz: Int, cantidadMaiz: Int) {


    var nombreArroz = ""
    var precioArroz = 0
    var cantidadArroz = 0
    var nombreMaiz = ""
    var precioMaiz = 0
    var cantidadMaiz = 0


    init {
        this.nombreArroz = nombreArroz
        this.precioArroz = precioArroz
        this.cantidadArroz = cantidadArroz
        this.nombreMaiz = nombreMaiz
        this.precioMaiz = precioMaiz
        this.cantidadMaiz = cantidadMaiz
    }

}