package com.example.laba5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.io.*;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.List;

@WebServlet(name = "LaptopServlet", value = "/laptop")
public class LaptopServlet extends HttpServlet {

    private Gson gson = new Gson();
    private LaptopsDB laptopsDB;

    @Override
    public void init() throws ServletException {
        super.init();
        laptopsDB = new LaptopsDB();
    }

    // Добавление объекта к JSON
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonRequest = request.getReader().lines().collect(Collectors.joining());
        Laptop newLaptop = gson.fromJson(jsonRequest, Laptop.class);

        try {
            laptopsDB.addLaptop(newLaptop);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    // передача клиенту JSON
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Laptop> laptops = null;
        try {
            laptops = laptopsDB.getLaptops();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String jsonResponse = gson.toJson(laptops);
        response.getWriter().write(jsonResponse);

    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            laptopsDB.delLaptop(id);
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Laptop laptop = gson.fromJson(request.getReader(), Laptop.class);

        try {
            laptopsDB.updateLaptop(laptop);
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }

}

