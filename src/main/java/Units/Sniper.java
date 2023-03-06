package Units;

import java.util.ArrayList;
import java.util.List;

/**
 * Снайпер
 */
public class Sniper extends Arreys{


    public Sniper(String name, int x, int y) {
        super(name, 9, 15, 10, 8, 10, x, y, 12, 32);
    }


    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        super.step(t1, t2);
    }

    @Override
    public String getInfo() {
        return "Снайпер";
    }


}