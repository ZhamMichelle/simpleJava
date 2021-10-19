package patterns.strategy;
/*Паттерн Стратегия (Strategy) относится к поведенческим (behavioral) паттернам проектирования. Также известен как Политика (Policy).
Основным замыслом паттерна является следующая ситуация. Вы определяете семейство алгоритмов, инкапсулируете каждый и делаете их взаимозаменяемыми.
*/
public class TheMain {
    public static void main(String[] args) {
        Sedan sedan=new Sedan();
        sedan.fill();

        ChildrenBuggies buggy=new ChildrenBuggies();
        buggy.setFillStrategy(new StandartFillStrategy());
        buggy.fill();
    }
}
