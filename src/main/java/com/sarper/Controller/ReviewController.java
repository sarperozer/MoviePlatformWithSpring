package com.sarper.Controller;

import com.sarper.Controller.interfaces.IReviewController;
import com.sarper.Dto.ReviewDto;
import com.sarper.Service.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reviews")
public class ReviewController implements IReviewController {
    @Autowired
    private IReviewService reviewService;

    @PostMapping("/movie/{movie_id}")
    @Override
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto, @PathVariable Long movie_id, Authentication authentication) {
        return reviewService.addReview(reviewDto, movie_id, authentication);
    }

    @Override
    @GetMapping(path = "/movie/{id}")
    public List<ReviewDto> getReviewsOfMovie(@PathVariable Long id) {
        return reviewService.getReviewsOfMovie(id);
    }

    @Override
    @GetMapping(path = "/user/{user_id}")
    public List<ReviewDto> getReviewsOfUser(@PathVariable Long user_id) {
        return reviewService.getReviewsOfUser(user_id);
    }


}
