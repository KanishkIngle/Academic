/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Problem Statement-
Create Stop Watch with Swing GUI and Multithreading. Provide Facility for Lap
Counting.
*/
/**
 *
 * @author kanishk
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/*
this is my little stop watch program, it uses a game loop that I use for some video games I have made, modified to update 100 times a
second instead of 60 times a second, I used my timer instead of the built in swing timer, because I hate the swing timer, it sucks.
I went a little comment happy on this one, I tried to explain what everything is & what everything does, just cause I could.
*/
public class StopWatch extends JFrame//extends JFrame so that you don't have to type out JFrame all the time like a chump
{
	//swing components
	private JPanel panel = new JPanel();//will be added to the frame and the other components will be added to this panel
	private JTextField text = new JTextField();//time will be entered and displayed here
                   private JTextField countShow=new JTextField();
	private JLabel label = new JLabel();//prompts the user
	private JLabel whiteLabel = new JLabel();//purely decorative
	private JButton button = new JButton();//the button that stops/starts the stop watch
                   private JButton LapCount=new JButton();/**/ 
	//constants
	static final int WIDTH = 80;//width of the window
	static final int HEIGHT = 200;//height of the window
	static final int FPS = 100; //fps of the game loop or amount of updates a second
	static final long OPTIMAL_TIME = 1000000000 / FPS;//sets the amount of time each loop should take
	//other
	private boolean running = true;//if made false the game loop will end
	private boolean countStart = false;//true if the count down has started
	private boolean countOver = false;//true just for a brief moment when the counter hits 0
	private double counter = 0;//the stop watch counter, will be dropped 1.0 a second when the stop watch is started
                   private double lap=0;/**/
                   private int count=0;/**/
	private Font font = new Font("Verdana", 0, 8);//label font, unnecessary but pimp
	private DecimalFormat numFormat = new DecimalFormat();//the display format, set so the text field displays a number with 2 decimal places
	public static void main(String args[]){new StopWatch();}//compact main method just the way I like it
	public StopWatch()//constructor
	{
		setSize(new Dimension(WIDTH, HEIGHT));//sets the window size to the predetermined width/height, obviously
		setDefaultCloseOperation(3);//EXIT_ON_CLOSE is an int that = 3, so I put 3 because it's cooler that way
		getContentPane().add(panel);//creates a pane for this JFrame and adds the panel to that pane
		setLocationRelativeTo(null);//starts the window in the middle of the screen
		setResizable(true);//we don't want anyone messing with the size of the window just cause there is no reason for them to mess with it
		setVisible(true);//what use would this program be if it wasn't visible?...not very
		panel.setLayout(null);//null layout is my favourite, it let's you set the location of each component manually
		
		makeGui();//lays out the initial states of the swing components before the game loop takes over
		repaint();//this stops the GUI from doing weird stuff
		
		long lastLoopTime = System.nanoTime();//used in the loop
		while(running)//my awesome game loop, it's smooth and simple. there are better game loops but I like this one
		{
    		long now = System.nanoTime();//now = the current time in nanoseconds
    	        long updateLength = now - lastLoopTime;//updateLength = difference between the last loop's time and the current time
    	        lastLoopTime = now;
    	        double delta = updateLength / ((double)OPTIMAL_TIME);

    	        update(delta);
    	        paintGui();
    	    
    	        try{Thread.sleep((lastLoopTime-System.nanoTime())/1000000 + 10 );}
    	        catch(Exception ex){}//this catch is thrown every once and a while but that does not matter much
		}      
	}
	public String customFormat(String pattern, double value) //returns a number set to to specified number format
	{
		numFormat.applyPattern(pattern);
		return numFormat.format(value);
	}
	private void makeGui() 
	{
		whiteLabel.setBounds(WIDTH/2-2, 0, WIDTH, HEIGHT);
		label.setBounds(WIDTH/2-2, 8, WIDTH, 10);
		text.setBounds(WIDTH/2-2, 33, WIDTH, 21);
                                     countShow.setBounds(WIDTH/2-2, 120, WIDTH, 21);
		button.setBounds(WIDTH/2-2, 62, WIDTH, 18);
                                     LapCount.setBounds(WIDTH/2-2, 90, WIDTH, 18);
		
		text.setText("0.00");//sets the text field to display "0.00"
                                     countShow.setText("Lap "+count);
		label.setText("ENTER      TIME");//prompts the user to enter a time
		button.setText("start");//the button will either have "start" or "stop" on its face
		LapCount.setText("Count");
		label.setFont(font);//sets the label font to my pimp font
		
		text.setBackground(Color.gray);
                                     countShow.setBackground(Color.gray);
		panel.setBackground(Color.black);//the sides are black
		whiteLabel.setBackground(Color.white);//the white decorative stripe
		whiteLabel.setOpaque(true);//has to be opaque to have a non transparent background
		
		panel.add(label);
		panel.add(text);
                                     panel.add(countShow);
		panel.add(button);
                                     panel.add(LapCount);
		panel.add(whiteLabel);
		
		button.addActionListener(
				new ActionListener()//class within a class(class inception)
				{
					public void actionPerformed(ActionEvent event) 
					{
						if(countStart) countStart = false; //stops the countdown if the countdown isn't already stopped
						else 
						{
							countStart = true;//starts the count down
							try//if you try to parse a non number from the text field an exception will be thrown
							{
								counter = Integer.parseInt(text.getText());
							}
							catch(NumberFormatException ex) {text.setText("0.00");}//this catch will set the text field to "0.00"
						}
					}
				}
				);
                                     LapCount.addActionListener(
                                                                            new ActionListener()
                                                                            {
                                                                                              public void actionPerformed(ActionEvent event)
                                                                                              {
                                                                                                     
                                                                                                       count=count+1;
                                                                                                       String countParsed=Integer.toString(count);
                                                                                                       try{
                                                                                                           
                                                                                                       countShow.setText("Lap "+countParsed);
                                                                                                       }catch(Exception e){
                                                                                                       JOptionPane.showMessageDialog(null,e);
                                                                                                       }     
                                                                                              }
                                                                            }                                                                                    
                                                                           );
	}
	private void update(double delta) //update & paintGui will be called by the game loop over and over 100x a second
	{
		if(countStart)
		{
			counter -= delta*.01;//delta*.01 will subtract 1.0 a second from the counter
			if(counter <= 0)
			{
				counter = 0;//in case the counter dips below 1 it is now made to be zero.
				countStart = false;
				countOver = true;
			}
		}
	}
	private void paintGui() //this will be called right after the update method, if this was a video game this would be my render method
	{
		if(countStart)//if the count down is triggered
		{
			text.setText(customFormat("0.00", counter));//makes it so that the display of the counter will have 2 decimal points only
			text.setEnabled(false);//prevents you from messing with the text field while it's doing it's thing
			LapCount.setEnabled(true);
                                                        button.setText("stop");//indicates that the stop watch can be paused, because it can, you know?
                                                        
		}
		else
		{
			text.setEnabled(true);//allows you to modify the text field again
			button.setText("start");//indicates that the timer can be started again
			if(countOver) text.setText(customFormat("0.00", counter));
			countOver = false;
		}
	}
}
