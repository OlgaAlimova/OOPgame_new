package Units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Основная боевая еденица
 */
public abstract class Unit implements GameInterface {
    protected String name;
    protected int hp;
    protected int speed, attack;
    protected int maxHp, def, damageMin, damageMax;

    protected String state;


    protected Vector2D pos;

    public Unit(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack) {
        this.name = name;
        this.speed = speed;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.def = def;
        this.damageMin = damegeMin;
        this.damageMax = damegeMax;
        pos = new Vector2D(x, y);
        this.attack = attack;
        state = "Stand";
    }

    public static String getName() { // Дать случайное имя
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    @Override
    public String toString() {
        return "👷" +
                " H:" + Math.round(hp) +
                " D:" + def +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state;
    }


    @Override
    public String getInfo() {
        return "Я человек!" + "HP: " + this.hp;
    }


    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) { }

    public int findNearest(ArrayList<Unit> team) {
        double min = 100;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if (min > pos.distance(team.get(i).pos) & !team.get(i).state.equals("Die")) {
                index = i;
                min = pos.distance(team.get(i).pos);
            }
        }
        return index;
    }

    protected void getDamage(float damage){
        hp -= damage;
        if (hp > maxHp) hp = maxHp;
        if (hp < 0){
            System.out.println(getInfo() + " " + name + " умер");
            state = "Die";
            hp = 0;
        }
    }

    public int[] getPos() {
        return new int[]{pos.x, pos.y};
    }

    public String getState() {
        return state;
    }
}
