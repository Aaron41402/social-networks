// Team member: Chia Long Lin, Yu Han Lai - final part1
package final_part1;

import java.util.Scanner;
import StackAndQueuePackage.*;

public class ProfileOps {
    private HashedDictionary<String, Profile> profileMap;
    private UndirectedGraph<Profile> profileGraph;

    public ProfileOps() {
        this.profileMap = new HashedDictionary<>();
        this.profileGraph = new UndirectedGraph<>();
    }

    public void addFriends() {
        if (profileGraph.isEmpty() || profileMap.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName)) {
            System.out.println("There's no such profile named " + pName + "!\n");
            return;
        }
        Profile profile = profileMap.getValue(pName);
        System.out.print("Enter the name of the friend: ");
        String fName = sc.nextLine().trim();

        Profile friendProfile;
        if (!profileMap.contains(fName)) {
            friendProfile = new Profile(fName);
        } else {
            friendProfile = profileMap.getValue(fName);
        }
        profile.addFriend(fName);
        friendProfile.addFriend(pName);
        profileMap.add(fName,friendProfile);
        profileGraph.addVertex(friendProfile);
        profileGraph.addEdge(profile, friendProfile);
    }

    public void createProfile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName)) {
            // profile not present, can add it
            Profile profile = new Profile(pName);
            profileMap.add(pName, profile);
            profileGraph.addVertex(profile);
            System.out.print("Enter profile status:\n"
                    + "1. Online\n"
                    + "2. Offline\n"
                    + "3. Busy\n"
                    + "Enter >> ");
            int stChoice = Integer.parseInt(sc.nextLine().trim());

            while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
                System.out.println("Invalid status choice!\n");
                System.out.print("Enter profile status:\n"
                        + "1. Online\n"
                        + "2. Offline\n"
                        + "3. Busy\n"
                        + "Enter >> ");
                stChoice = Integer.parseInt(sc.nextLine().trim());
            }
            if (stChoice == 1) {
                profile.setOnlineStatus();
            } else if (stChoice == 2) {
                profile.setOfflineStatus();
            } else if (stChoice == 3) {
                profile.setBusyStatus();
            } else {
                profile.setOfflineStatus();
            }
            System.out.println("Profile status set to " + profile.getStatus() + ".");

            char yesNo;
            do {
                System.out.print("Add friend? [y/n]: ");
                yesNo = sc.nextLine().trim().charAt(0);
                if (yesNo == 'N' || yesNo == 'n')
                    break;
                else if (yesNo == 'Y' || yesNo == 'y')
                {
                    System.out.print("Name of the friend: ");
                    String fName = sc.nextLine().trim();
                    Profile friendProfile;
                    if (!profileMap.contains(fName)) {
                        friendProfile = new Profile(fName);
                    } else {
                        friendProfile = profileMap.getValue(fName);
                    }
                    profile.addFriend(fName);
                    friendProfile.addFriend(pName);
                    profileMap.add(fName,friendProfile);
                    profileGraph.addVertex(friendProfile);
                    profileGraph.addEdge(profile, friendProfile);
                }
                else
                    System.out.println("Please enter y or n.\n");
            }
            while (yesNo != 'N' || yesNo != 'n');

            System.out.println("Profile has been created for " + pName + ".\n");
        }
    }

    public void searchProfile() {
        if (profileGraph.isEmpty() || profileMap.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name to search: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName))
            System.out.println("Sorry, there's no such profile named " + pName + "!\n");
        else
            System.out.println("Match found:\n" + profileMap.getValue(pName) + "\n");
    }

    public void updateProfile() {
        if (profileGraph.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name to search: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName))
            System.out.println("Sorry, there's no such profile named " + pName + "!\n");
        else {
            // update the profile
        	System.out.print("Enter new name for the profile: ");
        	String newPName = sc.nextLine().trim();
        	profileMap.getValue(pName).setName(newPName);
        	Profile profile = profileMap.getValue(pName);
        	profile.setName(newPName);
        	profileMap.remove(pName);
        	profileMap.add(newPName, profile);
            System.out.print("Enter profile status:\n"
                    + "1. Online\n"
                    + "2. Offline\n"
                    + "3. Busy\n"
                    + "Enter >> ");
            int stChoice = Integer.parseInt(sc.nextLine().trim());
            while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
                System.out.println("Invalid status choice!\n");
                System.out.print("Enter profile status:\n"
                        + "1. Online\n"
                        + "2. Offline\n"
                        + "3. Busy\n"
                        + "Enter >> ");
                stChoice = Integer.parseInt(sc.nextLine().trim());
            }
            if (stChoice == 1)
                profile.setOnlineStatus();
            else if (stChoice == 2)
                profile.setOfflineStatus();
            else if (stChoice == 3)
                profile.setBusyStatus();
            else
                profile.setOfflineStatus();

            char yesNo;
            do {
                System.out.print("Add friend? [y/n]: ");
                yesNo = sc.nextLine().trim().charAt(0);
                if (yesNo == 'N' || yesNo == 'n')
                    break;
                else if (yesNo == 'Y' || yesNo == 'y')
                {
                    System.out.print("Name of the friend: ");
                    String fName = sc.nextLine().trim();
                    Profile friendProfile;
                    if (!profileMap.contains(fName)) {
                        friendProfile = new Profile(fName);
                    } else {
                        friendProfile = profileMap.getValue(fName);
                    }
                    profile.addFriend(fName);
                    friendProfile.addFriend(pName);
                    profileMap.add(fName,friendProfile);
                    profileGraph.addVertex(friendProfile);
                    profileGraph.addEdge(profile, friendProfile);
                }
                else
                    System.out.println("Please enter y or n.\n");

            } while (yesNo != 'N' || yesNo != 'n');
            System.out.println("Profile updated successfully.\n");
        }
    }

    public void deleteProfile() {
        if (profileGraph.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name to search: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName))
            System.out.println("Sorry, there's no such profile named " + pName + "!\n");
        else {
            profileMap.remove(pName);  
            System.out.println("Profile for " + pName + " is deleted successfully.\n");
        }
    }

    public void removeFriends() {
        if (profileGraph.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name to search: ");
        String pName = sc.nextLine().trim();
        if (!profileMap.contains(pName))
            System.out.println("Sorry, there's no such profile named " + pName + "!\n");
        else {
            Profile profile = profileMap.getValue(pName);
            LinkedList<String> friends = profile.getFriends();
            System.out.println("There are " + friends.size() + " friends.");
            for (int i = 0; i < friends.size(); i++) {
                if (i == friends.size() - 1)
                    System.out.println(friends.get(i));
                else
                    System.out.print(friends.get(i) + ", ");
            }
            System.out.print("Enter the name of the friend to remove: ");
            String fName = sc.nextLine().trim();
            int c = 0;
            for (int i = 0; i < friends.size(); i++) {
                if (friends.get(i).equalsIgnoreCase(fName)) {
                    friends.remove(i);
                    c++;
                }
            }
            profileMap.remove(fName);
            if (c == 0)
                System.out.println("Sorry, there's no such friend named " + fName + "!\n");
            else
                System.out.println("Total " + c + " friend(s) were removed.\n");
        }
    }

    public void friendship() {
        if (profileGraph.isEmpty()) {
            System.out.println("No profiles yet!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter profile name to search: ");
        String pName = sc.nextLine().trim();
        Profile profile = profileMap.getValue(pName);
        //       -> A
        // Aaron -> B ---------> D
        //       -> C        |-> E
        //                   |-> F
        // Lau   -> G
        QueueInterface<Profile> queue = profileGraph.getBreadthFirstTraversal(profile);
        
        System.out.print("Enter name of the friend to search:");
        String fName = sc.nextLine().trim();
        Profile fProfile = null;
        while (!queue.isEmpty()) {
            Profile p = queue.dequeue();
            if (p.getName().equals(fName)) {
                fProfile = p;
                break;
            }
        }
        if (fProfile == null) {
            System.out.println("Friend not exist");
            return;
        }
        System.out.println(fProfile.getName() + "'s Friends are ");

        StringBuilder sb = new StringBuilder();
        QueueInterface<Profile> fQueue = profileGraph.getBreadthFirstTraversal(fProfile);
        while (!fQueue.isEmpty()) {
            Profile p = fQueue.dequeue();
            if (profileGraph.hasEdge(fProfile, p)) {
                sb.append(p.getName());
                sb.append(",");
            }
        }
        System.out.println(sb.toString() + "\n");
    }
}
