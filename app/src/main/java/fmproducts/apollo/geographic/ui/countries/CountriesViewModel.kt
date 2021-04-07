package fmproducts.apollo.geographic.ui.countries

import GetContinentCountriesQuery
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import fmproducts.apollo.geographic.util.*
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val _continent = MutableLiveData<GetContinentCountriesQuery.Continent>()
    val continent: LiveData<GetContinentCountriesQuery.Continent> = _continent


    fun load(code: String) {
        viewModelScope.launch {
            mainActivity.showProgressBar()
            try {
                val response =
                    apolloClient.query(GetContinentCountriesQuery.builder().code(code).build())
                        .await()
                response.data?.continent()?.let {
                    _continent.value = it
                }
            } catch (e: ApolloException) {
                mainActivity.networkError()
            }
            mainActivity.hideProgressBar()
        }
    }

}