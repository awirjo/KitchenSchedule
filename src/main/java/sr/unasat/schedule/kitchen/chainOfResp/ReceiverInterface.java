package sr.unasat.schedule.kitchen.chainOfResp;

public interface ReceiverInterface {
    boolean processMessage(Message msg);
    void setNextChain(ReceiverInterface nextChain);
}
