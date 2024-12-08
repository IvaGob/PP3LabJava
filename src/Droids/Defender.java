package Droids;

import Game.FileIO;

public class Defender extends Droid{
    private String droidType = "Defender";
    private float Maxhealth;
    private float damage;
    private float defence;
    private int critChance;
    private int attackChance;

    public Defender(String iname) {
        super(iname);
        this.Maxhealth = 140;
        this.damage = 20;
        this.defence = 30;
        this.critChance = 13;
        this.attackChance = 50;
    }
    @Override
    public String toString(){
        return this.GetName()+"(Захисник):\n"+
                "Здоров'я: "+this.Maxhealth+"\n"+
                "Урон: "+this.damage+"\n"+
                "Захист: "+this.defence+"\n"+
                "Крит. Шанс"+this.critChance+"%\n"+
                "Атак. Шанс"+this.attackChance+"%";
    }
}
