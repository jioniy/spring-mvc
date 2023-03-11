package hello.servlet.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello")
public class helloServlet extends HttpServlet {
    /**
     * HTTP 요청을 통애 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);//org.apache.catalina.connector.RequestFacade@159bd408
        System.out.println("response = " + response);//org.apache.catalina.connector.ResponseFacade@762094d

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
