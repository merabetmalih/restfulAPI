import com.example.shakil.kotlinjsonexample.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}