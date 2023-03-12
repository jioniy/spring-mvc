package hello.servlet.web.frontcontroller.v1;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FrontController Pattern
 * - front controller servlet 하나로 클라이언트의 요청을 받음(입구를 하나로!)
 * - 요청에 맞는 컨트롤러를 찾아서 호출
 * - 공통 처리 가능
 * - front controller를 제외한 controller는 서블릿(요청 매핑)을 사용하지 않아도 됨.
 *
 * Spring Wev MVC & Front controller
 *  - (Spring Web MVC 의 DispatcherServlet) <== Front Controller Pattern
 */
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/frontcontroller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String, ControllerV1> controllerMap = new HashMap<>();
    
    public FrontControllerServletV1() {//url Mapping 정보 + 호출될 controller 삽입
        controllerMap.put("/front-controller/v1/members/new-form", new
                MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new
                MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new
                MemberListControllerV1());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}