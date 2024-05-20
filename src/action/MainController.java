/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import Interface.IEpreuveDao;
import Interface.IJoueurDao;
import Interface.IMatchDao;
import Interface.ITournoiDao;
import beans.BeanException;
import dao.DaoException;
import java.sql.SQLException;
import dao.DaoFactory;
import dao.EpreuveDaoImpl;
import dao.JoueurDaoImpl;
import dao.MatchDaoImpl;
import dao.TournoiDaoImpl;
import dao.UserDaoImpl;
import vueSwing.FenetrePrincipal;

/**
 *
 * @author WalidDev
 */
public class MainController {

    private FenetrePrincipal mainWindow;
    private UserDaoImpl userDao;
    private IJoueurDao joueurDao;
    private ITournoiDao tournoiDao;
    private IMatchDao matchDao;
    private IEpreuveDao epreuveDao;
    ////////////////////////PanJoueur
    private String[] headerMainTabJoueur;
    private String idJoueurSelected;
    ////////////////////////PanTournoi
    private String[] headerMainTabTournoi;
    private String idTournoiSelected;
    ////////////////////////PanMatch
    private String[] headerMainTabMatchVainqueur;
    private String[] headerMainTabMatchFinaliste;
    private String idMatchSelected;
    
    ////////////////////////PanEpreuve
    private String[] headerMainTabEpreuve;

    

    public MainController() throws BeanException, DaoException {

        //Initilisation des libelles des tableaux
        headerMainTabJoueur = new String[]{"ID", "NOM", "PRENOM", "SEXE"};
        headerMainTabTournoi = new String[]{"ID", "NOM", "CODE"};
        headerMainTabMatchVainqueur = new String[]{"IDMatch","IDVainqueur", "NOM", "PRENOM","SEXE"};
        headerMainTabMatchFinaliste= new String[]{"IDMatch","IDFinaliste", "NOM", "PRENOM","SEXE"};
        headerMainTabEpreuve= new String []{"IDEpreuve", "Annee", "Type", "IdMatch", "NomVainqueur", "PrenomVainqueur", "NomFinaliste","PrenomFinaliste"};
        //Initialisation de la DaoFactory
        userDao = new UserDaoImpl(DaoFactory.getInstance());
        //Initialisation des interfaces
        joueurDao = new JoueurDaoImpl(userDao.getDaoFactory());
        tournoiDao = new TournoiDaoImpl(userDao.getDaoFactory());
        matchDao = new MatchDaoImpl(userDao.getDaoFactory());
        epreuveDao = new EpreuveDaoImpl(userDao.getDaoFactory());
        //Initialisation de la fenetre swing
        mainWindow = new FenetrePrincipal(this);
        mainWindow.setVisible(true);
    }

    public FenetrePrincipal getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(FenetrePrincipal mainWindow) {
        this.mainWindow = mainWindow;
    }

    public String[] getHeaderMainTabJoueur() {
        return headerMainTabJoueur;
    }

    public void setHeaderMainTabJoueur(String[] headerMainTabJoueur) {
        this.headerMainTabJoueur = headerMainTabJoueur;
    }

    public String getIdJoueurSelected() {
        return idJoueurSelected;
    }

    public void setIdJoueurSelected(String idJoueurSelected) {
        this.idJoueurSelected = idJoueurSelected;
    }

    public String[] getHeaderMainTabTournoi() {
        return headerMainTabTournoi;
    }

    public void setHeaderMainTabTournoi(String[] headerMainTabTournoi) {
        this.headerMainTabTournoi = headerMainTabTournoi;
    }

    public String getIdTournoiSelected() {
        return idTournoiSelected;
    }

    public void setIdTournoiSelected(String idTournoiSelected) {
        this.idTournoiSelected = idTournoiSelected;
    }

    public IJoueurDao getJoueurDao() {
        return joueurDao;
    }

    public void setJoueurDao(IJoueurDao joueurDao) {
        this.joueurDao = joueurDao;
    }

    public ITournoiDao getTournoiDao() {
        return tournoiDao;
    }

    public void setTournoiDao(ITournoiDao tournoiDao) {
        this.tournoiDao = tournoiDao;
    }

    public IMatchDao getMatchDao() {
        return matchDao;
    }

    public void setMatchDao(IMatchDao matchDao) {
        this.matchDao = matchDao;
    }

    public String[] getHeaderMainTabMatchFinaliste() {
        return headerMainTabMatchFinaliste;
    }

    public void setHeaderMainTabMatchFinaliste(String[] headerMainTabMatchFinaliste) {
        this.headerMainTabMatchFinaliste = headerMainTabMatchFinaliste;
    }

    public String[] getHeaderMainTabMatchVainqueur() {
        return headerMainTabMatchVainqueur;
    }

    public void setHeaderMainTabMatchVainqueur(String[] headerMainTabMatchVainqueur) {
        this.headerMainTabMatchVainqueur = headerMainTabMatchVainqueur;
    }

   

    public String getIdMatchSelected() {
        return idMatchSelected;
    }

    public void setIdMatchSelected(String idMatchSelected) {
        this.idMatchSelected = idMatchSelected;
    }

    public IEpreuveDao getEpreuveDao() {
        return epreuveDao;
    }

    public void setEpreuveDao(IEpreuveDao epreuveDao) {
        this.epreuveDao = epreuveDao;
    }

    public String[] getHeaderMainTabEpreuve() {
        return headerMainTabEpreuve;
    }

    public void setHeaderMainTabEpreuve(String[] headerMainTabEpreuve) {
        this.headerMainTabEpreuve = headerMainTabEpreuve;
    }

    
    
    public static void main(String args[]) throws SQLException, BeanException, DaoException {

        new MainController();

    }

}
