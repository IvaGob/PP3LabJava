package Droids;

import Game.FileIO;

public class Boss extends Droid{
    private String droidType = "Boss";
    private float Maxhealth;
    private float damage;
    private float defence;
    private int critChance;
    private int attackChance;

    public Boss(String iname) {
        super(iname);
        this.Maxhealth = 300;
        this.damage = 40;
        this.defence = 20;
        this.critChance = 5;
        this.attackChance = 35;
    }
    @Override
    public String toString(){
        return this.GetName()+"(Босотрон):\n"+
                "Здоров'я: "+this.Maxhealth+"\n"+
                "Урон: "+this.damage+"\n"+
                "Захист: "+this.defence+"\n"+
                "Крит. Шанс"+this.critChance+"%\n"+
                "Атак. Шанс"+this.attackChance+"%";
    }
}
