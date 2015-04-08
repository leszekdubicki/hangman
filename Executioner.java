/**
Class for processing one word for HANGMAN project in JAVA
Author:	Leszek Dubicki
email:	Leszek.Dubicki@student.ncirl.ie
ID:	x14125439
*/
import java.util.Scanner;
public class Executioner{
	public String hang(int livesLost){
		StringBuffer gallowsBuff = new StringBuffer();
		gallowsBuff.append("    ________\n"); //13 chars in line
		gallowsBuff.append("   |        |\n");//14 chars
		gallowsBuff.append("   |        0\n");//14 chars
		gallowsBuff.append("   |       /|\\\n");//15 chars
		gallowsBuff.append("   |       / \\\n");//15 chars
		gallowsBuff.append("  / \\\n");
		gallowsBuff.append(" /   \\\n");
		gallowsBuff.append("/     \\");
		//array of indexes of characters to replace in gallowsBuff:
		int indexes[] = new int[7];
		indexes[0] = 13+13-1;
		indexes[1] = indexes[0] + 14;
		indexes[2] = indexes[1] + 13;
		indexes[3] = indexes[2] + 1;
		indexes[4] = indexes[3] + 1;
		indexes[5] = indexes[4] + 13;
		indexes[6] = indexes[5] + 2;
		//temporary scanner:
		//Scanner sc = new Scanner(System.in); int j = 2;
		for (int i = livesLost;i<7;i++){
			//System.out.println(indexes[i]);
			//j = sc.nextInt();
			gallowsBuff.replace(indexes[i],indexes[i]+1," ");
			//System.out.println(gallowsBuff);
		}

		return gallowsBuff.toString();
	}
}