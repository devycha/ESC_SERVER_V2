package com.minwonhaeso.esc.review.model.dto;

import com.minwonhaeso.esc.review.model.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ReviewDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Double star;
        private String comment;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private Double star;
        private String comment;
        private String nickname;
        private LocalDate createdAt;

        public static ReviewDto.Response fromEntity(Review review) {
            return Response.builder()
                    .id(review.getId())
                    .star(review.getStar())
                    .comment(review.getComment())
                    .nickname(review.getMember().getNickname())
                    .createdAt(review.getCreatedAt())
                    .build();
        }
    }
}
