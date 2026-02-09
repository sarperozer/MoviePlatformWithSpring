package com.sarper.Service;

import com.sarper.Dto.MovieDto;
import com.sarper.Model.Movie;
import com.sarper.Repository.MovieRepository;
import com.sarper.Service.interfaces.IMovieService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);

        if(movieRepository.save(movie) == null) throw new RuntimeException("Error saving movie");

        return movieDto;
    }

    @Override
    public void deleteMovie(Long id) {

        if (movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return;
        }

        throw new RuntimeException("Movie not found!");
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();

            if (movieDto.getMovieName() != null) movie.setMovieName(movieDto.getMovieName());
            if (movieDto.getMovieDescription() != null) movie.setMovieDescription(movieDto.getMovieDescription());
            if(movieDto.getGenre() != null) movie.setGenre(movieDto.getGenre());
            if (movieDto.getDirectorName() != null) movie.setDirectorName(movieDto.getDirectorName());

            movieRepository.save(movie);
            return movieDto;
        }

        throw new RuntimeException("Movie not found!");
    }
}
