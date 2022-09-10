package asha.binar.challangechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import asha.binar.challangechaptertiga.databinding.FragmentHomeNavBinding


class HomeNavFragment : Fragment() {

    private var _binding: FragmentHomeNavBinding?= null
    private val binding get() = _binding!!
    private val dataSet = MainActivity().aWord


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeNavBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AlphabetNavAdapter()
        adapter.submitData(dataSet)

        binding.rvAlphabets.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvAlphabets.adapter = adapter

    }


}