package sr.unasat.schedule.kitchen.chainOfResp;

import sr.unasat.schedule.kitchen.dao.DepartmentDAO;
import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.Department;
import sr.unasat.schedule.kitchen.entities.Menu;

public class FirstDepartmentHandler implements ReceiverInterface  {
    private ReceiverInterface nextReceiver;
    MenuDAO menuDAO = new MenuDAO();

    public void setNextChain(ReceiverInterface nextReceiver) { this.nextReceiver = nextReceiver; }

    public boolean processMessage(Message msg)  {
        if (msg.text.contains("ICT"))  {
            Menu menu = menuDAO.findByMealForIct("Waffle");
            System.out.println("The following menu for ICT Department has been requested: " + menu + "\n" + msg.priority + "priority issue: "+ msg.text);
            return true;
        }
        else { if (nextReceiver != null) { nextReceiver.processMessage(msg); } }
        return false;
    }
}
