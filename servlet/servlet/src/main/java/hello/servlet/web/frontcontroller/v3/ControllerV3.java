package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * *****V3
 * Controller에서 HttpServletRequest 객체 대신 Model 객체를 파라미터로 변경(서블릿 종속 제거)
 */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
