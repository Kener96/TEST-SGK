package controller;

import static javafx.scene.input.KeyCode.M;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import application.Main;
import com.sun.security.ntlm.Client;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import library.Registers;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jets3t.service.impl.soap.axis._2006_03_01.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.*;

import static org.mockito.AdditionalAnswers.returnsFirstArg;


public class MainControllerTest_Mockito {


    private static Registers registers;


    @Test
    public void testBehavior() throws Exception{
        Registers reg=Mockito.mock(Registers.class);
        reg.setName("Kamile");
        reg.setName("Fatih");

        verify(reg).setName("Kamile");
       // verify(reg).setName("ibrahim"); // hatalı olan test
    }

    @Mock
    public Registers register;

  /*  @InjectMocks
    private MainController mainController;
*/
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    //private Registers registers;

    @Test
    public void tesssssssst() throws Exception{
        final Registers userStub=new Registers();
//register=Mockito.mock(Registers.class);
userStub.setName("gulay");
userStub.setSurname("efe");


    }


    @BeforeClass
    public static void beforeClass(){

       // registers=new Registers();
        registers=Mockito.mock(Registers.class);
      //  MockitoAnnotations.initMocks(this);
        //registers=mock(Registers.class);
//mockMvc=Mock





    }


    @Test
    public void test1() {

        Registers reg=Mockito.mock(Registers.class);

    }

    @Test
    public void t(){
        Registers test=mock(Registers.class);
        when(test.getId()).thenReturn(151805007);
        assertEquals(test.getId(),151805007);
    }

    @Test
    public void t2(){
        Iterator<String> i=mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result=i.next()+" "+i.next();
        assertEquals("Mockito rocks",result);

    }

    @Test
    public void t3(){
        Properties properties=new Properties();
        Properties spyProperties=spy(properties);
        doReturn("Kamile").when(spyProperties).get("name");
        Object value=spyProperties.get("name");
        assertEquals("Kamile",value);
    }


    @Test
    public void t4_Wrong(){
        List<String> list=new LinkedList<>();
        List<String> spy=spy(list);

        when(spy.get(1)).thenReturn("Kamile");
        assertEquals("Kamile",spy.get(1));
    }


    @Test
    public void t4_Correct(){
        List<String> list=new LinkedList<>();
        List<String> spy=spy(list);

        doReturn("Kamile").when(spy).get(0);
        assertEquals("Kamile",spy.get(0));
    }

    @Test
    public final void answerTest(){

        MainController m=new MainController();
        Registers registers=mock(Registers.class);
        when(registers.getName()).thenReturn("Kamile");
        //m.showRegisters();
        m.getRegistersList();
         verify(registers,atLeastOnce()).getDate();


    }


          @Test
    public void testName(){  //fail
        Registers test=Mockito.mock(Registers.class);
        when(test.getName()).thenReturn("Kamileeee");
        assertEquals(test.getName(),"Kamile");

          }

          @Test
     public void testId(){ //correct
         Registers test2=Mockito.mock(Registers.class);
         when(test2.getId()).thenReturn(Integer.valueOf("151805007"));
         assertEquals(test2.getId(),151805007);
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


    @Test
    public void letsMockListSizeMethod(){
       // ObservableList<Registers> list = getRegistersList();

       //assertTrue(true);//çalışıyo

        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());





    }

    @Test
    public void letsMockListSize_ReturnMultpleValues(){

        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());


    }

    @Test
    public void letsMockListGet(){

        List listMock=mock(List.class);
        when(listMock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",listMock.get(0));


    }

    @Test
    public void testVerify3() throws Exception{ //3 kez setname metodunu çağırdığımı doğruladım

         Registers registers=mock(Registers.class);
         registers.setName("Kamile");
        registers.setName("Kamile");
        registers.setName("Kamile");

        verify(registers,times(3)).setName("Kamile");

         //registers.getDate().toLocalDate().plusDays(1);
        // verify(registers,times(2)).getDate();


    }
         @Test
    public void testWhen(){




         }




}