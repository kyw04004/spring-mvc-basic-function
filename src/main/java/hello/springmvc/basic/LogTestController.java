package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller는 반환값이 String이면 뷰 이름으로 인식
 * @RestController는 HTTP 메시지 바디에 바로 입력
 */

/**
 * 로그 사용시 장점
 * 1. 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 출력 모양 조정 가능
 * 2. 로그 레벨에 따라 개발 서버에서는 모든 로그를 출력하고, 운영 서버에서는 출력하지 않는 등 상황에 맞게 조절 가능
 * 3. 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등 로그를 별도의 위치에 남길 수 있음.
 *    특히, 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능
 * 4. 성능도 System.out 보다 좋음. (내부 버퍼링, 멀티 스레드 등등)
 */
@Slf4j
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);
        //로그 출력 레벨을 info로 설정해도 문자 더하기 연산이 실행됨
        //log.debug("trace log="+name)

        //로그 출력 레벨을 info로 설정하면 아무 일도 발생하지 않음
        log.trace("trace log={}", name);

        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
