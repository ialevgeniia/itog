public class MyFirstProgram{

public static void main (String[] args){
    hello("everybody");
    hello("Я");
    Rectangle r = new Rectangle (3,5);
    System.out.println("Площадь прямоугольника = " + r.area());
    }

    public static void hello(String smb){
        System.out.println("Hello, " + smb + "!");
    }


}