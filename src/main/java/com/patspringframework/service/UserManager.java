package com.patspringframework.service;

import com.patspringframework.dao.UserDAOImpl;
import com.patspringframework.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PH on 6/19/2016.
 */
@Service
public class UserManager implements ServiceManager {

//    private UserDAOImpl userDAO = DaoFactory.getUserDao();

    @Autowired
    private UserDAOImpl userDAO;

    @Override
    public void create(Object object) {
        User user = (User)object;
        String p = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(p);
        userDAO.create(object);
    }

    @Override
    public List getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(Object object) {
        userDAO.update(object);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }
}
