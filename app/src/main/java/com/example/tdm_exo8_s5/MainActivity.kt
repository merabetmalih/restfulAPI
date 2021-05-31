package com.example.tdm_exo8_s5

import MyTaskAdapter
import RetrofitService
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tdm_exo8_s5.Model.Task
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyTaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mService = Common.retrofitService

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        //dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllTaskList()
    }

    private fun getAllTaskList() {
        // dialog.show()

        mService.getTaskList().enqueue(object : Callback<MutableList<Task>> {
            override fun onFailure(call: Call<MutableList<Task>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Task>>, response: Response<MutableList<Task>>) {
                adapter = MyTaskAdapter(baseContext, response.body() as MutableList<Task>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter


            }

        })
    }
}