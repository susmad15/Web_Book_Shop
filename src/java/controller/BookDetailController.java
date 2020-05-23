package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Author;
import data.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.DB_Access;

@WebServlet(name = "BookDetailController", urlPatterns = {"/BookDetailController"})
public class BookDetailController extends HttpServlet {

    private DB_Access db = DB_Access.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Start BookDetailController");

        String bodyText = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();

        System.out.println("BookDetailController BodyText: " + bodyText);

        String lastname = bodyText.split(",")[0];

        //System.out.println("Lastname: " + lastname);
        
        //List<Author> authorlist = db.getListOfAuthors(lastname);
        
        //System.out.println("BookDetailController AuthorList: " + authorlist);
        
        //log("BookDetailConotroller: AuthorList: "+ authorlist);

        Author autor = db.getAuthorWithName(lastname);
        
        log("Author: " + autor.toString());

        Book book = db.getFirstBookOfAuthor(autor);

        System.out.println("Book: " + book);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        String jsonString = gson.toJson(book);

        System.out.println("JsonString: " + jsonString);

        OutputStreamWriter out = new OutputStreamWriter(response.getOutputStream());

        out.write(jsonString);

        out.flush();

    }

}
