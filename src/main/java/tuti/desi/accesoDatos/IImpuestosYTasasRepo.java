package tuti.desi.accesoDatos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.ImpuestosYTasas;

@Repository
public interface IImpuestosYTasasRepo extends JpaRepository<ImpuestosYTasas, Long> {
	@Query("SELECT i FROM ImpuestosYTasas i WHERE ( i.id = :id) ")
	ImpuestosYTasas findBy_Id(@Param("id") Long id);

	Optional<ImpuestosYTasas> findById(@Param("id") Long id);

}
