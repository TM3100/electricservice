package electricservice.service;

import electricservice.model.Medidor;
import electricservice.repository.MedidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedidorService {

    private final MedidorRepository medidorRepository;

    @Autowired
    public MedidorService(MedidorRepository medidorRepository) {
        this.medidorRepository = medidorRepository;
    }

    /**
     * Guarda un medidor después de verificar que no exista otro medidor
     * con el mismo número, garantizando la unicidad para evitar duplicaciones.
     *
     * @param medidor Objeto Medidor a guardar.
     * @return El objeto Medidor guardado.
     * @throws RuntimeException si ya existe un medidor con el número proporcionado.
     */
    public Medidor guardarMedidor(Medidor medidor) {
        medidorRepository.findByNumeroMedidor(medidor.getNumeroMedidor())
                .ifPresent(existing -> {
                    throw new RuntimeException("Ya existe un medidor con el número: " + medidor.getNumeroMedidor());
                });
        return medidorRepository.save(medidor);
    }

    /**
     * Busca un medidor utilizando su número único.
     *
     * @param numeroMedidor El número de medidor por el que se realizará la búsqueda.
     * @return El objeto Medidor encontrado.
     * @throws RuntimeException si no se encuentra ningún medidor con el número indicado.
     */
    public Medidor buscarPorNumero(String numeroMedidor) {
        return medidorRepository.findByNumeroMedidor(numeroMedidor)
                .orElseThrow(() -> new RuntimeException("No se encontró medidor con el número: " + numeroMedidor));
    }

    // Se pueden agregar otros métodos, como listar, actualizar o eliminar medidores según se necesite.
}
