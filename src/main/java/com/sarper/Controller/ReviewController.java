package com.sarper.Controller;

import com.sarper.Controller.interfaces.IMovieController;
import com.sarper.Controller.interfaces.IReviewController;
import com.sarper.Dto.ReviewRequest;
import com.sarper.Dto.ReviewResponse;
import com.sarper.Model.Review;
import com.sarper.Service.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reviews")
public class ReviewController implements IReviewController {
    @Autowired
    private IReviewService reviewService;
    @PostMapping
    @Override
    public ReviewResponse addReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(reviewRequest);
    }

    @Override
    @GetMapping(path = "/movie/{id}")
    public List<ReviewResponse> getReviewsOfMovie(@PathVariable Long id) {
        return reviewService.getReviewsOfMovie(id);
    }
}
