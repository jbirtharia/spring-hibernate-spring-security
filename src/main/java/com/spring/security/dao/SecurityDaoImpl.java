package com.spring.security.dao;

import com.spring.security.entity.Authorities;
import com.spring.security.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.logging.Logger;

@Repository
public class SecurityDaoImpl implements SecurityDao{

    private static Logger log = Logger.getLogger(SecurityDao.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Users loadUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users u where u.username =: username");
        query.setParameter("username",username);
        return (Users) query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void save(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
