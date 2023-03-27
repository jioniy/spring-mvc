package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Slf4j 를 추가 하면 로그 선언 없이 Logger(log) 객체를 사용 가능하다.
 */
@RestController
public class LogTestController {

    /* 1. 로그 선언 */
    private final Logger log = LoggerFactory.getLogger(getClass());
    //private final Logger log = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        /* 2. 로그 호출 - System.out.println과 유사 */
        log.trace("trace log={}", name); // 로컬 서버
        log.debug("debug log={}", name); // 개발 서버에서 보는 정보
        log.info(" info log={}", name); // 운영 서버에서 보는 정보
        log.warn(" warn log={}", name); // 위험 정보
        log.error("error log={}", name); // 에러

        /*
        * 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨
        * 연산을 하면서 메모리와 CPU를 사용하게 됨, trace를 사용하지 않아도 쓸모없는 리소스를 사용하게 되는 낭비가 발생함
        * 이런 방식으로 사용하면 X
        */
        log.debug("String concat log=" + name);

        return "ok";
        // @Controller 는 반환 값이 String 이면 뷰 이름으로 인식. 뷰를 찾고 뷰가 렌더링
        // @RestController 는 반환 값으로 뷰를 찾지 X, HTTP Message Body 에 바로 입력
    }
}
