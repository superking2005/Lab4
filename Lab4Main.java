// Lab 4 - Binary Search Trees
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates a BST with user interactivity.

package lab4;

import java.util.*;
import java.io.*;

public class Lab4Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TODO: Create output file
		Scanner scnr = new Scanner(System.in);
		try {
			File lab4BSTtxt = new File("lab4BST.txt");
			if (lab4BSTtxt.createNewFile()) {
				System.out.println("File created:" + lab4BSTtxt.getName());
			} else {
				System.out.println("File " + lab4BSTtxt.getName() + " already exists");
			}
		} catch (IOException unableToCreate) {
			System.out.println("File could not be created");
		}
		FileOutputStream fileStream = new FileOutputStream("Lab4BST.txt");
		PrintWriter outFS = new PrintWriter(fileStream);
		
		BST kroneBST = new BST();
		
		kroneBST.insert(57.12);
		kroneBST.insert(23.44);
		kroneBST.insert(87.43);
		kroneBST.insert(68.99);
		kroneBST.insert(111.22);
		
		kroneBST.insert(44.55);
		kroneBST.insert(77.77);
		kroneBST.insert(18.36);
		kroneBST.insert(543.21);
		kroneBST.insert(20.21);
		
		kroneBST.insert(345.67);
		kroneBST.insert(36.18);
		kroneBST.insert(48.48);
		kroneBST.insert(101.00);
		kroneBST.insert(11.00);
		
		kroneBST.insert(21.00);
		kroneBST.insert(51.00);
		kroneBST.insert(1.00);
		kroneBST.insert(251.00);
		kroneBST.insert(151.00);
		
		// TODO: breadth-first
		System.out.println("Breadth-first");
		System.out.println(kroneBST.breadthFirst());
		// inOrder
		System.out.println("In-order");
		System.out.println(kroneBST.inOrder(kroneBST.getRoot()));
		// preOrder
		System.out.println("Pre-order");
		System.out.println(kroneBST.preOrder(kroneBST.getRoot()));
		// postOrder
		System.out.println("Post-order");
		System.out.println(kroneBST.postOrder(kroneBST.getRoot()));
		
		
		System.out.print("1: Search ");
		System.out.print("2: Add ");
		System.out.print("3: Delete ");
		System.out.print("4: Print ");
		System.out.print("5: Quit \n");
		boolean quit = false;
		while (!quit) {
			System.out.print("Select operation: ");
			int userSel = scnr.nextInt();
			switch (userSel) {
			case 1: // Search
				System.out.print("Enter Krone to search for: ");
				double searchVal = scnr.nextDouble();
				String searchRes = "If user sees this, something went wrong.";
				try {
					searchRes = kroneBST.searchRecur(kroneBST.getRoot(), searchVal).getData().print();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(searchRes);
				break;
			case 2: // Add
				System.out.print("Enter value of new Krone: ");
				double newVal = scnr.nextDouble();
				kroneBST.insert(newVal);
				break;
			case 3: // Delete
				System.out.print("Enter value to delete: ");
				double toDel = scnr.nextDouble();
				kroneBST.delete(toDel);
				break;
			
			case 4: // Print
				System.out.println("1: Breadth-first 2: In-order 3: Pre-order 4: Post-order 5: All");
				System.out.print("Select traversal method: ");
				int travMtd = scnr.nextInt();
				switch (travMtd) {
				case 1:
					kroneBST.breadthFirst();
					break;
				case 2:
					kroneBST.inOrder();
					break;
				case 3:
					kroneBST.preOrder();
					break;
				case 4:
					kroneBST.postOrder();
					break;
				case 5:
					kroneBST.breadthFirst();
					kroneBST.inOrder();
					kroneBST.preOrder();
					kroneBST.postOrder();
					break;
				default:
					System.out.println("I don't have a case for: " + travMtd);
				}
				break;
			case 5: // Exit
				quit = true;
				// kroneBST.breadthFirst(kroneBST.getRoot());
				kroneBST.inOrder();
				kroneBST.preOrder();
				kroneBST.postOrder();
			default:
				System.out.println("I don't have a case for: " + userSel);
			}
		}

	}

}
