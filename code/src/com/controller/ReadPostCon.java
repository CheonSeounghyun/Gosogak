package com.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.MemberDTO;
import com.model.PostDAO;
import com.model.PostDTO;

import front.ICommand;

public class ReadPostCon implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int post_cd = Integer.parseInt(request.getParameter("num"));
		
//		System.out.println(post_cd);
		
		PostDAO dao = new PostDAO();
		PostDTO click_p_info = dao.selectOne(post_cd);
		
//		HttpSession session = request.getSession();
//		
//		session.removeAttribute("click_p_info_id");
//		session.setAttribute("click_p_info_id", click_p_info_id);
		
		Gson gson = new Gson();
		String value = gson.toJson(click_p_info);
		
		return value;
	}

}
