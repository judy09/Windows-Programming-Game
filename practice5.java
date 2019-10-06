//------------------------------------------------------
//�d�ҵ{��5�G�Q����L�ӱ���Ⲿ��
//���{���HŪ�ɤ覡���J�a�ϡA�a���ɦW�١Fmap1.txt
//�w�]�a�Ϥj�p��8*8�A�ϥΪ̥i�H�ۦ�w�q
//�}�C�Ȼ��� : 0=�D�� ; 1=��� ; 2:���I
//�{�����w��@�W�U���s���{���X
//�{�����ϥ�Judge()�ӧP�_�O�_�I���A�w��@�P�_�O�_�I�����
//�{�����w��@��L�W�U���ʪ��{���X
//------------------------------------------------------
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class practice5 extends JFrame {
	Container c;
	Container a;
	private final JLabel actor = new JLabel();
	private final JLabel box_jpg = new JLabel();
	private final JLabel box_jpg1 = new JLabel();
	private final JLabel box_jpg2 = new JLabel();
	private final JLabel box_jpg3 = new JLabel();
	private final JLabel box_jpg4 = new JLabel();
	private final JLabel box_jpg5 = new JLabel();
	private final JLabel box_jpg6 = new JLabel();
	private final JLabel wallLabel = new JLabel();
	private final JLabel roadLabel = new JLabel();
	private final JButton UpButton = new JButton();
	private final JButton RightButton = new JButton();
	private final JButton LeftButton = new JButton();
	private final JButton DownButton = new JButton();
	private final JLabel successLabel = new JLabel();


	Icon road_icon = new ImageIcon(getClass().getResource("/png/road.png"));
	Icon wall_icon = new ImageIcon(getClass().getResource("/png/wall.png"));
	Icon black_icon = new ImageIcon(getClass().getResource("/png/black.png"));
	Icon success_icon = new ImageIcon(getClass().getResource("/png/success.png"));
	Icon box_icon = new ImageIcon(getClass().getResource("/png/box.PNG"));
	Icon ActorRight_icon = new ImageIcon(getClass().getResource("/png/01right.png"));
	Icon ActorLeft_icon = new ImageIcon(getClass().getResource("/png/01left.png"));
	Icon ActorUp_icon = new ImageIcon(getClass().getResource("/png/01up.png"));
	Icon ActorDown_icon = new ImageIcon(getClass().getResource("/png/01down.png"));

	private int map[][];                   //�G���a�Ϥ����Ʋ�
	
	private int Level_num = 0;             //��e�a�ϵ���
	int num = 0, total = 0;
	private final JLabel messageLabel = new JLabel();
	private final JLabel [][]box = new JLabel[7][7];
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			System.out.print("H");
			practice5 frame = new practice5();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public practice5() {
		super();
		setBounds(100, 100, 530, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			setForm();
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}
	
	//�]�m��ӵ���
	private void setForm() {		
		this.setTitle("���c�l�C��");
		// this.setSize(825,645);
		//�T��Τ���ܵ���j�p
		// this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�]�m���f�~�����
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

	private void boxInit(){
		if(Level_num == 1){
			getContentPane().add(box_jpg);
			box_jpg.setIcon(box_icon);
			box_jpg.setBounds(2 * 64, 4 * 64, 64, 64);
			map[4][2] = 3;
			box[4][2] = box_jpg;
			
			
			getContentPane().add(box_jpg1);
			box_jpg1.setIcon(box_icon);
			box_jpg1.setBounds(3 * 64, 5 * 64, 64, 64);
			map[5][3] = 3;
			box[5][3] = box_jpg1;
			
			getContentPane().add(box_jpg2);
			box_jpg2.setIcon(box_icon);
			box_jpg2.setBounds(4 * 64, 5 * 64, 64, 64);
			map[5][4] = 3;
			box[5][4] = box_jpg2;
			
			getContentPane().add(box_jpg3);
			box_jpg3.setIcon(box_icon);
			box_jpg3.setBounds(5 * 64, 3 * 64, 64, 64);
			map[3][5] = 3;
			box[3][5] = box_jpg3;
		}
		if(Level_num == 0){
			getContentPane().add(box_jpg);
			box_jpg.setIcon(box_icon);
			box_jpg.setBounds(2 * 64, 5 * 64, 64, 64);
			map[5][2] = 3;
			box[5][2] = box_jpg;
			
			
			getContentPane().add(box_jpg1);
			box_jpg1.setIcon(box_icon);
			box_jpg1.setBounds(3 * 64, 2 * 64, 64, 64);
			map[2][3] = 3;
			box[2][3] = box_jpg1;
			
			getContentPane().add(box_jpg2);
			box_jpg2.setIcon(box_icon);
			box_jpg2.setBounds(3 * 64, 5 * 64, 64, 64);
			map[5][3] = 3;
			box[5][3] = box_jpg2;
			
			getContentPane().add(box_jpg3);
			box_jpg3.setIcon(box_icon);
			box_jpg3.setBounds(4 * 64, 2 * 64, 64, 64);
			map[2][4] = 3;
			box[2][4] = box_jpg3;
			
			getContentPane().add(box_jpg4);
			box_jpg4.setIcon(box_icon);
			box_jpg4.setBounds(4 * 64, 5 * 64, 64, 64);
			map[5][4] = 3;
			box[5][4] = box_jpg4;
			
			getContentPane().add(box_jpg5);
			box_jpg5.setIcon(box_icon);
			box_jpg5.setBounds(5 * 64, 3 * 64, 64, 64);
			map[3][5] = 3;
			box[3][5] = box_jpg5;
			
			getContentPane().add(box_jpg6);
			box_jpg6.setIcon(box_icon);
			box_jpg6.setBounds(6 * 64, 3 * 64, 64, 64);
			map[3][6] = 3;
			box[3][6] = box_jpg6;
		}
		
	}
	
	private void jpgMap(){
		for (int i=0; i<8; i++ )
			for (int j=0; j<8; j++ )
			{	
				JLabel tmp = new JLabel();
				getContentPane().add(tmp);
				switch (map[i][j]){
				case 0: 
					tmp.setIcon(road_icon);
					break;
				case 1: 
					tmp.setIcon( wall_icon);
					break;
				case 2: 
					tmp.setIcon(success_icon);
					break;
				case 4: 
					tmp.setIcon(black_icon);
					break;
				default:
					tmp.setIcon(road_icon);
				
				}
				tmp.setBounds(0+j*64, 0+i*64,64, 64);
			}
	}
	
	private void victory()
	{
		if(num == total){
			JOptionPane.showMessageDialog(null, "�C������","���c�l",2,ActorUp_icon);	
			Level_num++;
			try
			{
				if(Level_num == 1){
					// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// JFrame.invalidate();
					// map.close();
					// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					c.removeAll();
					// a.removeAll();
					// this.drawScreen();
					// main(args[])					
					jbInit();
					 // main();
				}
			}
			catch(Exception e)
			{
				System.out.println(e+" �C������");
			}
		}
	}
	private int current_x=0, current_y=0;  //�D���Ҧb��m���y��
	private void jbInit()  throws Exception {

		a = getContentPane();
		a.addKeyListener(new ThisContentPaneKeyListener());
		if(Level_num == 1){
			num = 0; total = 4;
			c = getContentPane();
			c.setLayout(null);
			c.add(actor);
			actor.setIcon(ActorUp_icon);
			actor.setBounds(1*64, 4*64, 64, 64);
			current_x=1; 
			current_y=4;  //�D���Ҧb��m���y��
		}
		if(Level_num == 0){
			num = 0; total = 7;
			c = getContentPane();
			c.setLayout(null);
			c.add(actor);
			actor.setIcon(ActorUp_icon);
			actor.setBounds(1*64, 5*64, 64, 64);
			current_x=1; 
			current_y=5;
			
		}
		a.getFocusListeners();
		if(Level_num == 1)
			map=readMap("map1.txt");//�ŧi�@�ӤG���}�Cmap�Ӧs��readMap�^�Ǫ��G���}�C��
		if(Level_num == 0)
			map=readMap("map2.txt");
		boxInit();
		jpgMap();
	
		a.add(wallLabel);
		wallLabel.setIcon(wall_icon);
		wallLabel.setText("wall");
		wallLabel.setBounds(267, 548, 64, 64);
		
		a.add(roadLabel);
		roadLabel.setIcon(road_icon);
		roadLabel.setText("road");
		roadLabel.setBounds(337, 548, 64, 64);
		
		a.add(UpButton);
		UpButton.addActionListener(new UpButtonActionListener());
		UpButton.setText("Up");
		UpButton.setBounds(80, 548, 70, 25);
		
		a.add(RightButton);
		RightButton.addActionListener(new RightButtonActionListener());
		RightButton.setText("Right");
		RightButton.setBounds(151, 574, 70, 25);
		
		a.add(LeftButton);
		LeftButton.addActionListener(new LeftButtonActionListener());
		LeftButton.setText("Left");
		LeftButton.setText("Left");
		LeftButton.setBounds(10, 574, 70, 25);
		
		a.add(DownButton);
		DownButton.addActionListener(new DownButtonActionListener());
		DownButton.setText("Down");
		DownButton.setBounds(80, 600, 70, 25);
		
		a.setFocusable(true);
		a.requestFocus();
	}
	private int[][] readMap(String mapfile) throws FileNotFoundException {
		
		File f = new File(mapfile);			//�ŧi�@��File��Ū���a����
		int[][] map=new int[8][8];			//�ŧi�@�ӤG���}�C�s���q�a����Ū��Ӫ���
		Scanner sc = new Scanner(f);		//�Q��Scanner��Ū���a���ɪ���
			for(int i=0;i<8;i++){			//�ŧi�@�ӱ_���^���Ū���a����
				for(int j=0;j<8;j++){
					map[i][j]=sc.nextInt();	//�N�q�a����Ū���쪺�ȩ�J�}�C
				}
			}
		return map; 						//�^��Ū���쪺�G���}�C��
	}
	private class UpButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			upButton_actionPerformed(e);
		}
	}
	private class DownButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			downButton_actionPerformed(e);
		}
	}
	private class RightButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rightButton_actionPerformed(e);
		}
	}
	private class LeftButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			leftButton_actionPerformed(e);
		}
	}
	private class ThisContentPaneKeyListener extends KeyAdapter {
			
		public void keyPressed(KeyEvent e) {
			thisContentPane_keyPressed(e);
		}
	}

	protected void upButton_actionPerformed(ActionEvent e) {
		a.requestFocus();
		if(current_y>0){					//�P�_current_y�O�_�W�L�a�Ͻd��
			if(map[current_y-1][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 3){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 12){
					return;
				}
				
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 3){
					return;
				}
				
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 12){
					return;
				}
						
				if(map[current_y-1][current_x] == 0){
					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					
					return;
				}
						
				if(map[current_y-1][current_x] == 2){
					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 0){
					map[current_y-1][current_x] = 0;
					map[current_y-2][current_x] = 3;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 2){
					map[current_y-1][current_x] = 0;
					map[current_y-2][current_x] = 12;
					num++;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 0){
					map[current_y-1][current_x] = 2;
					map[current_y-2][current_x] = 3;
					num--;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 2){
					map[current_y-1][current_x] = 2;
					map[current_y-2][current_x] = 12;
				}
					
					box[current_y-1][current_x].setLocation(current_x*64, current_y*64-128);
					box[current_y-2][current_x] = box[current_y-1][current_x];
					box[current_y-1][current_x] = null;

					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					victory();
					return;				//�Yjudge()�P�_�a�Ϥ���樫�A�٭�current_y
		}
	}
	protected void downButton_actionPerformed(ActionEvent e) {
		a.requestFocus();
		if(current_y<7){
			if(map[current_y+1][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 3){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 12){
					return;
				}
				
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 3){
					return;
				}
				
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 12){
					return;
				}
						
				if(map[current_y+1][current_x] == 0){
					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					
					return;
				}
						
				if(map[current_y+1][current_x] == 2){
					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 0){
					map[current_y+1][current_x] = 0;
					map[current_y+2][current_x] = 3;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 2){
					map[current_y+1][current_x] = 0;
					map[current_y+2][current_x] = 12;
					num++;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 0){
					map[current_y+1][current_x] = 2;
					map[current_y+2][current_x] = 3;
					num--;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 2){
					map[current_y+1][current_x] = 2;
					map[current_y+2][current_x] = 12;
				}
					box[current_y+1][current_x].setLocation(current_x*64, current_y*64+128);
					box[current_y+2][current_x] = box[current_y+1][current_x];
					box[current_y+1][current_x] = null;

					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					victory();
					return;	
		}
	}

	protected void rightButton_actionPerformed(ActionEvent e) {
		a.requestFocus();
		if(current_x<7){     
			if(map[current_y][current_x+1] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 3){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 12){
					return;
				}
				
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 3){
					return;
				}
				
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 12){
					return;
				}
						
				if(map[current_y][current_x+1] == 0){
					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					
					return;
				}
						
				if(map[current_y][current_x+1] == 2){
					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 0){
					map[current_y][current_x+1] = 0;
					map[current_y][current_x+2] = 3;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 2){
					map[current_y][current_x+1] = 0;
					map[current_y][current_x+2] = 12;
					num++;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 0){
					map[current_y][current_x+1] = 2;
					map[current_y][current_x+2] = 3;
					num--;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 2){
					map[current_y][current_x+1] = 2;
					map[current_y][current_x+2] = 12;
				}
			
					box[current_y][current_x+1].setLocation(current_x*64+128, current_y*64);
					box[current_y][current_x+2] = box[current_y][current_x+1];
					box[current_y][current_x+1] = null;

					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					victory();
					return;
		}
	}
	protected void leftButton_actionPerformed(ActionEvent e) {
		a.requestFocus();
		if(current_x>0){
			if(map[current_y][current_x-1] == 1){
					return;
				}
				
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 1){
					return;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 3){
					return;
				}
				
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 12){
					return;
				}
		
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 1){
					return;
				}
				
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 3){
					return;
				}
				
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 12){
					return;
				}
				
				if(map[current_y][current_x-1] == 0){
					current_x-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x-64, y);	//���ʨ��⪺y�y�ЦV������64
					actor.setIcon(ActorLeft_icon);
					
					return;
				}
				
				if(map[current_y][current_x-1] == 2){
					current_x-=1;
					int x= actor.getX();		
					int y= actor.getY();			
					actor.setLocation(x-64, y);	
					actor.setIcon(ActorLeft_icon);
					return;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 0){
					map[current_y][current_x-1] = 0;
					map[current_y][current_x-2] = 3;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 2){
					map[current_y][current_x-1] = 0;
					map[current_y][current_x-2] = 12;
					num++;
				}
						
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 0){
					map[current_y][current_x-1] = 2;
					map[current_y][current_x-2] = 3;
					num--;
				}
						
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 2){
					map[current_y][current_x-1] = 2;
					map[current_y][current_x-2] = 12;

					
				}
					box[current_y][current_x-1].setLocation(current_x*64-128, current_y*64);
					box[current_y][current_x-2] = box[current_y][current_x-1];
					box[current_y][current_x-1] = null;

					current_x-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x-64, y);	
					actor.setIcon(ActorLeft_icon);
					victory();
					return;
		}
	}

	public void downButton_action(){
		if(current_y!=7){
			current_y++;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x, y+64);
			}
			else 	current_y--;
		}
	}
	
	public void rightButton_action(){
		if(current_x!=7){
			current_x++;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x+64, y);
			}
			else 	current_y--;
		}
	}
	
	protected boolean judge() {
		boolean result = false;
		//0:road ; 1:wall ; 2:goal
		if (map[current_y][current_x]==0)		//�Y�ثe��m��map�Ȭ�0=road
		{result = true;}						//�^�ǥi�H����
		// else if (map[current_y][current_x]==3)
		// {result = false;}
		else if (map[current_y][current_x]==2)		//�Y�ثe��m��map�Ȭ�2=goal
		{
			// JOptionPane.showMessageDialog(this, "���\�L��");
			result = true;
		}
       return result;
	}
	
	protected void thisContentPane_keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		if(keyCode==37){
			if(current_x>0){
				
				// current_x--;
				if(map[current_y][current_x-1] == 1){
					return;
				}
				
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 1){
					return;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 3){
					return;
				}
				
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 12){
					return;
				}
		
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 1){
					return;
				}
				
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 3){
					return;
				}
				
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 12){
					return;
				}
				
				if(map[current_y][current_x-1] == 0){
					current_x-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x-64, y);	//���ʨ��⪺y�y�ЦV������64
					actor.setIcon(ActorLeft_icon);
					
					return;
				}
				
				if(map[current_y][current_x-1] == 2){
					current_x-=1;
					int x= actor.getX();		
					int y= actor.getY();			
					actor.setLocation(x-64, y);	
					actor.setIcon(ActorLeft_icon);
					return;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 0){
					map[current_y][current_x-1] = 0;
					map[current_y][current_x-2] = 3;
				}
						
				if(map[current_y][current_x-1] == 3 && map[current_y][current_x-2] == 2){
					map[current_y][current_x-1] = 0;
					map[current_y][current_x-2] = 12;
					num++;
				}
						
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 0){
					map[current_y][current_x-1] = 2;
					map[current_y][current_x-2] = 3;
					num--;
				}
						
				if(map[current_y][current_x-1] == 12 && map[current_y][current_x-2] == 2){
					map[current_y][current_x-1] = 2;
					map[current_y][current_x-2] = 12;

					
				}
					box[current_y][current_x-1].setLocation(current_x*64-128, current_y*64);
					box[current_y][current_x-2] = box[current_y][current_x-1];
					box[current_y][current_x-1] = null;

					current_x-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x-64, y);	
					actor.setIcon(ActorLeft_icon);
					victory();
					return;
			}
		}
		else if(keyCode==38){
			if(current_y>0){				//�P�_current_y�O�_�W�L�a�Ͻd��
				// current_y--;					//���o���ʨ���W�誺��
				
				if(map[current_y-1][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 3){
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 12){
					return;
				}
				
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 1){
					return;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 3){
					return;
				}
				
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 12){
					return;
				}
						
				if(map[current_y-1][current_x] == 0){
					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					
					return;
				}
						
				if(map[current_y-1][current_x] == 2){
					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					return;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 0){
					map[current_y-1][current_x] = 0;
					map[current_y-2][current_x] = 3;
				}
						
				if(map[current_y-1][current_x] == 3 && map[current_y-2][current_x] == 2){
					map[current_y-1][current_x] = 0;
					map[current_y-2][current_x] = 12;
					num++;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 0){
					map[current_y-1][current_x] = 2;
					map[current_y-2][current_x] = 3;
					num--;
				}
						
				if(map[current_y-1][current_x] == 12 && map[current_y-2][current_x] == 2){
					map[current_y-1][current_x] = 2;
					map[current_y-2][current_x] = 12;
				}
					
					box[current_y-1][current_x].setLocation(current_x*64, current_y*64-128);
					box[current_y-2][current_x] = box[current_y-1][current_x];
					box[current_y-1][current_x] = null;

					current_y-=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y-64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorDown_icon);
					victory();
					return;	
			}	
		}
		else if(keyCode==39){
			if(current_x<7){
				// current_x++;
				if(map[current_y][current_x+1] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 3){
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 12){
					return;
				}
				
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 1){
					return;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 3){
					return;
				}
				
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 12){
					return;
				}
						
				if(map[current_y][current_x+1] == 0){
					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					
					return;
				}
						
				if(map[current_y][current_x+1] == 2){
					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					return;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 0){
					map[current_y][current_x+1] = 0;
					map[current_y][current_x+2] = 3;
				}
						
				if(map[current_y][current_x+1] == 3 && map[current_y][current_x+2] == 2){
					map[current_y][current_x+1] = 0;
					map[current_y][current_x+2] = 12;
					num++;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 0){
					map[current_y][current_x+1] = 2;
					map[current_y][current_x+2] = 3;
					num--;
				}
						
				if(map[current_y][current_x+1] == 12 && map[current_y][current_x+2] == 2){
					map[current_y][current_x+1] = 2;
					map[current_y][current_x+2] = 12;
				}
			
					box[current_y][current_x+1].setLocation(current_x*64+128, current_y*64);
					box[current_y][current_x+2] = box[current_y][current_x+1];
					box[current_y][current_x+1] = null;

					current_x+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x+64, y);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorRight_icon);
					victory();
					return;
			}
		}
		else if(keyCode==40){
			if(current_y<7){
				// current_y++;
				if(map[current_y+1][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 3){
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 12){
					return;
				}
				
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 1){
					return;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 3){
					return;
				}
				
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 12){
					return;
				}
						
				if(map[current_y+1][current_x] == 0){
					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					
					return;
				}
						
				if(map[current_y+1][current_x] == 2){
					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					return;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 0){
					map[current_y+1][current_x] = 0;
					map[current_y+2][current_x] = 3;
				}
						
				if(map[current_y+1][current_x] == 3 && map[current_y+2][current_x] == 2){
					map[current_y+1][current_x] = 0;
					map[current_y+2][current_x] = 12;
					num++;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 0){
					map[current_y+1][current_x] = 2;
					map[current_y+2][current_x] = 3;
					num--;
				}
						
				if(map[current_y+1][current_x] == 12 && map[current_y+2][current_x] == 2){
					map[current_y+1][current_x] = 2;
					map[current_y+2][current_x] = 12;
				}
					box[current_y+1][current_x].setLocation(current_x*64, current_y*64+128);
					box[current_y+2][current_x] = box[current_y+1][current_x];
					box[current_y+1][current_x] = null;

					current_y+=1;
					int x= actor.getX();			//���o���ʨ���ثe��X�y��
					int y= actor.getY();			//���o���ʨ���ثe��Y�y��
					actor.setLocation(x, y+64);	//���ʨ��⪺y�y�ЦV�W����64
					actor.setIcon(ActorUp_icon);
					victory();
					return;	
			}
		}
	}
}
