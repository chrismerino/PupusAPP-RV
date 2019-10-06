package sv.edu.bitlab.pupusapprv.RecyclerViewRelleno

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno
import sv.edu.bitlab.pupusapprv.R

class RellenoViewHolder (itemViem: View, val listener: RellenoViewHolderListener): RecyclerView.ViewHolder(itemViem) {
    private lateinit var maizButton : Button
    private lateinit var arrozButton : Button

    fun bindData (relleno: Relleno){
        maizButton = itemView.findViewById(R.id.botonMaiz)
        arrozButton = itemView.findViewById(R.id.botonArroz)

        maizButton.text = relleno.nombre
        arrozButton.text = relleno.nombre

        maizButton.setOnClickListener{ listener.onMaizClick(relleno.nombre)}
        arrozButton.setOnClickListener{ listener.onArrozClick(relleno.nombre)}
    }

    interface RellenoViewHolderListener {
        fun onCounterButtonClick(relleno: String, masa: String)

        fun onMaizClick(relleno: String)

        fun onArrozClick(relleno: String)
    }
}