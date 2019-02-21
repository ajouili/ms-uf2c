package org.sid;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	/**
	 * la prémiere methode utilisant le nom de la methode comme
	 * requeete SQL
	 * @param nom
	 * @return
	 */
	public List<Etudiant> findByNomContains(String nom);
	
	/**
	 * la seconde methode utilisant @Query pour ecrire la requette
	 * et x c'est le parametre qui represante l'attribut nom
	 * cette requette s'appelle hql
	 * @param nom
	 * @return
	 */
	
//	@Query("select p from Etudiant e where e.nom like :x")
//	public List<Etudiant> checher(@Param("x")String nom);
}
