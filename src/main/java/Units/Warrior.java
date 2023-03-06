package Units;

import java.util.ArrayList;

public abstract class  Warrior extends Unit{

    public Warrior(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack) {
        super(name, speed, maxHp, def, damegeMin, damegeMax, x, y, attack);
    }

    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        if (state.equals("Die")) {hp = 0; return;}
        int target = findNearest(t2);
        if (target < 2) {
            float damdge = (t2.get(target).def - attack > 0) ?
                    damageMin : (t2.get(target).def - attack < 0) ?
                    damageMax : ( (damageMax+damageMin) / 2);
            t2.get(target).getDamage(damdge);
            return;
        }
        moveToOpponent(target, t2);
    }

    void moveToOpponent(int target, ArrayList<Unit> t2){
        if (pos.onTheTop(t2.get(target).pos) & (pos.y != t2.get(target).pos.y)){
            pos.y++;
            return;
        } else if (!pos.onTheTop(t2.get(target).pos) & (pos.y != t2.get(target).pos.y)) {
            pos.y--;
            return;
        }
        if (pos.onTheLeft(t2.get(target).pos)) {
            pos.x++;
            return;
        } else if (!pos.onTheLeft(t2.get(target).pos)){
            pos.x--;
            return;
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC82" +
                " H:" + Math.round(hp) +
                " D:" + def +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state;
    }
}