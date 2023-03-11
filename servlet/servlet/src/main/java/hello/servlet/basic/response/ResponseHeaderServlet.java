package hello.servlet.basic.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse 역할
 * * 응답 메시지 생성
 * : HTTP 응답 코드 지정
 * : 헤더 생성
 * : 바디 생성
 * * 편의 기능 제공
 * : Content-Type, Cookie, redirect
 *
 * http://localhost:9090/response-header
 *
 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //[status-line] - 응답 상태 코드 지정
        response.setStatus(HttpServletResponse.SC_OK); //200

        //[response-headers] - 헤더 생성
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        response.setHeader("Pragma", "no-cache");//캐시 무효화
        response.setHeader("my-header","hello");

        //[Header 편의 메서드]
        content(response);//content-type
        cookie(response);//cookie
        redirect(response);//redirect
        
        //[message body] - 바디 생성
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    /* content 변의 메서드 */
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }
    
    /* 쿠키 편의 메서드 */
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    /* redirect 편의 메서드*/
    private void redirect(HttpServletResponse response) throws IOException {
        /* Status Code 302
         * Location: /basic/hello-form.html*/
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        response.sendRedirect("/basic/hello-form.html");
    }

}
