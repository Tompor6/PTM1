package test;


import java.util.HashMap;
import java.util.Map;

public class TopicManagerSingleton {



    public static TopicManager get(){
        return TopicManager.instance;
    }

    public static class TopicManager{
        private TopicManager(){}

        private Map<String, Topic> topics = new HashMap<>();

        private static final TopicManager instance = new TopicManager();

        public Topic getTopic(String Name){
            if(topics.containsKey(Name)){
                return topics.get(Name);
            }else{
                Topic t = new Topic(Name);
                topics.put(Name, t);
                return t;
            }
        }

        public Topic[] getTopics(){
            return topics.values().toArray(new Topic[0]);
        }

        public void clear(){
            topics.clear();
        }
    }





    
}
