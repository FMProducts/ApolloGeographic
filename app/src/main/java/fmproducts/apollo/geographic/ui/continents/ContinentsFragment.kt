package fmproducts.apollo.geographic.ui.continents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fmproducts.apollo.geographic.databinding.ContinentsFragmentBinding

class ContinentsFragment() : Fragment() {

    private lateinit var viewBinding: ContinentsFragmentBinding
    private lateinit var viewModel: ContinentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = ContinentsFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContinentsViewModel::class.java)
        viewModel.continents.observe(viewLifecycleOwner) {
            viewBinding.continentsRecycler.adapter = ContinentsAdapter(requireContext(), it)
        }
        viewModel.load()
    }

}