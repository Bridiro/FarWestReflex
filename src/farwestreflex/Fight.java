package farwestreflex;

//classe che gestisce l'intero combattimento

public class Fight {

    GameManager gm;

    String dead;

    public int reactionTimeBad = 400;

    public long startTime, finishTime, reactionTime;

    public Fight(GameManager gm){

        this.gm = gm;
    }

    public void setFightBase(){

        gm.sChanger.base();
        gm.ui.buttonSkipAll.setVisible(false);
        gm.ui.buttonNext.setVisible(false);
        gm.ui.buttonFire.setVisible(true);
        gm.ui.messageText.setText("Devi sparare più velocemente possibile appena senti la campana del mezzogiorno.");
        dead = "base";
        gm.sounds.bellsStarted = false;
        gm.sounds.setTimerBell();
    }

    public void setFightBoss(){

        gm.sChanger.finale();
        gm.ui.buttonSkipAll.setVisible(false);
        gm.ui.buttonNext.setVisible(false);
        gm.ui.buttonFire.setVisible(true);
        gm.ui.messageText.setText("Devi sparare più velocemente possibile appena senti la campana del mezzogiorno.");
        dead = "boss";
        gm.sounds.bellsStarted = false;
        gm.sounds.setTimerBell();
    }

    public void setDead(){

        if(dead == "base"){

            gm.sChanger.dead_enemy();
            gm.ui.messageText.setText("Complimenti, hai eliminato il primo ostacolo che ti separa dal tuo più grande nemico!\nTempo di reazione: " + reactionTime + "m/s");
        }
        else if(dead == "boss"){

            gm.sChanger.finale_mexican_dead();
            gm.ui.messageText.setText("Complimenti, hai eliminato il più grande nemico degli Stati Uniti e permesso la ricostruzione Del Muro!\nTempo di reazione: " + reactionTime + "m/s");
        }
    }

    public void setGoodDead(){

        if(gm.sounds.bellsStarted){

            if(dead == "base"){

                gm.sChanger.dead_good();
                gm.ui.messageText.setText("TEMPO DI REAZIONE SOTTO ALLA MEDIA\nTempo di reazione: " + reactionTime + "m/s");
            }
            else if(dead == "boss") {

                gm.sChanger.finale_good_dead();
                gm.ui.messageText.setText("TEMPO DI REAZIONE SOTTO ALLA MEDIA\nTempo di reazione: " + reactionTime + "m/s");
            }
        }
        else{

            gm.sounds.t.cancel();
            if(dead == "base"){

                gm.sChanger.dead_good();
                gm.ui.messageText.setText("NON SI BARA!\nPENA CAPITALE PER CHI NON SEGUE LE REGOLE");
            }
            else if(dead == "boss") {

                gm.sChanger.finale_good_dead();
                gm.ui.messageText.setText("NON SI BARA!\nPENA CAPITALE PER CHI NON SEGUE LE REGOLE");
            }
        }
    }
}
