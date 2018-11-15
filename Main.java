import java.util.*;
import java.lang.*;


public class Main<E> implements SecureDataContainer<E>{


     public HashMap<String,Utente> vou;


     /*constructor*/
     public Main() {
       vou = new HashMap();
     }

    /* public boolean containsKey(Object U){
       if (U==this) return true;
       if (!(U instanceof Utente)) return false;
       Utente utente = (Utente) U;
       for (Utente z : vou.keySet()){
        if (utente.equals(z)) return true;
          }
          return false;
        }*/

     public void createUser(String Id, String passw)throws NullPointerException,IllegalArgumentException {
       /*
           REQUIRES: Id != null && passw != null && id non appartenente a SecureDataContainer
           THROWS:  if (id == null || passw == null) lancia NullPointerException
                    se id appartiene già SecureDataContainer lancia IllegalArgumentException
           MODIFIES: this
           EFFECTS: crea un nuovo utente e lo inserisce all'interno della collezione
     */
        if (Id==null || passw==null) throw new NullPointerException();


        if (vou.size()!=0){
          if (vou.containsKey(Id)) {
            throw new IllegalArgumentException();
          }
        }

          Utente val = new Utente (passw, new ArrayList());
          vou.put(Id, val);
      }


     public int getSize(String Owner, String passw) throws NullPointerException,IllegalArgumentException{
      /*
         REQUIRES: Owner != null && passw != null && Owner appartenente a SecureDataContainer
         THROWS:  if (Owner == null || passw == null) lancia NullPointerException
                  se Owner non è presente in SecureDataContainer lancia IllegalArgumentException
         EFFECTS: Restituisce il numero di E data presenti nella collezione per l'utente Owner
      */


      if (Owner==null || passw==null)  throw new NullPointerException();

      //Utente app = null;
      if (vou.containsKey(Owner)==false)
        throw new IllegalArgumentException();


      Utente app = vou.get(Owner);

      if (!(vou.get(Owner).controlla(passw))) {
        System.out.println("password errata");
        return -1;
      }
      return vou.get(Owner).getAL().size();

}





    public boolean put(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException{
    /*
       REQUIRES: Owner != null && passw != null && data!=null && Owner presente nella collezione
       THROWS:  se (Owner == null || passw == null || data == null ) lancia NullPointerException
                se Owner non appartiene alla collezione lancia IllegalArgumentException
       MODIFIES: this
       EFFECTS: controlla che la password relativa all'utente sia corretta, se lo è
                inserisce il dato E data e restituisce true, altrimenti restituisce false
    */


    if (Owner==null || passw==null || data==null)
      throw new NullPointerException();


    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();

  //  Utente app = vou.get(Owner);

    if (vou.get(Owner).controlla(passw)==false){
     System.out.println("password errata");
     return false;
   }
    if (vou.get(Owner).getAL().contains(data)){
     System.out.println(Owner+ "già possiede questo dato");
     return false;
   }

    vou.get(Owner).getAL().add(data);
    return true;

  }




  public E get(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException{
    /*
       REQUIRES: Owner != null && passw != null && data!=null && Owner e data presente nella collezione
       THROWS:  se (Owner == null || passw == null || data == null ) lancia NullPointerException
                se Owner || E data non appartiene alla collezione lancia IllegalArgumentException
       EFFECTS: controlla che la password relativa a Owner sia corretta, se lo è
                restituisce una copia del dato E data relativa a quell'utente,
                se la password è errata restituisce null
    */


    if (Owner==null || passw==null || data==null)
      throw new NullPointerException();


    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();



    if (!(vou.get(Owner).controlla(passw))) {
      System.out.println("password errata");
      return null;
    }

    if (vou.get(Owner).getAL().contains(data)) return data;
    else {
      System.out.println(Owner+" non possiede questo dato");
      return null;
    }
}

 public E remove(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException{
    /*
       REQUIRES: Owner != null && passw != null && data!= null && Owner presente nella collezione
       THROWS:  se (Owner == null || passw == null || data == null ) lancia NullPointerException
                se Owner || E data non appartiene alla collezione lancia IllegalArgumentException
       MODIFIES: this
       EFFECTS: rimuove il dato E data dalla collezione se la password corrisponde a Owner
                e se il dato è presente e restituisce il dato rimosso, se la password
                non corrisponde allora restituisce null
    */


    if (Owner==null || passw==null)
      throw new NullPointerException();

    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();


    if (vou.get(Owner).controlla(passw)==false){
      System.out.println("password errata");
      return null;
    }
    if (vou.get(Owner).getAL().contains(data)){
      vou.get(Owner).getAL().remove(data);
      return data;
    }else{
      System.out.println(Owner+" non possiede questo dato");
      return null;
    }

  }
 public void copy(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException{
      /*
       REQUIRES: Owner != null && passw != null && data!= null && Owner presente nella collezione
       THROWS:  se (Owner == null || passw == null || data == null ) lancia NullPointerException
                se Owner || E data non appartiene alla collezione lancia IllegalArgumentException
       MODIFIES: this
       EFFECTS: crea una copia del dato se password corrisponde a Owner
    */


    if (Owner==null || passw==null || data==null)
      throw new NullPointerException();

    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();





    if (vou.get(Owner).controlla(passw)==false)
      System.out.println("passwor errata");
    else {
    if (vou.get(Owner).getAL().contains(data)) vou.get(Owner).getAL().add(data);
    else System.out.println(Owner+" non possiede questo dato");
  }
}


  public void share(String Owner, String passw, String Other, E data) throws NullPointerException,IllegalArgumentException{
    /*
       REQUIRES: Owner != null && passw != null && data!= null && Other!=null && Owner presente nella collezione
       THROWS:  se (Owner == null || passw == null || data == null || Other == null) lancia NullPointerException
                se Owner || E data non appartiene alla collezione lancia IllegalArgumentException
       MODIFIES: this
       EFFECTS: condivide il dato E data di Owner(se passw corrisponde) nella collezione con l'utente Other
    */


    if (Owner==null || passw==null)
      throw new NullPointerException();

    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();
    if (vou.containsKey(Other)==false)
      throw new IllegalArgumentException();


    if (vou.get(Owner).controlla(passw)==false)
      System.out.println("password errata");

    if (!(vou.get(Owner).getAL().contains(data)))
      System.out.println(Owner+" non possiede questo dato");
    else
      vou.get(Owner).getAL().add(data);



}


    public Iterator<E> getIterator(String Owner, String passw) throws NullPointerException,IllegalArgumentException{
    /*
       REQUIRES: Owner != null && passw != null && Owner presente in SecureDataContainer
       THROWS:  se Owner == null || passw == null lancia NullPointerException
                se Owner non è presente in SecureDataContainer lancia IllegalArgumentException
       EFFECTS: restituisce un iteratore che fornisce tutti i dati dell'utente Owner
                se passw corisponde a Owner
    */


    if (Owner==null || passw==null)
      throw new NullPointerException();


    if (vou.containsKey(Owner)==false)
      throw new IllegalArgumentException();



    if (vou.get(Owner).controlla(passw)==false){
      System.out.println("password errata");
      return null;
    }

    Iterator<E> it = vou.get(Owner).getAL().iterator();
    while (it.hasNext()){
      System.out.println(it.next());
      }
      return it;
}





}
