package fmproducts.apollo.geographic.ui.continents

import GetContinentsQuery
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fmproducts.apollo.geographic.databinding.ContinentItemBinding
import fmproducts.apollo.geographic.ui.countries.CountriesFragment
import fmproducts.apollo.geographic.util.mainActivity
import fmproducts.apollo.geographic.util.navigate

class ContinentsAdapter(
    context: Context,
    var data: List<GetContinentsQuery.Continent>
) : RecyclerView.Adapter<ContinentsAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContinentItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val continent = data[position]
        with(holder.binding) {
            continentName.text =
                String.format("%d. %s (%s)", position, continent.name(), continent.code())
            root.setOnClickListener {
                mainActivity.navigate(CountriesFragment(continentCode = continent.code()))
            }
        }
    }

    override fun getItemCount() = data.size

    class ViewHolder(val binding: ContinentItemBinding) : RecyclerView.ViewHolder(binding.root)
}