package de.me.howmanyclicks.repository;

import de.me.howmanyclicks.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session getSessionById(String s_id);


//    @Query("SELECT MIN(video_id) FROM Session WHERE id=:session")
//    public int getVideoById(String session);
}
