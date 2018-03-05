package BLuR.model.entities;

import BLuR.model.enums.$CLASS;
import BLuR.model.enums.$GENDER;
import BLuR.model.enums.$RACE;

public class Hero {
    //-------------------------------------MAIN ENTITY----------------------------------------
    private String Name;
    private $RACE Race;
    private $CLASS Class;
    private $GENDER Gender;
    //private $APPEARANCE Appearance; - Внешность (картинкой из пресетов)
    //----------------------------------------------------------------------------------------

    //----------------------------------MAIN ATTRIBUTES---------------------------------------
    private int Level;
    private int Exp;
    private int Exp_Need;

    private int HP;
    private int Attack;
    private int Defence;
    private int Fame; //Fame level
    private int FameQ; //Fame Quanlity
    private int Fame_Need;
    //----------------------------------------------------------------------------------------

    //------------------------------------AMPS------------------------------------------------
    private double Crit_Chance;
    private double Crit_Amp;
    private double Fire_Amp;
    private double Shock_Amp;
    private double Darkness_Amp;
    private double Light_Amp;
    private double Elemental_Amp;
    //----------------------------------------------------------------------------------------

    //-------------------------------------------DEFENCE AMPS---------------------------------
    private double Fire_Def;
    private double Shock_Def;
    private double Darkness_Def;
    private double Light_Def;
    private double Elemental_Def;
    //----------------------------------------------------------------------------------------

    //---------------------------------------------LEVELS-------------------------------------
    private int Luck;
    private int Lockpicking;
    private int Wisdom;
    // Rest in development
    //----------------------------------------------------------------------------------------

    //--------------------------------------RESOURCES-----------------------------------------
    private int Gold;
    private int Red_Crystals;
    private int Blue_Crystals;
    //Rest in development
    //----------------------------------------------------------------------------------------






    //------------CONSTRUCTORS----------
    public Hero(String _name, $RACE _race, $CLASS _class, $GENDER _gender){
        Name=_name;
        Race=_race;
        Class=_class;
        Gender=_gender;

        //Rest are test values (for test)
        executeTestValues();





    }

    private void executeTestValues(){
        Level=1;
        Exp=0;
        Exp_Need=100;
        HP=100;
        Attack=10;
        Defence=10;
        Fame=1;
        FameQ=0;
        Fame_Need=100;
        Crit_Chance=0;
        Crit_Amp=2;
        Fire_Amp=0;
        Shock_Amp=0;
        Darkness_Amp=0;
        Light_Amp=0;
        Elemental_Amp=0;
        Fire_Def=0;
        Shock_Def=0;
        Darkness_Def=0;
        Light_Def=0;
        Elemental_Def=0;
        Luck=1;
        Lockpicking=1;
        Wisdom=1;
        Gold=100;
        Red_Crystals=0;
        Blue_Crystals=0;
    }

















    //---------------GETTERS AND SETTERS-------------

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public $RACE getRace() {
        return Race;
    }

    public void setRace($RACE race) {
        Race = race;
    }


    public $CLASS getHeroClass() {
        return Class;
    }

    public void setHeroClass($CLASS aClass) {
        Class = aClass;
    }

    public $GENDER getGender() {
        return Gender;
    }

    public void setGender($GENDER gender) {
        Gender = gender;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public int getExp_Need() {
        return Exp_Need;
    }

    public void setExp_Need(int exp_Need) {
        Exp_Need = exp_Need;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getFame() {
        return Fame;
    }

    public void setFame(int fame) {
        Fame = fame;
    }

    public int getFameQ() {
        return FameQ;
    }

    public void setFameQ(int fameQ) {
        FameQ = fameQ;
    }

    public int getFame_Need() {
        return Fame_Need;
    }

    public void setFame_Need(int fame_Need) {
        Fame_Need = fame_Need;
    }

    public double getCrit_Chance() {
        return Crit_Chance;
    }

    public void setCrit_Chance(double crit_Chance) {
        Crit_Chance = crit_Chance;
    }

    public double getCrit_Amp() {
        return Crit_Amp;
    }

    public void setCrit_Amp(double crit_Amp) {
        Crit_Amp = crit_Amp;
    }

    public double getFire_Amp() {
        return Fire_Amp;
    }

    public void setFire_Amp(double fire_Amp) {
        Fire_Amp = fire_Amp;
    }

    public double getShock_Amp() {
        return Shock_Amp;
    }

    public void setShock_Amp(double shock_Amp) {
        Shock_Amp = shock_Amp;
    }

    public double getDarkness_Amp() {
        return Darkness_Amp;
    }

    public void setDarkness_Amp(double darkness_Amp) {
        Darkness_Amp = darkness_Amp;
    }

    public double getLight_Amp() {
        return Light_Amp;
    }

    public void setLight_Amp(double light_Amp) {
        Light_Amp = light_Amp;
    }

    public double getElemental_Amp() {
        return Elemental_Amp;
    }

    public void setElemental_Amp(double elemental_Amp) {
        Elemental_Amp = elemental_Amp;
    }

    public double getFire_Def() {
        return Fire_Def;
    }

    public void setFire_Def(double fire_Def) {
        Fire_Def = fire_Def;
    }

    public double getShock_Def() {
        return Shock_Def;
    }

    public void setShock_Def(double shock_Def) {
        Shock_Def = shock_Def;
    }

    public double getDarkness_Def() {
        return Darkness_Def;
    }

    public void setDarkness_Def(double darkness_Def) {
        Darkness_Def = darkness_Def;
    }

    public double getLight_Def() {
        return Light_Def;
    }

    public void setLight_Def(double light_Def) {
        Light_Def = light_Def;
    }

    public double getElemental_Def() {
        return Elemental_Def;
    }

    public void setElemental_Def(double elemental_Def) {
        Elemental_Def = elemental_Def;
    }

    public int getLuck() {
        return Luck;
    }

    public void setLuck(int luck) {
        Luck = luck;
    }

    public int getLockpicking() {
        return Lockpicking;
    }

    public void setLockpicking(int lockpicking) {
        Lockpicking = lockpicking;
    }

    public int getWisdom() {
        return Wisdom;
    }

    public void setWisdom(int wisdom) {
        Wisdom = wisdom;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getRed_Crystals() {
        return Red_Crystals;
    }

    public void setRed_Crystals(int red_Crystals) {
        Red_Crystals = red_Crystals;
    }

    public int getBlue_Crystals() {
        return Blue_Crystals;
    }

    public void setBlue_Crystals(int blue_Crystals) {
        Blue_Crystals = blue_Crystals;
    }
}
