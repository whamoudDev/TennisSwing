/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import Interface.IMatchDao;
import beans.MatchVersion;
import vueSwing.FenetrePrincipal;

/**
 *
 * @author WalidDev
 */
public class MatchActionController {
    
    private MainController mainController;
    private FenetrePrincipal mainWindow;
    private IMatchDao matchDao;
    private MatchVersion selectedMatchVersion;

    public MatchActionController(MainController mainController, IMatchDao matchDao) {
       super();
       this.mainController = mainController;
       this.mainWindow = mainController.getMainWindow();
       this.matchDao = matchDao;
    }
    
    public void actionComboListMatchVainqueurFinaliste(){
        
        String version = mainWindow.getComboListMatchVainqueurFinaliste().getSelectedItem().toString();
        if(version.equals("Vainqueur")){
            mainWindow.refreshMainTabMatchVainqueur();
        }else{
            mainWindow.refreshMainTabMatchFinaliste();
        }
     
    }
    
}
