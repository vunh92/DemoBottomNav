package com.vunh.demobottomnav.presentation.dashboard.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.vunh.demobottomnav.databinding.FragmentDashboardDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardDetailFragment : Fragment() {
    private lateinit var binding: FragmentDashboardDetailBinding
//    val args: DashboardFragmentD by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("nameToShow")
        binding.textview.text = text
        binding.btBack.setOnClickListener {
            view.findNavController().navigateUp()
        }
    }
}