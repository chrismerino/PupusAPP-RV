package sv.edu.bitlab.pupusapprv.Network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.ModeloDeDatos
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.Orden
import sv.edu.bitlab.pupusapprv.ModeloDeDatos.OrdenPupusas
import sv.edu.bitlab.pupusapprv.Relleno

interface PupusasApiService {
    @GET("rellenos/")
    fun getRellenos() : Call<List<Relleno>>

    @POST("ordens/")
    fun submitOrden(@Body params: Orden, @Path("id") id:Int) : Call<Orden>
}
