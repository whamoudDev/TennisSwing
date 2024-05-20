/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import Interface.ITournoiDao;
import beans.Tournoi;
import vueSwing.FenetrePrincipal;

/**
 *
 * @author WalidDev
 */
public class TournoiActionController {

    private MainController mainController;
    private FenetrePrincipal mainWindow;
    private ITournoiDao tournoiDao;
    private Tournoi selectedTournoi;

    public TournoiActionController(MainController mainController, ITournoiDao tournoiDao) {
        super();
        this.mainController = mainController;
        this.mainWindow = mainController.getMainWindow();
        this.tournoiDao = tournoiDao;

    }

    public ITournoiDao getTournoiDao() {
        return tournoiDao;
    }

    public void setTournoiDao(ITournoiDao tournoiDao) {
        this.tournoiDao = tournoiDao;
    }

    public void ActionMouseClickTabTournoi() {

        selectedTournoi = null;
        int rowIndex = mainWindow.getMainTabTournoi().getSelectedRow();
        if (rowIndex != -1) {
            for (Tournoi tournoi : tournoiDao.getAllTournoi()) {
                if (Integer.parseInt(tournoi.getId()) == Integer.parseInt((String) mainWindow.getMainTabTournoi().getValueAt(mainWindow.getMainTabTournoi().getSelectedRow(), 0))) {
                    selectedTournoi = tournoi;
                }
            }

            mainController.setIdTournoiSelected(selectedTournoi.getId());
            mainWindow.getTextIdTournoiSelected().setText(selectedTournoi.getId());
            mainWindow.getTextNomTournoiSelected().setText(selectedTournoi.getNom());
            mainWindow.getTextCodeTournoiSelected().setText(selectedTournoi.getCode());

        }
    }

    public void actionAddTournoi() {

        if (tournoiDao.ajouter(new Tournoi(mainWindow.getTextNomTournoiSelected().getText(),
                mainWindow.getTextCodeTournoiSelected().getText()))) {

            System.out.println("Tournoi ajouté");
            mainWindow.refreshMainTabTournoi();
        } else {
            System.out.println("Ajout annulé");
        }
        mainController.setIdTournoiSelected("");
        mainWindow.getTextIdTournoiSelected().setText("");
        mainWindow.getTextNomTournoiSelected().setText("");
        mainWindow.getTextCodeTournoiSelected().setText("");
    }

    public void actionEditTournoi() {

        if (selectedTournoi != null
                && tournoiDao.modifier(selectedTournoi.getId(),
                        new Tournoi(mainController.getMainWindow().getTextNomTournoiSelected().getText(),
                                mainController.getMainWindow().getTextCodeTournoiSelected().getText()))) {

            System.out.println("Tournoi modifié");
            selectedTournoi = null;
            mainWindow.refreshMainTabTournoi();
        } else {
            System.out.println("Modification annulé");
        }
        mainController.setIdTournoiSelected("");
        mainWindow.getTextIdTournoiSelected().setText("");
        mainWindow.getTextNomTournoiSelected().setText("");
        mainWindow.getTextCodeTournoiSelected().setText("");
    }

    public void actionDeleteTournoi() {

        if (selectedTournoi != null && tournoiDao.supprimer(selectedTournoi.getId())) {

            System.out.println("Tournoi supprimé");
            selectedTournoi = null;
            mainWindow.refreshMainTabTournoi();
        } else {
            System.out.println("Suppression annulé");
        }
        mainController.setIdTournoiSelected("");
        mainWindow.getTextIdTournoiSelected().setText("");
        mainWindow.getTextNomTournoiSelected().setText("");
        mainWindow.getTextCodeTournoiSelected().setText("");
    }

}
