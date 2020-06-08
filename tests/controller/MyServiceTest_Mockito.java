package controller;

import application.MyDao;
import library.RegisterService;
import library.Registers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class MyServiceTest_Mockito {

    @Mock
    private MyDao myDao;
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