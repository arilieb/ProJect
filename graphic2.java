package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class graphic2 extends JPanel implements ActionListener{
	static JFrame frame = new JFrame();
	JLabel jl = new JLabel("");
	JLabel jl2 = new JLabel("");
	JLabel jl3 = new JLabel("");
	JLabel jl4 = new JLabel("what is your name?");
	JTextField tf = new JTextField(20);
	player you = new player("","");
	int searches = 0;
	int room = 0;
	int hr = 0;
	int pushes = 0;
	int yesNum = 0;
	int cmd = 0;
	int hintNum=0;
	boolean first = true;
	inventory yourInv = new inventory(new String[5]);
	boolean torch = false;
	int torchTurn = 30;
	
	  
	  
	
  public graphic2() {
	JButton cmd = new JButton("commands");  
    JButton btn = new JButton("try");
    cmd.addActionListener(this);
    btn.addActionListener(this);
    add(cmd);
    add(btn);
    add(tf);
    add(jl);
    add(jl2);
    add(jl3);
    add(jl4);

  }

  public static void main(String[] args) {
    
    
    frame.getContentPane().add(new graphic2());
   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setVisible(true);
  }


/*class ButtonListener implements ActionListener {
  ButtonListener() {
  }
*/
  public void actionPerformed(ActionEvent e) {
	  
	if (e.getActionCommand().equals("commands")) {
		cmd++;
		System.out.println("Button1 has been clicked");
		if(cmd%2==1){
		jl2.setText(/*jl2.getText() + */"<html> inv = display inventory <br>"
          		+ " search = search room <br>"
          		+ " open + door,door2,door3,etc = open door <br>"
          		+ " pick up + item name= pick up item <br>"
          		+ " use + item name + on + object name = use item on object<br>"
          		+ " room = get room number<br>"
          		+ " hint = hint<br>"
          		+ " clear = clear subtext<br>"
          		+ " wait = wait 1 hr<br>"
          		+ " push + object = push object<br>"
          		+ " how long = have I been here?<br>");
          }
		else if(cmd%2==0){
			jl2.setText("");
		}
	}
	
    if (e.getActionCommand().equals("try")) {
      System.out.println("Button1 has been clicked");
     
          if (tf.getText().equals("inv")){
        	  jl2.setText(inventory());
          }
          else if (tf.getText().equals("wait")){
        	  hr++;
        	  jl2.setText(/*jl2.getText()+*/"<html> you wait an hour<br></html>");
          }
          else if (tf.getText().equals("how long")){
        	  jl2.setText(/*jl2.getText()+*/ "<html>you have been here for "+ hr + " hour(s)<br></html>");
          }
          else if (tf.getText().equals("clear")){
        	  jl2.setText("");
          }
   
          else if (tf.getText().equals("hint")){
        	  jl2.setText("<html>you didnt come in here naked you know<br> and you might have to try things twice</html>");
          }
          else if (room > 3 && tf.getText().equals("room")){
        	  jl2.setText("you've been down here so long,<br> its getting difficult to remember,<br> 3, or was it 4?");
        	  
          }
          else if (room < 3 && tf.getText().equals("room")){
        	  jl2.setText("room " + room + " ... I think.");
          }
      if(first == true){
      if (you.getName().equals("")){
    	  you.setName(tf.getText());
    	  jl3.setText(you.getName());
    	  jl4.setText("what is your age?");
      }
      else if(!you.getName().equals("")){
    	  you.setAge(tf.getText());
    	  jl4.setText("are you ready?");
    	  System.out.println(you.getName() + you.getAge());
    	  first = false;
      }
      }
      
    	  
      if(tf.getText().equals("yes") && yesNum == 0){
    	  yourInv.add("lighter");
    	  room++;
    	  yesNum++;
    	  jl4.setText("");
    	  first = false;
    	  jl.setText("It is dark, too dark, but someone locked the door behind you");
      }
      if (room == 1){
    	 
    	 
    	  if (tf.getText().equals("search") && searches == 0){
    	  jl.setText("<html>you fumble along the damp and moldy walls searching,<br> but as the minutes drag by, your hope begins to wane,<br> maybe you should just sit down</html>");
          searches++;
          }
    	  else if (tf.getText().equals("search") && searches == 1){
	      jl.setText("<html>you continue what now seems like<br> a near futile effort, but alas,<br> after stumbling through the heavy, <br> shapeless forms suspended in the middle of the room,<br> you kick something wooden, a torch!</html>");
	      searches++;
    	  }
    	  else if (tf.getText().equals("search") && searches == 2){
          jl.setText("doesnt seem like theres anymore to find here, maybe you should just give up");
          searches++;
          }
          if (searches>=1){
      	    if (tf.getText().equals("pick up torch")){
      	    
      	    yourInv.add("torch");
      	    jl2.setText("<html>you now have a torch<br>");
      	    }
      	  
      	    else if (iHave("torch")==true && tf.getText().equals("use lighter on torch")){
      	    jl.setText("<html>the room is illuminated,<br> maybe it would have been better to leave the torch unlit,<br> you avert your gaze from what hangs above you and look around.<br>the walls are mossy stone, and there seems to be a rectangular outline set in far wall...<br> could that open?</html>" );
          	torch = true;
          	jl2.setText("you now have a lit torch");
      	    }
      	    else if (torch == true && pushes == 0 && tf.getText().equals("push rectangular outline")){
          	jl.setText("<html>the rectangular stone blocking the passage ahead moves back slightly,<br> but resists your efforts</html>");
          	pushes++;
          	}
          	else if (torch == true && pushes == 1 && tf.getText().equals("push rectangular outline")){
          	jl.setText("<html>the rectangular stone moves back further,<br> but appears just wide enough for you<br> to squeeze through to the subsequent passage should you choose; proceed?</html>");
          	pushes++;
          	}
          	else if (torch == true && pushes == 2 && tf.getText().equals("push rectangular outline")){
          	jl.setText("<html>the rectangular stone moves back further,<br> you are now certain you can descend to the adjoining passage</html>");	
          	}
          	else if(tf.getText().equals("yes") && pushes ==1){
         		 jl.setText("<html>seems you got stuck;<br> you'll probably be here for awhile,<br> you could try waiting</html>");
/*          	if() */
          	}
          }
      	    
          
      }
      tf.setText("");
    }
  }         
          
  
  public void restart(){
	  
  }
  public String inventory(){
	String inv = "<html>";
	for (int i = 0; i< yourInv.getList().length; i++){
		inv+= yourInv.getList()[i] + "<br>";
	}
	inv+="</html>";
	return inv;
	  
  }
  public boolean iHave(String what){
	  for (int i = 0; i<yourInv.getList().length; i++){
		  if (yourInv.getList()[i] == what){
			  return true;
		  }
	  }
	  return false;
  }
}