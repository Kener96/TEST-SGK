package controller;

import javafx.scene.control.Button;
import library.Registers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class MainControllerTest_Junit  {
    Connection connection;


    private Registers test=new Registers("Kamile");

    @Rule
    public TestName testName=new TestName();

    @Before
    public void setup(){
        test=new Registers("Kamile");
        System.out.println("start" + testName.getMethodName());
    }

    @Test
    public void test1(){

        assertEquals("Kamile",test.getName());

    }








    @Test
    public void test(){
        MainController test=new MainController();
        int result=test.addNumber(5,2);
        assertEquals(7,result);
    }


    @Test
    public void testFindById(){
      /*  MainController register= new MainController();
        Assert.assertEquals("Kamile",register.toString());
        return;*/

        // assertEquals(4,list.fi);

       // FxAssert.verifyThat("Kamile", LabeledMatchers.hasText("kamile"));
      // FxAssert.verifyThat("insertButton",LabeledMatchers.hasText("Ekle"));

       // Label label=(Label) GuiTest.find("Numara");
      assertTrue(true);




    }

    @Test
    public void testIt() throws Exception
    {
       // Connection connection=getConnection();
        connection.setAutoCommit(false);

        MainController mainController=new MainController();
        try {
            mainController.getRegistersList();
            assertEquals("Kamile",mainController.toString());

        }finally {
            connection.rollback();
            connection.close();
        }


    }







}