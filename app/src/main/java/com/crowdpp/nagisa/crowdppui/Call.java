package com.crowdpp.nagisa.crowdppui;

/**
 * Created by nagisa on 5/1/17.
 */

public class Call {
    String name, date, duration;
    public Call(String name, String date, String duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }
}
