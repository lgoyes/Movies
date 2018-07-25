package co.com.condorlabs.movies.movielist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.condorlabs.movies.R
import io.condorlabs.lgoyes.domain.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/25/2018
 */
class MovieItemAdapter (val movies : List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val movieItemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
        return MovieItemViewHolder(movieItemView)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieHolder = MovieItemViewHolder( holder.itemView )

        movieHolder.viewMovieTitle.text = movies[position].name
        movieHolder.viewRateBar.rating = movies[position].voteAverage.toFloat()/2.0f

        //movieHolder.viewPosterPicture.drawable
    }

    internal class MovieItemViewHolder( emptyLayout : View) : RecyclerView.ViewHolder(emptyLayout) {
        var viewPosterPicture = emptyLayout.iv_activitylist_recyclerviewitem
        var viewMovieTitle = emptyLayout.tv_activitylist_recyclerviewitem_title
        var viewRateBar = emptyLayout.rb_activitylist_recyclerviewitem_voteaverage
    }
}
