package com.ncr.restoidea.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ncr.restoidea.MainActivity
import com.ncr.restoidea.R
import com.ncr.restoidea.databinding.FragmentHomeBinding
import com.ncr.restoidea.databinding.RestaurantFragmentBinding
import com.ncr.restoidea.ui.home.HomeAdapter
import com.ncr.restoidea.ui.home.HomeViewModel

class RestaurantFragment : Fragment() {
    private var restlist: ArrayList<String>? = null
    private var _binding: RestaurantFragmentBinding? = null
    private lateinit var restaurantAdapter: RestaurantAdapter
    companion object {
        fun newInstance() = RestaurantFragment()
    }
    private val binding get() = _binding!!
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {   viewModel =
        ViewModelProvider(this).get(RestaurantViewModel::class.java)

        _binding = RestaurantFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        binding.menulist.hasFixedSize()
        binding.menulist.layoutManager = LinearLayoutManager(requireActivity())
        restaurantAdapter = RestaurantAdapter(requireActivity() as MainActivity)
        viewModel.getrests("")?.observe(viewLifecycleOwner, Observer {
            restaurantAdapter.setData(it)
            restlist = it as ArrayList<String>?

        })

        binding.menulist.adapter = restaurantAdapter
        // TODO: Use the ViewModel
    }

}