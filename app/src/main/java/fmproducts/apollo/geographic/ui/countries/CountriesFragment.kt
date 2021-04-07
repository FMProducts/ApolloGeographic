package fmproducts.apollo.geographic.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fmproducts.apollo.geographic.databinding.CountriesFragmentBinding
import fmproducts.apollo.geographic.util.mainActivity

class CountriesFragment(val continentCode: String) : Fragment() {

    private lateinit var viewBinding: CountriesFragmentBinding
    private lateinit var viewModel: CountriesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = CountriesFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        viewModel.continent.observe(viewLifecycleOwner) {
            mainActivity.supportActionBar?.title = it.name()
            viewBinding.countriesRecycler.adapter = CountriesAdapter(requireContext(), it.countries())
        }
        viewModel.load(continentCode)
    }

}