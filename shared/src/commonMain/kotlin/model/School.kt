package model

data class School (
    val name: String,
    val inStateTuition: Double?,
    val outStateTuition: Double?,
    val majors: List<String>?
)