package com.sarper.Controller;

import com.sarper.Controller.interfaces.IMovieController;
import com.sarper.Model.Movie;
import com.sarper.Service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
