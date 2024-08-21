package com.devjhon.calculomotoristaapp.Layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.devjhon.calculomotoristaapp.R
import com.devjhon.calculomotoristaapp.databinding.FragmentCaluloAlugadoBinding

class CaluloAlugadoFragment : Fragment(), View.OnClickListener {

    private lateinit var  _binding: FragmentCaluloAlugadoBinding
    private val binding get()  = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCaluloAlugadoBinding.inflate(inflater, container, false)
        binding.btnCalcularAlugado.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnProprio.setOnClickListener {
            findNavController().navigate(R.id.action_caluloAlugadoFragment_to_calculoProprioFragment)
        }
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_calcularAlugado){
            calcularAlugado()
        }
    }

    fun calcularAlugado(){
        val kmPorLitro = binding.edtKmlAlugado.text.toString().toFloat()
        val valorCombustivelAlugado = binding.edtValorCombustivelAlugado.text.toString().toFloat()
        val valorAluguel = binding.edtValorAluguel.text.toString().toFloat()
        val salarioAlugado = binding.edtSalarioDesejadoAlugado.text.toString().toFloat()
        val kmRodadosAlugado = binding.edtKmRodadoAlugado.text.toString().toFloat()

        val quantidadeLitrosAlg = kmRodadosAlugado / kmPorLitro
        val totalCombustivel = quantidadeLitrosAlg * valorCombustivelAlugado

        val valorTotalAlugado = totalCombustivel + valorAluguel + salarioAlugado

        binding.txtValorTotalAlugado.text = "R$ ${"%.2f".format(valorTotalAlugado)}"

        Toast.makeText(requireContext(), "$valorTotalAlugado", Toast.LENGTH_SHORT).show()
    }
}