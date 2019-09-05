package com.megaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Long userId;
    private String userName;
    private Integer age;
    private String userEmailId;
}
