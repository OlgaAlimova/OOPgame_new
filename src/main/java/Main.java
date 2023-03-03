import Units.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int UNITS = 10;

    public static void main(String[] args) {


        ArrayList<Unit> holyTeam = new ArrayList<>();
        ArrayList<Unit> darkTeam = new ArrayList<>();
        ArrayList<Unit> allTeam = new ArrayList<>();
        Scanner user_input = new Scanner(System.in);
        createTeam(holyTeam, 0, 1);
        createTeam(darkTeam, 3, 10);
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        sortedTeam(allTeam);


        System.out.println(allTeam);

        while (true){
            for (Unit human: allTeam) {
                if ( holyTeam.contains(human)) human.step(holyTeam, darkTeam);
                else human.step(darkTeam, holyTeam);
            }
            user_input.nextLine();
            System.out.println(allTeam);
        }


    }

    static void sortedTeam(ArrayList<Unit> team){
        team.sort(new Comparator<Unit>() { // Сортируем весь список
            @Override
            public int compare(Unit o1, Unit o2) {
                if (o2.getSpeed() == o1.getSpeed()) {
                    return o1.getHp() - o2.getHp();
                }
                return o2.getSpeed() - o1.getSpeed();
            }
        });
    }

    static void createTeam(ArrayList team, int offset, int posY){
        for (int i = 1; i <= UNITS; i++) {
            int rnd = new Random().nextInt(4) + offset;
            switch (rnd){
                case (0):
                    team.add(new Sniper(Unit.getName(),i, posY));
                    break;
                case (1):
                    team.add(new Outlaw(Unit.getName(),i, posY));
                    break;
                case (2):
                    team.add(new Mag(Unit.getName(),i, posY));
                    break;
                case (3):
                    team.add(new Fermer(Unit.getName(),i, posY));
                    break;
                case (4):
                    team.add(new Crossbowman(Unit.getName(),i, posY));
                    break;
                case (5):
                    team.add(new Monk(Unit.getName(),i, posY));
                    break;
                case (6):
                    team.add(new Spearman(Unit.getName(),i, posY));
                    break;
            }
        }
    }


}