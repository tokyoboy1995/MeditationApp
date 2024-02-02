import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JFrame myFrame = new JFrame("Image Pane");
    ImageIcon startIcon = new ImageIcon(this.getClass().getResource("/start.png"));
    JButton startButton = new JButton(startIcon);

    ImageIcon pauseIcon = new ImageIcon(this.getClass().getResource("/pause.png"));
    JButton pauseButton = new JButton(pauseIcon);

    ImageIcon resetIcon = new ImageIcon(this.getClass().getResource("/reset.png"));
    JButton resetButton = new JButton(resetIcon);

    ImageIcon fiveMin = new ImageIcon(this.getClass().getResource("/5min.png"));
    JButton fiveMinButton = new JButton(fiveMin);
    ImageIcon tenMin = new ImageIcon(this.getClass().getResource("/10min.png"));
    JButton tenMinButton = new JButton(tenMin);
    ImageIcon sevMin = new ImageIcon(this.getClass().getResource("/7min.png"));
    JButton sevMinButton = new JButton(sevMin);
    JLabel timeLabel = new JLabel();
    final ImageIcon Background;
    private JLabel myLabel;

    int elapsedTime = 5000;
    int seconds = 5;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    MusicBg bell = new MusicBg();


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            elapsedTime -= 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

            if(elapsedTime <= 0) {
                timer.stop();
                try {
                    bell.musicBg();
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    });

    Stopwatch() {
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(172, 185, 160, 45);
        timeLabel.setFont(new Font("Arial",Font.PLAIN, 36));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        Background = new ImageIcon(this.getClass().getResource("/bg.png"));
        myLabel = new JLabel(Background);
        myLabel.setSize(500, 350);


        startButton.setBounds(203, 240, 100, 40);
        startButton.addActionListener(this);
        startButton.addActionListener(this);
        startButton.setOpaque(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);



        pauseButton.setBounds(219, 282, 70, 30);
        pauseButton.addActionListener(this);
        pauseButton.addActionListener(this);
        pauseButton.setOpaque(false);
        pauseButton.setBorderPainted(false);
        pauseButton.setFocusPainted(false);



        resetButton.setBounds(405, 285, 80, 30);
        resetButton.addActionListener(this);
        resetButton.addActionListener(this);
        resetButton.setOpaque(false);
        resetButton.setBorderPainted(false);
        resetButton.setFocusPainted(false);


        fiveMinButton.setBounds(205, 70, 100, 100);
        fiveMinButton.addActionListener(this);
        fiveMinButton.setOpaque(false);
        fiveMinButton.setBorderPainted(false);
        fiveMinButton.setFocusPainted(false);

        tenMinButton.setBounds(40, 30, 80, 80);
        tenMinButton.addActionListener(this);
        tenMinButton.setOpaque(false);
        tenMinButton.setBorderPainted(false);
        tenMinButton.setFocusPainted(false);

        sevMinButton.setBounds(375, 32, 90, 90);
        sevMinButton.addActionListener(this);
        sevMinButton.setOpaque(false);
        sevMinButton.setBorderPainted(false);
        sevMinButton.setFocusPainted(false);


        frame.add(startButton);
        frame.add(pauseButton);
        frame.add(resetButton);
        frame.add(fiveMinButton);
        frame.add(tenMinButton);
        frame.add(sevMinButton);
        frame.add(timeLabel);
        frame.add(myLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

}

@Override
public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton) {
            start();
        } else if (e.getSource() == pauseButton) {
            stop();
        } else if (e.getSource() == resetButton) {
            started = false;
            reset();
        } else if (e.getSource() == fiveMinButton) {
            started = false;
            makeFiveMin();
        } else if (e.getSource() == tenMinButton) {
            started = false;
            makeTenMin();
        } else if (e.getSource() == sevMinButton) {
            started = false;
            makeSevMin();
        }

}

void start() {

        if(elapsedTime > 0)
         timer.start();
        else
         timer.stop();
}

void stop() {
        timer.stop();
}

void reset() {
        timer.stop();
    try {
        bell.stopMusic();
    } catch (UnsupportedAudioFileException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (LineUnavailableException e) {
        throw new RuntimeException(e);
    }
    elapsedTime = 300000;
        seconds = 0;
        minutes = 5;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
}

void makeFiveMin() {
        timer.stop();
        elapsedTime = 300000;
        seconds = 0;
        minutes = 5;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
}

    void makeTenMin() {
        timer.stop();
        elapsedTime = 600000;
        seconds = 0;
        minutes = 10;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

    void makeSevMin() {
        timer.stop();
        elapsedTime = 420000;
        seconds = 0;
        minutes = 7;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }


}
