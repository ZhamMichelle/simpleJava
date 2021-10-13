package algorithms.dynamic;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TheMain {
    private static Map<Integer, Sub> subs = new HashMap<>();
    private final static int constanta = 6;
    private static int[][] result;
    private static Map<Integer, SubResult> subRes = new LinkedHashMap<>();

    public static void main(String[] args) {
        loadSubs();
        result = new int[subs.size()][constanta];
        for (int i = 0; i < subs.size(); i++) {
            for (int j = 0; j < constanta; j++) {
                int weight = j + 1;
                result[i][j] = getMaxCost(i, j, weight);
            }
        }

        for (int i = 0; i < subs.size(); i++) {
            System.out.println();
            for (int j = 0; j < constanta; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < subRes.size(); i++) {
            System.out.println(subRes.get(i).toString() + " ");
        }
    }

    public static Integer getMaxCost(int subId, int col, int weight) {
        Sub sub = subs.get(subId);
        SubResult subResult;
        subResult = new SubResult(weight, List.of(sub.getName()));
        subRes.put(subId, subResult);
        if (subId != 0) {
            int previousWeight=0;
            try{
                previousWeight = subRes.get(subId - 1).getWeight();
            }catch (NullPointerException e){
                for (int i = 0; i < subRes.size(); i++) {
                    System.out.println(subRes.get(i).toString() + " ");
                }
                System.out.println("row: "+subId);
                System.out.println("col: "+col);
                System.out.println("prev: "+previousWeight);
                System.out.println(e.getMessage());
            }
            var sumWeight = previousWeight + sub.getWeight();

            var names = subRes.get(subId - 1).getName();
            if (previousWeight > weight && result[subId - 1][col]>sub.getCost()) {
                    return result[subId - 1][col];
            }
            else if(result[subId - 1][col]>sub.getCost()){
                System.out.println("row: "+subId);
                System.out.println("col: "+col);
                System.out.println("weight: "+weight);
                System.out.println("sumWeight: "+sumWeight);
                System.out.println("previousWeight: "+previousWeight);
                return result[subId - 1][col];
            }
            else if (sumWeight <= weight) {

                subResult = new SubResult(sumWeight, names);
                subRes.put(subId, subResult);
                return result[subId - 1][col] + sub.getCost();
            } else if (sub.getWeight() <= weight) {
                subResult = new SubResult(sub.getWeight(), List.of(sub.getName()));
                subRes.put(subId, subResult);
                return sub.getCost();
            } else {
                subResult = new SubResult(subRes.get(subId - 1).getWeight(), subRes.get(subId - 1).getName());
                subRes.put(subId, subResult);
                return result[subId - 1][col];
            }
        } else {
            if (sub.getWeight() <= weight) {
                subResult = new SubResult(sub.getWeight(), List.of(sub.getName()));
                subRes.put(subId, subResult);
                return sub.getCost();
            } else {
                return 0;
            }
        }
    }


    public static void loadSubs() {
        subs.put(0, new Sub("first", 2, 6));
        subs.put(1, new Sub("second", 1, 8));
        subs.put(2, new Sub("third", 3, 4));
        subs.put(3, new Sub("forth", 6, 7));
        subs.put(4, new Sub("fifth", 2, 1));
        subs.put(5, new Sub("sixth", 4, 9));
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


    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

class SubResult {
    private int weight;
    private List<String> name;

    public SubResult(int weight, List<String> name) {
        this.weight = weight;
        this.name = name;
    }

    public SubResult() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubResult{" +
                "weight=" + weight +
                ", name=" + name +
                '}';
    }
}
