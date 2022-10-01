package farwestreflex;

public class Story {

    GameManager gm;

    int fight1 = 4;
    int fight2 = 7;
    int fight3 = 11;
    int fine = 14;

    public Story(GameManager gm){

        this.gm = gm;
    }

    //tutta la storia è basata su un counter, qui c'è cosa succede per ogni incremento
    public String getStory(int count){

        String phrase = "";

        switch(count){

            case 1: phrase = "Dopo anni ed anni di ricerca, Giangiovanni era finalmente riuscito a raggiungere la sua meta finale."; break;
            case 2: phrase = "Infatti, il villagio di Doran, era dove Hernandez e gli ultimi suoi scagnozzi si nascondevano."; break;
            case 3: phrase = "Scagnozzo : \"Maledetto! Come ci hai trovati?\"\nGiangiovanni : \"Me lo ha detto un vecchio.\""; break;
            case 4: phrase = "fbase"; break;
            case 5: phrase = "Cesar : \"V-v-vendicami, Ciro...\"\nCiro : \"CESAAAARRR! COME HAI POTUTOOO!\""; gm.sChanger.base(); break;
            case 6: phrase = "Giangiovanni : \"Con una pistola.\""; break;
            case 7: phrase = "fbase"; gm.fight.reactionTimeBad = 350; break;
            case 8: phrase = "Giangiovanni : \"HERNANDEZ!!\""; gm.sChanger.finale(); break;
            case 9: phrase = "Hernandez : \"Era a mi quien buscabas!\""; break;
            case 10: phrase = "Giangiovanni : \"...\""; break;
            case 11: phrase = "fboss"; gm.fight.reactionTimeBad = 250; break;
            case 12: phrase = "Hernandez : \"Por que me perseguiste hasta aquì?\""; break;
            case 13: phrase = "Giangiovanni : \"Para vengar a Alejandra\""; break;
            case 14: phrase = "FINE!"; break;
        }

        return phrase;
    }

    //funzione per "skippare" direttamente allo scontro
    public void skipToFight(){

        if(gm.counter < fight1){

            gm.counter = fight1;
        }
        else if(gm.counter < fight2){

            gm.counter = fight2;
        }
        else if(gm.counter < fight3){

            gm.counter = fight3;
        }
        else if(gm.counter < fine){

            gm.counter = fine;
        }
    }
}
