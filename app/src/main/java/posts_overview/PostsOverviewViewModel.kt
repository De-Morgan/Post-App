package posts_overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import network.Post
import network.PostApi

class PostsOverviewViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val post: LiveData<List<Post>>
        get() = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val getDeferredPosts = PostApi.retrofitService.getPosts()
            try {
                val listResult = getDeferredPosts
                if (listResult.isNotEmpty()) {
                    _posts.value = listResult
                }
            } catch (e: Exception) {
                _posts.value = ArrayList()
            }
        }
    }

}

