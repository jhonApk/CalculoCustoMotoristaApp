package com.devjhon.calculomotoristaapp.Layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devjhon.calculomotoristaapp.R
import com.devjhon.calculomotoristaapp.databinding.ActivityMainBinding

class CalculoProprioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculo_proprio, container, false)

        view.findViewById<Button>(R.id.btn_alugado).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_calculoProprioFragment_to_caluloAlugadoFragment)
        }

        return view
    }


}

