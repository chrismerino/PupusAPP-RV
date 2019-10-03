package sv.edu.bitlab.pupusapprv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var informacionArrayList: ArrayList<String>
    private lateinit var recyclerViewLista: RecyclerView
    private lateinit var layout: RecyclerView.LayoutManager
    private lateinit var varAdapter: AdapterDeRecyclerView
    private lateinit var botonEnviar: Button
    private lateinit var botonUno: Button
    private lateinit var botonDos: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewLista = findViewById(R.id.recycler_view_lista_en_main_activity)
        layout = LinearLayoutManager(this)
        varAdapter = AdapterDeRecyclerView(ArrayList())

        botonEnviar = findViewById(R.id.boton_enviar)

        botonEnviar.setOnClickListener {
            for (i in 1..100){
                informacionArrayList.add(i.toString())
            }
        }


        recyclerViewLista.layoutManager = layout
        recyclerViewLista.adapter = AdapterDeRecyclerView(informacionArrayList)


    }
}
