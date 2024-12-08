package Droids;

import Game.FileIO;

public class Attacker extends Droid {
    private String droidType = "Attacker";
    private float Maxhealth;
    private float damage;
    private float defence;
    private int critChance;
    private int attackChance;

    public Attacker(String iname) {
        super(iname);
        this.Maxhealth = 75;
        this.damage = 40;
        this.defence = 10;
        this.critChance = 31;
        this.attackChance = 60;
    }
    @Override
    public String toString(){
        return this.GetName()+"(Атакотрон):\n"+
                "Здоров'я: "+this.Maxhealth+"\n"+
                "Урон: "+this.damage+"\n"+
                "Захист: "+this.defence+"\n"+
                "Крит. Шанс"+this.critChance+"%\n"+
                "Атак. Шанс"+this.attackChance+"%";
    }
}
