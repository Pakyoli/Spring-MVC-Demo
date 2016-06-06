package com.patspringframework.dao;

import java.util.List;

/**
 * Created by pakyo_000 on 6/4/2016.
 */
public interface DAO{
    public void create(Object object);
    public List retrieve();
    public Object getById(Integer id);
    public void update(Object object);
    public void delete(Integer id);
}

