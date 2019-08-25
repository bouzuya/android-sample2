package net.bouzuya.sample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import net.bouzuya.sample2.HomeFragmentDirections.Companion.actionHomeToInput
import net.bouzuya.sample2.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels {
        ServiceLocator.providesHomeViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return HomeFragmentBinding.inflate(inflater, container, false).also { binding ->
            binding.lifecycleOwner = this
            binding.viewModel = viewModel

            viewModel.goToInputEvent.observe(this, Observer {
                findNavController().navigate(actionHomeToInput())
            })
        }.root
    }
}
