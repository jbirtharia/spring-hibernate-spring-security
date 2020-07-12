package com.spring.security.service;

import com.spring.security.dao.SecurityDao;
import com.spring.security.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Service
public class SecurityService {

    private static Logger logger = Logger.getLogger(SecurityService.class.getName());

    @Autowired
    private SecurityDao securityDao;

    @Transactional
    public Users loadUserByName(String username){
        Users users = securityDao.loadUserByUsername(username);
        logger.info("Roles : "+users.getAuthorities());
        return users;
    }
}
