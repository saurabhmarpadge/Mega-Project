package com.megaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Long userId;
    private String userName;
    private Integer age;
    private String userEmailId;
}
