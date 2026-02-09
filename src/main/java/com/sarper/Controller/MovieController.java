package com.sarper.Controller;

import com.sarper.Controller.interfaces.IMovieController;
import com.sarper.Dto.MovieDto;
import com.sarper.Model.Movie;
import com.sarper.Service.interfaces.IMovieService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/movies")
public class MovieController implements IMovieController {
    @Autowired
    private IMovieService movieService;

    @Override
    @GetMapping(path = "/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @Override
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MovieDto addMovie(@RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        return movieService.updateMovie(id, movieDto);
    }


}
