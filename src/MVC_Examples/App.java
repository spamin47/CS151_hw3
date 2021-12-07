package MVC_Examples;

//
//import studentappMVC.controller.Controller;
//import studentappMVC.controller.Message;
//import studentappMVC.model.StudentModel;
//import studentappMVC.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        StudentModel model = new StudentModel();
        View view = new View(queue, model.getName(), model.getClasses());
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}

