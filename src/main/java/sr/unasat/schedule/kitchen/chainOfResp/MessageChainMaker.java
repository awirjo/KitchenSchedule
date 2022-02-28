package sr.unasat.schedule.kitchen.chainOfResp;

public class MessageChainMaker {

    public void messageMaker(){
        System.out.println("Chain Of Responsibility Design Pattern Error Handling.\n");

        //End of Chain Of Responsibility:
        FirstDepartmentHandler firstDepartmentHandler = new FirstDepartmentHandler();

        //First handler
        SecondDepartmentHandler secondDepartmentHandler = new SecondDepartmentHandler();
        secondDepartmentHandler.setNextChain(firstDepartmentHandler);

        //Starting point: Raiser will raise issues and set the first handler:
        IssueRaiser raiser = new IssueRaiser(secondDepartmentHandler);

        Message m1 = new Message("ICT request order to be delivered", MessagePriority.High );

        raiser.raiseMessage(m1);
    }
}
