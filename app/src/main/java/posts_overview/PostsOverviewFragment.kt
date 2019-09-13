package posts_overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mypostapp.databinding.PostsOverviewFragmentBinding

class PostsOverviewFragment : Fragment() {

    lateinit var binding: PostsOverviewFragmentBinding

    private val postViewModel: PostsOverviewViewModel by lazy {
        ViewModelProviders.of(this).get(PostsOverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PostsOverviewFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val postListAdapter = PostListAdapter()
        binding.viewModel = postViewModel
        binding.postsList.adapter = postListAdapter
        postViewModel.post.observe(this, Observer {
            it?.let {
                postListAdapter.data = it
            }
        })
        return binding.root
    }


}
