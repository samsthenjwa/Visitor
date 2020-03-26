public class Main {
    public static void main(String[] args){
        Visitor visitor = new Visitor();

        visitor.save("Sambulo Ngema",25, "25/03/2020","21:22","Please come again","Thapelo Ramongalo");
        visitor.load("Sambulo Ngema");
    }
}
