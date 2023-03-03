package Units;
/**
 * Маги
 */
public class Mag extends Magic{


    public Mag(String name, int x, int y) {
        super(name, 9, 30, 12, -5, -5, x, y, 17, true);
    }

    @Override
    public String getInfo() {
        return "Колдун";
    }

    @Override
    public String toString() {
        return String.format("Колдун: %s  |  HP: %d  |  Speed: %d  |  ATK: (%d)  |  DEF: %d  |  (X,Y): (%d,%d) | Status: %s\n", this.name, this.hp, this.speed, this.damegeMin, this.def, this.pos.x, this.pos.y, this.state);
    }
}