package com.patspringframework.dao;

import com.patspringframework.Utilities.dbUtil;
import com.patspringframework.dto.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Repository
public class UserDAOImpl implements DAO {

    @Override
    public void create(Object object) {

        PreparedStatement stmt = null;
        User user = (User)object;

        try{
            String query = "insert into users (first_name, last_name, username, password, enabled, role_id, created_date) values (?,?,?,?,?,?,?)";
            stmt = dbUtil.getConn().prepareStatement(query);
            int i=0;
            stmt.setString(++i,user.getFirstName());
            stmt.setString(++i,user.getLastName());
            stmt.setString(++i,user.getUsername());
            stmt.setString(++i,user.getPassword());
            stmt.setInt(++i,user.isEnabled());
            stmt.setInt(++i,user.getRole_id());
            stmt.setDate(++i,(java.sql.Date)user.getDateCreated());
            stmt.execute();

        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            dbUtil.closeConn();
            dbUtil.closeStmt(stmt);
        }
    }

    @Override
    public List retrieve() {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List users = new ArrayList();
        User user;

        try{
            String query = "select * from users;";
            stmt = dbUtil.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            while(rs!=null && rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEnabled(rs.getInt("enabled"));
                user.setRole_id(rs.getInt("role_id"));
                this.addChildEntities(user);
                users.add(user);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            dbUtil.closeConn();
            dbUtil.closeStmt(stmt);
            dbUtil.closeRS(rs);
        }

        return users;
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Integer id) {

    }

    private void addChildEntities(User user) {
        AddressDAOImpl addressDAO = DaoFactory.getAddressDao();
        user.setAddress(addressDAO.getByUserId(user.getId()));
    }
}
