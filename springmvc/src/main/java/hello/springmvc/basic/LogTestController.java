package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController : 기존 @Controller에서 문자를 반환하면 ViewName으로 사용하는걸 방지하기 위해 사용.
// RestController를 사용하면 문자를 리턴할 때 진짜 문자가 반환된다.
@RestController
@Slf4j
public class LogTestController {

//    @Slf4j 애노테이션을 이용해, 아래 코드를 대체할 수 있음.
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // trace, debug는 applications.properties에서 설정해야 한다.
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);

        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}
