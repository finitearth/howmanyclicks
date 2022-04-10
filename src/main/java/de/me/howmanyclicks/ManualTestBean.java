package de.me.howmanyclicks;

import de.me.howmanyclicks.model.Session;
import de.me.howmanyclicks.model.Video;
import de.me.howmanyclicks.repository.SessionRepository;
import de.me.howmanyclicks.repository.UserRepository;
import de.me.howmanyclicks.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class ManualTestBean {
    SessionRepository sessionRepository;
    VideoRepository videoRepository;
    UserRepository userRepository;

    ManualTestBean(SessionRepository sessionRepository, VideoRepository VideoRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.videoRepository = VideoRepository;
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){
        List<Video> vids = List.of(
                    new Video("96TrU37lyjI", 35433, 413),
                    new Video("VgyIKqNmA74", 2670, 1597),
                    new Video("jeRgFqbBM5E", 1184567, 167),
                    new Video("W85oD8FEF78", 26768597, 25),
                    new Video("Nl6A6l79bsw", 2779186, 1672),
                    new Video("Km139_X0Q7w", 10933, 8440),
                    new Video("NOzNZuQc3QY", 414012, 318),
                    new Video("Zu_KROtD2pc", 104308, 334)
                );

        this.videoRepository.saveAll(vids);
        Session session = new Session(vids);
        this.sessionRepository.save(session);

    }
}
