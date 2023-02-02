package com.app.consenso.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserLogin {
    //https://www.baeldung.com/hibernate-notnull-vs-nullable
    // @NonNull
    @Column(nullable = false)
    private String email;
    private String password;

}
