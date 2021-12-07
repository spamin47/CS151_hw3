package MVC_Examples;

//import studentappMVC.controller.AddClassMessage;
//import studentappMVC.controller.Message;
//import studentappMVC.controller.NewNameMessage;
//import studentappMVC.model.StudentModel;
//import studentappMVC.view.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    StudentModel studentModel;
    View view;

    public Controller(BlockingQueue<Message> queue, StudentModel studentModel, View view) {
        this.queue = queue;
        this.studentModel = studentModel;
        this.view = view;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == NewNameMessage.class) {
                // button updateStudentName was clicked
                NewNameMessage nameMessage = (NewNameMessage) message;
                studentModel.setName(nameMessage.getName()); // update model
                view.updateNameInView(studentModel.getName()); // update view
            }
            else if(message.getClass() == AddClassMessage.class) {
                // button addClass was clicked
                // update model and view
                AddClassMessage classMessage = (AddClassMessage) message;
                studentModel.addClass(classMessage.getCourse());
                view.updateListOfClassesInView(studentModel.getClasses());
            }

        }
    }
}

