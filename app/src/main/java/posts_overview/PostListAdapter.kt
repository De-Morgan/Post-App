package posts_overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mypostapp.R
import network.Post

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    var data = listOf<Post>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = data[position]
        holder.bind(post)
    }


    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.title)
        private val body: TextView = view.findViewById(R.id.body)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.post_item_list, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(post: Post) {
            title.text = post.title
            body.text = post.body
        }

    }

}