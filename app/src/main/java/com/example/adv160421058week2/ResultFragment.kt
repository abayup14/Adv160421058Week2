package com.example.adv160421058week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421058week2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val skor = ResultFragmentArgs.fromBundle(requireArguments()).skor
            binding.txtScore.text = "Your score is $skor"
        }
        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionResultToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}