package jp.co.aforce.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.InformationDAO;
import jp.co.aforce.been.MemberInformation;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class userRegister
 */
@WebServlet("/views/userRegister")
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
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

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yymmddmm");
	String MEMBER=("A"+sdf.format(cal.getTime()));
	
	try {
		//MEMBER_ID
		//String MEMBER_ID=request.getParameter(MEMBER);
		//姓
		String LAST_NAME=request.getParameter("LAST_NAME");
		//名
		String FARST_NAME=request.getParameter("FARST_NAME");
		//性別
		String SEX=request.getParameter("SEX");
		//年
		int BIRTH_YEAR=Integer.parseInt(request.getParameter("birth_year"));
		//月
		int BIRTH_MONTH=Integer.parseInt(request.getParameter("birth_month"));
		//日
		int BIRTH_DAY=Integer.parseInt(request.getParameter("birth_day"));
		//電話番号
		String PHONE_NUMBER=request.getParameter("PHONE_NUMBER");
		//メールアドレス
		String MAIL_ADDRESS=request.getParameter("MAIL_ADDRESS");
		//仕事
		String JOB=request.getParameter("JOB");
		
		MemberInformation p=new MemberInformation();
		p.setId(MEMBER);
		p.setLname(LAST_NAME);
		p.setFname(FARST_NAME);
		p.setSex(SEX);
		p.setByear(BIRTH_YEAR);
		p.setBmonth(BIRTH_MONTH);
		p.setBday(BIRTH_DAY);
		p.setPnumber(PHONE_NUMBER);
		p.setMail(MAIL_ADDRESS);
		p.setJob(JOB);
		
		InformationDAO dao=new InformationDAO();
		int line=dao.insert(p);
		if(line>0) {
			out.println("登録が完了しました");
		}
	}catch (Exception e) {
		e.printStackTrace(out);
	}
	Page.footer(out);
	
	}

}
