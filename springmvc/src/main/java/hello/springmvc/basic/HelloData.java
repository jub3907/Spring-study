package hello.springmvc.basic;

import lombok.Data;

// Getter, Setter 등을 자동으로 만들어둠.
@Data
public class HelloData {
    private String username;
    private int age;
}
