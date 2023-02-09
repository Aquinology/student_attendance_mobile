package com.example.studentattendance.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentattendance.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment(){
    private var binding: FragmentStatisticsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatisticsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}
