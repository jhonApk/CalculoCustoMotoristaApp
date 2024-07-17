package com.devjhon.calculomotoristaapp.Layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.devjhon.calculomotoristaapp.R

class CaluloAlugadoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calulo_alugado, container, false)

        view.findViewById<Button>(R.id.btn_proprio).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_caluloAlugadoFragment_to_calculoCustoProprio)
        }
        return view
    }
}