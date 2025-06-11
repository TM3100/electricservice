package electricservice.repository;

import electricservice.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
   Optional<Cliente> findByCedula(String cedula);


   boolean existsByCedula(String cedula);
}
