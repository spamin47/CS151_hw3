package MVC_Examples;

import java.util.ArrayList;

public class StudentModel {
    private String name = "default name";
    private ArrayList<String> classes = new ArrayList<>();

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public void addClass(String name) {
        this.classes.add(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getClasses() {
        return (ArrayList<String>) classes.clone();
    }
}
