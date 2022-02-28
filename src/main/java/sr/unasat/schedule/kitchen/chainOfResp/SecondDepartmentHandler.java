package sr.unasat.schedule.kitchen.chainOfResp;

import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.Menu;

public class SecondDepartmentHandler implements ReceiverInterface {
    private ReceiverInterface nextReceiver;
    MenuDAO menuDAO = new MenuDAO();

    public void setNextChain(ReceiverInterface nextReceiver) { this.nextReceiver = nextReceiver; }

    public boolean processMessage(Message msg) {
        if (msg.text.contains("Hrm"))  {
            Menu menu = menuDAO.findByMealForIct("Porridge");
            System.out.println("The following menu for Hrm Department has been requested: " + menu + "\n" + msg.priority + "priority issue: "+ msg.text);
            return true;
        }
        else { if (nextReceiver != null) { nextReceiver.processMessage(msg); } }
        return false;
    }
}
