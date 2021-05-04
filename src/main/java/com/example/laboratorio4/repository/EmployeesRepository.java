package com.example.laboratorio4.repository;

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
            "where d.department_name like %?1% or e.first_name like %?1% or e.last_name like %?1%\n" +
            "or j.job_title like %?1% or l.city like %?1%",nativeQuery = true)
    List<Employees> listarEmpleadosPorNombreApellidoDepartamentoPuestoCiudad(String name);
    //@Query(value="select e.first_name as nombre,e.last_name as apellido,jh.start_date as fechainicio,jh.end_date as fechafin,j.job_title as puesto from employees e inner join jobs j on e.job_id = j.job_id\n" +
    //        "inner join job_history jh on e.employee_id = jh.employee_id\n" +
    //       "where e.salary>15000",nativeQuery = true)
    //List<DetalleEmpleados> obtenerDetalle();
    //@Query(value="select e.first_name as nombre,e.last_name as apellido, d.department_name as departamento, Max(salary) as salario from employees e inner join departments d on e.department_id = d.department_id\n" +
    //        "group by d.department_name",nativeQuery = true)
    //List<SalarioMaxDep> obtenerDetalle2();
    //@Query(value="select c.country_name as pais,l.city as ciudad,count(department_id) as cantidad from locations l inner join countries c on l.country_id = c.country_id\n" +
    //        "inner join departments d on l.location_id = d.location_id\n" +
    //        "where department_id in (select department_id from employees\n" +
    //        "                        group by department_id\n" +
    //        "                        having count(employee_id)>3)\n" +
    //        "group by c.country_name, l.city",nativeQuery = true)
    //List<DetalleDepxPaisyCiudad> obtenerDetalle3();
    //@Query(value="select d.department_name as department,e.first_name as nombre,e.last_name as apellido,e.salary as salary\n" +
    //        "from departments d inner join employees e\n" +
    //        "on d.manager_id = e.employee_id\n" +
    //        "where datediff(now(),e.hire_date)/365>5\n" +
    //        "order by salary desc",nativeQuery = true)
    //List<DetalleMasAnios> obtenerDetalle4();


}
