package com.spring.security.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class UserContext extends User {

    private String username;

    private String password;

    public UserContext(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
    {
        //Calling super constructor for setting properties
        super(username, password, enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
