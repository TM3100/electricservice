package electricservice.controller;

import electricservice.model.Medidor;
import electricservice.service.MedidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medidores")
public class MedidorController {

    private final MedidorService medidorService;

    @Autowired
    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }

    /**
     * Endpoint para crear un nuevo medidor.
     * Se espera recibir un objeto Medidor en el cuerpo de la petición.
     *
     * @param medidor El objeto Medidor a crear.
     * @return El medidor creado y guardado en la base de datos.
     */
    @PostMapping
    public ResponseEntity<Medidor> crearMedidor(@RequestBody Medidor medidor) {
        Medidor nuevoMedidor = medidorService.guardarMedidor(medidor);
        return ResponseEntity.ok(nuevoMedidor);
    }

    /**
     * Endpoint para obtener un medidor por su número único.
     *
     * @param numeroMedidor El número de medidor a buscar.
     * @return El medidor encontrado.
     */
    @GetMapping("/{numeroMedidor}")
    public ResponseEntity<Medidor> obtenerMedidor(@PathVariable String numeroMedidor) {
        Medidor medidor = medidorService.buscarPorNumero(numeroMedidor);
        return ResponseEntity.ok(medidor);
    }

    // Se pueden agregar otros endpoints, como listar todos los medidores, actualizar o eliminar.
}

