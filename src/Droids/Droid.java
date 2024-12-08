package Droids;
import Game.FileIO;

public class Droid {
    private String droidType = "Default";
    private String name = "Basotron";
    private float Maxhealth;
    private float health;
    private float damage;
    private float defence;
    private int critChance;
    private int attackChance;

    public Droid(String iname) {
        this.name = iname;
        this.Maxhealth = 100;
        this.health = this.Maxhealth;
        this.damage = 20;
        this.defence = 10;
        this.critChance = 13;
        this.attackChance = 50;
    }
    public String GetType(){
        return this.droidType;
    }
    //Set
    public void setMaxhealth(float ihealth){
        this.Maxhealth = ihealth;
    }
    public void setHealth(float ihealth){
        this.health = ihealth;
    }
    public void setDamage(float idamage){
        this.damage = idamage;
    }
    public void setDefence(float idefence){
        this.defence = idefence;
    }
    public void setCritChance(int iCritChance){
        this.critChance = iCritChance;
    }
    public void setAttackChance(int iAttackChance){
        this.attackChance = iAttackChance;
    }
    //Get
    public String GetName(){
        return this.name;
    }
    public float GetMaxHealth(){
        return this.Maxhealth;
    }
    public float GetHealth(){
        return this.health;
    }
    public float GetDefence(){
        return this.defence;
    }
    public float GetDamage(){
        return this.damage;
    }
    public float GetCritChance(){
        return this.critChance;
    }
    public float GetAttackChance(){
        return this.attackChance;
    }
    public Boolean isHealer() {
        return false;
    }
    @Override
    public String toString(){
        return this.GetName()+"(Стандартотрон):\n"+
                "Здоров'я: "+this.GetMaxHealth()+"\n"+
                "Урон: "+this.GetDamage()+"\n"+
                "Захист: "+this.GetDefence()+"\n"+
                "Крит. Шанс"+this.GetCritChance()+"%\n"+
                "Атак. Шанс"+this.GetAttackChance()+"%";
    }

}
