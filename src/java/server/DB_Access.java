package server;

import data.Author;
import data.Book;
import data.BookShop;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DB_Access {
    
    private static DB_Access theInstance;
    
    private XML_Access xml;
    
    private EntityManager em;
    private EntityManagerFactory emf;

    private DB_Access() {
        xml = XML_Access.getInstance();
        
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        
        em = emf.createEntityManager();
    }
    
    public static DB_Access getInstance() {
        if(theInstance == null) {
            theInstance = new DB_Access();
        }
        
        return theInstance;
    }
    
    public void persistBookShop() {
        BookShop shop = xml.loadBookShop();
        
        em.getTransaction().begin();
        
        shop.getPublisherlist()
            .stream()
            .forEach(em::persist);
        
        em.getTransaction().commit();
    }
    
    public List<Author> getAllAuthors() {
        TypedQuery query = em.createNamedQuery("Author.getAll", Author.class);
        
        return query.getResultList();
    }
    
    public Author getAuthorWithName(String lastname) {
        TypedQuery query = em.createNamedQuery("Author.getWithName", Author.class);
        
        query.setParameter("lastname", lastname);
        
        List<Author> authors = query.getResultList();
        
        System.out.println("DB_Access: authors: " + authors);
        
        Author a = authors.get(0);
        
        System.out.println("DB_Access: Author: " + a);
        
        return a;
    }
    
    public List<Author> getListOfAuthors(String name) {
        TypedQuery query = em.createNamedQuery("Author.findByLastName", Author.class);
    
        query.setParameter("lastname", name);
        
        return query.getResultList();
    }
    
    public Book getFirstBookOfAuthor(Author author) {
        TypedQuery<Book> query = em.createNamedQuery("Book.findByAuthor", Book.class);
        
        query.setParameter("lastname", author.getLastname());
        
        return query.getResultList().get(0);
    }
    
    public static void main(String[] args) {
        System.out.println("Persist BookShop");
        
        DB_Access db = DB_Access.getInstance();
        
        db.persistBookShop();
    }
    
    
}
