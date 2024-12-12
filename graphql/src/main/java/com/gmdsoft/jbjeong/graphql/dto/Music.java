package com.gmdsoft.jbjeong.graphql.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Music {
    private Long id;

    private String name;

    private String releaseDate;

    private String createdAt;
}
