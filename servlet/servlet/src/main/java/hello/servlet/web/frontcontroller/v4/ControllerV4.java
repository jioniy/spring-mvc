package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

/**
 * Model 없이 뷰 객체만 반환해주도록 설정
 * --> model 객체는 파라미터로 전달
 */
public interface ControllerV4 {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
