
/**
 *
 * @author kanishk
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class vCard {
    JFrame Contact;
    JButton Open,Create;
    vCard(){
        Contact=new JFrame("Save as vCard Format");
        Open=new JButton("'Open");
        Create=new JButton("Create");
        //set bounds
        Open.setBounds(36,87,70,20);
        Create.setBounds(36,110,80,20);

        Open.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            String DirName ="C:\\Users\\kanishk\\Contacts";

                            String FileName = JOptionPane.showInputDialog("Enter the file Name to Open (with Extension)-");
                            File F = new File(DirName,FileName);
                            String line = null;
                            if (F.exists()){
                                JOptionPane.showMessageDialog(null,F.getName()+" exists","Contact exists",JOptionPane.PLAIN_MESSAGE);

                                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+DirName+"\\"+FileName);
                            }else{
                                JOptionPane.showMessageDialog(null,"File does'nt exists"," Not Found",JOptionPane.PLAIN_MESSAGE);
                            }

                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null, ex);
                        }

                    }
                }
        );
        Create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String DirName = "C:\\Users\\kanishk\\Contacts";
                        Scanner sc = new Scanner(System.in);
                        Scanner scanfile = new Scanner(System.in);
                        Scanner sc1 = new Scanner(System.in);
                        JOptionPane.showMessageDialog(null,"Remember this contact will be saved Externally in *.vcf format","Warning",JOptionPane.PLAIN_MESSAGE);
                        String FileName=JOptionPane.showInputDialog("Name the Contact File");
                        File F = new File(DirName,FileName);
                        String path =DirName+"\\"+FileName+".vcf";

                        try{
                            FileWriter fw = new FileWriter(path);
                            BufferedWriter bf = new BufferedWriter(fw);
                            String Name =JOptionPane.showInputDialog("Enter Name");
                            bf.write(Name);
                            bf.newLine();
                            String Phone=JOptionPane.showInputDialog("Enter Phone Number");
                            bf.write(Phone);
                            bf.flush();
                            bf.close();
                            fw.close();
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex);
                        }
                        JOptionPane.showMessageDialog(null,"Contact Saved Successfully","File Saved",JOptionPane.PLAIN_MESSAGE);

                    }
                }
        );

        Contact.add(Open);
        Contact.add(Create);

        Contact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Contact.setSize(200,300);
        Contact.setLayout(null);
        Contact.setVisible(true);
        Contact.setResizable(false);

    }
}
