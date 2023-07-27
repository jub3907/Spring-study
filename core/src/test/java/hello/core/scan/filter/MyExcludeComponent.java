package hello.core.scan.filter;

import java.lang.annotation.*;

// 얘가 붙은건 ComponentScan에 추가한다. 정도로 이해.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
