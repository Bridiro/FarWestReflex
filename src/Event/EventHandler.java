package Event;

import farwestreflex.GameManager;

//classe che contiene una funzione per ogni possiblile interazione dell'utente con l'applicazione

public class EventHandler {

    GameManager gm;

    public EventHandler(GameManager gm){

        this.gm = gm;
    }

    public void next(){

        gm.counter += 1;
        String text = gm.story.getStory(gm.counter);

        if(text.equals("fboss")){
            gm.fight.setFightBoss();
        }
        else if(text.equals("fbase")){
            gm.fight.setFightBase();
        }
        else if(text.equals("FINE!")){
            gm.ui.buttonSkipAll.setVisible(false);
            gm.ui.buttonNext.setVisible(false);
            gm.ui.buttonFire.setVisible(false);
            gm.ui.buttonRestart.setVisible(true);
        }
        else{
            gm.ui.messageText.setText(text);
        }
    }

    public void skip(){

        gm.story.skipToFight();
        String text = gm.story.getStory(gm.counter);

        if(text.equals("fboss")){
            gm.fight.setFightBoss();
        }
        else if(text.equals("fbase")){
            gm.fight.setFightBase();
        }
        else if(text.equals("FINE!")){
            gm.ui.buttonSkipAll.setVisible(false);
            gm.ui.buttonNext.setVisible(false);
            gm.ui.buttonFire.setVisible(false);
            gm.ui.buttonRestart.setVisible(true);
        }
    }

    public void fire(){

        gm.fight.finishTime = System.currentTimeMillis();

        gm.fight.reactionTime = gm.fight.finishTime - gm.fight.startTime;

        if(gm.sounds.bellsStarted && gm.fight.reactionTime < gm.fight.reactionTimeBad){

            gm.sounds.playGun();
            gm.fight.setDead();
        }
        else{

            gm.sounds.playGun();
            gm.fight.setGoodDead();
        }
    }

    public void welcome(){

        gm.sChanger.base();
    }

    public void restart(){

        gm.counter = 0;
        gm.sChanger.intro();
    }
}
