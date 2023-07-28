package com.empleados.sistemagestionempleados.controllers;

import com.empleados.sistemagestionempleados.exceptions.ResourcesNotFoundException;
import com.empleados.sistemagestionempleados.models.Empleado;
import com.empleados.sistemagestionempleados.repositories.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @PostMapping("empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No existe el empleado"));
        return ResponseEntity.ok().body(empleado);
    }

    @PutMapping("empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado datosEmpleado) {
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No existe el empleado"));
        empleado.setNombre(datosEmpleado.getNombre());
        empleado.setApellido(datosEmpleado.getApellido());
        empleado.setEmail(datosEmpleado.getEmail());

        Empleado empleadoActualizado = empleadoRepositorio.save(empleado);

        return ResponseEntity.ok().body(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No existe el empleado con el ID : " + id));

        empleadoRepositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
