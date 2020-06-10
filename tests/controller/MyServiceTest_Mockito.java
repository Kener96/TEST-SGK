package controller;

import application.MyDao;
import library.RegisterService;
import library.Registers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
//import org.anvard.introtojava.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;


//@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest_Mockito {

    @Mock
    private MyDao myDao;
/*    @Mock
    private Connection c;
    @Mock
    private DataSource ds;
    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs;

    private Registers r;
  */
/*
    @Before
    public  void setUp() throws Exception{
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        r=new Registers();
        r.setId(1);
        r.setName("elif");
        r.setSurname("esen");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(r.getName());
        when(rs.getString(3)).thenReturn(r.getSurname());
        when(stmt.executeQuery()).thenReturn(rs);


    }
*/
 /*   @Test(expected = IllegalArgumentException.class)
    public void nullCreateThrowsExeption(){
        new MyDao(ds).create(null);

    }

    @Test
    public void createPerson(){
        new MyDao(ds).create(r);
    }

    @Test
    public void Cre(){
        MyDao dao=new MyDao(ds);
        dao.create(r);
        Registers p=dao.retrieve(1);
        assertEquals(r,p);
    }
*/

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testFindById() {
        MockitoAnnotations.initMocks(this);
        RegisterService registerService = new RegisterService(myDao);
        registerService.findById(1);
        Mockito.verify(myDao).findById(1);
    }

    @Test
    public void test() {
        RegisterService registerService = new RegisterService(myDao);
        Mockito.when(myDao.findById(1)).thenReturn(createTestEntity());
        Registers actual = registerService.findById(1);
        Assert.assertEquals("Kamile", actual.getName());
        Assert.assertEquals("Ener", actual.getSurname());
        Mockito.verify(myDao).findById(1);
    }

    private Registers createTestEntity() {
        Registers registers=new Registers();
        registers.setName("Ege");
        registers.setSurname("Ener");
        return registers;
    }





}