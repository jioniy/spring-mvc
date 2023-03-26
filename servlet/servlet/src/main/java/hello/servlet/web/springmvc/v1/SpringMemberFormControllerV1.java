package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller == @Component @RequestMapping
 * - @Component : 스프링 빈 자동 등록 (내부에 @Component가 있어 컴포넌트 스캔의 대상이 됨)
 * - @RequestMapping : 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식(request mapping 대상으로 인식)
 *
 * RequestMappingHandlerMapping
 * : 스프링 빈 중에서 @RequestMapping 또는 @Controller 가 클래스 레벨에 붙어 있는 경우에 매핑 정보로 인식 (스프링 부트 3.0(스프링 프레임워크 6.0)부터는 적용 X, 오직 Controller annotation 만 인식)
 */
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
        // InternalResourceViewResolver 가 prefix, suffix 를 달아 forward()
    }



}
