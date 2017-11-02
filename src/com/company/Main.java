package com.company;

import com.company.Content.Content;
import com.company.Content.Video;
import com.company.Observer.Observer;
import com.company.Observer.Subscriber;
import com.company.Subject.Channel;
import com.company.Subject.Subject;

public class Main {

    public static void main(String[] args) {
        Subject funVideoChannel = new Channel("Funny videos");
        Subject videoGameChannel = new Channel("Let's play");

        Observer bobJackUser = new Subscriber("Robin Jack");
        Observer miniGirlUser = new Subscriber("Hellen Straford");
        Observer totalDominatorUser = new Subscriber("Mister Anonymous");
        Observer user001 = new Subscriber("Black Jack");

        bobJackUser.subscribe(funVideoChannel);
        miniGirlUser.subscribe(funVideoChannel);
        totalDominatorUser.subscribe(funVideoChannel);
        user001.subscribe(funVideoChannel);

        user001.subscribe(videoGameChannel);

        funVideoChannel.addContent(new Video("Cute kitties", "Cute kitties funny play in the garden"));
        videoGameChannel.addContent(new Video("Spin Tires","Play the best fame in the world: Sping Tires"));

        bobJackUser.unsubscribe(funVideoChannel);
        funVideoChannel.addContent(new Video("Drank man", "Drunk man fallen from bicycle"));

    }
}
