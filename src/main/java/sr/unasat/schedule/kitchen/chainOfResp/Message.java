package sr.unasat.schedule.kitchen.chainOfResp;

public class Message {
    public String text;
    public MessagePriority priority;

    public Message(String msg, MessagePriority p){
        text = msg;
        priority = p;
    }
}

enum MessagePriority { Normal, High }
