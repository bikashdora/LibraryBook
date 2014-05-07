package com.org.bookservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "RoleEntity")
@Table(name = "roles", uniqueConstraints = {
@UniqueConstraint(columnNames = "roleid")})
public class RoleEntity {
	
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -6790693372846798580L;
	
	@Id   
    @Column(name = "roleid", unique = true, nullable = false)
    private String roleId;

	public RoleEntity(String roleId) {
		
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
 
    
}
