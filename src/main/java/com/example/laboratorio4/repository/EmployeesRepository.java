package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.EmpMayorSalarioDto;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value="select * from employees e inner join jobs j on j.job_id = e.job_id\n" +
            "inner join departments d on d.department_id = e.department_id\n" +
            "inner join locations l on l.location_id = d.location_id\n" +
            "where e.first_name like %?1% or d.department_name like %?1% or e.last_name like %?1%\n" +
            "or j.job_title like %?1% or l.city like %?1%",nativeQuery = true)
    List<Employees> listarEmpleadosPorNombreApellidoDepartamentoPuestoCiudad(String name);

    @Query(value = "select e.first_name as nombre, e.last_name as apellido, jh.start_date as fechainicio, jh.end_date as fechafin, j.job_title as puesto\n" +
            "from job_history jh\n" +
            "join employees e on (jh.employee_id= e.employee_id)\n" +
            "join jobs j on (e.job_id=j.job_id)\n" +
            "where e.salary > 8000;" ,nativeQuery = true)
    List<EmpMayorSalarioDto> empleadoMayor();

    @Query(value = "select e.first_name as nombre, e.last_name as apellido, jh.start_date as fechainicio, jh.end_date as fechafin, j.job_title as puesto\n" +
            "from job_history jh\n" +
            "join employees e on (jh.employee_id= e.employee_id)\n" +
            "join jobs j on (e.job_id=j.job_id)\n" +
            "where e.salary > ?1",nativeQuery = true)
    List<EmpMayorSalarioDto> listaMayorSalario(int salary);

}
