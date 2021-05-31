

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tdm_exo8_s5.Model.Task
import com.example.tdm_exo8_s5.R

import kotlinx.android.synthetic.main.layout_task_item.view.*

class MyTaskAdapter(private val context: Context, private val movieList: MutableList<Task>): RecyclerView.Adapter<MyTaskAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_task_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            txt_name.text = movieList[position].title
            txt_date.text = movieList[position].id.toString()
        }


    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txt_name : TextView
        var txt_date : TextView


        init {

            txt_name = itemView.txt_name
            txt_date = itemView.txt_date

        }
    }
}