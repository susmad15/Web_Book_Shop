package data;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQuery(name = "Book.findByAuthor",
        //query="SELECT b FROM Book b JOIN b.authorlist list JOIN Author a WHERE a.lastname = :lastname")
        query = "SELECT b FROM Book b, Author a WHERE a.lastname = :lastname")
@XmlType(propOrder = {"bookId", "title", "url", "price", "isbn", "authorlist"})
public class Book {

    @Id
    @GeneratedValue
    @Expose
    private int bookId;

    @Expose
    private String title;
    
    @Expose
    private String url;
    @Expose
    private double price;
    @Expose
    private String isbn;

    @ManyToMany(mappedBy = "booklist", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Author> authorlist;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisherID")
    private Publisher publisher;

    public Book() {
        authorlist = new ArrayList<>();
    }

    @XmlElement(name = "bookId")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @XmlElementWrapper(name = "authorlist")
    @XmlElement(name = "author")
    public List<Author> getAuthorlist() {
        return authorlist;
    }

    public void setAuthorlist(List<Author> authorlist) {
        this.authorlist = authorlist;
    }

    @XmlTransient
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title=" + title + ", url=" + url + ", price=" + price + ", isbn=" + isbn + ", authorlist=" + authorlist + ", publisher=" + publisher + '}';
    }
    
    

}
