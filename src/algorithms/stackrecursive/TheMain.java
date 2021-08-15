package algorithms.stackrecursive;

public class TheMain {
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(4));
    }

    public static int fact(int x){
        if(x==1)
            return x;
        else
            return x * fact(x - 1);
    }
}


