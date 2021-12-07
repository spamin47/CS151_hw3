package Hw3;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Value> queue;
    View view;
    public Controller(View view, BlockingQueue<Value> queue){
        this.view = view;
        this.queue = queue;
    }

    public void mainLoop(){
        while(view.isDisplayable()){
            Value value = null;
            try{
                value = queue.take();
            }catch(InterruptedException e){
                e.printStackTrace();
            }


            if(value.getClass() == RedValue.class){
                System.out.println("Red Value found in queue. ");
                RedValue red = (RedValue) value;
                System.out.println("Red value: " + red.getValue());
                view.updateRedBar(red.getValue());
            }
            if(value.getClass() == GreenValue.class){
                System.out.println("Green Value found in queue. ");
                GreenValue green = (GreenValue) value;
                System.out.println("Green value: " + green.getValue());
                view.updateGreenBar(green.getValue());
            }
            if(value.getClass() == BlueValue.class){
                System.out.println("Blue Value found in queue. ");
                BlueValue blue = (BlueValue) value;
                System.out.println("Blue value: " + blue.getValue());
                view.updateBlueBar(blue.getValue());
            }

        }
    }
}
