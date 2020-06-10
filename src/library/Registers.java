package library;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.dbunit.operation.DatabaseOperation;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/*@Entity
@NamedQueries({ @NamedQuery( name = "Register.find" ,query = "SELECT r from Register r where" +
        " r.name like:name " + "or r.surname like: name")})
*/



public class Registers {

  //  @Id
    private int id;
    private String name;
    private String surname;
    private String department ;
    private String mail;
    private Date date;
    private Date date2;

    public Registers(Connection connection) {

    }

    public Registers() {

    }



    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setId(Integer id){ this.id=id;}
    public void setDepartment(String department) {this.department = department;}
    public void setMail(String mail) {this.mail =mail;}
    public void setDate (Date date) {this.date=date;}
    public void setDate2 (Date date2) {this.date2=date2;}

   // public void getName(String name) {this.name=name;}

    public Registers(String s) {

    }

    public Registers(int Id, String Name, String Surname, String Department, String Mail, Date Date ,Date Date2){
        this.id = Id;
    	this.name=Name;
        this.surname = Surname;
        this.department=Department;
        this.mail=Mail;
        this.date=Date;
      this.date2=Date2;

    }




    public int getId() {
    	return id;
    }
    public  String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getDepartment() {
        return department;
    }
    public String getMail() {
        return mail;
    }
    public Date getDate() {
        return date;
    }
    public Date getDate2() { return date2; }


    public boolean runInGround(String location) {
        if(location.equals("ground")) {
            System.out.println("The person runs in the " + location);
            return true;
        } else {
            System.out.println("The person doesn't run in the " +   location);
            return false;
        }

    }


    public boolean isPlay() {

        if(this.runInGround("ground")) {
            System.out.println("The person plays.");
            return true;
        }
        else {
            System.out.println("The person doesn't play");
            return false;
        }
    }

}
