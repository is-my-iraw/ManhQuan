package com.example.ss6.controller;

import com.example.ss6.dao.BrandDAO;
import com.example.ss6.dao.PhoneDAO;
import com.example.ss6.entity.Brand;
import com.example.ss6.entity.Phone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    PhoneDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new PhoneDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> listPhone = getAllPhone();

        request.setAttribute("phones", listPhone);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        Phone product = new Phone(name, Integer.valueOf(price),description, Integer.valueOf(brand));
        dao.insertPhone(product);
        response.sendRedirect("list");
    }

    private List<Phone> getAllPhone() {
        List<Phone> list = dao.getPhone();
        for (Phone p : list){
            System.out.println(p.getName());
        }
        return dao.getPhone();
    }
}
