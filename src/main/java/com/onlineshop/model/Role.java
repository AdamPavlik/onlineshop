package com.onlineshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 04.07.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	@Override
	public String getAuthority() {
		return this.getName();
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
