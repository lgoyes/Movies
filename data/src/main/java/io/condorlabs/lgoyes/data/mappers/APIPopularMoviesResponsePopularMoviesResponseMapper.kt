package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIPopularMoviesResponse
import io.condorlabs.lgoyes.domain.models.PopularMoviesResponse
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIPopularMoviesResponsePopularMoviesResponseMapper :
        Function<APIPopularMoviesResponse, PopularMoviesResponse> {
    override fun apply(t: APIPopularMoviesResponse): PopularMoviesResponse {
        return PopularMoviesResponse(
                t.page,
                t.totalResults,
                t.totalPages,
                t.results
        )
    }
}
