import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../services/empleado.service';
import { Route, Router } from '@angular/router';


@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css']
})
export class RegistrarEmpleadoComponent implements OnInit {


  empleado: Empleado = new Empleado();

  constructor(private empleadoServicio: EmpleadoService, private router: Router) {}

  ngOnInit(): void {

  }

  guardarEmpleado() {
    this.empleadoServicio.guardarRegistroEmpleado(this.empleado).subscribe(dato => {
      console.log(dato);
      this.irListaDeEmpleados();

    })
  }

  irListaDeEmpleados() {
    this.router.navigate(["/empleados"])
  }

  onSubmit(){
    this.guardarEmpleado();
  }

}
