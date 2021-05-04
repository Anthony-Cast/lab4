package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.HistorialAniosDto;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value = "select e.first_name as nombre, e.last_name as apellido, js.start_date as inicio, js.end_date as fin, \n" +
            "\t\ttimestampdiff(YEAR, js.start_date, js.end_date) as anios, \n" +
            "\t\t(timestampdiff(MONTH, js.start_date, js.end_date)-(timestampdiff(YEAR,js.start_date, js.end_date)*12)) as meses,\n" +
            "j.job_title as cargo from job_history js join employees e on (js.employee_id=e.employee_id) join jobs j on (j.job_id=e.job_id)\n" +
            "order by anios desc",nativeQuery = true)
    List<HistorialAniosDto> listaHistorial();

}
