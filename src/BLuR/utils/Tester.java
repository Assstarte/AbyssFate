package BLuR.utils;

import BLuR.model.entities.Hero;
import BLuR.model.enums.$CLASS;
import BLuR.model.enums.$GENDER;
import BLuR.model.enums.$RACE;

public class Tester {
    public static void main(String [] args){
        Hero testHero = new Hero("Max", $RACE.ELF, $CLASS.WARRIOR, $GENDER.MALE);
        System.out.println(testHero.getDefence());
    }
}
