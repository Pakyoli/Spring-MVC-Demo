package com.patspringframework.dao;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
public abstract class DaoFactory {


    public static UserDAOImpl getUserDao(){
        return new UserDAOImpl();
    }

    public static AddressDAOImpl getAddressDao(){
        return new AddressDAOImpl();
    }
//    public static ProductDAOImpl getProductDAO(){
//        return new ProductDAOImpl();
//    }
}
