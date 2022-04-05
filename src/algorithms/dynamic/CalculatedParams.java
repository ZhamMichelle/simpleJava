package algorithms.dynamic;

import java.util.List;

public class CalculatedParams {
    private Integer id;
    private Integer column;
    private List<Integer> weights;
    private List<String> names;
    private Integer sumCost;

    public CalculatedParams(
    Integer id,
    Integer column,
    List<Integer> weights,
    List<String> names,
    Integer sumCost    ) {
        this.id = id;
        this.column = column;
        this.weights = weights;
        this.names = names;
        this.sumCost = sumCost;
    }


    public Integer getId() {
        return id;
    }

    public Integer getColumn() {
        return column;
    }

    public List<Integer> getWeights() {
        return weights;
    }

    public List<String> getNames() {
        return names;
    }

    public Integer getSumCost() {
        return sumCost;
    }

    @Override
    public String toString() {
        return "CalculatedParams{" +
                "id=" + id +
                ", column=" + column +
                ", weights=" + weights +
                ", names=" + names +
                ", sumCost=" + sumCost +
                '}';
    }
}
