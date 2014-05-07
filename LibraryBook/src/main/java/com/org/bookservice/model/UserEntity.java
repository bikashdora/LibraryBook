package com.org.bookservice.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="UsersEntity")
@Table(name = "users",uniqueConstraints = {
		@UniqueConstraint(columnNames = "userid")})
public class UserEntity {

	

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id @NotNull @NotBlank  
    @Column(name = "userid", unique = true, nullable = false)
    private String userId;
 
    @Column(name = "password", nullable = false, length =20)
    @NotNull @NotBlank
    private String password;
    
    @Column(name = "enabled", nullable = false, length =5)    
    private boolean enabled;
    
    public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",joinColumns={@JoinColumn(name="user_id", referencedColumnName="userid")}
    , inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="roleid")})
    private Set<RoleEntity> roles;
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
}
