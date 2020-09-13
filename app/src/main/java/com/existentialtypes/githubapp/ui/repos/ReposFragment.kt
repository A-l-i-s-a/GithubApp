package com.existentialtypes.githubapp.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.existentialtypes.githubapp.R
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal

class ReposFragment : Fragment() {

    companion object {
        fun newInstance() = ReposFragment()
    }

    private lateinit var viewModel: ReposViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.repos_fragment, container, false)
        val bundle: Bundle? = arguments
        val repo: GithubRepositoriesMinimal = bundle!!.get("repo") as GithubRepositoriesMinimal
        view.findViewById<TextView>(R.id.avatarImageView).text = repo.owner!!.login
        view.findViewById<TextView>(R.id.nameRepoTextView).text = repo.name
        val avatar = view.findViewById<ImageView>(R.id.avatarAuthorCommitImageView)
        Glide
            .with(avatar.context)
            .load(repo.owner.avatarUrl)
            .circleCrop()
            .apply(
                RequestOptions()
            )
            .into(avatar)
        val reposViewModelFactory = ReposViewModelFactory(repo)
        viewModel = ViewModelProvider(this, reposViewModelFactory).get(ReposViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.commitsRV)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.commits.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = CommitAdapter(it)
        })
        return view
    }
}