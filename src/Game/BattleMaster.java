package Game;

import Droids.Droid;
//import Droids.Healer;
import Game.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BattleMaster {
    private List<String> battleLog;
    Color color = new Color();
    List<Droid> blueTeam;
    List<Droid> redTeam;
    private int turn = 1;
    private FileIO fileIO;

    public BattleMaster(List<Droid> iblueTeam,List<Droid> iredTeam,FileIO ifileIO) throws IOException {
        battleLog = new ArrayList<String>();
        this.blueTeam = iblueTeam;
        this.redTeam = iredTeam;
        this.fileIO = ifileIO;
        Turn();
    }
    //
    void Turn() throws IOException {
        fileIO.Print(color.BLACK+"Хід: "+turn+color.RESET);
        if(turn%2==0){
            //Спочатку атакують сині
            fileIO.Print(color.BLUE+"Черга синьої команди:"+color.RESET);
            TeamAttack(blueTeam,redTeam);
            if(AnySurvivor(redTeam)){
                fileIO.Print(color.RED+"Черга червоної команди:"+color.RESET);
                TeamAttack(redTeam,blueTeam);
                //Якщо у синіх всі мертві то червоні перемагають
                if(AnySurvivor(blueTeam)){
                    fileIO.Print(color.BLACK+"Хід закінчився"+color.RESET);
                    PrintHealth();
                    turn++;
                    Turn();
                }
                else{
                    fileIO.Print(color.RED+"Червона команда перемогла!");
                    FightEnd();
                }

            } else{
                fileIO.Print(color.BLUE+"Блакитна команда перемогла!");
                FightEnd();
            }
        }
        else{
            //Спочатку атакують червоні
            fileIO.Print(color.RED+"Черга червоної команди:"+color.RESET);
            TeamAttack(redTeam,blueTeam);
            if(AnySurvivor(blueTeam)){
                fileIO.Print(color.BLUE+"Черга синьої команди:"+color.RESET);
                TeamAttack(blueTeam,redTeam);
                //Якщо у червоних всі мертві то сині перемагають
                if(AnySurvivor(redTeam)){
                    fileIO.Print(color.BLACK+"Хід закінчився"+color.RESET);
                    PrintHealth();
                    turn++;
                    Turn();
                }
                else{
                    fileIO.Print(color.BLUE+"Блакитна команда перемогла!");
                    FightEnd();
                }
            }
            else{
                fileIO.Print(color.RED+"Червона команда перемогла!");
                FightEnd();
            }
        }
    }
    //
    void TeamAttack(List<Droid> AttackTeam, List<Droid> DefendTeam){
        Random rand = new Random();
        for(Droid droid : AttackTeam){
                if(droid.isHealer()){
                        int target;
                        while(true){
                            target = rand.nextInt(AttackTeam.size());
                            if(AttackTeam.get(target).GetHealth()>0) break;
                        }
                        heal(droid, AttackTeam.get(target));
                } else{
                        int target;
                        while(true){
                            target = rand.nextInt(DefendTeam.size());
                            if(DefendTeam.get(target).GetHealth()>0) break;
                        }
                        Attack(droid,DefendTeam.get(target));
                }
//                try{
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e){
//                    fileIO.Print("got interrupted!");
//                }

        }
    }
    //
    Boolean AnySurvivor(List<Droid>team){
        for(Droid droid : team){
            if(droid.GetHealth()>0)return true;
        }
        return false;
    }
    //
    void PrintHealth(){
        fileIO.Print(color.BLUE+"Синя команда:"+color.RESET);
        for(Droid droid : blueTeam){
            fileIO.Print(color.YELLOW+droid.GetName()+" "+color.RESET+droid.GetHealth()+"/"+color.BLACK+droid.GetMaxHealth()+color.RESET);
        }
        fileIO.Print(color.RED+"Червона команда"+color.RESET);
        for(Droid droid : redTeam){
            fileIO.Print(color.YELLOW+droid.GetName()+" "+color.RESET+droid.GetHealth()+"/"+color.BLACK+droid.GetMaxHealth()+color.RESET);
        }
    }
    //
    void FightEnd() throws IOException {
        for(Droid droid : blueTeam){
            droid.setHealth(droid.GetMaxHealth());
        }
        for(Droid droid : redTeam){
            droid.setHealth(droid.GetMaxHealth());
        }
        if(fileIO.GetIsRecording()){
            fileIO.SaveToFile();
        }

    }

    public void Attack(Droid Attacker, Droid enemy){
        if(Attacker.GetMaxHealth() >0){
            //Шанс на атаку
            Random rand = new Random();
            int randomInt = rand.nextInt(100);
            if(randomInt < Attacker.GetAttackChance()){
                //Вираховуємо атаку
                float attack = Attacker.GetDamage() - enemy.GetDefence();
                if(attack < 0) attack = 1;
                //Перевіряєм чи буде критична шкода
                randomInt = rand.nextInt(100);
                if(randomInt < Attacker.GetAttackChance()){
                    this.fileIO.Print(Attacker.GetName() + " задав критичної шкоди!");
                    attack *=2;
                }
                //Наносим урон
                this.fileIO.Print(Attacker.GetName()+" наніс "+attack+" урона "+enemy.GetName()+"!");
                enemy.setHealth(enemy.GetHealth()-attack);
                if(enemy.GetHealth()<0){
                    enemy.setHealth(0);
                }
            } else{
                this.fileIO.Print(Attacker.GetName()+" не попав!");
            }
        } else{
            this.fileIO.Print("\u001B[30m"+Attacker.GetName()+" зламаний, тому пропускає свій хід..."+"\u001B[0m");
        }

    }
    void heal(Droid healer, Droid target){
        target.setHealth(target.GetHealth()+healer.GetDamage());
        if(target.GetHealth()>target.GetMaxHealth()){
            target.setHealth(target.GetMaxHealth());
        }
        fileIO.Print(healer.GetName()+" вилікував "+ healer.GetDamage()+" здоров'я "+target.GetName()+"!");
    }

}
