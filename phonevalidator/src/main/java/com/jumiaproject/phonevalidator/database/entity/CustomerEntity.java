package com.jumiaproject.phonevalidator.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity {

    @Id
    @Column(name = "id")
    private Integer customerEntityId;

    @Column(name = "name")
    private String customerName;

    @Column(name = "phone")
    private String customerPhone;

}
