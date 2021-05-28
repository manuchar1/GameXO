package com.example.gamexo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gamexo.databinding.FragmentUserChoiceBinding


class UserChoiceFragment : Fragment() {

    private var binding:FragmentUserChoiceBinding?  = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserChoiceBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.button9?.setOnClickListener {
            navigate()
        }
    }


    private fun navigate() {
        findNavController().navigate(R.id.action_userChoiceFragment_to_gameActivity)
    }
}