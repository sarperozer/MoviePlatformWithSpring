package com.sarper.Controller.interfaces;

import com.sarper.Dto.MovieDto;
import com.sarper.Model.Movie;

import java.util.List;

public interface IMovieController {

    Movie getMovie(Long movieId);

    List<Movie> getAllMovies();

    MovieDto addMovie(MovieDto movieDto);

    void deleteMovie(Long movieId);

    MovieDto updateMovie(Long movieId, MovieDto movieDto);
}
