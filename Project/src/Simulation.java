import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Item> itemList = new ArrayList<Item>();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split("=");
            Item item = new Item(data[0], Integer.parseInt(data[1]));
            itemList.add(item);
        }
        return itemList;
    }
    public ArrayList<Rocket> loadU1(ArrayList<Item> items){
        U1 u1 = new U1();
        ArrayList<Rocket> u1List = new ArrayList<Rocket>();
        u1List.add(u1);
        for(int i=0; i<items.size(); i ++){
            if(u1.canCarry(items.get(i))){
                u1.carry(items.get(i));
            }
            else{
                u1 = new U1();
                u1List.add(u1);
                if(u1.canCarry(items.get(i))){
                    u1.carry(items.get(i));
                }
            }
        }
        return u1List;
    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        U2 u2 = new U2();
        ArrayList<Rocket> u2List = new ArrayList<Rocket>();
        u2List.add(u2);
        for(int i=0; i<items.size(); i ++){
            if(u2.canCarry(items.get(i))){
                u2.carry(items.get(i));
            }
            else{
                u2 = new U2();
                u2List.add(u2);
                if(u2.canCarry(items.get(i))){
                    u2.carry(items.get(i));
                }
            }
        }
        return u2List;
    }
    public int runSimulation(ArrayList<Rocket> rockets){
        int totCost = 0;
        for(int i=0; i<rockets.size(); i++){
            if(!rockets.get(i).launch() || !rockets.get(i).land()){
                totCost += rockets.get(i).cost;
            }
        }
        return totCost;
    }

    public static void main(String[] args){
        File itemFile = new File("phase-1.txt");
        File colonyFile = new File("phase-2.txt");
        Simulation simulation = new Simulation();
        ArrayList<Rocket> u1List;
        ArrayList<Rocket> u2List;
        ArrayList<Rocket> rockets = new ArrayList<Rocket>();
        try{
            ArrayList<Item> itemList = simulation.loadItems(itemFile);
            ArrayList<Item> colonyList = simulation.loadItems(colonyFile);
            itemList.addAll(itemList.size(), colonyList);
            //for(int i=0; i<itemList.size(); i ++){
            //    System.out.println(itemList.get(i).getName());
            //}
            u1List = simulation.loadU1(itemList);
            u2List = simulation.loadU2(itemList);
            //rockets.addAll(0,u1List);
            //rockets.addAll(u1List.size(),u2List);
            System.out.println("For U1, total budget is " + simulation.runSimulation(u1List));
            System.out.println("For U2, total budget is " + simulation.runSimulation(u2List));

        } catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

    }
}
