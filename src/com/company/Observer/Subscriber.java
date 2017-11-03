package com.company.Observer;

import com.company.Content.Content;
import com.company.Subject.Channel;
import com.company.Subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer {
    private String name;
    private List<Subject> subscriptions = new ArrayList<>();

    public Subscriber(String name) {
        this.name = name;
    }

    public void subscribe(Subject subject){
        if (!subscriptions.contains(subject)){
            System.out.print((char) 27 + "[34mSubscription: " + (char)27 + "[0m");
            System.out.println(this +" subscribed to channel " +subject);
            subscriptions.add(subject);
            subject.attach(this);
        }
    }

    public void unsubscribe(Subject subject) {
        if (subscriptions.contains(subject)){
            System.out.print((char) 27 + "[31mUnsubscription: " + (char)27 + "[0m");
            System.out.println(this +" unsubscribed from channel" +subject);
            subscriptions.remove(subject);
            subject.detach(this);
        }
    }

    @Override
    public void update(Subject subject) {
        Content content;
        if (subject instanceof Channel){
            Channel channel = (Channel)subject;
            content =  channel.getLastContent();
            if (content == null){
                System.out.println("This video is not exist!");
            }else {
                System.out.print((char) 27 + "[35mNotify: " + (char)27 + "[0m");
                System.out.println(String.format("%s got %s: %s ",this,content.getClass().getSimpleName(),content.getName()));
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
