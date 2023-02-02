package com.example.studentattendance.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentattendance.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(){
    private var binding: FragmentSettingsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}
