package com.example.indepth.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//TODO: The entity is the model which is passed into the repository
@Entity
//Lombok reduces all the boiler plate(getters and setters)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
//validation pkg. has many forms; NotBlank, Length, Email, Future etc...
    @NotBlank(message = "Please Add Department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
