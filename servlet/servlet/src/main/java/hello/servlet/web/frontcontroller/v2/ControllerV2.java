package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * View 를 분리한 Front Controller 의 사용
 * front controller 이외 controller 의 일관성을 유지하기 위한 인터페이스 생성
 */
public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}