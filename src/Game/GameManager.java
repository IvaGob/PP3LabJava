package Game;

import Droids.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    Color color = new Color();
    private List<Droid> droids;
    private String filename = "C:\\Laba\\test.txt";
    private FileIO fileIO;
    public GameManager(){
        fileIO = new FileIO(filename);
        this.droids = new ArrayList<Droid>();
    }
    public void Start() throws IOException {
        System.out.println(color.RED+"░▒▓███████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░▒▓███████▓▒░       ░▒▓███████▓▒░ ░▒▓██████▓▒░▒▓████████▓▒░▒▓████████▓▒░▒▓█▓▒░      ░▒▓████████▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                "░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓███████▓▒░░▒▓████████▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓██████▓▒░   \n" +
                "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                "░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░▒▓███████▓▒░       ░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓████████▓▒░▒▓████████▓▒░ "+color.RESET);
        System.out.println("Вітаємо в Droid Battle!\n");
        Controls();
    }
    public void CreateDroid(){

        System.out.println(color.YELLOW+"Якого типу робота ви хочете створити?\n"+ color.GREEN+
                "1.Стандартотрон\n" +
                "2.Атакотрон\n" +
                "3.Захисник\n" +
                "4.Лікувач\n" +
                "5.Босотрон\n"+color.RESET);
        int choice = 0;
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        //
        System.out.println("Введіть ім'я робота:");
        String droidName = in.next();
        Droid newDroid;
        switch(choice){
            case 1:
            newDroid = new Droid(droidName);
            droids.add(newDroid);
            break;
            case 2:
                newDroid = new Attacker(droidName);
                droids.add(newDroid);
                break;
            case 3:
                newDroid = new Defender(droidName);
                droids.add(newDroid);
                break;
            case 4:
                newDroid = new Healer(droidName);
                droids.add(newDroid);
                break;
            case 5:
                newDroid = new Boss(droidName);
                droids.add(newDroid);
                break;
            default:
                System.out.println("Не вдалося створити робота!");
                break;
        }
    }
    public void StartBattle() throws IOException {
        int countA = 0;
        System.out.println("Введіть кількість роботів в синій команді:");
        Scanner in = new Scanner(System.in);
        countA = in.nextInt();
        System.out.println("Введіть кількість роботів в червоній команді:");
        int countB = in.nextInt();

        if(countA>droids.size()||countA<=0||countB>droids.size()||countB<=0){
            System.out.println("Помилка кількості!");
        }
        System.out.println("Оберіть роботів для синьої команди:");
        List<Droid> blueTeam = new ArrayList<Droid>();
        for(int i = 0;i<countA;i++){
            System.out.println("Введіть індекс робота:");
            int index = in.nextInt();
            blueTeam.add(droids.get(index));
        }
        System.out.println("Оберіть роботів для червоної команди:");
        List<Droid> redTeam = new ArrayList<Droid>();
        for(int i = 0;i<countB;i++){
            System.out.println("Введіть індекс робота:");
            int index = in.nextInt();
            redTeam.add(droids.get(index));
        }
        BattleMaster battleMaster = new BattleMaster(blueTeam,redTeam,fileIO);
    }
    public void DisplayBots(){
        int i = 0;
        for(Droid droid : droids){
            System.out.println(color.YELLOW+i+". "+color.RED+droid+color.RESET);
            i++;
        }
    }
    public void Controls() throws IOException {
        int choice = 0;
        while(choice!=7){
            System.out.println(color.YELLOW+"Що ви хочете зробити?\n"+color.GREEN+
                    "1.Створити нового дроїда\n" +
                    "2.Продивитись всіх дроїдів\n" +
                    "3.Почати новий бій\n" +
                    "4.Записувати бій в файл\n" +
                    "5.Продивитись записаний бій з файлу\n" +
                    "6. Змінити файл з якого читати/в який записувати бої\n" +
                    "7.Закінчити програму"+color.RESET);
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice){
                case 1:
                    CreateDroid();
                    break;
                case 2:
                    DisplayBots();
                    break;
                case 3:
                    StartBattle();
                    break;
                case 4:
                    if(fileIO.GetIsRecording()){
                        fileIO.StopRecording();
                        System.out.println("Тепер бій не буде записуватись.");
                    } else {
                        fileIO.StartRecording();
                        System.out.println("Тепер бій буде записуватись.");
                    }
                    break;
                case 5:
                    fileIO.LoadFromFile();
                    break;
                case 6:
                    System.out.println("Введіть шлях до файлу:");
                    String filename = in.next();
                    fileIO.setFileName(filename);
                    break;
                case 7:
                    break;
                default:
                    System.out.println(color.RED+"Неправильна команда!"+color.RESET);
                    break;
            }
        }
    }
}
