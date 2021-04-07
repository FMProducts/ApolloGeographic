package fmproducts.apollo.geographic.ui.continents

import androidx.lifecycle.ViewModel
import GetContinentsQuery
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import fmproducts.apollo.geographic.util.*
import kotlinx.coroutines.launch

class ContinentsViewModel: ViewModel(){
    private val _continents = MutableLiveData<List<GetContinentsQuery.Continent>>()
    val continents: LiveData<List<GetContinentsQuery.Continent>> = _continents
    fun load() {
        mainActivity.showProgressBar()
        viewModelScope.launch {
            try {
                val response = apolloClient.query(GetContinentsQuery.builder().build()).await()
                response.data?.let { _continents.value = it.continents() }
            }
            catch (e: ApolloException){
                mainActivity.networkError()
            }
            mainActivity.hideProgressBar()
        }
    }
}
