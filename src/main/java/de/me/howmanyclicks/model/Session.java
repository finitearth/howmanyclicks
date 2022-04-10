package de.me.howmanyclicks.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue
    long id;

    @ManyToMany
    @JoinTable(
            name="session_user",
            joinColumns = {@JoinColumn(name="session_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    List<User> users;

    @ManyToMany
    @JoinTable(
            name="session_video",
            joinColumns = {@JoinColumn(name="session_id")},
            inverseJoinColumns = {@JoinColumn(name="video_id")}
    )
    List<Video> videos;

    int vids_to_go;

    public Session(List<Video> videos){
        this.videos = videos;
        this.vids_to_go = 5;
    }
}
