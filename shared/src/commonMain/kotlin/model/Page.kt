package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class Page(
    val metadata: Metadata,
    val results: List<Result>,
)

@Serializable
data class Metadata(
    val page: Long,
    val total: Long,
    @JsonNames("per_page")
    val perPage: Long,
)

@Serializable
data class Result(
    @JsonNames("latest.school.name", "school.name")
    val latestSchoolName: String,
    @JsonNames("latest.cost.tuition.in_state")
    val latestCostTuitionInState: Long? = null,
    @JsonNames("latest.cost.tuition.out_of_state")
    val latestCostTuitionOutOfState: Long? = null,
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
    val overallMedianEarnings: Long? = null,
)
