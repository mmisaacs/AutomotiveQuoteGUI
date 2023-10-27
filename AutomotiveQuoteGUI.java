import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomotiveQuoteGUI implements ActionListener {
    JCheckBox oilChange, lubeJob, radiatorFlush, transmission, inspection,
            muffler, rotation, labor, parts;
    JTextField numOfHours, partsPrice, totalNum;

    JButton totalPrice;

    double total;


    AutomotiveQuoteGUI(){
        //create the frame
        JFrame jfrm = new JFrame ("Joe's Automotive Service Quote");
        jfrm.setSize(300,400);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel routine = new JLabel("<html><B>Regular Routine Services");
        oilChange = new JCheckBox("Oil Change - $36.00");
        oilChange.addActionListener(this);
        lubeJob = new JCheckBox("Lube Job - $18.00");
        lubeJob.addActionListener(this);
        radiatorFlush = new JCheckBox("Radiator Flush - $30.00");
        radiatorFlush.addActionListener(this);
        inspection = new JCheckBox("Inspection - $15.00");
        inspection.addActionListener(this);
        muffler = new JCheckBox("Muffler Replacement - $100.00");
        muffler.addActionListener(this);
        rotation = new JCheckBox("Tire Rotation - $20.00");
        rotation.addActionListener(this);

        JLabel nonRoutine = new JLabel("<html><B>Non-Routine Services");

        //parts, user fill in value, added to total. editable changes when pressed
        parts = new JCheckBox("Parts(in $): ");
        partsPrice = new JTextField(10);
        partsPrice.setEditable(false);
        parts.addActionListener(this);

        labor = new JCheckBox("Labor - 20.00 x per hour: ");
        numOfHours = new JTextField(2);
        numOfHours.setEditable(false);
        labor.addActionListener(this);

        totalPrice = new JButton("Total");
        totalPrice.addActionListener(this);

        //JLabel totalPrice = new JLabel("Total Price: $" + total);
        totalNum = new JTextField(5);
        totalNum.setEditable(false);

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
        jfrm.getContentPane().add(totalPrice);
        jfrm.getContentPane().add(totalNum);


        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        total = 0.0;
        double hours = 0.0;
        //add routine prices to total if pressed
        if(oilChange.isSelected()){
            total += 36.0;
        }
        if(lubeJob.isSelected()){
            total += 18.00;
        }
        if(radiatorFlush.isSelected()){
            total += 30.00;
        }
        if(inspection.isSelected()){
            total += 15.00;
        }
        if(muffler.isSelected()){
            total += 100.00;
        }
        if(rotation.isSelected()){
            total += 20.00;
        }

        if(labor.isSelected()){
            numOfHours.setEditable(true);
            hours = Double.parseDouble(numOfHours.getText());
        }
        if(!labor.isSelected()){
            numOfHours.setEditable(false);
        }
        if(parts.isSelected()){
            partsPrice.setEditable(true);
            total = Double.parseDouble(partsPrice.getText());

        }
        //make uneditable if not selected
        if(!parts.isSelected()){
            partsPrice.setEditable(false);
        }

        //if button is pressed, total is outputted
        if(e.getActionCommand().equals("Total")){
            total += hours * 20;
            totalNum.setText("$" + total);
            total = 0;
        }
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
