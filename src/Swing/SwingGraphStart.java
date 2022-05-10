package Swing;

import javax.swing.*;
import java.awt.*;

import java.util.Arrays;


import static SortingTest.SortingTest.*;


class SwingTest extends JPanel {
    public static int quantity = 18;
    public static long[] timeArray = new long[quantity];

    public static long initData() {
        Integer[] array = createAndFill();
        long startTime = System.nanoTime();
        ShellSort(array, array.length);
        long endTime = System.nanoTime();
        long finalTime = endTime-startTime;
        return finalTime/200;
    }

    public long[] runInitData(){
        for (int i = 0; i < quantity; i++) {
            timeArray[i] = initData();
        }
        return timeArray;
    }

    public long[] refractToMicroSec(long[] timeArray) {
        long[] NewTimeArray = timeArray;
        for (int i = 0; i < quantity; i++) {
            NewTimeArray[i] = NewTimeArray[i]/5;
        }
        return NewTimeArray;
    }

    private long[] doDrawing(Graphics g) {

        var g2d = (Graphics2D) g;
        runInitData();
        g2d.setColor(new Color(212, 212, 212));
        g2d.drawRect(40, (int) (800-70-timeArray[0]), 45, (int) (timeArray[0]));
        g2d.drawRect(120, (int) (800-70-timeArray[1]), 45, (int) (timeArray[1]));
        g2d.drawRect(200, (int) (800-70-timeArray[2]), 45, (int)timeArray[2]);
        g2d.drawRect(280, (int) (800-70-timeArray[3]), 45, (int)timeArray[3]);
        g2d.drawRect(360, (int) (800-70-timeArray[4]), 45, (int)timeArray[4]);
        g2d.drawRect(440, (int) (800-70-timeArray[5]), 45, (int)timeArray[5]);
        g2d.drawRect(520, (int) (800-70-timeArray[6]), 45, (int) (timeArray[6]));
        g2d.drawRect(600, (int) (800-70-timeArray[7]), 45, (int) (timeArray[7]));
        g2d.drawRect(680, (int) (800-70-timeArray[8]), 45, (int) (timeArray[8]));
        g2d.drawRect(760, (int) (800-70-timeArray[9]), 45, (int) (timeArray[9]));
        g2d.drawRect(840, (int) (800-70-timeArray[10]), 45, (int)timeArray[10]);
        g2d.drawRect(920, (int) (800-70-timeArray[11]), 45, (int)timeArray[11]);
        g2d.drawRect(1000, (int) (800-70-timeArray[12]), 45, (int)timeArray[12]);
        g2d.drawRect(1080, (int) (800-70-timeArray[13]), 45, (int)timeArray[13]);
        g2d.drawRect(1160, (int) (800-70-timeArray[14]), 45, (int) (timeArray[14]));
        g2d.drawRect(1240, (int) (800-70-timeArray[15]), 45, (int) (timeArray[15]));
        g2d.drawRect(1320, (int) (800-70-timeArray[16]), 45, (int) (timeArray[16]));
        g2d.drawRect(1400, (int) (800-70-timeArray[17]), 45, (int) (timeArray[17]));




        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(40, 800-70-(int)timeArray[0], 45, (int)timeArray[0]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(120, 800-70-(int)timeArray[1], 45, (int)timeArray[1]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(200, 800-70-(int)timeArray[2], 45, (int)timeArray[2]);

        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(280, 800-70-(int)timeArray[3], 45, (int)timeArray[3]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(360, 800-70-(int)timeArray[4], 45, (int)timeArray[4]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(440, 800-70-(int)timeArray[5], 45, (int)timeArray[5]);

        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(520, 800-70-(int)timeArray[6], 45, (int)timeArray[6]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(600, 800-70-(int)timeArray[7], 45, (int)timeArray[7]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(680, 800-70-(int)timeArray[8], 45, (int)timeArray[8]);

        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(760, 800-70-(int)timeArray[9], 45, (int)timeArray[9]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(840, 800-70-(int)timeArray[10], 45, (int)timeArray[10]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(920, 800-70-(int)timeArray[11], 45, (int)timeArray[11]);

        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(1000, 800-70-(int)timeArray[12], 45, (int)timeArray[12]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(1080, 800-70-(int)timeArray[13], 45, (int)timeArray[13]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(1160, 800-70-(int)timeArray[14], 45, (int)timeArray[14]);

        g2d.setColor(new Color(125, 167, 116));
        g2d.fillRect(1240, 800-70-(int)timeArray[15], 45, (int)timeArray[15]);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(1320, 800-70-(int)timeArray[16], 45, (int)timeArray[16]);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(1400, 800-70-(int)timeArray[17], 45, (int)timeArray[17]);

        System.out.println(Arrays.toString(refractToMicroSec(timeArray)) + "- microseconds array");
        System.out.println("Average time = "+Arrays.stream(timeArray).sum()/ timeArray.length+ " microseconds");

        return timeArray;
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}




public class SwingGraphStart extends JFrame {

    public SwingGraphStart() {
        var drawPanel = new SwingTest();
        add(drawPanel);
        setSize(1600, 800);
        setTitle("Graph");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        var ex = new SwingGraphStart();
        ex.setVisible(true);

    }
}
