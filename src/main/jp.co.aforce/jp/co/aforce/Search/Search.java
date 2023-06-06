package jp.co.aforce.Search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.InformationDAO;
import jp.co.aforce.been.MemberInformation;

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
		response.sendRedirect("/MemberInformation/views/userUpdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		String keyword=request.getParameter("keyword");
		
		InformationDAO dao = new InformationDAO();
		List<MemberInformation> MenberInformation;
		try {
			MenberInformation = dao.search(keyword);
			if(MenberInformation != null) {
				session.setAttribute("existence", "IDを確認しました更新内容を記入してください。");
				session.setAttribute("box", "keyword");
				request.getRequestDispatcher("/views/userUpdate.jsp").forward(request, response);
			}else {
				session.setAttribute("errormsg", "ユーザIDが違うか、存在していません。");
				session.setAttribute("box", keyword);
				response.sendRedirect("/views/userUpdate.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
