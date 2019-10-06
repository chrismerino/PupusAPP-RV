package sv.edu.bitlab.pupusapprv.ModeloDeDatos

import android.os.Parcel
import android.os.Parcelable

class OrdenTomada(): Parcelable {

    var precioUnidad = 0.5F
    var textInput = ""
    var maiz = hashMapOf(
        QUESO to 0,
        FRIJOLES to 0,
        REVUELTAS to 0
    )
    var arroz = hashMapOf(
        QUESO to 0,
        FRIJOLES to 0,
        REVUELTAS to 0
    )

    // PARCELABLE

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeFloat(this.precioUnidad)
        dest.writeInt(maiz[QUESO]!!)
        dest.writeInt(maiz[FRIJOLES]!!)
        dest.writeInt(maiz[REVUELTAS]!!)
        dest.writeInt(arroz[QUESO]!!)
        dest.writeInt(arroz[FRIJOLES]!!)
        dest.writeInt(arroz[REVUELTAS]!!)
    }

    constructor(parcel: Parcel) : this() {
        precioUnidad = parcel.readFloat()
        maiz[QUESO] = parcel.readInt()
        maiz[FRIJOLES] = parcel.readInt()
        maiz[REVUELTAS] = parcel.readInt()
        arroz[QUESO] = parcel.readInt()
        arroz[FRIJOLES] = parcel.readInt()
        arroz[REVUELTAS] = parcel.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getTotal(): Float {
        val totalDeMaiz = maiz.map { entry ->
            entry.value
        }.reduce { total, counter -> total + counter }

        val totalDeArroz = arroz.map { entry ->
            entry.value
        }.reduce {total, counter -> total + counter}

        return (totalDeArroz * precioUnidad) + (totalDeMaiz * precioUnidad)
    }

    companion object CREATOR : Parcelable.Creator<OrdenTomada> {
        const val QUESO = "QUESO"
        const val FRIJOLES = "FRIJOLES"
        const val REVUELTAS = "REVUELTAS"
        const val MAIZ = "MAIZ"
        const val ARROZ = "ARROZ"

        override fun createFromParcel(parcel: Parcel): OrdenTomada {
            return OrdenTomada(parcel)
        }


        override fun newArray(size: Int): Array<OrdenTomada?> {
            return arrayOfNulls(size)
        }



        // CREANDO ORDENES RANDOM
        // DATOS LOCALES PARA TESTING

        fun randomOrders(): ArrayList<OrdenTomada>{
            var lista = arrayListOf<OrdenTomada>()

            for (index in 0 .. 10){
                val orden = OrdenTomada()
                val diasRandom = (Math.random() * 10).toInt()

                orden.maiz[QUESO] = (Math.random() *10 ).toInt()
                orden.maiz[FRIJOLES] = (Math.random() *10 ).toInt()
                orden.maiz[REVUELTAS] = (Math.random() *10 ).toInt()
                orden.arroz[QUESO] = (Math.random() *10 ).toInt()
                orden.arroz[FRIJOLES] = (Math.random() *10 ).toInt()
                orden.arroz[REVUELTAS] = (Math.random() *10 ).toInt()
                lista.add(orden)
            }
            return lista
        }


    }
}