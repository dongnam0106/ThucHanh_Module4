package com.example.demo.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cities")
@Data
@Validated
public class City{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=15, message = "Nhập đúng tên thành phố từ 1-15 ký tự!")
    private String name;

    @NotNull
    @Min(value = 0, message = "Phải là số dương!")
    private Float area;

    @NotNull
    @Min(value = 0, message = "Phải là số dương!")
    private Float population;

    @NotNull
    @Min(value = 0, message = "Phải là số dương!")
    private Float  gdp;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @Column(nullable=false, columnDefinition="TEXT")
    private String introduce;

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//
//        City city = (City) target;
//        String name = city.getName();
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
//        if (name.length()>15 || name.length()<1){
//            errors.rejectValue("name", "name.length");
//        }
//        if (!name.startsWith("0")){
//            errors.rejectValue("name", "name.startsWith");
//        }
//        if (!name.matches("(^$|[a-zA-Z]*$)")){
//            errors.rejectValue("name", "name.matches");
//        }
//    }

}
