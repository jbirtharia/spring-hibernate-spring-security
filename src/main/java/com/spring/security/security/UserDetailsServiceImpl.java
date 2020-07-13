package com.spring.security.security;

import com.spring.security.entity.Users;
import com.spring.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private SecurityService service;


    /*Spring security with UserDetail class (Hibernate).
    * Following method will fetch user from db and set into usercontext object.
    * If we get usercontext object then user is avaialble in db and he can login, but if it is
    * not present then he cannot login.*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String roles = "";

        Users user = service.loadUserByName(username);

        UserContext userContext=new UserContext(user.getUsername(),user.getPassword(),
                user.getEnabled(), true, true, true, getGrantedAuthorities(user));

        userContext.setId(user.getId());
        logger.info("UserContext : "+userContext.toString());

        return userContext;
    }

    /*This method will provide all roles of particular user*/
    private List<GrantedAuthority> getGrantedAuthorities(Users users){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        users.getAuthorities().forEach(auth->{
            authorities.add(new SimpleGrantedAuthority("ROLE_"+auth.getAuthority()));
        });
        return authorities;
    }
}
