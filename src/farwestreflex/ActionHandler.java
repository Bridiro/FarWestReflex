package farwestreflex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//classe ActionListener per "capire" cosa l'utente ha premuto

public class ActionHandler implements ActionListener {

    GameManager gm;

    public ActionHandler(GameManager gm){

        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String yourChoice = e.getActionCommand();

        switch(yourChoice){

            case "welcome": gm.eHandler.welcome(); break;
            case "next": gm.eHandler.next(); break;
            case "skip": gm.eHandler.skip(); break;
            case "fire": gm.eHandler.fire(); break;
            case "restart": gm.eHandler.restart(); break;
        }
    }
}
