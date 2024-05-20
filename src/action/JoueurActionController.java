/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import Interface.IJoueurDao;
import beans.BeanException;
import beans.Joueur;
import dao.DaoException;
import vueSwing.FenetrePrincipal;

/**
 *
 * @author WalidDev
 */
public class JoueurActionController {

    private MainController mainController;
    private FenetrePrincipal mainWindow;
    private IJoueurDao joueurDao;
    private Joueur selectedJoueur;

    public JoueurActionController(MainController mainController, IJoueurDao joueurDao) {
        super();
        this.mainController = mainController;
        this.mainWindow = mainController.getMainWindow();
        this.joueurDao = joueurDao;

    }

    public IJoueurDao getJoueurDao() {
        return joueurDao;
    }

    public void setJoueurDao(IJoueurDao joueurDao) {
        this.joueurDao = joueurDao;
    }

    public void ActionMouseClickTabJoueur() {

        selectedJoueur = null;
        int rowIndex = mainWindow.getMainTabJoueur().getSelectedRow();
        if (rowIndex != -1) {
            for (Joueur joueur : joueurDao.getAllJoueur()) {
                if (Integer.parseInt(joueur.getId()) == Integer.parseInt((String) mainWindow.getMainTabJoueur().getValueAt(mainWindow.getMainTabJoueur().getSelectedRow(), 0))) {
                    selectedJoueur = joueur;
                }
            }
            mainController.setIdJoueurSelected(selectedJoueur.getId());
            mainWindow.getTextIdSelected().setText(selectedJoueur.getId());
            mainWindow.getTextNomSelected().setText(selectedJoueur.getNom());
            mainWindow.getTextPrenomSelected().setText(selectedJoueur.getPrenom());
            mainWindow.getTextSexeSelected().setText(selectedJoueur.getSexe());
        }
    }

    public void actionAddJoueur() throws BeanException, DaoException {

        if (joueurDao.ajouter(new Joueur(mainWindow.getTextNomSelected().getText(),
                mainWindow.getTextPrenomSelected().getText(),
                mainWindow.getTextSexeSelected().getText()))) {

            System.out.println("Joueur ajouté");
            mainWindow.refreshMainTabJoueur();
        } else {
            System.out.println("Ajout annulé");
        }

        mainController.setIdJoueurSelected("");
        mainWindow.getTextIdSelected().setText("");
        mainWindow.getTextNomSelected().setText("");
        mainWindow.getTextPrenomSelected().setText("");
        mainWindow.getTextSexeSelected().setText("");

    }

    public void actionEditJoueur() throws BeanException, DaoException {

        if (selectedJoueur != null
                && joueurDao.modifier(selectedJoueur.getId(),
                        new Joueur(mainController.getMainWindow().getTextNomSelected().getText(),
                                mainController.getMainWindow().getTextPrenomSelected().getText(),
                                mainController.getMainWindow().getTextSexeSelected().getText()))) {

            System.out.println("Joueur modifié");
            selectedJoueur = null;
            mainWindow.refreshMainTabJoueur();
        } else {
            System.out.println("Modification annulé");
        }
        mainController.setIdJoueurSelected("");
        mainWindow.getTextIdSelected().setText("");
        mainWindow.getTextNomSelected().setText("");
        mainWindow.getTextPrenomSelected().setText("");
        mainWindow.getTextSexeSelected().setText("");
    }

    public void actionDeleteJoueur() throws BeanException, DaoException {

        if (selectedJoueur != null && joueurDao.supprimer(selectedJoueur.getId())) {

            System.out.println("Joueur supprimé");
            selectedJoueur = null;
            mainWindow.refreshMainTabJoueur();
        } else {
            System.out.println("Suppression annulé");
        }
        mainController.setIdJoueurSelected("");
        mainWindow.getTextIdSelected().setText("");
        mainWindow.getTextNomSelected().setText("");
        mainWindow.getTextPrenomSelected().setText("");
        mainWindow.getTextSexeSelected().setText("");
    }

}
