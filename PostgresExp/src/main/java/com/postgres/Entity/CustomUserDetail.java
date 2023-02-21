package com.postgres.Entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail extends StudentInfo implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	public CustomUserDetail(StudentInfo student) {
		super(student);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Set<GrantedAuthority> authorities = new HashSet<>(getRoles.size());
		//for(Role role : getRoles()) {
			//authorities.add(new SimpleGrantedAuthority(role.getUserRole));
		//}
		//return authorities;
		return null;
	}
	
	@Override
	public String getUsername()
	{
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
