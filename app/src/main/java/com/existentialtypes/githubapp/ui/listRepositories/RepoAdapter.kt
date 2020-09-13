package com.existentialtypes.githubapp.ui.listRepositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.existentialtypes.githubapp.R
import com.existentialtypes.githubapp.network.model.GithubRepositories
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal


class RepoAdapter(
    private val list: List<GithubRepositoriesMinimal>,
    private val viewModel: ListRepositoriesViewModel,
    private val listener: RepoViewHolder.Listener
) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    class RepoViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val name = v.findViewById<TextView>(R.id.nameTextView)
        private val programmingLanguage = v.findViewById<TextView>(R.id.programmingLanguageTextView)
        private val countForks = v.findViewById<TextView>(R.id.countForksTextView)
        private val countStars = v.findViewById<TextView>(R.id.countStarsTextView)
        private val avatars = v.findViewById<ImageView>(R.id.imageView)
        private val author = v.findViewById<TextView>(R.id.authorTextView)
        private val description = v.findViewById<TextView>(R.id.descriptionTextView)

        fun bind(repo: GithubRepositories) {
            name.text = repo.name
            programmingLanguage.text = repo.language
            countForks.text = repo.forks.toString()
            countStars.text = repo.stargazersCount.toString()
            Glide
                .with(avatars.context)
                .load(repo.owner?.avatarUrl)
                .circleCrop()
                .apply(
                    RequestOptions()
                )
                .into(avatars)
            author.text = repo.owner!!.login
            description.text = repo.description
        }

        interface Listener {
            fun onItemClick(repo: GithubRepositoriesMinimal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo: GithubRepositoriesMinimal = list[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(repo)
        }
        holder.bind(viewModel.repo(repo))
        holder.itemView.tag = repo
    }
}