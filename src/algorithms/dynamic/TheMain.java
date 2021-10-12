package algorithms.dynamic;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TheMain {
    private static Map<Integer, Sub> subs=new HashMap<>();
    private final static int constanta = 6;
    private static int[][] result;

    public static void main(String[] args) {
        loadSubs();
        result = new int[subs.size()][constanta];
        for(int i=0;i<subs.size();i++){
            for(int j=0;j<constanta;j++){
                result[i][j]=getMaxCost(subs,j,i);
            }
        }

        for(int i=0;i<subs.size();i++){
            System.out.println();
            for(int j=0;j<constanta;j++){
                System.out.print(result[i][j] + " ");
            }
        }
    }
    public static Integer getMaxCost(@NotNull Map<Integer,Sub> subs, int weight, int row){
        for(Map.Entry<Integer,Sub> item : subs.entrySet()){
//            System.out.println("item: " + item.getValue().getWeight());
            if(item.getValue().getWeight()>weight){
                if(row==0){
                    return 0;
                }else{
                    return result[row-1][weight];
                }
            }else{
                return item.getValue().getCost();
            }
        }
        return 1000;
    }

    public static void loadSubs(){
        subs.put(1,new Sub("first",2,6));
        subs.put(2,new Sub("second",1,8));
        subs.put(3,new Sub("third",3,4));
        subs.put(4,new Sub("forth",6,7));
        subs.put(5,new Sub("fifth",2,1));
        subs.put(6,new Sub("sixth",4,9));
    }

}

class Sub {
    private String name;
    private int weight;
    private int cost;

    public Sub(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
