package com.devjhon.calculomotoristaapp.Layout

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.devjhon.calculomotoristaapp.R
import com.devjhon.calculomotoristaapp.databinding.ActivityMainBinding
import com.devjhon.calculomotoristaapp.databinding.FragmentCalculoProprioBinding
import com.devjhon.calculomotoristaapp.databinding.FragmentCaluloAlugadoBinding

class CalculoProprioFragment : Fragment(), View.OnClickListener{

    private lateinit var _binding: FragmentCalculoProprioBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentCalculoProprioBinding.inflate(inflater, container, false)
        binding.btnCalcularProprio.setOnClickListener(this)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAlugado.setOnClickListener {
            findNavController().navigate(R.id.action_calculoProprioFragment_to_caluloAlugadoFragment)
        }
    }


    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcularProprio) {
            calculateProprio()
        }
    }


    private fun calculateProprio(){
        val kmPorLitroProprio = binding.edtKmlProprio.text.toString().toFloat()
        val valorCombustivel = binding.edtValorCombustivelProprio.text.toString().toFloat()
        val parcelaCarro = binding.edtParcelaCarro.text.toString().toFloat()
        val valorManutecao = binding.edtValorManutencao.text.toString().toFloat()
        val reservaImprevisto = binding.edtReservaImprevisto.text.toString().toFloat()
        val salarioDesejado = binding.edtSalarioDesejadoProprio.text.toString().toFloat()
        val kmRodadoProprio = binding.edtKmRodadoProprio.text.toString().toFloat()

        val  quantidadeLitros = kmRodadoProprio / kmPorLitroProprio
        val valorTotalCombustivelProprio = valorCombustivel * quantidadeLitros

        val valorTotal = valorTotalCombustivelProprio + parcelaCarro + valorManutecao + reservaImprevisto + salarioDesejado

        binding.txt_aceitarKm.text = "R$ ${"%.2f".format(valorTotal)}"

        Toast.makeText(requireContext(), "$valorTotal", Toast.LENGTH_SHORT).show()
    }
}

