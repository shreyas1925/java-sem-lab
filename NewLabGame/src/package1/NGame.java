//This project is written by SHREYAS R SHETTIGAR 4NI19IS094

//In this project I have covered maximum topics which were given
//The topics are as follows

//Abstract Class
//Scope and Lifetime of variables
//Declaring objects
//Instance variables of different data types
//Constructors/Methods
//this keyword
//Inheritanes
//Objects as parameters
//Access control mechanism
//Multiple THreads using Player and Monster 
//Use of super()
//Packages
//Interfaces
//Exception Handling
//String Handling is done
//Overriding and Overloading



package package1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MonsterAttack extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++) {
			System.out.println("Attack Monster\n");
			try { Thread.sleep(500);
			} catch(Exception e) {
				
			};
			
		}
	}
}

class PlayerAttack extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++) {
			System.out.println("Attack Player\n");
		}
	}
}



public class NGame {
	ChoiceHandler cHandler = new ChoiceHandler();
	
	 UI ui = new UI();
	 
	 VisibilityManager vm = new VisibilityManager(ui);
	 
	 Story story = new Story(this,ui,vm);
	 
	 String nextPosition1,nextPosition2,nextPosition3,nextPosition4,nextPosition5;
	
	 abstract class PlayerRun 
	 {
			public void jump() {
				System.out.println("Player is going to jump !!");
			}
			
			public abstract void chase();
			public abstract void dare();
		}
		
		 class PlayerChasing extends PlayerRun{
			public void chase() {
				System.out.println("Now player is chasing");
			}
			
			public void dare() {
				System.out.println("Player is now dared to chase the Monster");
			}
	 }
		 
		
		 public NGame() {
				ui.createUI(cHandler);
				story.defaultSetup();
				vm.showTitleScreen();
			}
			
			
			
			public class ChoiceHandler implements ActionListener{
				public void actionPerformed(ActionEvent event) {
					String yourCHoice = event.getActionCommand();
					
					switch (yourCHoice ){
		             case "start":
		                 vm.hideTitleScreen();
		                 story.townGate();
		                  break;
		             case "c1":story.selectPosition(nextPosition1);
		             break;
		             case "c2": 
		            	 story.selectPosition(nextPosition2);
		             break;
		             case "c3":
		            	 story.selectPosition(nextPosition3);
		             break;
		             case "c4": 
		            	 story.selectPosition(nextPosition4);
		             break;
		             case "c5":
		            	 story.selectPosition(nextPosition5);
		                 break;
		         }
				}
			}
			
			
		
	 
		public static void main(String[] args)
		{
			new NGame();
			
//			PlayerChasing a = new PlayerChasing();
			
			MonsterAttack obj1 = new MonsterAttack();
			
			PlayerAttack obj2 = new PlayerAttack();
			
			obj1.start();
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			};
			obj2.start();
			
		}
		
		
	}


