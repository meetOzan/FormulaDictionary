package com.mertozan.myapplication.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mertozan.myapplication.databinding.FragmentTeamsBinding

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamsBinding
    private lateinit var rv: RecyclerView
    private lateinit var adapter: TeamAdapter
    private val viewModel by lazy { TeamViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = binding.rvTeams
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        observer()

    }

    private fun observer() {
        viewModel.teamList.observe(viewLifecycleOwner) {
            adapter = TeamAdapter(it, requireContext())
            rv.adapter = adapter
        }
    }

}