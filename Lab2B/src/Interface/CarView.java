package Interface;

import Vehicles.GroupCars;
import Vehicles.Vehicle;
import Vehicles.View;
import Vehicles.Volvo240;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements View {

    public CarView(String framename, ArrayList<Vehicle> cars){ // ,GroupCars cars){
        //this.model = model;
        this.drawPanel = new DrawPanel(X, Y-200, cars);
        initComponents(framename);
    }

    private static final int X = 800; // private -> can not be reached outside the class.
    public int getX() { return  X; }

    private static final int Y = 800; // private as well.
    public int getY() { return Y; }

    // The controller member
    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;

    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");

    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Raise Bed");
    JButton lowerBedButton = new JButton("Lower Bed");

    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y+30));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1); //step

        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(removeCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(addCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+74, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-45,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-45,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setLocation(dim.width/2-this.getSize().width/2, 0);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // methods
    public void setStartButtonAL(ActionListener a) {
        startButton.addActionListener(a);
    }
    public void setStopButtonAL(ActionListener a) {
        stopButton.addActionListener(a);
    }
    public void setGasButtonAL(ActionListener a) {
        gasButton.addActionListener(a);
    }
    public void setBrakeButtonAL(ActionListener a) { brakeButton.addActionListener(a); }
    public void setTurboOnButtonAL(ActionListener a) {
        turboOnButton.addActionListener(a);
    }
    public void setTurboOffButtonAL(ActionListener a) {
        turboOffButton.addActionListener(a);
    }
    public void setLiftBedButtonAL(ActionListener a) {
        liftBedButton.addActionListener(a);
    }
    public void setLowerBedButtonAL(ActionListener a) {
        lowerBedButton.addActionListener(a);
    }
    public void setAddCarButtonAL(ActionListener a) {
        addCarButton.addActionListener(a);
    }
    public void setRemoveCarButtonAL(ActionListener a) {
        removeCarButton.addActionListener(a);
    }
    public void repaint() { drawPanel.repaint();}
}