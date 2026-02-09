package com.sarper.Service.interfaces;

import com.sarper.Dto.MovieDto;
import com.sarper.Model.Movie;

import java.util.List;

public interface IMovieService {

    Movie getMovie(Long movieId);

    List<MovieDto> getMovies(String director, String genre);

    MovieDto addMovie(MovieDto movieDto);

    void deleteMovie(Long id);

    MovieDto updateMovie(Long id, MovieDto movieDto);
}
