package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.ImpuestosYTasas;

@Repository
public interface IImpuestosYTasasRepo extends JpaRepository<ImpuestosYTasas, Long> {

}
