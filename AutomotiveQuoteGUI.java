import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
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

        //create title
        Border rBevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        JLabel joes = new JLabel(" Joe's Automotive ");
        joes.setFont(new Font("Times New Roman", Font.BOLD, 18));
        joes.setBorder(rBevelBorder);


        //implement checkboxes and action listeners
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

        //
        labor = new JCheckBox("Labor - 20.00 x per hour: ");
        numOfHours = new JTextField(2);
        numOfHours.setEditable(false);
        labor.addActionListener(this);

        //button to add print total
        totalPrice = new JButton("Total");
        totalPrice.addActionListener(this);

        //JLabel totalPrice = new JLabel("Total Price: $" + total);
        totalNum = new JTextField(5);
        totalNum.setEditable(false);

        //add to content pane
        jfrm.add(joes);
        jfrm.add(routine);
        jfrm.add(oilChange);
        jfrm.add(lubeJob);
        jfrm.add(radiatorFlush);
        jfrm.add(inspection);
        jfrm.add(muffler);
        jfrm.add(rotation);
        jfrm.add(nonRoutine);
        jfrm.add(labor);
        jfrm.add(numOfHours);
        jfrm.add(parts);
        jfrm.add(partsPrice);
        jfrm.add(totalPrice);
        jfrm.add(totalNum);

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

        //when pressed, it takes the value from the text field and adds it to double
        if(labor.isSelected()){
            numOfHours.setEditable(true);
            hours = Double.parseDouble(numOfHours.getText());
        }
        //when unpressed, text field is uneditable
        if(!labor.isSelected()){
            numOfHours.setEditable(false);
        }
        //when pressed, it adds the price for parts to total
        if(parts.isSelected()){
            partsPrice.setEditable(true);
            total += Double.parseDouble(partsPrice.getText());
        }
        //make uneditable if not selected
        if(!parts.isSelected()){
            partsPrice.setEditable(false);
        }

        //if button is pressed, total is outputted
        if(e.getActionCommand().equals("Total")){
            total += hours * 20;
            totalNum.setText("$" + String.format("%.2f", total));
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
