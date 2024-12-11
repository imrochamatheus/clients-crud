package com.imrochamatheus.clients_crud.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "CPF is required")
    @Size(min = 11, max = 11, message = "The CPF must have 11 characters")
    private String cpf;

    @PositiveOrZero(message = "Income must be positive or zero")
    private Double income;

    @PastOrPresent(message = "The date of birth must be past or present")
    private LocalDate birthDate;

    private Integer child;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer child) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.child = child;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;

        return Objects.equals(this.id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
