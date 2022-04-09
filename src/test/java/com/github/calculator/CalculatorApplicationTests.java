package com.github.calculator;

import com.github.calculator.unity.ExpressImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

    @Test
    void contextLoads() {
        ExpressImpl it=new ExpressImpl(3);
        it.deal();
        it.display();
    }

}
