package com.example.laboratorio4.controller;

import com.example.laboratorio4.entity.Departments;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.repository.DepartmentsRepository;
import com.example.laboratorio4.repository.EmployeesRepository;
import com.example.laboratorio4.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Autowired
    LocationsRepository locationsRepository;

    @GetMapping("")
    public String indice() {
        return "Search/indice";
    }

    @GetMapping("/Salario")
    public String listaEmpleadosMayorSalrio(Model model) {

        model.addAttribute("lista", employeesRepository.empleadoMayor());
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar(@RequestParam("search") @Valid Integer busqueda, Model model, RedirectAttributes attr) {

        attr.addFlashAttribute("msg", "Valor no soportado");
        model.addAttribute("lista", employeesRepository.listaMayorSalario(busqueda));
        return "Search/lista2";
    }

    @GetMapping("/Promdep")
    public String cantidadEmpleadosPorPais(Model model) {

        model.addAttribute("listaDepSalario", departmentsRepository.listaDepSalario());
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(@ModelAttribute("employees") Employees employees,
                                    @RequestParam("id") int depid, Model model, RedirectAttributes attr) {

        model.addAttribute("listaEmpleadoxDep", departmentsRepository.listaEmpleadoxDep(depid));
        return "/Search/lista3";

    }
}
