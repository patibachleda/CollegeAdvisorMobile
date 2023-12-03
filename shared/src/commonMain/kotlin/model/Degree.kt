package model

import kotlinx.serialization.Serializable

@Serializable
data class Degree (
    val name: String,
    val oneYearEarning: Int?
)