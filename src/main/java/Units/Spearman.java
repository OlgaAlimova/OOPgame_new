package Units;

import java.util.ArrayList;
import java.util.List;

/**
 * Кпоейщики
 */
public class Spearman extends Warrior{


    public Spearman(String name, int x, int y) {
        super(name, 4, 10, 5, 1, 3, x, y, 4);
    }



    @Override
    public String getInfo() {
        return "Копейщик";
    }


}