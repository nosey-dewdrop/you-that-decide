import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Main{

      public static void main(String[] args){

            final int WIDTH = 400;
            final int LENGTH = 200;  
            ArrayList<String> possibleOptions = new ArrayList();

            JFrame myFrame = new JFrame();
            myFrame.setSize(WIDTH, LENGTH);
            myFrame.setLocationRelativeTo(null);
            myFrame.setTitle("Hello!!");
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            myFrame.setLayout(new BorderLayout());


            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JPanel displayPanel = new JPanel();
            displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
            JScrollPane scrollPane = new JScrollPane(displayPanel); 

            // Çiçekleri göstereceğimiz panel
            JPanel flowerPanel = new JPanel();
            flowerPanel.setLayout(new FlowLayout()); 
            flowerPanel.setBorder(BorderFactory.createTitledBorder("Flowers"));

            
            JTextField textField = new JTextField(10);
            JButton addButton = new JButton("add");
            JButton decideButton= new JButton("shuffle!!!");

            addButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                        String input = textField.getText();
                        if(!input.isEmpty()){

                              possibleOptions.add(input);
                              textField.setText("");

                              // JLabel itemLabel = new JLabel(input);
                              // displayPanel.add(itemLabel);
                              // displayPanel.revalidate();

                              try{
                                    ImageIcon flowerIcon = new ImageIcon("flower.png"); // Çiçek resmi buraya
                                    Image img = flowerIcon.getImage();
                                    Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                                    flowerIcon = new ImageIcon(scaledImg);

                                    JLabel flowerLabel = new JLabel(flowerIcon);
                                    flowerPanel.add(flowerLabel);
                                    flowerPanel.revalidate();
                                    flowerPanel.repaint();
                              }

                              catch (Exception ex) {
                                    JLabel placeholderLabel = new JLabel("🌸");
                                    placeholderLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
                                    flowerPanel.add(placeholderLabel);
                                    flowerPanel.revalidate();
                                    flowerPanel.repaint();
                                }
                        }
                  }
            });

            decideButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e) {
                        decideShuffle(possibleOptions);

                        if (!possibleOptions.isEmpty()) {

                              possibleOptions.clear();
                              displayPanel.removeAll();
                              flowerPanel.removeAll();
                              displayPanel.revalidate();
                              displayPanel.repaint();
                              flowerPanel.revalidate();
                              flowerPanel.repaint();

                        }
                  }
            });


            panel.add(textField);
            panel.add(addButton);
            panel.add(decideButton);

            myFrame.add(panel, BorderLayout.NORTH);
            myFrame.add(scrollPane, BorderLayout.CENTER);
            myFrame.add(flowerPanel, BorderLayout.SOUTH);
        
            myFrame.setVisible(true);

      }


      public static void decideShuffle(ArrayList<String> options){
            if (options.isEmpty()) {
                JOptionPane.showMessageDialog(null,"empty");
            }

            else{
                  int count = options.size();
                  Random rand = new Random();
                  JOptionPane.showMessageDialog(null, options.get(rand.nextInt(count)),"result", JOptionPane.INFORMATION_MESSAGE);
            }
      }
}

// resimleri de random seçelim
