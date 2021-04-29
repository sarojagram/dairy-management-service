package com.agraminfotech.dairymanagement.security.setting;

import com.agraminfotech.dairymanagement.security.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="setting")
@Getter
@Setter
public class Setting  {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String operationDateSetting;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false,nullable = false,unique = true)
    private User user;
}
