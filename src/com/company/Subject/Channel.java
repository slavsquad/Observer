package com.company.Subject;

import com.company.Content.Content;
import com.company.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private List<Content> videos = new ArrayList<>();
    private String name;

    public Channel(String name) {
        this.name = name;
    }

    @Override
    public void attach(Observer observer) {
        if (!subscribers.contains(observer)){
            subscribers.add(observer);
            System.out.print((char) 27 + "[34mSubscription: " + (char)27 + "[0m");
            System.out.println(observer +" subscribed to channel " +this);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (subscribers.contains(observer)){
            subscribers.remove(observer);
            System.out.print((char) 27 + "[31mUnsubscription: " + (char)27 + "[0m");
            System.out.println(observer +" unsubscribed from channel" +this);
        }

    }

    @Override
    public void notifу() {
        for (Observer observer: subscribers){
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void addContent(Content content) {
        System.out.print((char) 27 + "[32mUpdate: " + (char)27 + "[0m");
        System.out.println(String.format("Channel[%s] add %s: %s | Description: %s",this,content.getClass().getSimpleName(),content.getName(),content.getDescription()));
        videos.add(content);
        notifу();
    }

    public Content getLastContent(){
        if (videos!=null && !videos.isEmpty()){
            return videos.get(videos.size()-1);
        }else {
            return null;
        }
    }
}
