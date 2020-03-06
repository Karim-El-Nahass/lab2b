package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vehicles.*;

import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    CarView carView;

    public CarController(CarView view, GroupCars groupCars) {
        carView = view;
        init(groupCars);
    }

    //methods:
    private void init(GroupCars groupCars) {

        carView.setStartButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.startEngine();
            }
        });

        carView.setStopButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.stopEngine();
            }
        });

        carView.setGasButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.gas(carView.gasAmount);
            }
        });

        carView.setBrakeButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.brake(carView.gasAmount);
            }
        });

        carView.setTurboOnButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.turboOn();
            }
        });

        carView.setTurboOffButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.turboOff();
            }
        });

        carView.setLiftBedButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.liftBed();
            }
        });

        carView.setLowerBedButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.lowerBed();
            }
        });

        carView.setAddCarButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.createCar();
                carView.drawPanel.cars = groupCars.cars;
                //carView.drawPanel.points = groupCars.carPoints;
                carView.repaint();
            }
        });

        carView.setRemoveCarButtonAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupCars.removeCar(carView);
            }
        });
    }
}