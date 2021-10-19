package patterns.builder;

public class TheMain {
    public static void main(String[] args) {
        BuilderPattern pattern=new BuilderPattern.Builder().setId(5).build();
        System.out.println(pattern.getId());
    }
}
