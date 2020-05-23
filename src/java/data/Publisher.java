package data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType(propOrder = {"publisherId", "name", "url", "booklist"})
public class Publisher {

    @Id
    @GeneratedValue
    private int publisherId;

    private String name;
    private String url;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST)
    private List<Book> booklist;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shopId")
    private BookShop shop;

    public Publisher() {
        booklist = new ArrayList();
    }

    @XmlElement(name = "publisherId")
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElementWrapper(name = "booklist")
    @XmlElement(name = "book")
    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    @XmlTransient
    public BookShop getBs() {
        return shop;
    }

    public void setBs(BookShop shop) {
        this.shop = shop;
    }

}
