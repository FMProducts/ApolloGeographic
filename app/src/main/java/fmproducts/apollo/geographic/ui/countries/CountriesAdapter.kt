package fmproducts.apollo.geographic.ui.countries

import android.content.Context
import GetContinentCountriesQuery
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fmproducts.apollo.geographic.databinding.CountryItemBinding

class CountriesAdapter(
    context: Context,
    var data: List<GetContinentCountriesQuery.Country>
): RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CountryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = data[position]
        with(holder.binding){
            countryName.text = String.format("%s (%s)", country.name(), country.emoji())
            countryPhoneCode.text = country.phone()
            countryCurrency.text = country.currency()
            countryCapitalCity.text = country.capital()
            countryLanguages.text = ""
            country.languages().forEach {
                countryLanguages.append("${it.name()}, ")
            }
        }
    }

    override fun getItemCount() = data.size

    class ViewHolder(val binding: CountryItemBinding): RecyclerView.ViewHolder(binding.root)
}