package com.existentialtypes.githubapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.Nullable

@JsonClass(generateAdapter = true)
@Parcelize
data class GithubRepositoriesMinimal(
    val id: Long? = 1,
    @Json(name = "node_id")
    val nodeId: String? = "",
    val name: String? = "",
    @Json(name = "full_name")
    val fullName: String? = "",
    val private: Boolean? = false,
    val owner: Owner? = Owner(),
    @Json(name = "html_url")
    val htmlUrl: String? = "",
    @Nullable
    val description: String? = "",
    val fork: Boolean? = false,
    val url: String? = "",
    @Json(name = "forks_url")
    val forksUrl: String? = "",
    @Json(name = "keys_url")
    val keysUrl: String? = "",
    @Json(name = "collaborators_url")
    val collaboratorsUrl: String? = "",
    @Json(name = "teams_url")
    val teamsUrl: String? = "",
    @Json(name = "hooks_url")
    val hooksUrl: String? = "",
    @Json(name = "issue_events_url")
    val issueEventsUrl: String? = "",
    @Json(name = "events_url")
    val eventsUrl: String? = "",
    @Json(name = "assignees_url")
    val assigneesUrl: String? = "",
    @Json(name = "branches_url")
    val branchesUrl: String? = "",
    @Json(name = "tags_url")
    val tagsUrl: String? = "",
    @Json(name = "blobs_url")
    val blobsUrl: String? = "",
    @Json(name = "git_tags_url")
    val gitTagsUrl: String? = "",
    @Json(name = "git_refs_url")
    val gitRefsUrl: String? = "",
    @Json(name = "trees_url")
    val treesUrl: String? = "",
    @Json(name = "statuses_url")
    val statusesUrl: String? = "",
    @Json(name = "languages_url")
    val languagesUrl: String? = "",
    @Json(name = "stargazers_url")
    val stargazersUrl: String? = "",
    @Json(name = "contributors_url")
    val contributorsUrl: String? = "",
    @Json(name = "subscribers_url")
    val subscribersUrl: String? = "",
    @Json(name = "subscription_url")
    val subscriptionUrl: String? = "",
    @Json(name = "commits_url")
    val commitsUrl: String? = "",
    @Json(name = "git_commits_url")
    val gitCommitsUrl: String? = "",
    @Json(name = "comments_url")
    val commentsUrl: String? = "",
    @Json(name = "issue_comment_url")
    val issueCommentUrl: String? = "",
    @Json(name = "contents_url")
    val contentsUrl: String? = "",
    @Json(name = "compare_url")
    val compareUrl: String? = "",
    @Json(name = "merges_url")
    val mergesUrl: String? = "",
    @Json(name = "archive_url")
    val archiveUrl: String? = "",
    @Json(name = "downloads_url")
    val downloadsUrl: String? = "",
    @Json(name = "issues_url")
    val issuesUrl: String? = "",
    @Json(name = "pulls_url")
    val pullsUrl: String? = "",
    @Json(name = "milestones_url")
    val milestonesUrl: String? = "",
    @Json(name = "notifications_url")
    val notificationsUrl: String? = "",
    @Json(name = "labels_url")
    val labelsUrl: String? = "",
    @Json(name = "releases_url")
    val releasesUrl: String? = "",
    @Json(name = "deployments_url")
    val deploymentsUrl: String? = ""
) : Parcelable
