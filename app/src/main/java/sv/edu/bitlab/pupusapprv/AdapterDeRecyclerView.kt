package sv.edu.bitlab.pupusapprv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.Pupusa

class AdapterDeRecyclerView (var contexto: Context,items: ArrayList<Pupusa>) : RecyclerView.Adapter<AdapterDeRecyclerView.ViewHolder>() {

    var items: ArrayList<Pupusa>? = null

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
        holder.nombre?.text = item?.nombre
        holder.precio?.text = item?.precio.toString()
        holder.cantidad?.text = item?.cantidad.toString()

    }


    class ViewHolder (vista: View): RecyclerView.ViewHolder(vista){
        var nombre: TextView? = null
        var precio: TextView? = null
        var cantidad: TextView? = null

        init {
            nombre = vista.findViewById(R.id.textViewTitulo)
            precio = vista.findViewById(R.id.textViewPrecio)
            cantidad = vista.findViewById(R.id.textViewCantidad)

        }

    }


}