package com.sarper.Controller.interfaces;

import com.sarper.Dto.ReviewDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IReviewController {

    ReviewDto addReview(ReviewDto reviewRequest, Long movieId, Authentication authentication);

    List<ReviewDto> getReviewsOfMovie(Long id);

    List<ReviewDto> getReviewsOfUser(Long userId);
}
