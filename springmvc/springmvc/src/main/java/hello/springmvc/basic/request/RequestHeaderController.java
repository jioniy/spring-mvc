package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j /*로그 객체 자동 생성 및 선언 -> log라는 이름으로 객체를 사용할 수 있음*/
@RestController /*@Controller를 사용하면 문자열 반환 시 뷰가 렌더링 되지만, @RestController를 사용하면 문자열이 바디에 직접 입력되어 반환된다.*/
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,/*사용 문자 영역*/
                          @RequestHeader MultiValueMap<String, String> headerMap,/* 요청 헤더의 모든 데이터 받아오기 - MultiValueMap은 하나의 Key에 여러 값을 받을 수 있다. */
                          @RequestHeader("host") String host,/* 요청 헤더 중 host 데이터 받아오기*/
                          @CookieValue(value="myCookie", required = false) String cookie /* 이름이 myCookie인 쿠키 데이터 받아오기, 필수값 여부 required*/
                          ){
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return "ok";
    }
}
