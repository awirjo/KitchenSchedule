package sr.unasat.schedule.kitchen.chainOfResp;

public class MessageChainMaker {

    public void messageMaker(){
        System.out.println("Chain Of Responsibility Design Pattern Error Handling.\n");

        //Making the Chain Of Responsibility:  Fax -> email
        ReceiverInterface faxHandler, emailHandler;

        //End of Chain Of Responsibility:
        emailHandler = new FirstDepartmentHandler();

        //Fax handler is before email
        faxHandler = new SecondDepartmentHandler();
        faxHandler.setNextChain(emailHandler);

        //Starting point: Raiser will raise issues and set the first handler:
        IssueRaiser raiser = new IssueRaiser(faxHandler);

        Message m1 = new Message("ICT request order to be delivered", MessagePriority.High);

        raiser.raiseMessage(m1);
    }
}
