package controller;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javafx.collections.ObservableList;
import library.Registers;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.sample.entity.Person;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileInputStream;


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
*/


public class MainControllerTest_dbUnit extends Registers{



    public MainControllerTest_dbUnit(String name) {
        super(name);

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
       // System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/user");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, " jdbc:mysql://localhost:3306/library");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "864297531");

    }


    public IDataSet getDataSet() throws Exception{
        return new FlatXmlDataSetBuilder().build(new FileInputStream("sampleData.xml"));
    }

    public DatabaseOperation getSetUpOperation() throws Exception{
        return DatabaseOperation.REFRESH;
    }

    public DatabaseOperation getTearDownOperation() throws Exception{
        return DatabaseOperation.NONE;
    }

/*
   @Autowired
    private MainController mainController;


    @Test
    @DatabaseSetup("sampleData.xml")
    public void testFind() throws Exception{
        ObservableList<Registers> list = this.mainController.find("ile");
        assertEquals(1,list.size());
        assertEquals("Kamile",list.get(0).getName());


    }

*/

   @Test
    public void testByName(){
       String name="Ege";
       assertThat(1,is("Ege"));

   }

   private String inputValue=new String("Hello");

   @Test
    public void testLogic(){
     // assertThat(inputValue,matches("Hello"));


   }



}