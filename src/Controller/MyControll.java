package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.SampleDTO;

/**
 * Servlet implementation class MyControll
 */
@WebServlet("/my")    //클라이언트 요청
public class MyControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
      // 컨텍스트 패스   : 웹서버에서 제공하는 다양한 웹 애플리케이션을 구분하기 위해 사용
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 컨트롤러는 클라이언트 요청 -> 디비(필수아님) -> 뷰에게 전달
		
		String view = "t01.jsp";
		
		// 가정  데이터베이에 접속하여 고객의 정보를 객체로 뷰에게 전송한다. 
		SampleDTO s = new SampleDTO();
		s.setName("순호");
		s.setAge(50);
		String sdata="이거슨 스트링 데이터";
		request.setAttribute("mys", s);	
		request.setAttribute("ssdata", sdata);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
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
