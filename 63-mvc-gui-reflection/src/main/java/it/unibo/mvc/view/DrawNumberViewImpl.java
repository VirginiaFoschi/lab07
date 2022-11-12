package it.unibo.mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberViewImpl implements DrawNumberView{

    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";

    //private DrawNumberController controller;
    private final DrawNumber model;
    private final JFrame frame = new JFrame(FRAME_NAME);

    public DrawNumberViewImpl(final DrawNumber model){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.model = model;
        final JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().add(panel);
        JPanel pCenter = new JPanel(new FlowLayout());
        JButton b1 = new JButton(GO);
        JTextField text = new JTextField(10);
        pCenter.add(text);
        pCenter.add(b1);
        JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton b2 = new JButton(RESET);
        JButton b3 = new JButton(QUIT);
        pSouth.add(b2);
        pSouth.add(b3);
        panel.add(pCenter, BorderLayout.CENTER);
        panel.add(pSouth, BorderLayout.SOUTH);

        b1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                DrawResult result = model.attempt(Integer.parseInt(text.getText()));
                System.out.println(result.getDescription());
            }
            
        });

        b2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                model.reset();
            }
            
        });

        b3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
            
        });

        frame.pack();
    }

    @Override
    public void setController(DrawNumberController observer) {
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        this.frame.setVisible(true);
    }

    @Override
    public void result(DrawResult res) {
        // TODO Auto-generated method stub
        
    }
    
}