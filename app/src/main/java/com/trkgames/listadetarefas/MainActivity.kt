package com.trkgames.listadetarefas

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.View
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.trkgames.listadetarefas.databinding.ActivityMainBinding
import com.trkgames.listadetarefas.models.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_task.*


class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclearViwer()


        binding.buttonAdd.setOnClickListener {

            addDataSoucer()
            atualizarDados()

        }

        check_not_done.setOnCheckedChangeListener(this)

    }

    private fun addDataSoucer() {

        val dataSource = DataSource.createDataSet(binding.edittextTask.text.toString(), urgentTask(), false)
        binding.edittextTask.setText("")

        this.taskAdapter.setDataSet(dataSource)
    }

    private fun urgentTask():Boolean {
        var urgent = true
        if (switch_urgent.isChecked){
            urgent = false
        } else {
            urgent = true
        }

        return urgent
    }

    private fun atualizarDados(){

        binding.recycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }



    }

    private fun initRecyclearViwer() {

         this.taskAdapter = TaskAdapter({task ->

        })

        binding.recycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }


    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (check_not_done.isChecked){
            println("ativado")
            atualizarDados()
        }else {
            atualizarDados()
            println("desaativado")
        }
    }


}


