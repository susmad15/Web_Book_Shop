package data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class BookShop {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.PERSIST)
    private List<Publisher> publisherlist;

    public BookShop() {
        publisherlist = new ArrayList();
    }

    @XmlElementWrapper(name = "publisherlist")
    @XmlElement(name = "publisher")
    public List<Publisher> getPublisherlist() {
        return publisherlist;
    }

    public void setPublisherlist(List<Publisher> publisherlist) {
        this.publisherlist = publisherlist;
    }

    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
