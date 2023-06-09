package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * View 분리
 * MyView - 뷰를 처리하는 객체
 * JSP 이외의 것을 렌더링할 경우에는 인터페이스로 구현해야하지만, JSP만을 렌더링 하는 경우이므로 구현체인 객체로 만듬
 * 뷰에 렌더링할 data(members, member)도 attribute로 전달함
 */
public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }


    public void render(Map<String, Object> model, HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);/* 컨트롤러에서 서블릿 종속성을 제거했기 때문에 다음 페이지에 렌더링 할 request Attribute를 함께 처리해 주어야함 */
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
    private void modelToRequestAttribute(Map<String, Object> model,
                                         HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}