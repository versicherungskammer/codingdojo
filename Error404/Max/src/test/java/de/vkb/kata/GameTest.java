package de.vkb.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by v005783 on 17.09.2019.
 */
public class GameTest {

    Game game = new Game();

    @Test
    public void schereschere() {
        //arrange goto autowired
        //act
        int result = game.gaming(0,0);
        //assert
        assertEquals(0, result);
    }
    @Test
    public void papierpapier() {
        //arrange goto autowired
        //act
        int result = game.gaming(1,1);
        //assert
        assertEquals(0, result);
    }
    @Test
    public void steinstein() {
        //arrange goto autowired
        //act
        int result = game.gaming(2,2);
        //assert
        assertEquals(0, result);
    }
    @Test
    public void echseechse() {
        //arrange goto autowired
        //act
        int result = game.gaming(3,3);
        //assert
        assertEquals(0, result);
    }
    @Test
    public void spockspock() {
        //arrange goto autowired
        //act
        int result = game.gaming(4,4);
        //assert
        assertEquals(0, result);
    }

    @Test
    public void schereschneidetpapier() {
        //arrange goto autowired
        //act
        int result = game.gaming(0,1);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reverseschereschneidetpapier() {
        //arrange goto autowired
        //act
        int result = game.gaming(1,0);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void papierbedecktstein() {
        //arrange goto autowired
        //act
        int result = game.gaming(1,2);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversepapierbedecktstein() {
        //arrange goto autowired
        //act
        int result = game.gaming(2,1);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void steinerschlaegtechse() {
        //arrange goto autowired
        //act
        int result = game.gaming(2,3);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversesteinerschlaegtechse() {
        //arrange goto autowired
        //act
        int result = game.gaming(3,2);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void echsevergiftetspock() {
        //arrange goto autowired
        //act
        int result = game.gaming(3,4);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reverseechsevergiftetspock() {
        //arrange goto autowired
        //act
        int result = game.gaming(4,3);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void spockzertruemmertschere() {
        //arrange goto autowired
        //act
        int result = game.gaming(0,4);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversespockzertruemmertschere() {
        //arrange goto autowired
        //act
        int result = game.gaming(4,0);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void scherekoepftechse() {
        //arrange goto autowired
        //act
        int result = game.gaming(0,3);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversescherekoepftechse() {
        //arrange goto autowired
        //act
        int result = game.gaming(3,0);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void echsefrisstpapier() {
        //arrange goto autowired
        //act
        int result = game.gaming(3,1);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reverseechsefrisstpapier() {
        //arrange goto autowired
        //act
        int result = game.gaming(1,3);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void papierwiderlegtspock() {
        //arrange goto autowired
        //act
        int result = game.gaming(1,4);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversepapierwiderlegtspock() {
        //arrange goto autowired
        //act
        int result = game.gaming(4,1);
        //assert
        assertEquals(2, result);
    }


    @Test
    public void spockverdampftstein() {
        //arrange goto autowired
        //act
        int result = game.gaming(4,2);
        //assert
        assertEquals(1, result);
    }


    @Test
    public void reversespockverdampftstein() {
        //arrange goto autowired
        //act
        int result = game.gaming(2,4);
        //assert
        assertEquals(2, result);
    }

    @Test
    public void steinschleiftschere() {
        //arrange goto autowired
        //act
        int result = game.gaming(2,0);
        //assert
        assertEquals(1, result);
    }

    @Test
    public void reversesteinschleiftschere() {
        //arrange goto autowired
        //act
        int result = game.gaming(0,2);
        //assert
        assertEquals(2, result);
    }



}





