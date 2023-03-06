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
        return "Волшебник";
    }


}