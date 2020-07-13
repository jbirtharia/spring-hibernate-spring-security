package com.spring.security.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;


public class UserContext extends User {

    private Integer id;

    public UserContext(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
    {
        //Calling super constructor for setting properties
        super(username, password, enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "id=" + id +
                ", username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", authorities='" + this.getAuthorities() + '\'' +
                ", enabled='" + this.isEnabled() + '\'' +
                '}';
    }
}
