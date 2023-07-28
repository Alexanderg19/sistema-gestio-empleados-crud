package com.empleados.sistemagestionempleados.repositories;

import com.empleados.sistemagestionempleados.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
