package com.existentialtypes.githubapp.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.existentialtypes.githubapp.R

class ReposFragment : Fragment() {

    companion object {
        fun newInstance() = ReposFragment()
    }

    private lateinit var viewModel: ReposViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_fragment, container, false)
    }
}