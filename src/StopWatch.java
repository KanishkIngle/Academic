
import javax.swing.*;
import java.awt.event.*;

public class StopWatch extends JFrame implements  Runnable,ActionListener{
public long startTime;
int LapCount=0;
static java.text.SimpleDateFormat timerFormat=new java.text.SimpleDateFormat("mm:ss.SSS");
boolean isRunning=false;
Thread updater;
JButton StartandStop=new JButton("Start/Stop");
JTextField count=new JTextField();
Runnable displayUpdater=new Runnable() {
    @Override
    public void run() {
        displayElaspedTime(System.currentTimeMillis()-StopWatch.this.startTime);
    }
};
void displayElaspedTime(long ElaspedTime){
    StartandStop.setText(timerFormat.format(new java.util.Date(ElaspedTime)));
}
public  void run(){
    try{
        while(isRunning){
        SwingUtilities.invokeAndWait(displayUpdater);
        Thread.sleep(50);

        }
    }catch ( java.lang.reflect.InvocationTargetException ex){
        JOptionPane.showMessageDialog(null,ex);
        //should never occur
    }
    catch (InterruptedException ie){}
    //do Nothing
}
public void actionPerformed(ActionEvent e){
    if(isRunning){
        long ElapsedTime=System.currentTimeMillis()-startTime;
        isRunning=false;
        try{
            updater.join();
            LapCount=LapCount+1;
        }catch (InterruptedException ie){}
        displayElaspedTime(ElapsedTime);
        count.setText("Lap Count : "+LapCount);
    }else{
        startTime=System.currentTimeMillis();
        isRunning=true;
        updater=new Thread(this);
        updater.start();
    }
}
StopWatch(){
    super("Stop Watch");
    StartandStop.addActionListener(this);
    count.setBounds(50,100,150,20);
    count.setEnabled(false);
    StartandStop.setBounds(50,50,100,20);
    add(StartandStop);
    add(count);
    //getContentPane().add(StartandStop);
    setLayout(null);
    setSize(250,200);
    setVisible(true);
}
public static void main(String args[]){
    new StopWatch().addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });

}
}
