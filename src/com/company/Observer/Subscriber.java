package com.company.Observer;

import com.company.Content.Content;
import com.company.Subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer {
    private String name;
    private List<Subject> subscriptions = new ArrayList<>();

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subject subject){
        if (!subscriptions.contains(subject)){
            subscriptions.add(subject);
            subject.register(this);
        }
    }

    @Override
    public void unsubscribe(Subject subject) {
        if (subscriptions.contains(subject)){
            subscriptions.remove(subject);
            subject.delete(this);
        }
    }

    @Override
    public void update(Subject subject) {
        Content video;
        video =  subject.getLastContent();
        if (video == null){
            System.out.println("This video is not exist!");
        }else {
            System.out.print((char) 27 + "[35mNotify: " + (char)27 + "[0m");
            System.out.print(this +" watch ");
            video.show();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
