package com.sarper.Service.interfaces;

import com.sarper.Model.Movie;

import java.util.List;

public interface IMovieService {

    Movie getMovie(Long movieId);

    List<Movie> getAllMovies();
}
