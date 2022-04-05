package algorithms.dynamic;

import java.util.*;

public class ExersizeA {
    private static final Map<Integer, Subject> subjects = new HashMap<>();
    private final static int constanta = 6;
    private static final Set<Integer> cellsWeight = Set.of(1, 2, 3, 4, 5, 6);
    private static final List<CalculatedParams> calculatedParams = new ArrayList<>();

    public static void main(String[] args) {
        loadSubs();
        int row = 0;
        for (var entry : subjects.entrySet()) {
            for (int col = 0; col < constanta; col++) {
                getMaxCost(row, col, col + 1);
            }
            row++;
        }

//        for(int i=0; i< subjects.size(); i++){
//            int col=0;
//            int finalI = i;
//            cellsWeight.forEach(cell->{
//                getMaxCost(finalI, col++, cell);
//            });
//        }
        System.out.println(calculatedParams);
    }

    private static void getMaxCost(int id, int col, int cellWeight) {
        Subject sub = subjects.get(id);
        int currentCost = sub.getCost();
        int currentWeight = sub.getWeight();

        if (id == 0) {
            var names = List.of(sub.getName());
            if (currentWeight <= cellWeight) {
                addToArray(id, col, currentWeight, names, sub.getCost());
            } else {
                addToArray(id, col, 0, names, 0);
            }
        } else {
            var previousParamById = getPreviousParam(id-1, col);
            var previousParamByCol = getPreviousParam(id, col-1);

            int previousCost = previousParamById.getSumCost();
            int previousWeight = previousParamById.getWeights().get(col);
            int leftCost = 0;
            int leftWeight = 0;
            if (col != 0) {
                leftCost = previousParamByCol.getSumCost();
                leftWeight =previousParamByCol.getWeights().get(col-1);
            }
            var sumWeight = previousWeight + currentWeight;
            var sumCost = previousCost + currentCost;

            if (sumWeight <= cellWeight && previousWeight!=0) {
                var names = previousParamById.getNames();
                names.add(sub.getName());
                addToArray(id, col, sumWeight, names, sumCost);
            } else if (leftCost > previousCost) {
                var names = previousParamByCol.getNames();
                addToArray(id, col, leftWeight, names, leftCost);
            } else if (previousCost > currentCost && currentWeight <= cellWeight) {
                var names = previousParamById.getNames();
                addToArray(id, col, previousWeight, names, previousCost);
            } else if (currentWeight <= cellWeight) {
                var names=List.of(sub.getName());
                addToArray(id, col, currentWeight,names, sub.getCost());
            } else {
                var names = previousParamById.getNames();
                addToArray(id, col, previousWeight, names, previousCost);
            }
        }
    }

    public static void addToArray(int id, int col, Integer calculatedWeight, List<String> names, int sumCost) {
        CalculatedParams params;
        if (col == 0) {
            params = new CalculatedParams(id, col, List.of(calculatedWeight), names, sumCost);
        } else {
            var sumWeights = new ArrayList<>(getPreviousParam(id, col).getWeights());
            sumWeights.add(calculatedWeight);
            params = new CalculatedParams(id, col, sumWeights, names, sumCost);
        }
        calculatedParams.add(params);
    }

    public static CalculatedParams getPreviousParam(int id, int col) {
        return Optional.of(calculatedParams.stream()
                .filter(cp -> cp.getId() == id && cp.getColumn() == col)
                .findFirst())
                .get()
                .orElseThrow();
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
