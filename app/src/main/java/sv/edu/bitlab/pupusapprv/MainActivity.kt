package sv.edu.bitlab.pupusapprv

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.OrdenTomada
import sv.edu.bitlab.pupusapprv.Network.ApiService
import sv.edu.bitlab.pupusapprv.RecyclerViewRelleno.RellenoViewHolder
import sv.edu.bitlab.pupusapprv.RecyclerViewRelleno.RellenosListAdapter
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(),
    RellenoViewHolder.RellenoViewHolderListener,
    RellenoFragmentDialog.OnRellenoFragmentInteraction {


    override fun onCounterButtonClick(relleno: String, masa: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMaizClick(relleno: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onArrozClick(relleno: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var rellenos = arrayListOf<sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno>()
    private lateinit var rellenosList: RecyclerView


    override fun onButtonClicked(relleno: String){
        rellenos.add(sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno(relleno, -1))
        val adapter = rellenosList.adapter as RellenosListAdapter
        adapter.notifyDataSetChanged()
    }

    val orden = OrdenTomada()

    val pupusaStringResources = hashMapOf(
        QUESO to R.string.pupusa_queso,
        FRIJOLES to R.string.frijol_con_queso,
        REVUELTAS to R.string.revueltas
    )

    var botonesMaiz = hashMapOf<String, Button>()
    var botonesArroz = hashMapOf<String, Button>()

    var loadingContainer: View? = null

    override fun onBackPressed() {
        super.onBackPressed()
    }





    ////////////////////////////////////////


//    var lista: RecyclerView? = null
//    var adaptador: AdapterRVCheckOrden? = null
//    var layoutManager: RecyclerView.LayoutManager? = null
//
//
//    var botonEnviar: Button? = null
//    var botonMinus: Button? = null
//    var botonPlus: Button? = null
//    var textViewCantidad : Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val orderPupusas = ArrayList<ModeloDeDatos>()
//        textViewCantidad?.findViewById<Button>(R.id.textViewCantidad)
//
//
//        for (i in 0..50){
//            orderPupusas.add(ModeloDeDatos("Orden $i", 20, 4))
//        }
//
//        lista = findViewById(R.id.recycler_view_lista_en_main_activity)
//        lista?.setHasFixedSize(true)
//
//        layoutManager = LinearLayoutManager(this)
//        lista?.layoutManager = layoutManager
//
//
//        adaptador = AdapterRVCheckOrden(this, orderPupusas)
//        lista?.adapter = adaptador

        // RV

        val orden = OrdenTomada()
        val loadingContainer = findViewById<View>(R.id.loadingContainer)
        rellenosList = findViewById(R.id.rv_listaDeBotones)
        rellenosList.layoutManager = LinearLayoutManager(this)
        rellenosList.adapter = RellenosListAdapter(
            arrayListOf<sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno>(),
            listener = this
        )
        loadingContainer.visibility = View.VISIBLE

        //Dialog error en caso hay error

        ApiService.create().getRellenos().enqueue(object : retrofit2.Callback<List<Relleno>> {
            override fun onFailure(call: Call<List<Relleno>>, t: Throwable) {
                loadingContainer.visibility = View.GONE
                AlertDialog.Builder(getContent())
                    .setTitle("OOPS!")
                    .setMessage("Even things we love break sometimes :(")
                    .setNeutralButton("Ok", null)
                    .create()
                    .show()
            }


            override fun onResponse(
                call: Call<List<Relleno>>,
                response: Response<List<Relleno>>
            ) {
                loadingContainer.visibility = View.GONE
                rellenos = response.body()!! as ArrayList<sv.edu.bitlab.pupusapprv.ModeloDeDatos.Relleno>
                val adapter = rellenosList?.adapter as RellenosListAdapter
                adapter.rellenos = rellenos
                adapter.notifyDataSetChanged()
            }
        })

        //setSupportActionBar(findViewById(R.id.mainToolbar))
    }

    fun  getContent(): Context {
        return this
    }

/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }*/

/*    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.historial -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }

            R.id.new_relleno -> {
                val rellenoDialogo = RellenoFragmentDialogo.newInstance()
                rellenoDialogo.show(supportFragmentManager, "RELLENO_FRAGMENT")
            }
            R.id.precio_unidad -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }*/

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

    }

    companion object{
        const val MAIZ = "MAIZ"
        const val ARROZ = "ARROZ"
    }
}
