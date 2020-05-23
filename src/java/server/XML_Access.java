package server;

import data.Author;
import data.Book;
import data.BookShop;
import data.Publisher;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXB;

public class XML_Access {

    private static XML_Access theInstance;

    private String path;

    private XML_Access() {
        path = "/home/markus/Dokumente/HTL/5DHIF/POS/MaturaTest/Web_Book_Shop/RP_SF_bookshop.xml";
    }

    public static XML_Access getInstance() {
        if (theInstance == null) {
            theInstance = new XML_Access();
        }

        return theInstance;
    }

    public BookShop loadBookShop() {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Die Datei existiert nicht!!!");
        }

        BookShop shop = JAXB.unmarshal(file, BookShop.class);

        List<Author> authors = new ArrayList<>();

        for (Publisher pub : shop.getPublisherlist()) {
            pub.setBs(shop);
            for (Book book : pub.getBooklist()) {
                book.setPublisher(pub);
                for (Author author : book.getAuthorlist()) {
                    if (!authors.contains(author)) {
                        authors.add(author);
                    } else {
                        int index = book.getAuthorlist().indexOf(author);
                        Author obj = authors.get(authors.indexOf(author));
                        book.getAuthorlist().set(index, obj);
                    }
                    author.getBooklist().add(book);
                }
            }
        }

        //JAXB.marshal(shop, System.out);

        return shop;
    }

    public static void main(String[] args) {
        XML_Access xml = XML_Access.getInstance();

        xml.loadBookShop();
    }

}
