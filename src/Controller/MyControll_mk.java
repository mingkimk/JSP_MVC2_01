package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.SampleDTO_mk;

/**
 * Servlet implementation class MyControll
 */
@WebServlet("/MyControll") //클라이언트 요청 @ 어노테이션 컴파일러가 관리 하는 애 / 이 클래스는 컨트롤러로 사용하겠다라는 정의 ("/00")<- 컨트롤러 이름
public class MyControll_mk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyControll_mk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// controller 는 요청이 들어오면은 ->db(필수 아님)-> 뷰(view)에게 전달
		String view="T01.jsp";
		 
		//가정 db에 접속하여 고객의 정보를 객체로 뷰에게 전송
		
		SampleDTO_mk s= new SampleDTO_mk();
		s.setName("순호");
	
		String sdata="이거슨 스트링 데이터";
		request.setAttribute("mys", s);
		request.setAttribute("sdata", sdata);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
