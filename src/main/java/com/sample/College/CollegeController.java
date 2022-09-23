package com.sample.College;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CollegeController {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vinay");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		boolean exit = true;
		while (exit) {
			System.out.println("-----DabbaCollege-----\n1.Insert\n2.Display\n3.Update\n4.Delete");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				EntityTransaction et = em.getTransaction();
				et.begin();
				College c1 = new College();
				c1.setBranch(s.nextInt());
				c1.setColCode(s.nextInt());
				c1.setName(s.next());
				em.persist(c1);
				et.commit();
			}
				break;
			case 2: {
				System.out.println("----Display ----\nenter the college code to display its details");
				int code = s.nextInt();
				try {
					College findCollege = em.find(College.class, code);
					System.out.println("Details are  \nNo Of branches:" + findCollege.getBranch() + "\nCollege Code:"
							+ findCollege.getColCode() + "\n College Name:" + findCollege.getName() + "\n");
				} catch (NullPointerException e) {
							System.out.println("Data is not present");
				}
			}break;
			case 3:{
				EntityTransaction et=em.getTransaction();
				et.begin();
				System.out.println("----------Update---------\n");
				try {
					int code=s.nextInt();
					College updCol=em.find(College.class, code);
					updCol.setName("New Colleg");
					em.merge(updCol);
					et.commit();
				} catch (NullPointerException e) {
					System.out.println("Data is not present");
						
				}
			}break;
			case 4:{
				System.out.println("Delete Operation");
				EntityTransaction et=em.getTransaction();
				et.begin();
				try {
					int code=s.nextInt();
					College delCollege=em.find(College.class, code);
					em.remove(delCollege);
					et.commit();
				} catch (NullPointerException e) {
					System.out.println("Record is not present");
						
				}
			}

			
			}

		}
		emf.close();
		em.close();

	}

	
}
