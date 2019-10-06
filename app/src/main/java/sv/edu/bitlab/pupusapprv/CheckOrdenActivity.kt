package sv.edu.bitlab.pupusapprv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.ModeloDeDatos

class CheckOrdenActivity : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador: AdapterRVCheckOrden? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var botonEnviar: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_orden)

        val ordenPupusas = ArrayList<ModeloDeDatos>()


    }
}
