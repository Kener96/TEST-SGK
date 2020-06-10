package controller;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

import javafx.collections.ObservableList;
import library.Registers;
import org.dbunit.DatabaseTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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


public class MainControllerTest_dbUnit extends DBTestCase {

    public static final String TABLE_LOGIN = "new_table";
    private FlatXmlDataSet loadedDataSet;
    private MainController register;
    private Connection jdbcConnection;
    MainController controller;

/*
    MainControllerTest_dbUnit (){
        super();
    }
*/

    public MainControllerTest_dbUnit(String name) {
        super(name);

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
       // System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/user");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "864297531");

    }
/*
    @Override
    public IDatabaseConnection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "864297531");
        return new DatabaseConnection(jdbcConnection);
    }
*/
    @Override
    protected IDataSet getDataSet() throws Exception{
        //loadedDataSet =new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("sampleData.xml"));
        //return loadedDataSet;
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dataSample.xml"));

    }

    public DatabaseOperation getSetUpOperation() throws Exception{
        return DatabaseOperation.REFRESH;
    }

    public DatabaseOperation getTearDownOperation() throws Exception{
        return DatabaseOperation.NONE;
    }


   @Autowired
    private MainController mainController;


    @Test
    @DatabaseSetup("sampleData.xml")
    public void testAdd() throws Exception{

        ObservableList<Registers> list=mainController.getRegistersList();
        mainController.insert(32,"Ekrem","Erdogan","computer","ekrem@gmail.com", LocalDate.parse("12-01-2018"),LocalDate.parse("15.06.2020"));
    }


/*
    @Test
    public void testById() {
        int userId = 5;
       // Assert.assertThat(1, CoreMatchers.is(Integer.valueOf(userId)));
        assertThat(1,is(userId));
    }
*/


}