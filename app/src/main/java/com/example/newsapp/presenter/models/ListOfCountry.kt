package com.example.newsapp.presenter.models

import javax.inject.Inject

interface ListOfCountry {

    fun getList(): Array<String>

    fun getCodeOfCountry(country: String): String

    fun getNameOfCountry(code: String): String
}

class ListOfCountryImpl() : ListOfCountry {

    private val listOfCountry = arrayOf(
        "United Arab Emirates", "Argentina", "Austria", "Australia", "Belgium", "Bulgaria",
        "Brazil", "Canada", "Switzerland", "China", "Colombia", "Cuba", "Czechia", "Germany",
        "Egypt", "France", "United Kingdom", "Greece", "Hong Kong", "Hungary", "Indonesia",
        "Ireland", "Israel", "India", "Italy", "Japan", "North Korea", "Lithuania", "Latvia",
        "Morocco", "Mexico", "Malaysia", "Nigeria", "Netherlands", "Norway", "New Zealand",
        "Philippines", "Poland", "Portugal", "Romania", "Serbia", "Saudi Arabia", "Sweden",
        "Singapore", "Slovenia", "Slovakia","Thailand", "Turkey", "Taiwan", "Ukraine", "USA",
        "Venezuela", "South Africa")
    private val codeOfCountry = arrayOf("ae","ar","at","au","be","bg","br","ca","ch","cn","co","cu",
        "cz","de","eg","fr","gb","gr","hk","hu","id","ie","il","in","it","jp","kr","lt","lv","ma",
        "mx","my","ng","nl","no","nz","ph","pl","pt","ro","rs","sa","se","sg","si","sk","th","tr",
        "tw","ua","us","ve","za" )

    override fun getList() = listOfCountry

    override fun getCodeOfCountry(country: String) = codeOfCountry[listOfCountry.indexOf(country)]

    override fun getNameOfCountry(code: String) = listOfCountry[codeOfCountry.indexOf(code)]

}
