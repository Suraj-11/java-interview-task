package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder=true)
public class Widget {

  @NotNull(message = "Name cannot be empty")
  @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
  private String name;
  
  @NotNull(message = "Description cannot be null")
  @Size(min = 5, max = 1000)
  private String description;
  
  @NotNull(message = "Price cannot be null")
  @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
  @DecimalMax(value = "20000.00", message = "Price must not exceed 20,000.00")
  private int price;

}
