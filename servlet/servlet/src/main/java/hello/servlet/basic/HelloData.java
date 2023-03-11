package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // Lombok Annotation -> Create Getter, Setter Method
public class HelloData {
    private String username;
    private int age;
}
