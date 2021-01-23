package com.artem.testcase.ui.aboutProgram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artem.testcase.R

class AboutProgramFragment : Fragment() {

    private lateinit var aboutProgramViewModel: AboutProgramViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aboutProgramViewModel = ViewModelProvider(this).get(AboutProgramViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about_program, container, false)


        val textView: TextView = root.findViewById(R.id.text_about_program)
        aboutProgramViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}