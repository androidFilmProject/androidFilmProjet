package com.gmail.eamosse.imdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.imdb.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel) {
            token.observe(viewLifecycleOwner, Observer {
                //récupérer les catégories
                getCategories()
            })

            categories.observe(viewLifecycleOwner, Observer { it ->
                binding.categoryList.adapter = CategoryAdapter(it, CategoryAdapter.OnPagesListener{
                    val action = HomeFragmentDirections
                        .actionHomeFragmentToHomeSecondFragment(it.id.toString())
                    NavHostFragment.findNavController(this@HomeFragment)
                        .navigate(action)
                })

            error.observe(viewLifecycleOwner, Observer {
                //afficher l'erreur
            })
        })
    }
}}
