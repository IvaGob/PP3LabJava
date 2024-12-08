package Droids;

import Game.Color;
import Game.FileIO;

public class Healer extends Droid{
    private String droidType = "Healer";
    private float Maxhealth;
    private float damage;
    private float defence;
    public Healer(String iname) {
        super(iname);
        this.Maxhealth = 75;
        this.damage = 10;
        this.defence = 10;
    }
    public Boolean isHealer() {
        return true;
    }
    @Override
    public String toString(){
        return this.GetName()+"(Лікувач):\n"+
                "Здоров'я: "+this.Maxhealth+"\n"+
                "Урон: "+this.damage+"\n"+
                "Захист: "+this.defence+"\n";
    }
}
