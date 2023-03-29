package com.vunh.demobottomnav.presentation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.vunh.demobottomnav.databinding.FragmentDestinationBinding
import com.vunh.demobottomnav.presentation.dashboard.DashboardFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class DestinationFragment : Fragment() {
    private var _binding: FragmentDestinationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val destinationViewModel =
            ViewModelProvider(this).get(DestinationViewModel::class.java)

        _binding = FragmentDestinationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.welcomeWithNameTv
//        destinationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "This is destination Fragment"
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("nameToShow")
        _binding?.welcomeWithNameTv?.text = text

        _binding?.btDest?.setOnClickListener {
            val action = DestinationFragmentDirections.actionDestinationFragmentToDestinationSecondFragment("name from Dest 1")
            view.findNavController().navigate(action)
        }
        _binding?.btBack?.setOnClickListener {
            view.findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}