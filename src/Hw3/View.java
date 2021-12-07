package Hw3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    //blockingQueue
    BlockingQueue<Value> queue;
    //buttons
     JButton updateBlockButton;
     JButton resetButton;
     //textfields
     JTextField redTextArea;
     JTextField greenTextArea;
     JTextField blueTextArea;
     //panels
     JPanel leftSide;
     JPanel rightSide;
     //icons
    RectangleComponent redBar;
    RectangleComponent greenBar;
    RectangleComponent blueBar;
    //bar values


    public View(BlockingQueue<Value> queue){
        //declarations
        this.updateBlockButton = new JButton("update");
        this.resetButton = new JButton("reset");
        this.redTextArea = new JTextField();
        this.greenTextArea = new JTextField();
        this.blueTextArea = new JTextField();
        this.leftSide = new JPanel();
        this.rightSide = new JPanel();
        this.redBar = new RectangleComponent(1,350,100,0,Color.red);
        this.greenBar = new RectangleComponent(1,350,100,0,Color.green);
        this.blueBar = new RectangleComponent(1,350,100,0,Color.blue);
        this.queue = queue;

        //add listeners
        updateBlockButton.addActionListener(updateValue());
        resetButton.addActionListener(reset());

        //add components
            //leftside
        this.leftSide.add(new JLabel("Red"));
        leftSide.add(redTextArea);
        this.leftSide.add(new JLabel("Green"));
        leftSide.add(greenTextArea);
        this.leftSide.add(new JLabel("Blue"));
        leftSide.add(blueTextArea);
        leftSide.add(updateBlockButton);
        leftSide.add(resetButton);
            //rightside
        rightSide.add(redBar);
        rightSide.add(greenBar);
        rightSide.add(blueBar);

        //setting layout
        this.leftSide.setLayout(new GridLayout(9,1));
        this.rightSide.setLayout(new GridLayout(1,3,0,0));

        //main frame
        this.add(leftSide);
        this.add(rightSide);
        this.setSize(800,500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static ActionListener test(){
        return event -> System.out.println("Test!");
    }
    //update the values of red, green, and blue bars and put it into the blocking queue
    public ActionListener updateValue(){
        return event -> {
            //System.out.println(this.blueTextArea.getText().length());
            int blueValue;
            int redValue;
            int greenValue;

            //initiate the values by parsing the textArea into integers
            try{
                 redValue = Integer.parseInt(this.redTextArea.getText());

            }catch(NumberFormatException e){ //if value can't be parse into integers, set it to 0
                e.printStackTrace();
                redValue = 0;
            }
            try{

                greenValue = Integer.parseInt(this.greenTextArea.getText());
            }catch(NumberFormatException e){ //if value can't be parse into integers, set it to 0
                e.printStackTrace();
                greenValue = 0;
            }
            try{
                blueValue = Integer.parseInt(this.blueTextArea.getText());

            }catch(NumberFormatException e){ //if value can't be parse into integers, set it to 0
                e.printStackTrace();
                blueValue = 0;
            }

            System.out.println("Red: " + redValue  + " Green: " + greenValue+ " Blue: " + blueValue);

            try{
                //declare data for transferring
                RedValue rValue = new RedValue(redValue);
                GreenValue gValue = new GreenValue(greenValue);
                BlueValue bValue = new BlueValue(blueValue);
                //insert into queue to send data back to controller
                queue.put(rValue);
                queue.put(bValue);
                queue.put(gValue);

            }catch(Exception e){
                System.out.println("update button failed!");
                e.printStackTrace();
            }

        };
    }

    public void updateRedBar(int newValue){
        System.out.println("redHeight updated to " + newValue);
        redBar.setHeight(newValue);
    }
    public void updateGreenBar(int newValue){
        System.out.println("greenHeight updated to " + newValue);
        greenBar.setHeight(newValue);
    }
    public void updateBlueBar(int newValue){
        System.out.println("blueHeight updated to " + newValue);
        blueBar.setHeight(newValue);
    }
    //set bar height to 0. Reset values.
    public ActionListener reset(){
        return e ->{
            redTextArea.setText("");
            blueTextArea.setText("");
            greenTextArea.setText("");
            redBar.setHeight(0);
            greenBar.setHeight(0);
            blueBar.setHeight(0);
        };

    }
}
