package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * request url
 * localhost:9090/request-body-string
 *
 * HTTP Message Body에 데이터 직접 담아서 요청하는 경우 - text message
 * - HTTP API 에서 주로 사용 (데이터 형식 : JSON, XML, TEXT)
 * - 데이터 형식은 주로 JSON
 * POST, PUT, PATCH Method
 */
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // InputStream 으로 HTTP 바디의 데이터를 읽음.
        ServletInputStream inputStream = request.getInputStream();

        //inputStream 은 byte 코드를 반환. String 으로 보기 위해서 문자표(Charset) 지정 필요
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
