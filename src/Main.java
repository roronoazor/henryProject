import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        try{
            new Manager();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}