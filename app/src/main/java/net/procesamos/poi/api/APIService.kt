import net.procesamos.poi.model.POIsModels
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("POIs")
    fun getPOIs(): Call<MutableList<POIsModels>>
}