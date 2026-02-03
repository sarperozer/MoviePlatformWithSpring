package com.sarper.Controller.interfaces;

import com.sarper.Model.Movie;

import java.util.List;

public interface IMovieController {

    Movie getMovie(Long movieId);

    List<Movie> getAllMovies();
}
