package space.jtcao.visepanda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * City summary — from GET /api/cities
 */
@Serializable
data class City(
    @SerialName("name") val name: String,           // e.g. "beijing"
    @SerialName("name_cn") val nameCn: String = "",  // e.g. "北京"
    @SerialName("province") val province: String = "",
    @SerialName("best_season") val bestSeason: String = "",
    @SerialName("days") val days: String = "",
    @SerialName("vibe") val vibe: String = "",
    @SerialName("highlights") val highlights: String = "",
    @SerialName("budget_tip") val budgetTip: String = "",
    @SerialName("image") val image: String = ""      // "/static/img/city-beijing.jpg"
)

/**
 * City detail — from GET /api/cities/{city}
 */
@Serializable
data class CityDetail(
    @SerialName("city") val city: City = City(""),
    @SerialName("attractions") val attractions: List<Attraction> = emptyList(),
    @SerialName("food") val food: List<FoodItem> = emptyList(),
    @SerialName("hotels") val hotels: List<HotelSuggestion> = emptyList(),
    @SerialName("tips") val tips: Tips = Tips(),
    @SerialName("estimates") val estimates: PriceEstimate = PriceEstimate()
)

@Serializable
data class Attraction(
    @SerialName("name") val name: String = "",
    @SerialName("name_cn") val nameCn: String = "",
    @SerialName("type") val type: String = "",
    @SerialName("description") val description: String = "",
    @SerialName("price") val price: String = "",
    @SerialName("time") val time: String = "",
    @SerialName("tips") val tips: String = "",
    @SerialName("rating") val rating: Double = 0.0
)

@Serializable
data class FoodItem(
    @SerialName("name") val name: String = "",
    @SerialName("name_cn") val nameCn: String = "",
    @SerialName("description") val description: String = "",
    @SerialName("price_range") val priceRange: String = "",
    @SerialName("must_try") val mustTry: Boolean = false,
    @SerialName("rating") val rating: Double = 0.0
)

@Serializable
data class HotelSuggestion(
    @SerialName("area") val area: String = "",
    @SerialName("area_cn") val areaCn: String = "",
    @SerialName("price_range") val priceRange: String = "",
    @SerialName("description") val description: String = "",
    @SerialName("pros") val pros: String = ""
)

@Serializable
data class Tips(
    @SerialName("transport") val transport: String = "",
    @SerialName("best_time") val bestTime: String = "",
    @SerialName("language") val language: String = "",
    @SerialName("culture") val culture: String = "",
    @SerialName("safety") val safety: String = "",
    @SerialName("local_tips") val localTips: String = ""
)

@Serializable
data class PriceEstimate(
    @SerialName("budget") val budget: String = "",
    @SerialName("mid_range") val midRange: String = "",
    @SerialName("luxury") val luxury: String = "",
    @SerialName("daily_avg") val dailyAvg: String = "",
    @SerialName("currency") val currency: String = "CNY"
)
