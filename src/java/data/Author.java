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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType(propOrder = {"authorId", "firstname", "lastname", "url"})
@NamedQueries({
    @NamedQuery(name = "Author.findByLastName",
            query = "SELECT a FROM Author a WHERE a.lastname LIKE :lastname ORDER BY a.lastname"),
        
    @NamedQuery(name = "Author.getWithName", query = "SELECT DISTINCT a FROM Author a WHERE a.lastname = :lastname")
})
public class Author {

    @Id
    @GeneratedValue
    private int authorId;

    @Expose
    private String firstname;

    @Expose
    private String lastname;

    private String url;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Book> booklist;

    public Author() {
        booklist = new ArrayList();
    }

    @XmlElement(name = "authorId")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @XmlElement(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @XmlElement(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            Author a = (Author) obj;
            if (firstname.equals(a.firstname) && lastname.equals(a.lastname)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return lastname + ", " + firstname;
    }

}
