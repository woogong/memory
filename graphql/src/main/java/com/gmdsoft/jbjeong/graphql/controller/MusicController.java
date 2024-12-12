package com.gmdsoft.jbjeong.graphql.controller;

import com.gmdsoft.jbjeong.graphql.dto.Music;
import com.gmdsoft.jbjeong.graphql.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MusicController {
    private final MusicService musicService;

    @QueryMapping
    public Music music(@Argument Long id) {
        return musicService.get(id);
    }

    /*
        query {
            music(id: 1) {
                id
                name
                releaseDate
                createdAt
            }
        }
     */

    @MutationMapping
    public Music createMusic(@Argument String name, @Argument String releaseDate) {
        return musicService.create(Music.builder()
                .name(name)
                .releaseDate(releaseDate)
                .build());
    }

    /*
        mutation CreateMusicMutation {
            createMusic(name: "너무 아픈 사랑은 사랑이 아니었음을", releaseDate: "1994") {
                id
            }
        }
     */
}
