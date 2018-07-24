package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIMovie
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIMovieMovieMapper : Function<APIMovie, Movie> {
    override fun apply(t: APIMovie): Movie {
        return Movie(
                null,
                t.id.toString(),
                t.title,
                t.voteCount.toString(),
                t.posterPath,
                t.voteAverage.toString(),
                t.overview,
                t.releaseDate,
                null,
                null,
                null
        )
    }
}
