package hello.servlet.basic.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

//http://localhost:9090/request-header?username=hello
@WebServlet(name = "requestHeaderServlet", value = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
        response.getWriter().write("ok");

    }
    
    /* start line 정보 */
    private void printStartLine(HttpServletRequest request){
        System.out.println("---REQUEST_LINE - start ---");
        System.out.println("request.getMethod() = "+request.getMethod());//GET
        System.out.println("request.getProtocol() = "+request.getProtocol());//HTTP/1.1
        System.out.println("request.getScheme() = "+request.getScheme());//http
        System.out.println("request.getRequestURL() = "+request.getRequestURL());// http://localhost:9090/request-header
        System.out.println("request.getRequestURI() = "+request.getRequestURI());// /request-header
        System.out.println("request.getQueryString() = "+request.getQueryString());// username=hi
        System.out.println("request.isSecure() = "+request.isSecure()); // https 사용유무 - false

        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }
    
    /* header 모든 정보 */
    private void printHeaders(HttpServletRequest request){
        System.out.println("--- Headers - start ---");

        /*
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": "+request.getHeader(headerName));
        }
         */

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName ->System.out.println(headerName + ": "+request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    /* header 편리한 조회 */
    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    /* 기타 정보 - HTTP 메시지 정보 X*/
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
