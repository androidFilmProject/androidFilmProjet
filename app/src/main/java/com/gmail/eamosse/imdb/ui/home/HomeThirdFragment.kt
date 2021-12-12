package com.gmail.eamosse.imdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentHomeSecondBinding
import com.gmail.eamosse.imdb.databinding.FragmentHomeThirdBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeThirdFragment:Fragment() {
    private val args: HomeThirdFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding:FragmentHomeThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(homeViewModel) {
            token.observe(viewLifecycleOwner, Observer {
                //récupérer les Movies
                getMovie(args.myArg.toInt())
            })
            error.observe(viewLifecycleOwner, Observer {
                //afficher l'erreur
            })
        }

    }
}