package farwestreflex;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;
import java.util.Timer;

//classe per la riproduzione di suoni
//problemi inizialmente riscontrati:
//      la campana suonava anche se si sparava prima del suono, quindi se si riniziava velocemente i suoni si sovrapponevano
//
//      prima di usare la funzione Timer avevamo provato con delay, ma c'era un errore visto che si bloccava l'applicazione e creava delle eccezioni del JFrame
//
//      il suono della campana non inizia precisamente con l'inizio della clip, quindi la misurazione dei millisecondi non era corretta, ora aggiunto un delay anche per l'inizio dela misurazione

public class Sounds {

    GameManager gm;

    public boolean bellsStarted;

    public Timer t;

    public Sounds(GameManager gm){

        this.gm = gm;
    }

    public void playGun(){

        try{

            File path = new File(getClass().getClassLoader().getResource("rowdy-gun-shot-long-hit_1bpm_C.wav").toURI());

            if(path.exists()){

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
                Clip clip1 = AudioSystem.getClip();
                clip1.open(audioInput);
                clip1.start();
            }
            else{

                System.out.println("Can't find gun sound");
            }
        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    public void playBells(){

        try{

            File path = new File(getClass().getClassLoader().getResource("mixkit-church-bell-loop-621.wav").toURI());

            if(path.exists()){

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{

                System.out.println("Can't find bells sound");
            }
        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    public void setTimerBell(){

        Random rand = new Random();
        int delay = rand.nextInt(5000);
        delay += 5000;

        t = new Timer();
        t.schedule(
                new java.util.TimerTask(){
                    @Override
                    public void run(){
                        bellsStarted = true;
                        startBellRecordTimer();
                        gm.sounds.playBells();
                        t.cancel();
                    }
                },
                delay
        );
    }

    void startBellRecordTimer(){

        Timer timer = new java.util.Timer();
        timer.schedule(
                new java.util.TimerTask(){
                    @Override
                    public void run() {
                        gm.fight.startTime = System.currentTimeMillis();
                        timer.cancel();
                    }
                },
                150
        );
    }
}
