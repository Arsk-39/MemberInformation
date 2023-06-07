package jp.co.aforce.Search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.InformationDAO;
import jp.co.aforce.been.MemberInformation;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Search
 */
@WebServlet("/views/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	Page.header(out);
	
	try {
		String member_Id = request.getParameter("kyeword");
		InformationDAO DAO = new InformationDAO();
		List<MemberInformation> list = DAO.search(member_Id);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/userUpdate2.jsp").forward(request, response);
		
	}catch (Exception e) {
		
	}
	Page.header(out);
	}

}
