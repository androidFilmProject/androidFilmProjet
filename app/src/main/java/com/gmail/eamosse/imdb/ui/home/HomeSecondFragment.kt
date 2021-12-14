package com.gmail.eamosse.imdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentHomeSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeSecondFragment  : Fragment() {
    val args by navArgs<HomeSecondFragmentArgs>()
    private lateinit var binding: FragmentHomeSecondBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel) {
            token.observe(viewLifecycleOwner, Observer {
                //récupérer les lists de films
                getMoviesLists(args.myArg.toInt())

            })

            movieslists.observe(viewLifecycleOwner, Observer {
                    it ->
                binding.moviesList.adapter = MoviesListAdapter(it,MoviesListAdapter.OnPagesListener2{
                    val action = HomeSecondFragmentDirections.actionHomeSecondFragmentToHomeThirdFragment(it.id)
                    NavHostFragment.findNavController(this@HomeSecondFragment)
                        .navigate(action)
                })
            })
        }
    }
}