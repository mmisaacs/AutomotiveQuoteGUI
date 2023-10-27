import javax.swing.*;
import java.awt.*;

public class AutomotiveQuoteGUI {
    JCheckBox oilChange, lubeJob, radiatorFlush, transmission, inspection,
            muffler, rotation, labor;
    JTextField numOfHours, partsPrice;

    AutomotiveQuoteGUI(){
        //create the frame
        JFrame jfrm = new JFrame ("Joe's Automotive Service Quote");
        jfrm.setSize(300,400);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel routine = new JLabel("Regular Routine Services");
        oilChange = new JCheckBox("Oil Change - $36.00");
        oilChange.setHorizontalAlignment(JCheckBox.LEFT);
        lubeJob = new JCheckBox("Lube Job - $18.00");
        radiatorFlush = new JCheckBox("Radiator Flush - $30.00");
        inspection = new JCheckBox("Inspection - $15.00");
        muffler = new JCheckBox("Muffler Replacement - $100.00");
        rotation = new JCheckBox("Tire Rotation - $20.00");
        labor = new JCheckBox("Labor - 20.00 x per hour: ");
        JLabel nonRoutine = new JLabel("Non-Routine Services");
        JLabel parts = new JLabel("Parts(in $): ");
        partsPrice = new JTextField(5);

        numOfHours = new JTextField(2);

        jfrm.getContentPane().add(routine);
        jfrm.getContentPane().add(oilChange);
        jfrm.getContentPane().add(lubeJob);
        jfrm.getContentPane().add(radiatorFlush);
        jfrm.getContentPane().add(inspection);
        jfrm.getContentPane().add(muffler);
        jfrm.getContentPane().add(rotation);
        jfrm.getContentPane().add(nonRoutine);
        jfrm.getContentPane().add(labor);
        jfrm.getContentPane().add(numOfHours);
        jfrm.getContentPane().add(parts);
        jfrm.getContentPane().add(partsPrice);


        jfrm.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomotiveQuoteGUI();
            }
        });
    }
}
