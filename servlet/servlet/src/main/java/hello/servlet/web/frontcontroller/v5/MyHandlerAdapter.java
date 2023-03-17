package hello.servlet.web.frontcontroller.v5;
import hello.servlet.web.frontcontroller.ModelView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ControllerV3 방식과 ControllerV4 방식을 모두 사용하기 위한 어댑터 생성
 * * ControllerV3 - ModelView 반환 (jsp location, request attribute data)
 * * ControllerV4 - jsp location 이름 반환 (jsp location)
 *
 * 어댑터 패턴 사용 -> front controller가 다양한 방식의 컨트롤러를 사용할 수 있도록 변경
 */
public interface MyHandlerAdapter {

    /**
     * @param handler := controller
     * 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
    * */
    boolean supports(Object handler);

    /**
     * 실제 컨트롤러를 호출하는 메서드
     * 이전에는 front controller가 컨트롤러 호출, 
     * 현재는 어댑터가 컨트롤러 호출
     * @param request,response
     * @param handler := controller
     *
     * @return ModelView
     * 실제 컨트롤러가 ModelView를 반환하지 못하는 경우, 직접 생성해서 반환
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
