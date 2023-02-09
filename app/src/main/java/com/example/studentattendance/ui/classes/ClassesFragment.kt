package com.example.studentattendance.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentattendance.databinding.FragmentClassesBinding

class ClassesFragment : Fragment(){
    private var binding: FragmentClassesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClassesBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}
