package com.patspringframework.dao;

import com.patspringframework.dto.Address;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Repository
public class AddressDAOImpl implements DAO {

    @Override
    public void create(Object object) {

    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    public Address getByUserId(Integer id){
        return null;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Integer getSequence(Connection conn) {
        return null;
    }
}
