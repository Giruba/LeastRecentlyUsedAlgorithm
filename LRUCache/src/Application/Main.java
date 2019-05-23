package Application;

import java.util.Scanner;
import LRUCache.LRUCache;

public class Main {
	public static void main(String[] args) {
		System.out.println("Least Recently Used Algorith implementation of a Cache");
		System.out.println("------------------------------------------------------");
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the capcity of the LRU Cache");
			int capcity = scanner.nextInt();
			LRUCache lrucache = new LRUCache(capcity);
			int choice = 1;
			do {
				System.out.println("Enter the page you would like to refer");
				int page = scanner.nextInt();
				lrucache.ReferPage(page);
				lrucache.PrintDequeueElements();
				System.out.println("Press 0 to stop, 1 to continue");
				choice = scanner.nextInt();
			}while(choice == 1);
		}catch(Exception exception) {
			System.out.println("Application:Main:main: Thrown exception is "+exception.getLocalizedMessage());
		}
	}
}
