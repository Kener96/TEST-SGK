package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import application.Main;
import javafx.collections.ObservableList;
import library.Registers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

public class MainControllerTest_Mockito {

    @Test
    public void test1() {

        //Registers registers=Mockito.mock(Registers.class);
       // Mockito.when(registers.getName().matches("Kamile")).thenReturn(new Registers("Kamile"),151805007);
        // MainController m=registers.getName("");

       // MainController mainController=Mockito.mock(MainController.class);

        Registers reg=Mockito.mock(Registers.class);
       when(reg.getName()).thenReturn(String.valueOf(new Registers("Kamila")));
       // Mockito.when(reg.getSurname().matches("Ener")).thenReturn(true);
      //  assert  (reg.getName().equals("Kamile"));


       // MainController test=new MainController();
        //Mockito.when(test.getRegistersList()).thenReturn((ObservableList<Registers>) new Registers("Kamile"));


    }

          @Test
    public void testSimple(){
        Registers test=Mockito.mock(Registers.class);
        when(test.getName()).thenReturn("Kamileeee");
        assertEquals(test.getName(),"Kamile");

          }

          @Test
     public void testId(){
         Registers test2=Mockito.mock(Registers.class);
         when(test2.getId()).thenReturn(Integer.valueOf("151805007"));
         assertEquals(test2.getId(),"181805007");
     }

  /*   @Test
     public void testComp(){
        Registers test4=Mockito.mock(Registers.class);
        when(test4.getMail().equals("enerkamile@hotmail.com")).thenReturn(test4.getName().matches("Kamile"));
        assertEquals(test4.getName(),"Kamile");
     }
*/


     @Test
    public void testVerify(){
        Registers test3=Mockito.mock(Registers.class);
        when(test3.getName()).thenReturn("Fatih");
        test3.getName().equals("Fatih");
        test3.getName().equals("Kamile");
        verify(test3,times(2)).getName();

     }

    @Test
    public void testVerify2(){
        Registers test3=Mockito.mock(Registers.class);
        when(test3.getSurname()).thenReturn("Erdogan");
        test3.getSurname().equals("Ener");
        test3.getSurname().equals("Cura");
        verify(test3,times(2)).getSurname();

    }



}