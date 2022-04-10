package de.me.howmanyclicks.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue
    public long id;

    public String url;
    public int views;
    public int start_vid;

    public Video(String url, int views, int start_vid){
        this.url = url;
        this.views = views;
        this.start_vid = start_vid;
    }
}
