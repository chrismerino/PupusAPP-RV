package sv.edu.bitlab.pupusapprv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.ModeloDeDatos

class AdapterRVCheckOrden (var contexto: Context, items: ArrayList<ModeloDeDatos>) : RecyclerView.Adapter<AdapterRVCheckOrden.ViewHolder>() {

    var items: ArrayList<ModeloDeDatos>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.blueprint_orden_pupusas, parent, false)
        val viewHolder = ViewHolder(vista)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.nombreArroz?.text = item?.nombreArroz
        holder.precioArroz?.text = item?.precioArroz.toString()
        holder.cantidadArroz?.text = item?.cantidadArroz.toString()
        holder.nombreMaiz?.text = item?.nombreArroz
        holder.precioMaiz?.text = item?.precioArroz.toString()
        holder.cantidadMaiz?.text = item?.cantidadArroz.toString()

    }


    class ViewHolder (vista: View): RecyclerView.ViewHolder(vista){
        var nombreArroz: TextView? = null
        var precioArroz: TextView? = null
        var cantidadArroz: TextView? = null
        var nombreMaiz: TextView? = null
        var precioMaiz: TextView? = null
        var cantidadMaiz: TextView? = null

        init {
            nombreArroz = vista.findViewById(R.id.textViewTitulo)
            precioArroz = vista.findViewById(R.id.textViewPrecio)
            cantidadArroz = vista.findViewById(R.id.textViewCantidad)

        }

    }


}