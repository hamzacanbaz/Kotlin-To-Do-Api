package com.example.kotlincoroutinesexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlincoroutinesexample.R
import kotlinx.android.synthetic.main.fragment_detail.*
        class DetailFragment : Fragment() {

            val argum : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = argum.todoTitle
        description.text = argum.todoDetail

        goBackButton.setOnClickListener {
            val direction = DetailFragmentDirections.actionDetailFragmentToToDoList()
            findNavController().navigate(direction)
        }
    }




}