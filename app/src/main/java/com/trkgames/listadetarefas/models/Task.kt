package com.trkgames.listadetarefas.models

data class Task(
    var descricao: String,
    var urgent: Boolean,
    var done: Boolean
)
