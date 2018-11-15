import java.lang.*;
import java.util.*;

public interface SecureDataContainer<E> {
   //Overview: tipo di dato modificabile che permette memorizzazione
   //          e condivisione di dati
   //Typical element:insieme di oggetti di tipo E che rappresentano
   //                le informazioni di un utente


   //Crea l'identità un nuovo utente della collezione
 public void createUser(String Id, String passw) throws NullPointerException,IllegalArgumentException;

   //Restituisce il numero di elementi di un utente presenti nella collezione se il controllo di identità va a buon fine
 public int getSize(String Owner, String passw) throws NullPointerException,IllegalArgumentException;


   //Inserisce il valore del dato nella collezione se vengono rispettati i controlli di identita
 public boolean put(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException;


   //Ottiene una copia del valore del dato nella collezione se vengono
   //rispettati i controlli di identita
 public E get(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException;


   //Rimuove il dato nella collezione se vengono rispettati i controlli di identita
public E remove(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException;


   //Crea una copia del dato nella collezione se vengono rispettati i controlli di identita
public void copy(String Owner, String passw, E data) throws NullPointerException,IllegalArgumentException;


   //Condivide il dato nella collezione con un altro utente se vengono rispettati i controlli di identita
public void share(String Owner, String passw, String Other, E data) throws NullPointerException,IllegalArgumentException;


   //restituisce un iteratore(senza remove) che genera tutti i dati dell'utente in
   //ordine arbitrario, se vengono rispettati i controlli di identita
public Iterator<E> getIterator(String Owner, String passw) throws NullPointerException,IllegalArgumentException;



 }
