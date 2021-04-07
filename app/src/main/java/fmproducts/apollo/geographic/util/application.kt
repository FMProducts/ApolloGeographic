package fmproducts.apollo.geographic.util

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apollographql.apollo.ApolloClient
import fmproducts.apollo.geographic.MainActivity
import fmproducts.apollo.geographic.R

lateinit var mainActivity: MainActivity
lateinit var apolloClient: ApolloClient
fun MainActivity.navigate(fragment: Fragment, addToBackStack: Boolean = true){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.app_container, fragment)
    if (addToBackStack) transaction.addToBackStack(null)
    transaction.commit()
}

fun MainActivity.initFields(){
    mainActivity = this
    apolloClient = ApolloClient.builder()
        .serverUrl("https://countries.trevorblades.com")
        .build()
}

fun MainActivity.showProgressBar(){
    viewBinding.appProgressContainer.visibility = View.VISIBLE
}

fun MainActivity.hideProgressBar(){
    viewBinding.appProgressContainer.visibility = View.GONE
}

fun MainActivity.networkError(logMessage: String? = "error", toastMessage: String? = "Network error"){
    Log.e("apollo geographic", "app error: $logMessage")
    Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
}