package hello.servlet.web.servletmvc;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String viewPath = "/WEB-INF/views/new-form.jsp";
        
         RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
         dispatcher.forward(request, response);
         //다른 서블릿이나 JSP 로 이동 서버 내부에서 다시 호출 발생
        /**
         * /WEB-INF 내의 JSP 는 외부에서 직접 호출할 수 없다 .
         * 컨트롤러를 통해서 호출 가능하다.
         */
     }
 }