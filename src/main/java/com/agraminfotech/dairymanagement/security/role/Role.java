package com.agraminfotech.dairymanagement.security.role;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

}
