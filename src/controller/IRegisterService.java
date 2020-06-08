package controller;

import library.Registers;

public interface IRegisterService {

    boolean authenticate(final Registers registers) throws RegisterNotFoundExeption;

}
