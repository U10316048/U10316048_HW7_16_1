import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PickFourCards extends JFrame implements ActionListener{
	ImageIcon[] images = new ImageIcon[52];//declare an ImageIcon named images
	static JButton refresh = new JButton("Refresh");//declare a JButton named refresh
	static Container container;//declare container
	int[] hand = new int[4];//new an array to store 4 cards
	int[] deck = new int[52];//new an array to store 52 cards randomly
	//declare four JLabel to paint 4 cards
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	
	public PickFourCards(){	
		DeckOfCards();//shuffle and deal the cards
		showCard();//paint 4 cards
		refresh.addActionListener(this);//when click the "refresh" button,invoke actionPerformed
	}
	
	public void DeckOfCards(){
		
		// Initialize cards
		for (int i = 0; i < deck.length; i++){
		deck[i] = i;
		}
		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
		// Generate an index randomly
		int index = (int)(Math.random() * deck.length);
		int temp = deck[i];
		deck[i] = deck[index]; 
		deck[index] = temp;
		}

		// Display the first four cards
		for (int i = 0; i < 4; i++) {
		hand[i] = deck[i];//4 cards assign to hand array
		}
		for(int i = 1;i<=52;i++){
			images[i-1] = new ImageIcon((getClass().getResource("card/"+i+".png")));//put 52 cards assign to images array
		}
	}
	public void showCard(){
		//setLayout
		setLayout(new FlowLayout());
		//paint 4 cards
		card1 = new JLabel(images[hand[0]]);
		add(card1);
		card2 = new JLabel(images[hand[1]]);
		add(card2);
		card3 = new JLabel(images[hand[2]]);
		add(card3);
		card4 = new JLabel(images[hand[3]]);
		add(card4);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == refresh){
			//if user click the "refresh" button,do these thing
			DeckOfCards();
			card1.setIcon(images[hand[0]]);
			card2.setIcon(images[hand[1]]);
			card3.setIcon(images[hand[2]]);
			card4.setIcon(images[hand[3]]);
		}
	}
	
	public static void main(String[] args){
		//declare GUI frame
		PickFourCards frame = new PickFourCards();
		frame.setTitle("Pick Four Cards");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10,10,400,200);
		frame.setVisible(true);
		frame.setResizable(false);
		//declare container which can adjust button size and location
		container = frame.getContentPane();
		container.setLayout(null);
		refresh.setBounds(145,120,100,30);
		container.add(refresh);
		
	}
}
