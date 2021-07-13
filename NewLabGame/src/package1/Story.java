package package1;
import package2.Monster_Goblin;
import package2.Monster_Zombie;
import package2.SuperMonster;
import package2.Weapon_Knife;
import package2.Weapon_LongSword;


class PlayerChances{
	public void add() {
		System.out.println("PLayer recieved his chance of action in the game");
	}
}

class PlayerPlayed extends PlayerChances{
	
	@Override
	public void add() {
		System.out.println("Player played his Chance in the game ");
	}
}


 public class Story {
  
	NGame game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	
	int silverRing;
	
	public Story(NGame g,UI userInterface,VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm=vManager;
	}
		
		public void defaultSetup() {
	        player.hp = 10;
	       
	        ui.HPLabelNumber.setText("" + player.hp);
	      
	        player.currentWeapon = new Weapon_Knife();
	        ui.WeaponLabelName.setText(player.currentWeapon.name);
	        
	        silverRing=0;
	        
	}
		
		public void selectPosition(String nextPosition) {
			
			switch(nextPosition) {
			
			case "townGate": townGate();
			break;
			
			case "talkGuard":talkGuard();
			break;
			
			case "attackGuard":attackGuard();
			break;
			
			case "crossRoad":crossRoad();
			break;
			
			case "north":north();
			break;
			
			case "east":east();
			break;
			
			case "west":west();
			break;
			
			
			
			case "fight":fight();
			break;
			
			case "playerAttack":
                playerAttack();
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "win":
                win();
                break;
            case "lose":
                lose();
                break;
            case "ending":
                ending();
                break;
            case "toTitle":
                toTitle();
                break;
			}
			
		}
		
		 public void townGate() {
		       
		        ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
		        ui.choice1.setText("Talk to the guard");
		        ui.choice2.setText("Attack the guard");
		        ui.choice3.setText("Leave");
		        ui.choice4.setText("");
		        ui.choice5.setText("");
		        
		        game.nextPosition1="talkGuard";
		        game.nextPosition2="attackGuard";
		        game.nextPosition3="crossRoad";
		        game.nextPosition4="";
		        game.nextPosition5="";
		    }

		   public void talkGuard() {
		       if(silverRing==0) {
		    	   ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
			        ui.choice1.setText(">");
			        ui.choice2.setText("");
			        ui.choice3.setText("");
			        ui.choice4.setText("");
			        ui.choice5.setText("");
			        
			        game.nextPosition1="townGate";
			        game.nextPosition2="";
			        game.nextPosition3="";
			        game.nextPosition4="";
		       }else if(silverRing==1) {
		    	   
		    	   ending();
		    	   
		    	  
		       }
		      
		   }
		 


//
		    public void attackGuard() {
		       
		        ui.mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
		        player.hp = player.hp - 3;
		        ui.HPLabelNumber.setText("" + player.hp);
		        ui.choice1.setText(">");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		        ui.choice5.setText("");
		        
		        game.nextPosition1="townGate";
		        game.nextPosition2="";
		        game.nextPosition3="";
		        game.nextPosition4="";
		    }
//
		    public void crossRoad() {
		      
		        ui.mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		        ui.choice1.setText("Go north");
		        ui.choice2.setText("Go east");
		        ui.choice3.setText("Go south");
		        ui.choice4.setText("Go west");
		        ui.choice5.setText("");
		        
		        game.nextPosition1="north";
		        game.nextPosition2="east";
		        game.nextPosition3="talkGuard";
		        game.nextPosition4="west";
		        
	
		    }


	       public void north() {
		       
		        ui.mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
		        player.hp =  player.hp + 2;
		        ui.HPLabelNumber.setText("" + player.hp);
		        ui.choice1.setText("Go south");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		        ui.choice5.setText("");
		        
		        
		        game.nextPosition1="crossRoad";
		        game.nextPosition2="";
		        game.nextPosition3="";
		        game.nextPosition4="";
		        
		    }

		   public void east() {
		       
		        ui.mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		        player.currentWeapon = new Weapon_LongSword();
		        ui.WeaponLabelName.setText(player.currentWeapon.name);
		        ui.choice1.setText("Go west");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		       
		        
		        
		        game.nextPosition1="crossRoad";
		        game.nextPosition2="";
		        game.nextPosition3="";
		        game.nextPosition4="";
		        
		    }

		   public void west() {
			   
			   int i = new java.util.Random().nextInt(100)+1;
			   if(i<80){
				   monster = new Monster_Goblin();
			   }
			   else {
				   monster = new Monster_Zombie();
			   }
			   
		       
		        ui.mainTextArea.setText("You encounter a " + monster.name + "!");
		        ui.choice1.setText("Fight");
		        ui.choice2.setText("Run");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		        
		        
		        game.nextPosition1="fight";
		        game.nextPosition2="crossRoad";
		        game.nextPosition3="";
		        game.nextPosition4="";
		    }

		   public void fight() {
		     
		        ui.mainTextArea.setText(monster.name + " HP: " + monster.hp + "\n\nWhat do you do?");
		        ui.choice1.setText("Attack");
		        ui.choice2.setText("Run");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		      
		        game.nextPosition1="playerAttack";
		        game.nextPosition2="crossRoad";
		        game.nextPosition3="";
		        game.nextPosition4="";
		        
		        
		    }
		   
		   public void playerAttack () {
			   int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
			   
			   ui.mainTextArea.setText("You attacked the Goblin and gave "+playerDamage);
			   
			   monster.hp=monster.hp-playerDamage;
			   
			   ui.choice1.setText(">");
		       ui.choice2.setText("Defend");
		       ui.choice3.setText("");
		       ui.choice4.setText("");
		       
		       if(monster.hp>0) {
		    	    game.nextPosition1="playerAttack";
			        game.nextPosition2="monsterAttack";
			        game.nextPosition3="";
			        game.nextPosition4="";
		       }else  {
		    	    game.nextPosition1="win";
			        game.nextPosition2="";
			        game.nextPosition3="";
			        game.nextPosition4="";

		       }
		       
		       
		   }
		    
		   public void playerJump() {
			   System.out.println("The player is the  real hero of this game Story !!");
		   }
		   
		   
		   public void playerJump(int damage) {
			   System.out.println("The player got the damage of "+damage);
		   }
		   
		   public void monsterAttack() {
			    int playerDamage = new java.util.Random().nextInt(monster.attack);
		        player.hp = player.hp - playerDamage;
		        ui.mainTextArea.setText(monster.attackMessage  + "\nYou received " + playerDamage + " in damage!");
		        
		        ui.HPLabelNumber.setText("" + player.hp);
		        ui.choice1.setText(">");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		     
		        if (player.hp > 0) {
		        	game.nextPosition1 = "fight";
			        game.nextPosition2 = "";
			        game.nextPosition3 = "";
			        game.nextPosition4 = "";
		        } else {
		        	game.nextPosition1= "lose";
			        game.nextPosition2 = "";
			        game.nextPosition3 = "";
			        game.nextPosition4 = "";
			        
//			        player.hp = 0;
//		            ui.HPLabelNumber.setText("" + player.hp);
//		            lose();
		        }
		        
		   }
		   
		  public void win() {
			  ui.mainTextArea.setText("Congrajulations !! You have defeated the Goblin , the monster dropped the ring  you obtained the Silver Ring!! " );
			  silverRing=1;
			  
			    ui.choice1.setText("Go east");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		        
		        game.nextPosition1="crossRoad";
		        game.nextPosition2="";
		        game.nextPosition3="";
		        game.nextPosition4="";
			  
		  }
		  
		  public void lose() {
			  ui.mainTextArea.setText("Oops!! You are defeated/dead \nGAME OVER " );
			  silverRing=1;
			  
			    ui.choice1.setText("To the Title Screen");
		        ui.choice2.setText("");
		        ui.choice3.setText("");
		        ui.choice4.setText("");
		        
		        game.nextPosition1="toTitle";
		        game.nextPosition2="";
		        game.nextPosition3="";
		        game.nextPosition4="";
			  
		  }
		  
		  public void ending() {
				
			   ui.mainTextArea.setText("Guard : Oh you killed that " + monster.name + "! Welcome to our town you are the Real hero!\n\n<THE END>");
		        ui.choice1.setVisible(false);
		        ui.choice2.setVisible(false);
		        ui.choice3.setVisible(false);
		        ui.choice4.setVisible(false);
		        ui.choice5.setVisible(false);
		       
		
		  }
		  
		  public void toTitle() {
		        defaultSetup();
		        vm.showTitleScreen();
		  }

		  
}

