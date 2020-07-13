package com.spring.security.service;

import com.spring.security.dao.SecurityDao;
import com.spring.security.entity.Authorities;
import com.spring.security.entity.Users;
import com.spring.security.exception.DuplicateUserFoundException;
import com.spring.security.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SecurityService {

    private static Logger logger = Logger.getLogger(SecurityService.class.getName());

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private SecurityDao securityDao;

    @Transactional
    public Users loadUserByName(String username){
        Users users = securityDao.loadUserByUsername(username);
        logger.info("Roles : "+users.getAuthorities());
        return users;
    }

    @Transactional
    public void saveUser(Users user) {

        if(! this.duplicateUser(user)) {
            // encrypt the password
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            // prepend the encoding algorithm id
            encodedPassword = "{bcrypt}" + encodedPassword;

            List<Authorities> authorities = new ArrayList<>();
            authorities.add(new Authorities(user.getUsername(),"EMPLOYEE"));

            user.setAuthorities(authorities);
            user.setPassword(encodedPassword);
            user.setEnabled(true);
            logger.info("usercontext : "+user);

            //Save that spring security user object into db
            securityDao.save(user);
        }else {
            throw new DuplicateUserFoundException();
        }
    }

    private Boolean duplicateUser(Users user){
        Users tempUser = securityDao.loadUserByUsername(user.getUsername());
        logger.info("Temp User : "+tempUser);
        if(tempUser!=null)
            return true;
        else
            return false;
    }
}
