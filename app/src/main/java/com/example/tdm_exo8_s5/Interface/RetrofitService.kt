

import com.example.tdm_exo8_s5.Model.Task
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/todos")
    fun getTaskList(): Call<MutableList<Task>>
}