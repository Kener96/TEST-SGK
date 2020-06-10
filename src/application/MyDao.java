package application;

import library.Registers;
import org.junit.Assert;
import org.springframework.dao.DataAccessException;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
//import org.anvard.introtojava.Person;



public class MyDao {
    public Registers findById(int id){
        throw new UnsupportedOperationException();
    }
    public Registers findByName(String name){
        throw new UnsupportedOperationException();
    }

    private DataSource ds;

    public MyDao(DataSource ds){
        this.ds=ds;
    }


    public void create(Registers register){
        Assert.assertNotNull(register);
        try {
            Connection c=ds.getConnection();
            PreparedStatement stmt=c.prepareStatement("INSERT INTO registers (Number,Name,Surname) values (?,?,?)");
            stmt.setInt(1,register.getId());
            stmt.setString(2,register.getName());
            stmt.setString(3,register.getSurname());
            stmt.executeUpdate();
            c.close();

        } catch (SQLException e) {
            //throw new DataAccessException(e);
            e.printStackTrace();
        }

    }


    public Registers retrieve(int id) {
        try {
            Connection c=ds.getConnection();
            PreparedStatement stmt=c.prepareStatement("SELECT Number,Name,Surname FROM person WHERE Number?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();

            if(!rs.first()){
                return null;
            }


            Registers r=new Registers();
            r.setId(rs.getInt(1));
            r.setName(rs.getString(2));
            r.setSurname(rs.getString(3));
            return r;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


     public void update(Registers register){
        Assert.assertNotNull(register);
        try {
            {
                Connection c=ds.getConnection();
                PreparedStatement stmt=c.prepareStatement("UPDATE registers SET Name=?, Surname=? WHERE Number=?");
                stmt.setInt(1,register.getId());
                stmt.setString(2,register.getName());
                stmt.setString(3,register.getSurname());
                stmt.executeUpdate();
                c.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }


    public void delete(int id){

        try {

                Connection c=ds.getConnection();
                PreparedStatement stmt=c.prepareStatement("DELETE FROM registers WHERE Number=?");
                stmt.setInt(1,id);
                stmt.executeUpdate();
                c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
