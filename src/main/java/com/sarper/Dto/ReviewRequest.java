package com.sarper.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private Integer stars;
    private String comment;
    private Long userId;
    private Long MovieId;
}
