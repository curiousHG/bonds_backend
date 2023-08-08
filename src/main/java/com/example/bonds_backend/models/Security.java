package com.example.bonds_backend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "security")
// ondelete set status to inactive
@OnDelete(action = OnDeleteAction.NO_ACTION)
public class Security {
	
	@Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String ISIN;

    @Column(nullable = false)
    private String CUSIP;

    @Column(nullable = false)
    private String issuer;

    @Column(name = "maturity_date", nullable = false)
    private Date maturityDate;

    @Column(nullable = false)
    private double coupon;

    @Column(nullable = false)
    private String type;

    @Column(name = "face_value", nullable = false)
    private double faceValue;

    @Column(nullable = false)
    // #TODO: set default value to active and on delete change to inactive
    private String status;

}
