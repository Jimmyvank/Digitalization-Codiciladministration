// : c14:FileChooserTest.java
// Demonstration of File dialog boxes.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

package project2.pkg6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileBrowser extends JFrame
{
  private final JTextField filename = new JTextField(), dir = new JTextField();

  private final JButton open = new JButton("Open"), save = new JButton("Save");

  public String def;
  
  public FileBrowser()
  {
    JPanel p = new JPanel();
    open.addActionListener(new OpenL());
    p.add(open);
    Container cp = getContentPane();
    cp.add(p, BorderLayout.SOUTH);
    dir.setEditable(false);
    filename.setEditable(false);
    p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(filename);
    p.add(dir);
    cp.add(p, BorderLayout.NORTH);
  }

  class OpenL implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(FileBrowser.this);
      if (rVal == JFileChooser.APPROVE_OPTION)
      {
        filename.setText(c.getSelectedFile().getName());
        def = ((c.getCurrentDirectory().toString())+"\\"+(c.getSelectedFile().getName()));
        
        if (def != null)
        { 
            String pdfCheck = ("^([\\S]*\\.pdf)$");
            Pattern p = Pattern.compile(pdfCheck);
            Matcher m = p.matcher(def);
            boolean klopt = m.find();
            
           if (klopt)
           {
               // voer code uit
                System.out.println(def);
                PDFSplitter split = new PDFSplitter();
                split.main(def);
        }
        dir.setText(c.getCurrentDirectory().toString());
        
        
      }
      if (rVal == JFileChooser.CANCEL_OPTION) 
      {
        filename.setText("You pressed cancel");
        dir.setText("");
               
           }
           else
           {
               // laat melding zien en vraag op nieuw
               System.out.println("Kies een geldig document.");
               run(new FileBrowser(), 250, 110);
           }
            //System.out.print(klopt);
//            while(!klopt)
//            {
//                System.out.println("Kies een geldig document.");
//                System.exit(0);
//            }
            
//            System.out.println(def);
//            PDFSplitter split = new PDFSplitter();
//            split.main(def);
//        }
//        dir.setText(c.getCurrentDirectory().toString());
//        
//        
//      }
//      if (rVal == JFileChooser.CANCEL_OPTION) 
//      {
//        filename.setText("You pressed cancel");
//        dir.setText("");
      }
    }
  }

  public static void main(String[] args)
  {
    run(new FileBrowser(), 250, 110);
  }

  public static void run(JFrame frame, int width, int height) 
  {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
  }
} ///:~
