package de.vkb.codingdojo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    void testFirstTest(){
        assertEquals(true,true);
    }

    @Test
    void testFirstSum(){
       FirstProgramm firstProgramm = new FirstProgramm();

       int result = firstProgramm.sum(1,1);

       assertEquals(2,result);
    }

}
