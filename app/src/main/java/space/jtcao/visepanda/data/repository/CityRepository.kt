package space.jtcao.visepanda.data.repository

import kotlinx.serialization.json.Json
import space.jtcao.visepanda.data.api.ApiConfig
import space.jtcao.visepanda.data.model.City
import space.jtcao.visepanda.data.model.CityDetail
import space.jtcao.visepanda.data.model.MapData
import java.net.URL

/**
 * Repository for city and map data — fetched from the VisePanda API.
 *
 * Uses simple URL connections (no Retrofit needed for GET requests).
 * The API returns JSON that maps directly to our data models.
 */
class CityRepository {

    private val json = Json { ignoreUnknownKeys = true }

    /** Fetch all cities */
    suspend fun getCities(): List<City> {
        val url = URL("${ApiConfig.BASE_URL}/api/cities")
        val response = url.readText()
        return json.decodeFromString(response)
    }

    /** Fetch city detail */
    suspend fun getCityDetail(city: String): CityDetail {
        val url = URL("${ApiConfig.BASE_URL}/api/cities/$city")
        val response = url.readText()
        return json.decodeFromString(response)
    }

    /** Fetch map markers */
    suspend fun getMapData(): MapData {
        val url = URL("${ApiConfig.BASE_URL}/api/map")
        val response = url.readText()
        return json.decodeFromString(response)
    }

    /** Build image URL for a city */
    fun getCityImageUrl(cityName: String): String {
        return "${ApiConfig.BASE_URL}/static/img/city-$cityName.jpg"
    }
}
