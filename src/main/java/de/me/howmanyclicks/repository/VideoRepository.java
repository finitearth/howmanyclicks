package de.me.howmanyclicks.repository;

import de.me.howmanyclicks.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query("SELECT v FROM Video v WHERE v.id = cast(RAND() * 8 as int) + 1")
    Video getRandVid();
}
