import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
  interface Buttons{   // implementing the interface 
     JButton b1=new JButton("Show Result");
    JButton b2=new JButton("Cancel");
    }
public class Quiz extends JFrame implements ActionListener, Buttons,TextListener {
 public   int count=0,i;
 public Menu Home;
 public Menu About;
 public MenuItem New;
 public MenuItem High_Score;
 public MenuItem Exit;
 public MenuBar Screen;



    public JRadioButton b[]=new JRadioButton[12];
    public JLabel label[]=new JLabel[4];
     public JFrame frame;   
     public TextField TextItem;
     public String TextValue;
    public ButtonGroup g1,g2,g3;
    public Quiz(){
        super("PROGRAMMING LANUGAGE QUIZ");

        setVisible(true);
       setLayout(new FlowLayout());
       Home=new Menu("Home");
       New=new MenuItem("New");
        High_Score=new MenuItem("High Score");
        Exit=new MenuItem("Exit");
        Screen=new MenuBar();
        Home.add(New);Home.add(High_Score);Home.add(Exit); // to add item to the menu
        Screen.add(Home);
       
        setMenuBar(Screen);  // to set the MenuBar in the screen
       
        Exit.addActionListener(this);
        New.addActionListener(this);
        High_Score.addActionListener(this);

        





        label[0]=new JLabel("1.Who is the founder of C programming LANUGAGE?");
       label[2]=new JLabel("Enter your name");

        b[0]=new JRadioButton("Denis Richtie",false);   // for creating the option

        b[1]=new JRadioButton("Bill Grates",false);
        b[2]=new JRadioButton("Sailesh Acharya",false);
        b[3]=new JRadioButton("Steve Jobes",false);
        TextItem=new TextField(10); 	// for initializing the TextField
        TextItem.addTextListener(this); // for listing the text item and taking the data from it
        
        
       for(i=0;i<=3;i++){                       // for adding the events to the JRadioButton
            b[i].addActionListener(this);

        }
        b2.addActionListener(this); // for cancel button

         label[1]=new JLabel("2.Which of these are object oriented programming");
    
        b[5]=new JRadioButton("Java",false);   // for creating the option
        b[4]=new JRadioButton("Python",false);
        b[6]=new JRadioButton("C",false);
        b[7]=new JRadioButton("PASCAL",false);
        label[3]=new JLabel("3.When was Java released from Sun microwave?");
        b[8]=new JRadioButton("1969",false);   // for creating the option
        b[9]=new JRadioButton("1979`",false);
        b[10]=new JRadioButton("1995",false);
        b[11]=new JRadioButton("1968",false);
             for(i=4;i<=7;i++){                       // for adding the events to the JRadioButton
            b[i].addActionListener(this);

        }

                 for(i=8;i<=11;i++){                       // for adding the events to the JRadioButton
            b[i].addActionListener(this);

        }



    }

public void additem(){   // for adding the item in the gui
        int i,j;      
                                            // for adding Buttons in a group     
                                                g1=new ButtonGroup();
                                                for(i=0;i<=3;i++){
                                                g1.add(b[i]);   
                                    
                                            
                                                }
                                                
                                                g2=new ButtonGroup();
                                                for(i=4;i<=7;i++){
                                                g2.add(b[i]);   
                                    
                                            
                                                }
                                                g3=new ButtonGroup();
                                                for(i=8;i<=11;i++){
                                                g3.add(b[i]);   
                                    
                                            
                                                }

                                                
                                                
         add(label[2]);
         add(TextItem);                                       
         add(label[0]);
                for (j=0;j<=3;j++){
                add(b[j]);
            
            }
        

         add(label[1]);
            for (j=4;j<=7;j++){
                add(b[j]);
            
            }

        add(label[3]);
                for (j=8;j<=11;j++){
                add(b[j]);
            }

           
            add(b1);
            add(b2);
            b1.addActionListener(this);
            

     }
     
     public void textValueChanged(TextEvent e){
		 TextValue=TextItem.getText();
     count=0;
	 }
    public  void actionPerformed(ActionEvent ae){
        String s=ae.getActionCommand();
		

        if(s.equals("Denis Richtie")) ++count;
        else if (s.equals("Java")) ++count;
        else if(s.equals("1995")) ++count;
        else if(s.equals("Cancel")) System.exit(0);
        else if(s.equals("Exit")) System.exit(0);
     
        else if(s.equals("New")){
        Quizinherit q3=new Quizinherit();   
        q3.setSize(350,500);
        q3.additem();
        q3.setVisible(true);
        q3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        }
     
        else if(s.equals("Show Result")){
			JOptionPane.showMessageDialog(frame, ""+TextValue+ " Your score is "+count);
			addData();
        
        }
      

    }
    public class  Quizinherit extends Quiz{
      
        public Quizinherit(){
            System.out.println(" Using Inheritance");

        }



    }
    public static void main(String args []){
        Quiz q1=new Quiz();
        q1.setSize(350,500);
        q1.additem();
        q1.setVisible(true);
        q1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }

    public void addData(){
	   
	    try {
      Statement stmt;
	Class.forName("com.mysql.jdbc.Driver");
	String url ="jdbc:mysql://localhost:3306/mysql";
	Connection con =DriverManager.getConnection(url,"root", "");
	stmt = con.createStatement();
	stmt.executeUpdate("use test");

	stmt.executeUpdate("INSERT INTO `quiz` (`Name`, `Score`) VALUES ('"+TextValue+"', '"+count+"'); ");



	con.close();
		}
        catch( Exception e ) {
		  e.printStackTrace();
		}//end catch
	  }//end of addData
	} //end class 


		
		
    
    
    
    
    
    
    

