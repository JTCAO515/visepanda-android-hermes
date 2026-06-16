package space.jtcao.visepanda.data.repository

import kotlinx.serialization.json.Json
import space.jtcao.visepanda.data.api.ApiConfig
import space.jtcao.visepanda.data.model.MapData
import space.jtcao.visepanda.data.model.MapMarker
import java.net.URL

/**
 * Repository for map data — coordinates of all 36 cities in China.
 */
class MapRepository {

    private val json = Json { ignoreUnknownKeys = true }

    /** Fetch all city markers with coordinates */
    suspend fun getMapData(): MapData {
        val url = URL("${ApiConfig.BASE_URL}/api/map")
        val response = url.readText()
        return json.decodeFromString(response)
    }

    /** Convenience: get markers as a flat list */
    suspend fun getMarkers(): List<MapMarker> {
        return getMapData().cities
    }
}
