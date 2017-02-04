package com.boom.lobby;

import com.boom.lobby.matchmaker.Id;
import com.boom.lobby.matchmaker.MatchMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class GreetingController {

    private final MatchMaker matchMaker;

    @Autowired
    public GreetingController(MatchMaker matchMaker) {
        this.matchMaker = matchMaker;
    }

    @RequestMapping("/echo")
    public String echo(@RequestParam(value = "name") String name) {
        return name;
    }

    @RequestMapping("/join")
    public URL join(@RequestParam(value = "name", defaultValue = "World") Id id) throws MalformedURLException {
//        return matchMaker.join(id).get();
        return new URL("http://www.google.com");
    }
}