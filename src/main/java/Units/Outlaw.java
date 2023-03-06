package Units;

import java.util.ArrayList;
import java.util.List;

/**
 * Разбойник
 */
public class Outlaw extends Warrior {


    public Outlaw(String name, int x, int y) {
        super(name, 6, 10, 3, 2, 4, x, y, 8);
    }



    @Override
    public String getInfo() {
        return "Разбойник";
    }


}