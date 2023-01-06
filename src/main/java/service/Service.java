package service;

import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.HashSet;
import java.util.Set;

public class Service {

    public void add() {

        //Author entity
        Author author=new Author();
        author.setAge(45);
        author.setName("Gabriel Garcia Marquez");

        //Category
        Category category=new Category();
        category.setCategory_name("Classic");

        //Publisher
        Publisher publisher=new Publisher();
        publisher.setPublisher("ABC Publisher");

        //Language
        Language language=new Language();
        language.setLanguage("English");

        //Book Entity
        Book book1=new Book("Cien años de soledad",377,language,author,category,publisher);
        Book book2=new Book("Crónica de una muerte anunciada",455,language,author,category,publisher);
        Set<Book> bookSet=new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);

        //Address Entity
        Address address=new Address();
        address.setStreet("Kamycka");
        address.setZipCode(1300);
        address.setAuthor(author);
        author.setAddress(address);

        //Session opened
        Session session=HibernateUtil.getSessionFactory().openSession();
        //Transaction has been created before objects saved
        Transaction tx= session.beginTransaction();

        //Objects have saved
        session.persist(author);
        session.persist(category);
        session.persist(publisher);
        session.persist(language);
        session.persist(address);
        session.persist(book1);
        session.persist(book2);

        //commit transaction
        tx.commit();

        //session closed
        session.close();

    }
}
