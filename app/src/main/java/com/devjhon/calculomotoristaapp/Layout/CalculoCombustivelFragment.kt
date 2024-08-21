package com.devjhon.calculomotoristaapp.Layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devjhon.calculomotoristaapp.R
import com.devjhon.calculomotoristaapp.databinding.FragmentCalculoCombustivelBinding

class CalculoCombustivelFragment : Fragment() {
    private lateinit var _binding: FragmentCalculoCombustivelBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculo_combustivel, container, false)
    }

}