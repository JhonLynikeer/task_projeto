package com.trkgames.listadetarefas

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.trkgames.listadetarefas.databinding.ActivityMainBinding
import com.trkgames.listadetarefas.databinding.RowTaskBinding
import com.trkgames.listadetarefas.models.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row_task.*
import kotlinx.android.synthetic.main.row_task.view.*

class TaskAdapter (private val onItemClicked : (Task) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<Task> = ArrayList()
    var done: MutableList<Task> =   ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_task, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        when(holder){
            is TaskViewHolder ->{
                holder.bind(items[position], onItemClicked)

            }
        }

        holder.itemView.done_task.setOnClickListener {
            if (done.contains(items.get(position))) {
                done.remove(items.get(position))
                items.remove(items.get(position))
            } else {
               done.add(items.get(position))
            }

            Log.d("items", "itenns array \n $items \n done array \n $done")

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(task: Task){
        this.items.add(task)
        Log.d("items", "${done}")

    }

    class TaskViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val taskDescription = itemView.text_descricao
        private val taskUrgent = itemView.color_urgent
         val taskDone = itemView.done_task


        fun bind(task: Task, onItemClicked: (Task) -> Unit){
            taskDescription.text = task.descricao

            if (!task.urgent) taskUrgent.setBackgroundColor(Color.parseColor("#DF0101"))

            itemView.setOnClickListener{
                onItemClicked(task)
            }

        }

    }

}



