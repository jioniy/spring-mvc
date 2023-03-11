package hello.servlet.basic.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * GET/POST Method
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * 2. 동일한 파라미터 전송 가능
 * http://localhost:8080/request-param?username=hello&username=kim&age=20
 *
 * * 단일 파라미터 조회
 * String username = request.getParameter("username");
 * * 파라미터 이름들 모두 조회
 * Enumeration<String> parameterNames = request.getParameterNames();
 * * 파라미터를 Map으로 조회
 * Map<String, String[]> parameterMap = request.getParameterMap();
 * * 복수 파라미터 조회
 * String[] usernames = request.getParameterValues("username");
 */
@WebServlet(name = "requestParamServlet", value = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        /*전체 파라미터 조회
        username=hello
        age=20
        * */
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName +
                        "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        /*단일 파라미터 조회
        request.getParameter(username) = hello
        request.getParameter(age) = 20
         */
        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        /*이름이 같은 복수 파라미터 조회
        request.getParameterValues(username)
        username = hello
        username = kim
         */
        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }
        System.out.println();

        response.getWriter().write("ok");
    }

}
