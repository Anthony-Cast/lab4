package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int employeeid;
    @Column(name = "first_name")
    @NotBlank(message = "No puede estar vacío")
    private String firstname;

    @Column(name = "last_name",nullable = false)
    @NotBlank(message = "No puede estar vacío")
    private String lastname;

    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank(message = "No debe ser vacío o blanco")
    @Max(value = 65)
    @Min(value = 8,message = "Debe tener un mínimo de 8 caracteres")
    private String password;

    @Column(name = "phone_number")
    private String phonenumber;

    @Column(name = "hire_date", nullable = false)
    private Date hiredate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    private BigDecimal salary;
    private BigDecimal commission_pct;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
