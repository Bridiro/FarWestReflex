package farwestreflex;

import Event.EventHandler;

//classe principale che collega tutte le altre tra di loro
public class GameManager {

    public int counter = 0;

    public ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public SceneChanger sChanger = new SceneChanger(this);
    public Story story = new Story(this);

    public EventHandler eHandler = new EventHandler(this);
    public Sounds sounds = new Sounds(this);
    public Fight fight = new Fight(this);

    public static void main(String[] args) {

        new GameManager();
    }

    public GameManager() {


    }
    
}
