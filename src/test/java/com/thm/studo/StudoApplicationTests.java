package com.thm.studo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudoApplicationTests {

    @Test
    void itShouldAddNumbers() {
        //given
        Calculator calculator = new Calculator();
        int a = 20;
        int b = 30;

        //when
        int result = calculator.add(a, b);

        //then
        assertThat(result).isEqualTo(50);
    }

    class Calculator{
        public int add(int a, int b){
            return a + b;
        }
    }
}
