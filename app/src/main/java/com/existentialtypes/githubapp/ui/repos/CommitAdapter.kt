package com.existentialtypes.githubapp.ui.repos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.existentialtypes.githubapp.R
import com.existentialtypes.githubapp.network.model.Commits


class CommitAdapter(
    private val list: List<Commits>
) :
    RecyclerView.Adapter<CommitAdapter.RepoViewHolder>() {
    class RepoViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val date = v.findViewById<TextView>(R.id.dateCommitTextView)
        private val avatars = v.findViewById<ImageView>(R.id.avatarAuthorCommitImageView)
        private val author = v.findViewById<TextView>(R.id.authorCommitTextView)
        private val description = v.findViewById<TextView>(R.id.descriptionCommitTextView)

        fun bind(commits: Commits) {
            date.text = commits.commit!!.author!!.date
            if (commits.author != null) {
                Glide
                    .with(avatars.context)
                    .load(commits.author.avatarUrl)
                    .circleCrop()
                    .apply(
                        RequestOptions()
                    )
                    .into(avatars)
                author.text = commits.author.login
            } else {
                author.text = commits.commit.author!!.name
            }
            description.text = commits.commit.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_commit, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val commits: Commits = list[position]
        holder.bind(commits)
        holder.itemView.tag = commits
    }
}