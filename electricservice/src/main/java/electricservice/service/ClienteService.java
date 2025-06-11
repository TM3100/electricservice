package electricservice.service;

import electricservice.model.Cliente;
import electricservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Guarda un cliente después de validar que no exista ya un cliente con la misma cédula.
     *
     * @param cliente Objeto Cliente a guardar.
     * @return El objeto Cliente guardado.
     * @throws RuntimeException si ya existe un cliente con la cédula dada.
     */
    public Cliente guardarCliente(Cliente cliente) {
        clienteRepository.findByCedula(cliente.getCedula())
                .ifPresent(existing -> {
                    throw new RuntimeException("Ya existe un cliente con la cédula: " + cliente.getCedula());
                });

        return clienteRepository.save(cliente);
    }

    /**
     * Busca un cliente utilizando su cédula.
     *
     * @param cedula La cédula por la que se realizará la búsqueda.
     * @return El objeto Cliente encontrado.
     * @throws RuntimeException si no existe un cliente con la cédula proporcionada.
     */
    public Cliente buscarPorCedula(String cedula) {
        return clienteRepository.findByCedula(cedula).get();

    }

    // Se pueden agregar otros métodos para listar, actualizar o eliminar clientes según se requiera.
  public List<Cliente> getAll(){
        return clienteRepository.findAll();
  }

  public boolean existsByCedula(String cedula){
        return clienteRepository.existsByCedula(cedula);
  }
}

