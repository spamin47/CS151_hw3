package MVC_Examples;

//import studentappMVC.controller.Message;

public class AddClassMessage implements Message {
    private String course;

    public AddClassMessage(String str) {
        this.course = str;
    }

    public String getCourse() {
        return course;
    }
}


