package algorithms.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSecondMain {
    public static void main(String[] args) {
        List<Product> products=new ArrayList<>();
        products.add(new Product("LA",5));
        products.add(new Product("Chikago",5));

        Map<String,String> details=
                products.stream().collect(Collectors.toMap(Product::getName,p->{
                    return toString(p.getCount());
                }));
        System.out.println(details);
    }

    public static String toString(int i){
        return Integer.toString(i);
    }

}

class Product{
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(String name, int count){
        this.name=name;
        this.count=count;
    }

}
