package sv.edu.bitlab.pupusapprv.RecyclerViewRelleno

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno
import sv.edu.bitlab.pupusapprv.R

class RellenosListAdapter(var rellenos: List<Relleno>, val listener: RellenoViewHolder.RellenoViewHolderListener) : RecyclerView.Adapter<RellenoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RellenoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.relleno_item_view_holder, parent, false)
        return RellenoViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return rellenos.size
    }

    override fun onBindViewHolder(holder: RellenoViewHolder, position: Int) {
        holder.bindData(rellenos[position])
    }
}