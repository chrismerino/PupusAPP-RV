package sv.edu.bitlab.pupusapprv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.Pupusa

class MainActivity : AppCompatActivity() {


    var lista: RecyclerView? = null
    var adaptador: AdapterDeRecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null


    var botonEnviar: Button? = null
    var botonMinus: Button? = null
    var botonPlus: Button? = null
    var textViewCantidad : Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderPupusas = ArrayList<Pupusa>()
        textViewCantidad?.findViewById<Button>(R.id.textViewCantidad)


        for (i in 1..10000){
            orderPupusas.add(Pupusa("Orden $i", 20, 4))
        }

        botonEnviar?.findViewById<Button>(R.id.boton_enviar)
        botonEnviar?.setOnClickListener{
        }


        botonMinus?.findViewById<Button>(R.id.buttonMinus)
        botonMinus?.setOnClickListener{
            orderPupusas.remove(Pupusa("", 0, -1))
        }

        botonPlus?.findViewById<Button>(R.id.buttonPlus)
        botonPlus?.setOnClickListener{
            orderPupusas.add(Pupusa("", 0, +1))

        }




        lista = findViewById(R.id.recycler_view_lista_en_main_activity)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

//        botonEnviar = findViewById(R.id.boton_enviar)
//
//        botonEnviar?.setOnClickListener{
//            for (i in 1..100){
//                informacionArrayListUno?.add(i.toString())
//                informacionArrayListDos?.add(i.toString())
//            }
//        }

        adaptador = AdapterDeRecyclerView(this, orderPupusas)
        lista?.adapter = adaptador




    }
}
