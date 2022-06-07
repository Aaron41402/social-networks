// Team member: Chia Long Lin, Yu Han Lai - final part1
package final_part1;

import java.util.Scanner;

public class Driver {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
ProfileOps profileOps = new ProfileOps();
int choice;
	  
	do
	{
		displayMenu();
		choice = Integer.parseInt(sc.nextLine().trim());
		switch(choice)
		{
			case 1:
			{
				System.out.println("----------------------"+ "\nCREATE PROFILE MODULE:\n"
						+ "----------------------");
				profileOps.createProfile();
				break;
			}
		  
			case 2:
			{
				System.out.println("----------------------"+ "\nSEARCH PROFILE MODULE:\n"
				+ "----------------------");
				profileOps.searchProfile();
				break;
			}
			  
			case 3:
			{
				System.out.println("----------------------"+ "\nADD FRIENDS MODULE:\n"
				+ "-------------------");
				profileOps.addFriends();
				break;
			}
			  
			case 4:
			{
				System.out.println("----------------------"+ "\nREMOVE FRIENDS MODULE:\n"
				+ "----------------------");
				profileOps.removeFriends();
				break;
			}
			  
			case 5:
			{
				System.out.println("----------------------"+ "\nUPDATE PROFILE MODULE:\n"
				+ "----------------------");
				profileOps.updateProfile();
				break;
			}
			  
			case 6:
			{
				System.out.println("----------------------"+ "\nDELETE PROFILE MODULE:\n"
				+ "----------------------");
				profileOps.deleteProfile();
				break;
			}
			
			case 7:
			{
				System.out.println("----------------------"+ "\nSEE FRIENDS' FRIENDS MODULE:\n"
				+ "----------------------");
				profileOps.friendship();
				break;
			}
			  
			case 0:
			{
				System.out.println("\nThanks for using out Social Networking App.\n"
				+ "Hope to see you soon..Goodbye!\n");
				System.exit(0);
			}
		
			default:
			System.out.println("\nInvalid selection!\n");
		}
	}while(choice != 0);
	}
	  
	private static void displayMenu()
	{
		System.out.print("Choose from the options:\n"
		+ "1. Create personal profile\n"
		+ "2. Search for a profile\n"
		+ "3. Add friends\n"
		+ "4. Remove friends\n"
		+ "5. Update a profile\n"
		+ "6. Delete a profile\n"
		+ "7. See friends' friends\n"
		+ "0. Log out\n"
		+ "Your selection >> ");
	}
}

/*
Choose from the options:
1. Create personal profile
2. Search for a profile
3. Add friends
4. Remove friends
5. Update a profile
6. Delete a profile
7. See friends' friends
0. Log out
Your selection >> 1
----------------------
CREATE PROFILE MODULE:
----------------------
Enter profile name: aaron
Enter profile status:
1. Online
2. Offline
3. Busy
Enter >> 1
Profile status set to Online.
Add friend? [y/n]: y
Name of the friend: a
a added as a friend.

aaron added as a friend.

Add friend? [y/n]: y
Name of the friend: b
b added as a friend.

aaron added as a friend.

Add friend? [y/n]: y
Name of the friend: c
c added as a friend.

aaron added as a friend.

Add friend? [y/n]: n
Profile has been created for aaron.

Choose from the options:
1. Create personal profile
2. Search for a profile
3. Add friends
4. Remove friends
5. Update a profile
6. Delete a profile
7. See friends' friends
0. Log out
Your selection >> 5
----------------------
UPDATE PROFILE MODULE:
----------------------
Enter profile name to search: b
Enter new name for the profile: g
Enter profile status:
1. Online
2. Offline
3. Busy
Enter >> 1
Add friend? [y/n]: y
Name of the friend: d
d added as a friend.

b added as a friend.

Add friend? [y/n]: y
Name of the friend: e
e added as a friend.

b added as a friend.

Add friend? [y/n]: y
Name of the friend: f
f added as a friend.

b added as a friend.

Add friend? [y/n]: n
Profile updated successfully.

Choose from the options:
1. Create personal profile
2. Search for a profile
3. Add friends
4. Remove friends
5. Update a profile
6. Delete a profile
7. See friends' friends
0. Log out
Your selection >> 7
----------------------
SEE FRIENDS' FRIENDS MODULE:
----------------------
Enter profile name to search: aaron
Enter name of the friend to search:g
g's Friends are 
aaron,d,e,f,

Choose from the options:
1. Create personal profile
2. Search for a profile
3. Add friends
4. Remove friends
5. Update a profile
6. Delete a profile
7. See friends' friends
0. Log out
Your selection >> 0

Thanks for using out Social Networking App.
Hope to see you soon..Goodbye!
*/