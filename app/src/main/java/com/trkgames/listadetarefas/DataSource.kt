package com.trkgames.listadetarefas


import com.trkgames.listadetarefas.models.Task

class DataSource {

    companion object {

        fun createDataSet(description: String, urgent: Boolean, done: Boolean): Task{

                return Task (
                   description,
                    urgent,
                    done
                )
        }

    }

}