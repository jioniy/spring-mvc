package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. HandlerMapping 으로 Handler 조회 -> **BeanUrlHandlerMapping** 실행
 * 2. Handler Adapter 조회 -> support() 로 지원하는 handlerAdapter 찾기 -> **HttpRequestHandlerAdapter** 실행
 * 3. HttpRequestHandlerAdapter.handle() -> 내부에서 MyHttpRequestHandler 실행
 */
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
