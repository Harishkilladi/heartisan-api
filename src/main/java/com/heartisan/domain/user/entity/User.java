package com.heartisan.domain.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name= "email_address", unique = true, nullable = false)
	@NotNull
	private String username;
	
	@Column(name = "first_name", nullable = false)
	@NotNull
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	@NotNull
	private String lastName;
	
	@Column(name = "mobile_number", unique = true, nullable = false)
	@NotNull
	private String mobileNumber;
	
	@NotNull
	@Column(name = "password")
	@JsonIgnore
	private String password;
	
	@Column(name = "created", updatable = false, insertable = true)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created = new Date();

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "last_modified")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModified = new Date(); // initialising cos otherwise integration tests fail with not-null constraint validation

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

    @Version
    @Column(name = "version")
    @NotNull
    private Long version;
}
