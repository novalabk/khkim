package com.example.domain.model.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "user")
public class Hello implements UserDetails{
	@Id
	@GeneratedValue
	int id;
	
	@Column(name = "username")
	String name;
	
	@Column(name = "classname")
	String className;
	
	
	@Column(name = "userid")
	String userId;
	
	@Column(name = "createstamp")
	Timestamp createStamp;
	
	@Column(name = "updatestamp")
	Timestamp updateStamp;
	
	String password;
	
	
	String email;
	
	public Hello(){
		className = getClassName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return getClass().getName();
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	@PrePersist
	void prePersist() {
		Timestamp current = new Timestamp(new Date().getTime());
		createStamp = current;
		updateStamp = current;
		
	}
	
	@PreUpdate
	void preUpdate(){
		Timestamp current = new Timestamp(new Date().getTime());
		updateStamp = current;
	}

	public Timestamp getCreateStamp() {
		return createStamp;
	}

	public void setCreateStamp(Timestamp createStamp) {
		this.createStamp = createStamp;
	}

	public Timestamp getUpdateStamp() {
		return updateStamp;
	}

	public void setUpdateStamp(Timestamp updateStamp) {
		this.updateStamp = updateStamp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Transient
	private Collection<? extends GrantedAuthority> authorities;


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities){
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 
//	  @PreUpdate
//	  void updatedAt() {
//	    this.updatedAt = new Date();
//	  }
	
//	public String getClassName(){
//		return getClass().getName();
//	}
	
}
