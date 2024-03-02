package com.example.adv160421058week2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421058week2.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnStart.setOnClickListener {
//            val playerName = binding.txtName.text.toString()
//            val action = MainFragmentDirections.actionGameFragment(playerName)
//            Navigation.findNavController(it).navigate(action)
//        }
        binding.txtAngka1.text = Random.nextInt(1, 100).toString()
        binding.txtAngka2.text = Random.nextInt(1, 100).toString()
        var skor = 0
        binding.btnStart.setOnClickListener {
            val result = (binding.txtAngka1.text.toString().toInt() + binding.txtAngka2.text.toString().toInt())
            val input = binding.txtName.text.toString()
            if (result == input.toInt()) {
                val dialog = AlertDialog.Builder(activity)
                dialog.setTitle("Informasi")
                skor++
                dialog.setMessage("Jawaban anda benar.\nSkor anda sekarang: $skor")
                dialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    binding.txtName.text?.clear()
                    binding.txtAngka1.text = Random.nextInt(1, 100).toString()
                    binding.txtAngka2.text = Random.nextInt(1, 100).toString()
                })
                dialog.create().show()
            } else {
                val res = MainFragmentDirections.actionResultFragment(skor.toString())
                Navigation.findNavController(it).navigate(res)
                skor = 0
            }
        }
    }
}