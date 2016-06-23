package com.patspringframework.service;

import java.util.List;

/**
 * Created by PH on 6/8/2016.
 */
public interface ServiceManager {
    void create(Object object);
    List getAll();
    Object getById(Integer id);
    void update(Object object);
    void delete(Integer id);
}
