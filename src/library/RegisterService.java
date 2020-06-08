package library;


import application.MyDao;

public class RegisterService {

  private MyDao myDao;
  public RegisterService(MyDao myDao){ this.myDao=myDao;}
  public Registers findById(int id){return myDao.findById(id);}
  public Registers findByName(String name){ return myDao.findByName(name);}








}
