package asha.binar.challangechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import asha.binar.challangechaptertiga.databinding.FragmentWordNavBinding


class WordNavFragment : Fragment() {

    private var _binding : FragmentWordNavBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWordNavBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Words That Start With ${arguments?.getString("KEY_ALPHABETS")}"

        val aList = arguments?.getStringArrayList("KEY_WORDS")
        val adapter = WordAdapter(aList as ArrayList<String>)

        binding.rvWords.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvWords.adapter = adapter

    }


}