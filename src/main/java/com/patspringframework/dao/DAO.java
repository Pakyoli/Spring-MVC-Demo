package com.patspringframework.dao;

import java.sql.Connection;
import java.util.List;

/**
 * Created by pakyo_000 on 6/4/2016.
 */ public interface DAO{
    void create(Object object);
    List getAll();
    Object getById(Integer id);
    void update(Object object);
    void delete(Object object);
    Integer getSequence(Connection conn);
}

