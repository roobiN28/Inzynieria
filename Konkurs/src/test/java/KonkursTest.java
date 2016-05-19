import com.robin.konkurs.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class KonkursTest {

    @Test
    public void premiaZaNieparzyste () {
        int[] possitive = {5,7,9};
        int[] negative = {1,5,8,9};
        Konkurs konkurs = new Konkurs();
        BonusDecorator premia = new BonusOdds(konkurs);
        assertTrue(konkurs.execute(possitive) == 0);
        assertTrue(konkurs.execute(negative) == 0);
        assertTrue(premia.execute(possitive) == 50);
        assertTrue(premia.execute(negative) == 0);

    }
    @Test
    public void bonusForFirstAndLastZero () {
        int[] possitive = {0,0};
        int[] possitive1 = {0};
        int[] possitive2 = {0,5,6,4,0};
        int[] negative = {1,5,8,6};
        int[] negative1 = {0,1};
        int[] negative2 = {1,5,6,0};
        Konkurs konkurs = new Konkurs();
        BonusDecorator bonus = new BonusForFirstAndLastZero(konkurs);
        assertTrue(bonus.execute(possitive) == 100);
        assertTrue(bonus.execute(possitive1) == 100);
        assertTrue(bonus.execute(possitive2) == 100);
        assertTrue(bonus.execute(negative) == 0);
        assertTrue(bonus.execute(negative1) == 0);
        assertTrue(bonus.execute(negative2) == 0);
    }
    @Test
    public void bonusForMoreThen7 () {
        int[] negative = {0,0};
        int[] negative1 = {1,2,3,4,5,6,7};
        int[] possitive = {1,2,3,4,5,6,7,8};


        Konkurs konkurs = new Konkurs();
        BonusDecorator bonus = new BonusMoreThen7(konkurs);
        assertTrue(bonus.execute(negative) == 0);
        assertTrue(bonus.execute(negative1) == 0);
        assertTrue(bonus.execute(possitive) == 150);
    }
    @Test
    public void allBonusDecorators() {
        // 100 za BonusForFirstAndLastZero oraz 150 za BonusMoreThen7
        int[] first = {0,2,3,4,5,6,7,0,0};
        int[] non = {2,1};

        BonusDecorator bonus = new BonusForFirstAndLastZero(
            new BonusMoreThen7(
                new BonusOdds(new Konkurs())
            )
        );
        assertTrue(bonus.execute(first) == 250);
        assertTrue(bonus.execute(non) == 0);
    }


}
