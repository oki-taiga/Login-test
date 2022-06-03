package jp.co.afroce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.afroce.DAO.LoginDAO;
import jp.co.afroce.beans.Bean;

@WebServlet(urlPatterns= {"/jp.co.aforce/login"})
public class Login extends HttpServlet {

		public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();

			String id=request.getParameter("id");
			String pass=request.getParameter("pass");

			LoginDAO dao=new LoginDAO();

			try {
				Bean b=dao.search(id, pass);
				String loginId=b.getLoginId();

				if (loginId != null) {
					request.setAttribute("Bean", b);
					request.getRequestDispatcher("../jsp/result.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "IDもしくはパスワードが間違っています。");
					request.getRequestDispatcher("../jsp/result.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();


			}



		}
}
