package com.springboot.stonecruiser.entity;

import java.util.Date;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

	
	public User(User users) {

        this.temporaryInActive = users.temporaryInActive;
        this.emailId = users.emailId;
        this.id = users.id;
        this.lastName = users.lastName;
        this.firstName = users.firstName;
        this.password = users.password;
        this.roles = users.roles;

    }
	@Column
	public String code;
	@Column
	@Nonnull
	private String firstName;
	@Column
	@Nonnull
	private String lastName;
	@Column
	@Nonnull
	private String emailId;
	@Column
	@Nonnull
	private String mobNumber;
	@Column
	@Nonnull
	private String password;
	@Column
	private String unEncryptedPassword;
	@Column
	private String salt;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date lockedOn;
	@Column
	private Boolean status;

	@Column
	private Boolean temporaryInActive = Boolean.FALSE;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLockReleaseDate;

	@Column
	private Boolean lockedStatus;

	@Column
	private String lockedReason;

	@Column
	private Integer noOfTimesLocked;

	@Column
	private Integer noOfLoginFailed;
	@Column
	private Boolean whetherDeleted;

	@Column
	private String ipAddress;
	@Column
	private Boolean whetherSystemUser = false;

	@Column
	private Long totalLoginFailed;
	@Column
	private Long totalAutoLogout;
	@Column
	private String printName;
	@Column
	private Boolean whetherPasswordReset;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date passwordLastUpdated;
	@Column
	private String passwordBase64;

	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name ="user_id",unique = false),
    inverseJoinColumns = @JoinColumn(name = "roles_id", unique=false))
    private Set<Role> roles;
		

}
