package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.THE_MOVIE_DATABASE_API_KEY
import io.condorlabs.lgoyes.domain.interactors.base.ObservableUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class ObtainMovieDetailInteractor(mSubscribeOnScheduler: Scheduler,
                                  mObserveOnScheduler: Scheduler,
                                  private val mWebServiceRepository: IWebRepository) :
        ObservableUseCase<Movie, String>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: String): Observable<Movie> =
            mWebServiceRepository.getMovieDetails(params, THE_MOVIE_DATABASE_API_KEY)
}
