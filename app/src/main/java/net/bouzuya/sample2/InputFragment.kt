package net.bouzuya.sample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import net.bouzuya.sample2.databinding.InputFragmentBinding


class InputFragment : Fragment() {
    private val viewModel: InputViewModel by viewModels {
        ServiceLocator.providesInputViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return InputFragmentBinding.inflate(inflater, container, false).also { binding ->
            binding.lifecycleOwner = this
            binding.viewModel = viewModel
        }.root
    }
}
