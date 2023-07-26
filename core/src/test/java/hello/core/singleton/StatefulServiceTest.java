package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean((StatefulService.class));
        StatefulService statefulService2 = ac.getBean((StatefulService.class));

        // Thread A: A 사용자가 10000 주문
        statefulService1.order("userA", 10000);
        // Thread B: B 사용사자 20000 주문
        statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}