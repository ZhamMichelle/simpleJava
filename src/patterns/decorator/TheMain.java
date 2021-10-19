package patterns.decorator;
/*Декоратор Java — это структурный паттерн, который используется при динамическом проектировании объекта.
То есть при помощи этого паттерна можно к объекту «прикрутить» дополнительные свойства функциональности.
*/
public class TheMain {
    public static void main(String[] args) {
        Service devination = new Devination(450.0, "devination");
        Service horoscope=new Horoscope(0.0, "horoscope");
        Service aura=new Aura(devination);
        Service chakra=new Chakra(horoscope);
        System.out.println(aura.getPrice());
        System.out.println(chakra.getPrice());
    }
}
