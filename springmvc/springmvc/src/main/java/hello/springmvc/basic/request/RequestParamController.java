package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 요청 파라미터
 *  - 요청 파라미터를 담는 방식에는 query parameter, (POST) HTML Form 두가지 방식이 있다.
 *    (두 파라미터는 엄연히 다른 레벨이지만, 요청을 받아서 처리할 때는 구분하지 않는다.)
 */
@Slf4j
@Controller
public class RequestParamController {
    /**
     * 반환 타입이 없으면서 이렇게 응답에 값을 직접 집어넣으면, view 조회X (view page를 보여주는 것이 아니다!)
     */
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* 단순히 HttpServletRequest가 제공하는 방식으로 요청 파라미터를 조회 */
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }
}
