package com.example.ss6.controller;

import com.example.ss6.dao.BrandDAO;
import com.example.ss6.dao.PhoneDAO;
import com.example.ss6.entity.Phone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet", value = "/list")
public class ListServlet extends HttpServlet {

    PhoneDAO dao;
    BrandDAO categoryDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new PhoneDAO();
        categoryDAO = new BrandDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> listPhone = getAllPhone();
        request.setAttribute("phones", listPhone);
        request.getRequestDispatcher("listPhone.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Phone> getAllPhone() {
        List<Phone> list = dao.getPhone();
        for (Phone p : list){
            System.out.println(p.getName());
        }
        return dao.getPhone();
    }
}
