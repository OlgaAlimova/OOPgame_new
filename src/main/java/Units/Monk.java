package Units;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *  Монах
 */
public class Monk extends  Magic{


    public Monk(String name, int x, int y) {
        super(name, 5, 30, 7, -4, -4, x, y, 12, true);
    }




    @Override
    public String getInfo() {
        return "Монах";
    }

    @Override
    public String toString() {
        return String.format("Монах: %5s  |  HP: %d  |  Speed: %d  |  ATK: (%d)  |  DEF: %d  |  (X,Y): (%d,%d) | Status: %s\n", this.name, this.hp, this.speed, this.damegeMax, this.def, this.pos.x, this.pos.y, this.state);
    }
}
