package tn.esprit.devops.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.devops.dao.entities.Bloc;
import tn.esprit.devops.dao.entities.TypeChambre;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {

    @Query("select b from Bloc b where b.nomBloc=?1")
    Bloc selectByNomBJPQL1(String nom);

    @Query("select b from Bloc b where b.nomBloc=:nom")
    Bloc selectByNomBJPQL2(@Param("nom") String nom);

    @Query(value = "SELECT * FROM t_bloc WHERE nom_bloc=?1  ", nativeQuery = true)
    Bloc selectByNomBSQL1(String nom);

    @Query(value = "SELECT * FROM t_bloc WHERE nom_bloc=:nom  ", nativeQuery = true)
    Bloc selectByNomBSQL2(@Param("nom") String nom);

    @Modifying
    @Query("update Bloc b set b.nomBloc=?1 where b.capaciteBloc<10")
    void updateBlocJPQL(String nom);

    @Modifying
    @Query(value = "update t_bloc set nom_bloc=?1 where capacite_bloc<10", nativeQuery = true)
    void updateBlocSQL(String nom);
    @Query("select b from Bloc b join Chambre c on c.bloc.idBloc=b.idBloc  where c.typeC=?1")
    List<Bloc> selectBlocsByTypeChambreJPQL(TypeChambre typeChambre);

    List<Bloc> getByNomBloc(String nom);

    Bloc findByNomBloc(String nom);

    List<Bloc> getByCapaciteBloc(long cap);

    Bloc findByCapaciteBloc(long cap);

    List<Bloc> getByNomBlocAndCapaciteBloc(String nomB, long cap);

    List<Bloc> findByNomBlocIgnoreCase(String nomB);

    List<Bloc> findByCapaciteBlocGreaterThan(long cap);


    List<Bloc> findByNomBlocLike(String nom);


    List<Bloc> getByNomBlocOrCapaciteBloc(String nomB, long cap);


    List<Bloc> findByFoyerIdFoyer(long idFoyer);

    @Query("select b from Bloc b where b.foyer.idFoyer= ?1")
    List<Bloc> findByFoyerIdFoyerJPQL(long idFoyer);

    List<Bloc> findByFoyerUniversiteIdUniversite(long idUniversite);

    @Query("select b from Bloc b where b.foyer.universite.idUniversite=?1")
    List<Bloc> findByFoyerUniversiteIdUniversiteJPQL(long idUniversite);

    @Query("select b from Bloc b where b.foyer.idFoyer=?1 ")
    List<Bloc> req9JPQL(long idF);
    @Query(value = "SELECT b.* FROM t_bloc b JOIN t_foyer " +
            "f ON f.id_foyer= b.foyer_id_foyer  WHERE f.id_foyer=?1", nativeQuery = true)
    List<Bloc> req9SQL(long idF);

    @Query("select b from Bloc b where b.foyer.universite.idUniversite=?1 ")
    List<Bloc> req10JPQL(long idU);
    @Query(value = "SELECT * FROM t_bloc b JOIN t_foyer f " +
            "ON f.id_foyer= b.foyer_id_foyer JOIN t_universite u " +
            "ON u.foyer_id_foyer=f.id_foyer WHERE u.id_universite=?1;"
            , nativeQuery = true)
    List<Bloc> req10SQL(long idU);





    

}
