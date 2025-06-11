package electricservice.controller;

import electricservice.dto.ClienteDTO;
import electricservice.model.Cliente;
import electricservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente=new Cliente();
        cliente.setCedula(clienteDTO.getCedula());
        cliente.setTipoCliente(clienteDTO.getTipoCliente());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setNombre(clienteDTO.getNombre());
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<?> obtenerClientePorCedula(@PathVariable String cedula) {
        if(clienteService.existsByCedula(cedula)){
        return ResponseEntity.ok(clienteService.buscarPorCedula(cedula));}
        return ResponseEntity.ok("El cliente no fue encontrado");
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }
}

