package io.condorlabs.lgoyes.data.repositories

import io.condorlabs.lgoyes.data.database.IMoviesDao
import io.condorlabs.lgoyes.data.wrapper.DBMovieEntryMovieWrapper
import io.condorlabs.lgoyes.data.wrapper.MovieDBMovieEntryWrapper
import io.condorlabs.lgoyes.domain.models.MovieEntry
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class LocalRepository(private val mMoviesDao: IMoviesDao) : ILocalRepository {
    override fun getAllEntries(): Flowable<List<MovieEntry>> {
        val rawList = mMoviesDao.getAllMovies()
        return rawList.map {
            it.map {
                DBMovieEntryMovieWrapper.apply(it)
            }
        }
    }

    override fun insertEntry(movie: MovieEntry): Observable<Long> {
        val entry = MovieDBMovieEntryWrapper.apply(movie)
        return Observable.create { emitter ->
            emitter.onNext(mMoviesDao.insertMovie(entry))
            emitter.onComplete()
        }
    }

    override fun deleteEntry(movie: MovieEntry): Observable<Int> {
        val entry = MovieDBMovieEntryWrapper.apply(movie)
        return Observable.just(mMoviesDao.deleteMovie(entry))
    }

    override fun updateEntry(movie: MovieEntry): Observable<Int> {
        val entry = MovieDBMovieEntryWrapper.apply(movie)
        return Observable.just(mMoviesDao.updateMovie(entry))
    }
}
