package com.example.studentattendance.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentattendance.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {
    private var binding: FragmentCoursesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoursesBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}


