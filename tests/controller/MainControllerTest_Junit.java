package controller;

import application.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import library.Registers;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.loadui.testfx.GuiTest;
import org.omg.CORBA.portable.ApplicationException;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;


import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import static org.hamcrest.Matchers.hasProperty;
import static org.testfx.assertions.api.Assertions.assertThat;



import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;
import org.testfx.framework.junit.ApplicationTest;

///import org.testfx.assertions.api.Assertions;

import javax.annotation.WillCloseWhenClosed;
import javax.management.AttributeValueExp;
import javax.naming.Name;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import static org.testfx.matcher.control.LabeledMatchers.hasText;


public class MainControllerTest_Junit extends MainController{

    protected TableView<Registers> tableView;

    Connection connection;
   private  Button button;
    private MainController mainController;
   // private Registers test=new Registers("Kamile");

    @Rule
    public TestName testName=new TestName();
    public final ExpectedException exception=ExpectedException.none();



    @Before
    public void setup() throws Exception{
        mainController=new MainController();
       // registers=new Registers(151805007,"Kamile","Ener","Bilgisayar Mühendisliği","enerkamile@hotmail.com", LocalDate.parse("07-06-2020"),LocalDate("2021-05-14");
      //  test=new Registers("Kamile");
       // System.out.println("start" + testName.getMethodName());

          //Registers registers=new RegisterImpl(connection);

    }


    @Test
    public void testB() throws SQLException {
        mainController=new MainController();
        Registers registers=new Registers(connection);
        Connection connection=getConnection();

        connection.setAutoCommit(false);
        connection.getSchema();
         try {
              registers.setName("Kamile");
              assertEquals("Kamile",registers.getName());

              registers.setSurname("Ener");
              assertEquals("Ener",registers.getSurname());

             // assertNull(registers.getName());

         } finally {
             connection.rollback();
             connection.close();
         }




    }


    @Test
    public void testA(){
        MainController mainController=new MainController();

    }

   public MainControllerTest_Junit(){
        super();
   }


    @Test
    public void testC(){


       ObservableList<Registers> list=mainController.getRegistersList();
       mainController.insert(1,"ali","pek","comp","k@gmail.com",LocalDate.parse("2020-10-05"),LocalDate.parse("2020-11-06"));
       assertEquals(1,list.size());


       // assertEquals("Gaye","Kamile");
    }



    @Test
    public void bb() throws Exception{

     /*   verifyThat("#nameField",NodeMatchers.hasText("Burcu"));
        verifyThat("#surnameField",NodeMatchers.hasText("İckavak"));
        verifyThat("#list",(TableView tableView) -> {
            Object selectedItem=tableView.getSelectionModel().getSelectedItem();
            return Object.equals(selectedItem.toString(),"Burcu İckavak");
        });*/

       // Assert.assertEquals("Ege",mainController.getRegistersList().get(2));
     // verifyThat("#list", NodeMatchers.isNotNull());
     // verifyThat("#surnameField",NodeMatchers.isNotNull());

    }




  @Test
    public void test1(){

       // assertEquals("Kamile",test.getName());

    }


     @Test
     public void test2() throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Main().start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        thread.start();
        Thread.sleep(10000);



     }





    @Test
    public void test(){
        MainController test=new MainController();
        int result=test.addNumber(5,2);
        assertEquals(7,result);
    }


    @Test
    public void testFindById(){
       MainController register= new MainController();
       /* Assert.assertEquals("Kamile",register.toString());
        String result=register.getRegistersList().toString();
        //String result=register.showRegisters();
        assertEquals("Kamile",result);
       return;*/


      //  FxAssert.verifyThat("#tableView", LabeledMatchers.hasText("kamile"));
      //  MainController testt=new MainController();
      /*  Label label=(Label) GuiTest.find("numara");
       FxAssert.verifyThat("numara",LabeledMatchers.hasText("Numara"));*/
     //  FxAssert.verifyThat(".insertButton",LabeledMatchers.hasText("Ekle"));
// clickOn


       //

     assertTrue(true); //çalışıyo




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