package com.training.project.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
public class User {
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Integer userId;
	
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(name="password_hash", nullable = false)
    private String passwordHash;
    
    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @Column(name="last_login",updatable = true)
    @CreationTimestamp
    private LocalDateTime lastLogin;
    
    @Column(name="is_login")
    private Boolean isLogin;
    
//    (Many Users → One Role)
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Role role;

	public User() {
		super();
	}

	public User(Integer userId, String username, String passwordHash, LocalDateTime createdAt, LocalDateTime lastLogin,
			Boolean isLogin, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.passwordHash = passwordHash;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.isLogin = isLogin;
		this.role = role;
	}

	public User(String username, String passwordHash, LocalDateTime createdAt, LocalDateTime lastLogin, Boolean isLogin,
			Role role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.isLogin = isLogin;
		this.role = role;
	}
	
	public User(String username, String passwordHash, Boolean isLogin,Role role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.isLogin = isLogin;
		this.role = role;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the lastLogin
	 */
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the isLogin
	 */
	public Boolean getIsLogin() {
		return isLogin;
	}

	/**
	 * @param isLogin the isLogin to set
	 */
	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", passwordHash=" + passwordHash + ", createdAt="
				+ createdAt + ", lastLogin=" + lastLogin + ", isLogin=" + isLogin + ", role=" + role + "]";
	}
    
    
}