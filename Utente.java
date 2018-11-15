import java.lang.*;
import java.util.*;

class Utente<E> {
  protected String password;
  private ArrayList<E> d = new ArrayList();




  public boolean containsValue(Object e){
    if (e==this) return true;
    if (!(e instanceof Utente)) return false;
    if (password==e) return true;
    else return false;
  }

  /*constructor*/
  public Utente (String passw, ArrayList c) {
    password = passw;
    d = c;
  }

  public ArrayList getAL(){
    return d;
  }

  public boolean controlla(String passw){
    if (passw.equals(password))
      return true;
    else return false;
  }

  /*public ArrayList<E> getDatas(){
    return datas;
  }*/


}
