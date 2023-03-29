package com.vunh.demobottomnav.presentation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.vunh.demobottomnav.R
import com.vunh.demobottomnav.databinding.FragmentDestinationSecondBinding

class DestinationSecondFragment : Fragment() {
    private var _binding: FragmentDestinationSecondBinding? = null

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

        _binding = FragmentDestinationSecondBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.welcomeWithNameTv
//        destinationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "This is destination 2 Fragment"
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("nameToDest2")
        _binding?.welcomeWithNameTv?.text = text

        _binding?.btHome?.setOnClickListener {
            val action = DestinationSecondFragmentDirections.actionDestinationSecondFragmentToNavigationHome()
            val bundle = DestinationSecondFragmentArgs("name from Dest 2").toBundle()
//            arguments?.let {
//                DestinationSecondFragmentArgs.fromBundle(it).nameToHome = "name from Dest 2"
//            }
//            action.arguments.putString("nameToHome", "name from Dest 2")
            view.findNavController().navigate(R.id.action_destination_second_fragment_to_navigation_home, bundle)
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