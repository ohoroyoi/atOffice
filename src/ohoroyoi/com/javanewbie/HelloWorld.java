package ohoroyoi.com.javanewbie;

class Foo1 {
    static {
        System.out.println("Foo initializing");
    }
}

public class HelloWorld { //https://www.slipp.net/questions/276
    public static void main(String[] args) throws Exception {
        Cat cat1 = new Cat("냥냥");
        cat1.meow();
        Class.forName("Foo1"); //https://stackoverflow.com/questions/4202252/how-does-class-forname-work
    }
}
