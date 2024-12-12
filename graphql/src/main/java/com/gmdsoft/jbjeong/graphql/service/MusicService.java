package com.gmdsoft.jbjeong.graphql.service;

import com.gmdsoft.jbjeong.graphql.dto.Music;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class MusicService {

    private final Map<Long, Music> map = new HashMap<>();

    private long idPool = 0;

    public Music get(Long id) {
        Music music = map.get(id);

        if (music != null) {
            return music;
        } else {
            throw new RuntimeException("music not found");
        }
    }

    public synchronized Music create(Music music) {
        idPool++;
        music.setId(idPool);
        music.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        map.put(music.getId(), music);

        return music;
    }

}
