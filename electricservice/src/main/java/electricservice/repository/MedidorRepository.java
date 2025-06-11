package electricservice.repository;

import electricservice.model.Medidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedidorRepository extends JpaRepository<Medidor,Integer> {
   Optional<Medidor> findByNumeroMedidor(String numeroMedidor);
}
