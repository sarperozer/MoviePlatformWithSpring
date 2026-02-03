package com.sarper.Service;

import com.sarper.Model.Movie;
import com.sarper.Repository.MovieRepository;
import com.sarper.Service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getMovie(Long movieId) {
        return movieRepository.getReferenceById(movieId);
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
