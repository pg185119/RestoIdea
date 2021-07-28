package com.ncr.restoidea.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ncr.restoidea.MainActivity
import com.ncr.restoidea.R
import com.ncr.restoidea.databinding.FragmentHomeBinding
import com.ncr.restoidea.util.OnItemClickListener
import com.ncr.restoidea.util.addOnItemClickListener


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeAdapter: HomeAdapter
    private var restlist: ArrayList<String>? = null
    private var restlist_remove: ArrayList<String>? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.restlist.hasFixedSize()
        binding.restlist.layoutManager = LinearLayoutManager(requireActivity())
        homeAdapter = HomeAdapter(requireActivity() as MainActivity)
        homeViewModel.getrests("")?.observe(viewLifecycleOwner, Observer {
            homeAdapter.setData(it)
            restlist = it as ArrayList<String>?

        })

        binding.restlist.adapter = homeAdapter

        binding.restlist.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Selected")
                builder.setMessage("We have a choosen the safety assured  restaurant!")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                builder.setPositiveButton("Yes") { dialog, which ->
                    val bundle = bundleOf("restname" to restlist?.get(position))
                    findNavController().navigate(R.id.navigation_restaurant,bundle)
                }

                builder.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(requireContext(),
                        "Not selected", Toast.LENGTH_SHORT).show()

                }


                builder.show()


            }
        })
        binding.safetyswitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // If the switch button is on
                //rl.setBackgroundColor(Color.parseColor("#FF80DFB0"))

                // Show the switch button checked status as toast message

                restlist_remove = restlist
                restlist_remove?.removeAt(1)
                restlist_remove?.removeAt(3)
                homeAdapter.setData(restlist_remove!!)
            } else {
                // If the switch button is off
                //  rl.setBackgroundColor(Color.parseColor("#ed252f"))

                // Show the switch button checked status as toast message
                restlist_remove?.clear()
                restlist_remove?.add("Restaurant #1")
                restlist_remove?.add("Restaurant #2")
                restlist_remove?.add("Restaurant #3")
                restlist_remove?.add("Restaurant #4")
                restlist_remove?.add("Restaurant #5")
                homeAdapter.setData(restlist_remove!!)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}