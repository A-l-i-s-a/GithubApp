package com.existentialtypes.githubapp.ui.listRepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.existentialtypes.githubapp.R
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal

class ListRepositoriesFragment : Fragment() {

    companion object {
        fun newInstance() = ListRepositoriesFragment()
    }

    private lateinit var viewModel: ListRepositoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_repositories_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ListRepositoriesViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.listRepositoriesRV)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.repositories.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter =
                RepoAdapter(it, viewModel, object : RepoAdapter.RepoViewHolder.Listener {
                    override fun onItemClick(repo: GithubRepositoriesMinimal) {
                        findNavController().navigate(R.id.action_listRepositoriesFragment_to_reposFragment)
                    }
                })
        })

        return view
    }
}