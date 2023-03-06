package Units;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Arreys extends Unit{



    int shoot; // выстрелы

    public Arreys(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack, int shoot) {
        super(name, speed, maxHp, def, damegeMin, damegeMax, x, y, attack);
        this.shoot = shoot;
    }


    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        if (state.equals("Die")) {hp = 0; return;}
        if (state.equals("DIe") || shoot == 0) return;
        int target = findNearest(t2);
        System.out.println(name + " " + getInfo() + "  ->  " + t2.get(target).name +" "+ t2.get(target).getInfo());
        float damdge = (t2.get(target).def - attack > 0) ?
                damageMin : (t2.get(target).def - attack < 0) ?
                damageMax : ( (damageMax+damageMin) / 2);
        t2.get(target).getDamage(damdge);

        for (int i = 0; i < t1.size(); i++) {
            if (( t1.get(i).getInfo().equals("Фермер")) && t1.get(i).state.equals("Stand")){
                System.out.println("Фермер " + t1.get(i).name + " занят");
                t1.get(i).state = "Busy";
                return;
            }
        }
        shoot --;
    }

    @Override
    public String toString() {
        return "🏹" +
                " H:" + Math.round(hp) +
                " D:" + def +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state;
    }
}