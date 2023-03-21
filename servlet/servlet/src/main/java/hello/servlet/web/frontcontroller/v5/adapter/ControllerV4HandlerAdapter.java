package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    /*대상 handler(controller) 지정 - ControllerV4만 처리할 수 있다.*/
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }
    
    /* handler(controller) 처리 및 결과 반환 */
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        
        /*어댑터 역할 - 파라미터로 model 을 전달할 수 있도록 변환함*/
        String viewName = controller.process(paramMap, model); // viewName 만을 반환하는 컨트롤러

        /*어댑터 역할* - viewName 을 반환하는 controller 가 ModelView 를 반환할 수 있도록 변환함*/
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    /*요청 파라미터*/
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
