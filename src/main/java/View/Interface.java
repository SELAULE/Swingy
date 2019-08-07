package View;


import Controller.FileUpload;
import com.sun.jarsigner.ContentSigner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interface {

    JLabel statusLabel;
    public static int getWindowSize(int level) {
        return ( (level - 1) * 5 + 10 - (level % 2));
    }

    public String[] OpenFile(String path) throws IOException {

        FileReader file = new FileReader(path);
        BufferedReader filereader = new BufferedReader(file);

        int numberOfLines = readLines(path);
        String[] fileData = new String[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            fileData[i] = filereader.readLine();
        }
        filereader.close();
        return fileData;
    }

    public  int readLines(String path) throws IOException {
        FileReader fileToRead = new FileReader(path);
        BufferedReader bufReader = new BufferedReader(fileToRead);

        // String aline;

        int numberOfLines = 0;

        while (( /* aline */  bufReader.readLine() ) != null) {
            numberOfLines++;
        }
        bufReader.close();
        return numberOfLines;
    }

//    private class ButtonClickListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String command = e.getActionCommand();
//
//            if( command.equals( "Select Hero" ))  {
//                statusLabel.setText("Select Hero pressed");
//            }
//        }
//    }

    public static void main(String[] args) {
        JFrame frame;
        // JTextField statusLabel = new JTextField();
        frame = new JFrame("Swingy");
//        Interface reader = new Interface();
//        ButtonClickListener ButtonClicker = new ButtonClickListener();
        FileUpload buttons = new FileUpload();

        JButton SelectHeroButton = new JButton("Select Hero");
//        buttons.showEventDemo();

//
        try {
            String[] Contents = buttons.OpenFile("heroes.txt");
            String[][] splitString = new String[10][10];
            SelectHeroButton.addActionListener(e -> {
                for (int i = 0; i < Contents.length; i++) {
                    splitString[i] = Contents[i].split(",");
                    JTextField textfiled = new JTextField(splitString[0][3]);
                    frame.add(textfiled);
                    textfiled.setBounds(10, 100, 300, 500);
//                    JList list = new JList(splitString);
//
//                    //set a selected index
//                    frame.add(list);
//                    list.setSelectedIndex(2);
                }
            });
            SelectHeroButton.setBounds(130,50,100, 40);
//        int level = 7;
            frame.add(SelectHeroButton);//adding button in JFrame

//            JTextField textfiled = new JTextField(splitString[i]);
//            frame.add(textfiled);
//            textfiled.setBounds(10, 100, 300, 500);
//            JList list = new JList(splitString);
//
//            //set a selected index
//            list.setSelectedIndex(2);

        }catch (IOException ex) {
            System.out.print("Error");
        }


        frame.setSize(1000, 1000);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible
    }
}