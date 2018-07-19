package co.com.condorlabs.movies.movielist

import co.com.condorlabs.movies.presenters.IBasePresenter
import co.com.condorlabs.movies.views.IBaseView

/**
 * @author Luis Goyes on 7/19/18.
 */
interface MovieListContract {

    interface View : IBaseView {

        fun showMovies(movies: List<Any>)
    }

    interface Presenter: IBasePresenter<View> {

    }

}
