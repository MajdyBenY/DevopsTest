package tn.esprit.devops.services.chambre;

import tn.esprit.devops.dao.entities.Chambre;
import tn.esprit.devops.dao.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdate(Chambre c);
    List<Chambre> findAll();
    Chambre findById(long id);
    void deleteById(long id);
    void delete(Chambre c);
    List<Chambre>  getChambresParNomBloc( String nomBloc);
    long  nbChambreParTypeEtBloc(TypeChambre type, long idBloc);
    List<Chambre>  getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type);
    void listeChambresParBloc();
    void pourcentageChambreParTypeChambre();
    void nbPlacesDisponibleParChambreAnneeEnCours();

    List<Chambre> getChambresParNomBlocJava( String nomBloc);
    List<Chambre>getChambresParNomBlocKeyWord( String nomBloc);
    List<Chambre>getChambresParNomBlocJPQL( String nomBloc);
    List<Chambre>getChambresParNomBlocSQL( String nomBloc);


}
