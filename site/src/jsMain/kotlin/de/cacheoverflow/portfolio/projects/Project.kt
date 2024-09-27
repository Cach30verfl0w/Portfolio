package de.cacheoverflow.portfolio.projects

data class Project(
    val name: String,
    val url: String?,
    val icon: String?,
    val languages: List<EnumLanguage>,
    val description: String
)
