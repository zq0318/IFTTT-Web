package web.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.UserServiceImpl;
import web.formbean.UserTasksFormBean;
import web.formbean.*;
import service.impl.*;
import domain.*;
/**
 * Servlet implementation class UserTasksUIServlet
 */
@WebServlet("/UserTasksUIServlet")
public class UserTasksUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTasksUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get userId
		String userId = request.getParameter("userId");
		
		// get the user
		UserServiceImpl service = new UserServiceImpl();
		User user = service.getUserInfo(userId);
		
		// construct formbean
		UserTasksFormBean formbean = new UserTasksFormBean();
		formbean.setUserTasks((new UserServiceImpl()).getUserTasks(userId));
		formbean.setUserId(userId);
		request.setAttribute("formbean", formbean);
		
		// jump to UserTasks.jsp
		request.getRequestDispatcher("/WEB-INF/UserTasks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
