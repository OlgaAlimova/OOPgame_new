package Units;

import java.util.ArrayList;
import java.util.List;

public abstract class Magic extends Unit{
    protected boolean magic;

    public Magic(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack, boolean magic) {
        super(name, speed, maxHp, def, damegeMin, damegeMax, x, y, attack);
        this.magic = magic;
    }



    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        if (state.equals("Die")) {hp = 0; return;}
        for (int i = 0; i < t1.size(); i++) {
            if (t1.get(i).hp < t1.get(i).maxHp){
                t1.get(i).getDamage(damageMax);
                System.out.println(name + " " + getInfo() + "  ->  " + t1.get(i).name +" "+ t1.get(i).getInfo());
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "\uD83E\uDDD9" +
                " H:" + Math.round(hp) +
                " D:" + def +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state;
    }
}
