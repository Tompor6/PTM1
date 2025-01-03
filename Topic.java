package test;

import test.Agent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Topic{
    public final String name;
    Topic(String name){
        this.name=name;
    }
    List<Agent> subs = new LinkedList<>();
    List<Agent> pubs = new LinkedList<>();

    public void subscribe(Agent a){
        subs.add(a);
    }
    public void unsubscribe(Agent a){
        subs.remove(a);
    }

    public void publish(Message m){
        for(Agent a: subs){
            try {
                a.callback(name, m);
            }catch (Exception e){
                System.err.println("Failed to notify agent: " + e.getMessage());
            }
        }
    }

    public void addPublisher(Agent a){
        pubs.add(a);
    }

    public void removePublisher(Agent a){
        pubs.remove(a);
    }


}
