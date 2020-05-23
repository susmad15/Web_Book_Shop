package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Author;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.DB_Access;

@WebServlet(name = "BookShopController", urlPatterns = {"/BookShopController"})
public class BookShopController extends HttpServlet {

    private DB_Access db;

    private List<Author> authors;

    @Override
    public void init() throws ServletException {
        super.init();

        db = DB_Access.getInstance();

        db.persistBookShop();

        authors = db.getListOfAuthors("%");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("authors", authors);

        request.getRequestDispatcher("authorView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");

        String bufferedString = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();

        System.out.println("BufferedString: " + bufferedString);

        String bodyText = "";

        if (bufferedString != null) {
            bodyText = "%" + bufferedString + "%";
        } else {
            bodyText = "%";
        }
        
        System.out.println("BodyText: " + bodyText);

        authors = db.getListOfAuthors(bodyText);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        String jsonString = gson.toJson(authors);

        OutputStreamWriter out = new OutputStreamWriter(response.getOutputStream());

        out.write(jsonString);

        out.flush();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
