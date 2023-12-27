package model.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNames

// General metadata at beginning of response
@Serializable
data class Metadata(
    val page: Long,
    val total: Long,
    @JsonNames("per_page")
    val perPage: Long,
)


// For call to get schools in DropDown
@Serializable
data class SchoolPage(
    val metadata: Metadata,
    val results: List<SchoolTitle>,
)

@Serializable
data class SchoolTitle(
    @JsonNames("latest.school.name", "school.name")
    val latestSchoolName: String
)

// For call to get majors in DropDown
@Serializable
data class MajorPage(
    val metadata: Metadata,
    val results: List<ResultList>
)

@Serializable
data class ResultList(
    @JsonNames("latest.programs.cip_4_digit")
    val latestProgramsCip4Digit: List<Major>? = null,
)

@Serializable
data class Major(
    val title: String,
    val code: String,
)

// For call to get results in Results screen
@Serializable
data class ResultPage(
    val metadata: Metadata,
    val results: List<Results>
)

@Serializable
data class Results(
    @JsonNames("latest.school.name", "school.name")
    val latestSchoolName: String,
    @JsonNames("latest.cost.tuition.in_state")
    val latestCostTuitionInState: Float? = null,
    @JsonNames("latest.cost.tuition.out_of_state")
    val latestCostTuitionOutOfState: Float? = null,
    @JsonNames("latest.aid.median_debt.number.overall")
    val latestAidMedianDebtNumberOverall: Float? = null,
    @JsonNames("latest.programs.cip_4_digit")
    val latestProgramsCip4Digit: List<LatestProgramsCip4Digit>? = null,
)

@Serializable
data class LatestProgramsCip4Digit(
    val title: String,
    val earnings: Earnings? = null,
)

@Serializable
data class Earnings(
    @JsonNames("1_yr")
    val n1Yr: n1Yr,
)

@Serializable
data class n1Yr(
    @JsonNames("overall_median_earnings")
    val overallMedianEarnings: Float? = null,
)
