package controller;


import DAO.nhanvienDAO;
import model.nhanvien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/nhanvien")
public class nhanvienServlet extends HttpServlet {
    nhanvienDAO nhanvienDao = new nhanvienDAO();
    ArrayList<nhanvien> nhanviens=new ArrayList<>();
    Map<nhanvien, Integer> carts = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        nhanvien nhanvien= new nhanvien();
        if (action == null) {
            action = "";
        }
        RequestDispatcher dispatcher = null;
        switch (action){
            case "add":
                int id = Integer.parseInt(req.getParameter("id"));
                nhanvien sp = null;
                carts.put(sp,1);
                req.setAttribute("nhanvien", nhanvien.getIdNhanvien());
                dispatcher = req.getRequestDispatcher("/cart.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                nhanviens= (ArrayList<model.nhanvien>) nhanvienDAO.getAll();
                req.setAttribute("nhanviens",nhanviens);
                dispatcher = req.getRequestDispatcher("/dashbroad.jsp");
                dispatcher.forward(req, resp);

        }
    }


}

