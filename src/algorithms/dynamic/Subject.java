package algorithms.dynamic;

public class Subject {
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
