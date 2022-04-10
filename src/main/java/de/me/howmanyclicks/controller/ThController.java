package de.me.howmanyclicks.controller;

import de.me.howmanyclicks.model.Session;
import de.me.howmanyclicks.model.Video;
import de.me.howmanyclicks.repository.SessionRepository;
import de.me.howmanyclicks.repository.UserRepository;
import de.me.howmanyclicks.repository.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThController {
    VideoRepository vr;
    UserRepository ur;
    SessionRepository sr;

    public ThController(VideoRepository vr, UserRepository ur, SessionRepository sr){
        this.vr = vr;
        this.ur = ur;
        this.sr = sr;
    }

    @RequestMapping("/")
    public String showMenu(){
        return "menu";
    }

    @RequestMapping("video")
    public ModelAndView showVideo(
            @RequestParam("s") String s_id
    ){
        Video vid = null;
        while (vid == null) {
            vid = vr.getRandVid();
        }
        Session sess = sr.getSessionById(s_id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("vid", vid);
        mav.addObject("sess", sess);
        return mav;
    }

    @RequestMapping("/result")
    public ModelAndView showResult(
            @RequestParam("s") String s_id,
            @RequestParam("g") String guess
    ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("guess", guess);
        mav.addObject("actual", "idk");
        return mav;
    }

}