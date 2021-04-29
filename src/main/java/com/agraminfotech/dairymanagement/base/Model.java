package com.agraminfotech.dairymanagement.base;

import com.agraminfotech.dairymanagement.security.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id",nullable = false, updatable = false)
    private User createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,updatable = false)
    private Date createdDate;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by_id",insertable = false)
    private User modifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    private Date modifiedDate;

}
