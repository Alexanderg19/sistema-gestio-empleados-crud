import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private baseUrl = "http://localhost:8080/api/empleados";

  constructor(private httpClient: HttpClient) { }

  obtenerListaDeEmpleados(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${this.baseUrl}`);
  }

   guardarRegistroEmpleado(empleado: Empleado): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, empleado);
  }

  actualizarEmpleado(id:number, empleado: Empleado): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, empleado)
  }

  obtenerEmpleadoPorId(id:number): Observable<Empleado> {
    return this.httpClient.get<Empleado>(`${this.baseUrl}/${id}`);
  }

  eliminarEmpleado(id:number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
