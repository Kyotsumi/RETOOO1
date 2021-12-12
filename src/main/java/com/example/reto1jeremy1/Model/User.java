package com.example.reto1jeremy1.Model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", length = 50, nullable = false)
    private String email;
    @NonNull
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    @NonNull
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;

}
