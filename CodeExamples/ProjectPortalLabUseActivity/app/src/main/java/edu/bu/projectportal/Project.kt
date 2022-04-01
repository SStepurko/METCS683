package edu.bu.projectportal

data class Project(val id: Int, var title: String, var description: String, var author: String,
                   var gitLink: String, var isFavorite: Boolean, val keywords: List<Keyword> ){
    companion object {
        var project = Project(0, "Weather Forecast",
            "Weather Forecast is an app ...", "Sergei",
            "https://github.com/CS683/metcs683labs-SStepurko", true,
        listOf(Keyword("CS683", false), Keyword("Sergei", false), Keyword("Week2", false)))
    }

//        var projects = listOf(
//            Project(0, "Weather Forecast", "Weather Forecast is an app ..."),
//            Project(1, "Connect Me", "Connect Me is an app ... "),
//            Project(2, "What to Eat", "What to Eat is an app ..."),
//            Project(3, "Project Portal", "Project Portal is an app ..."))
//    }
}

data class Keyword(val name: String, var isChecked: Boolean)