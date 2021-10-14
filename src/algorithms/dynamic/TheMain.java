package algorithms.dynamic;

import java.util.*;

public class TheMain {
    private static Map<Integer, Subject> subjects = new HashMap<>();
    private final static int constanta = 6;
    private static int[][] result;
    private static Map<Integer, CalculatedWeight> weightArray = new LinkedHashMap<>();

    public static void main(String[] args) {
        loadSubs();
        result = new int[subjects.size()][constanta];
        for (int i = 0; i < subjects.size(); i++) {

            for (int j = 0; j < constanta; j++) {
                int weight = j + 1;
                result[i][j] = getMaxCost(i, j, weight);
            }
        }

        for (int i = 0; i < subjects.size(); i++) {
            System.out.println();
            for (int j = 0; j < constanta; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < weightArray.size(); i++) {
            System.out.println(weightArray.get(i).toString() + " ");
        }
    }

    public static Integer getMaxCost(int id, int col, int weight) {
        Subject sub = subjects.get(id);
        int currentCost = sub.getCost();
        int currentWeight = sub.getWeight();

        if (id != 0) {
            int previousCost = result[id - 1][col];
            int previousWeight = weightArray.get(id - 1).getWeight().get(col);


            var sumWeight = previousWeight + currentWeight;
            var sumCost = previousCost + currentCost;

            if (sumWeight <= weight) {
                var names = new ArrayList<>(weightArray.get(id - 1).getName());
                names.add(sub.getName());
                addToArray(id, col, sub, sumWeight, names);
                return sumCost;
            } else if (previousCost > currentCost && currentWeight <= weight) {
                addToArray(id, col, sub, previousWeight, weightArray.get(id - 1).getName());
                return previousCost;
            } else if (currentWeight <= weight) {
                addToArray(id, col, sub, currentWeight, List.of(sub.getName()));
                return sub.getCost();
            } else {
                return -1;
            }

        } else {
            if (currentWeight <= weight) {
                addToArray(id, col, sub, currentWeight, List.of());
                return sub.getCost();
            } else {
                addToArray(id, col, sub, 0, List.of());
                return 0;
            }
        }
    }

    public static void addToArray(int id, int col, Subject sub, Integer calculatedWeight, List<String> names) {
        CalculatedWeight weights;
        if (id == 0) {
            weights = new CalculatedWeight(List.of(calculatedWeight), List.of(sub.getName()));
            if (col == 0) {
                weightArray.put(id, weights);
            } else {
                var sumWeights = new ArrayList<>(weightArray.get(id).getWeight());
                sumWeights.add(calculatedWeight);
                weights = new CalculatedWeight(sumWeights, List.of(sub.getName()));
                weightArray.replace(id, weights);
            }
        } else {
//            var names = new ArrayList<>(weightArray.get(id).getName());
//            names.add(sub.getName());
            if (col == 0) {
                System.out.println("0:"+weightArray);
                System.out.println("0:"+id);
                weightArray.put(id, new CalculatedWeight(List.of(calculatedWeight), List.of(sub.getName())));
            }else{
                System.out.println(weightArray.get(1).getWeight());
                ArrayList<Integer> sumWeights = new ArrayList<>(weightArray.get(id).getWeight());
                sumWeights.add(calculatedWeight);
                weights = new CalculatedWeight(sumWeights, names);
                weightArray.replace(id, weights);
            }

        }
    }

    public static void loadSubs() {
        subjects.put(0, new Subject("first", 2, 6));
        subjects.put(1, new Subject("second", 1, 8));
        subjects.put(2, new Subject("third", 3, 4));
        subjects.put(3, new Subject("forth", 1, 7));
        subjects.put(4, new Subject("fifth", 2, 1));
        subjects.put(5, new Subject("sixth", 6, 9));
    }

}

class Subject {
    private String name;
    private int weight;
    private int cost;

    public Subject(String name, int weight, int cost) {
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

class CalculatedWeight {
    private List<Integer> weight;
    private List<String> name;

    public CalculatedWeight(List<Integer> weight, List<String> name) {
        this.weight = weight;
        this.name = name;
    }

    public CalculatedWeight() {
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public void setWeight(List<Integer> weight) {
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
