package com.mertozan.myapplication.ui.drivers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mertozan.myapplication.data.model.Drivers
import com.mertozan.myapplication.databinding.FragmentDriversBinding

class DriversFragment : Fragment() {

    private lateinit var binding: FragmentDriversBinding
    private lateinit var rv: RecyclerView
    private lateinit var adapter: DriverAdapter
    private val viewModel by lazy { DriverViewModel() }

    private var searchList = MutableLiveData<List<Drivers>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDriversBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = binding.rvDrivers
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        observer()

    }



    private fun observer() {
        viewModel.driverList.observe(viewLifecycleOwner) { driverList ->
            adapter = DriverAdapter(driverList,requireContext(),layoutInflater)
            rv.adapter = adapter
        }
    }

    private fun search(){
        binding.driverSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchDriver(query.toString(),searchList)
                adapter = DriverAdapter(searchList as List<Drivers>,requireContext(),layoutInflater)
                rv.adapter = adapter
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchDriver(newText.toString(),searchList)
                adapter = DriverAdapter(searchList as List<Drivers>,requireContext(),layoutInflater)
                rv.adapter = adapter
                return true
            }
        })
    }
}