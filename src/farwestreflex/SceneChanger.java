package farwestreflex;

//classe per il cambio di scena, ogni scena è in un layer che fa parte di un array

public class SceneChanger {

    GameManager gm;

    public SceneChanger(GameManager gm){

        this.gm = gm;
    }

    //per passare alla intro
    public void intro(){

        gm.ui.bgPanel[0].setVisible(true);
        gm.ui.panelText.setVisible(false);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(true);
        gm.ui.buttonSkipAll.setVisible(true);
        gm.ui.buttonRestart.setVisible(false);
        gm.ui.messageText.setText("Premere \"Next\" per passare al prossimo dialogo.\nPremere \"Skip\" per andare direttamente allo scontro.");
    }

    //per passare alla scena con lo scagnozzo (entrabi vivi)
    public void base(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.panelText.setVisible(true);
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(true);
        gm.ui.buttonSkipAll.setVisible(true);
        gm.ui.buttonRestart.setVisible(false);
    }

    //per passare alla scena con lo scagnozzo morto
    public void dead_enemy(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(true);
        gm.ui.buttonSkipAll.setVisible(true);
        gm.ui.buttonRestart.setVisible(false);
    }

    //per passare alla scena con lo scagnozzo (noi morti)
    public void dead_good(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(false);
        gm.ui.buttonSkipAll.setVisible(false);
        gm.ui.buttonRestart.setVisible(true);
    }

    //scena finale (entrambi vivi)
    public void finale(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(true);
        gm.ui.buttonSkipAll.setVisible(true);
        gm.ui.buttonRestart.setVisible(false);
    }

    //scena finale con cattivo morto
    public void finale_mexican_dead(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(true);
        gm.ui.buttonSkipAll.setVisible(true);
        gm.ui.buttonRestart.setVisible(false);
    }

    //scena finale noi morti
    public void finale_good_dead(){

        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(true);
        gm.ui.buttonFire.setVisible(false);
        gm.ui.buttonNext.setVisible(false);
        gm.ui.buttonSkipAll.setVisible(false);
        gm.ui.buttonRestart.setVisible(true);
    }
}
