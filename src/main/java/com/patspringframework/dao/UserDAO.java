package com.patspringframework.dao;

import com.patspringframework.dto.User;

/**
 * Created by PH on 6/8/2016.
 */
public interface UserDAO extends DAO {
    User getUserByUsername(String username);
    User getUserByHash(String hash);
}
