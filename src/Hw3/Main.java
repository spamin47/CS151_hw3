package Hw3;

import javax.naming.ldap.Control;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args){
        BlockingQueue<Value> queue = new LinkedBlockingQueue<>();
        System.out.println("Hi");
        View view = new View(queue);
        Controller controller = new Controller(view,queue);
        controller.mainLoop();
    }
}
