package com.company;

import com.company.Content.Video;
import com.company.Observer.Subscriber;
import com.company.Subject.Channel;

public class Main {

    public static void main(String[] args) {
        Channel funVideoChannel = new Channel("Funny videos");
        Channel videoGameChannel = new Channel("Let's play");

        Subscriber bobJackUser = new Subscriber("Robin Jack");
        Subscriber miniGirlUser = new Subscriber("Hellen Straford");
        Subscriber totalDominatorUser = new Subscriber("Mister Anonymous");
        Subscriber user001 = new Subscriber("Black Jack");

        bobJackUser.subscribe(funVideoChannel);
        miniGirlUser.subscribe(funVideoChannel);
        totalDominatorUser.subscribe(funVideoChannel);
        user001.subscribe(funVideoChannel);

        user001.subscribe(videoGameChannel);

        funVideoChannel.addContent(new Video("Cute kitties", "Cute kitties funny play in the garden"));
        videoGameChannel.addContent(new Video("Spin Tires","Play the best game in the world"));

        bobJackUser.unsubscribe(funVideoChannel);
        funVideoChannel.addContent(new Video("Drunk man", "Drunk man fallen from bicycle"));

    }
}
