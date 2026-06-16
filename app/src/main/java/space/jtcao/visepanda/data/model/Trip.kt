package space.jtcao.visepanda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A saved trip / itinerary.
 * Stored locally via DataStore — serialized as JSON.
 */
@Serializable
data class Trip(
    @SerialName("id") val id: String = "",
    @SerialName("title") val title: String = "",
    @SerialName("city") val city: String = "",
    @SerialName("days") val days: Int = 0,
    @SerialName("content") val content: String = "",
    @SerialName("created_at") val createdAt: Long = System.currentTimeMillis(),
    @SerialName("updated_at") val updatedAt: Long = System.currentTimeMillis()
)

/**
 * Map markers — from GET /api/map
 */
@Serializable
data class MapMarker(
    @SerialName("name") val name: String,
    @SerialName("name_cn") val nameCn: String = "",
    @SerialName("lat") val lat: Double = 0.0,
    @SerialName("lng") val lng: Double = 0.0,
    @SerialName("vibe") val vibe: String = "",
    @SerialName("days") val days: String = ""
)

@Serializable
data class MapData(
    @SerialName("cities") val cities: List<MapMarker> = emptyList()
)

/**
 * App configuration — from GET /api/config
 */
@Serializable
data class AppConfig(
    @SerialName("version") val version: String = "",
    @SerialName("map_center") val mapCenter: MapCenter? = null
)

@Serializable
data class MapCenter(
    @SerialName("lat") val lat: Double = 35.86,
    @SerialName("lng") val lng: Double = 104.19
)
