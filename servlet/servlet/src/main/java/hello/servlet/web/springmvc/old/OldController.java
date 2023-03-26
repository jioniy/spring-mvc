package hello.servlet.web.springmvc.old;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller 인터페이스를 구현하는 Controller
 *
 * DispatcherServlet 내부 doDispatch()
 * - HandlerMapping -> BeanNameUrlHandlerMapping 이용
 * - HandlerAdapter -> SimpleControllerHandlerAdapter 이용
 *
 * ViewResolver
 * - View 조회할 수 있도록 변경
 */
@Component("/springmvc/old-controller") // 해당 이름으로 스프링 빈 등록 -> 빈의 이름으로 url 매핑
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
        /**
         * ViewResolver
         * : InternalResourceViewResolver 라는 뷰 리졸버를 자동으로 등록 (SpringBoot 가 Bean 을 자동으로 등록)
         * : application.properties 에 등록한 spring.mvc.view.prefix/suffix 설정 정보를 참고하여 등록한다
         */
    }
}