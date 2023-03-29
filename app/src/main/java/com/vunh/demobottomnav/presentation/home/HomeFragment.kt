package com.vunh.demobottomnav.presentation.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.vunh.demobottomnav.databinding.FragmentHomeBinding
import com.vunh.demobottomnav.presentation.destination.DestinationSecondFragmentArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "This is home Fragment"
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val text = DestinationSecondFragmentArgs.fromBundle(it).nameToHome
            _binding?.textHome?.text = text
        }
        _binding?.buttonHome?.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToDestinationFragment()
            action.arguments.putString("nameToShow", "home put")
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}