package com.ty.onetoone_uni.person.controller;

import java.util.Scanner;

import com.ty.onetoone_uni.person.dao.PersonDao;
import com.ty.onetoone_uni.person.dto.Aadharcard;
import com.ty.onetoone_uni.person.dto.Person;

public class PersonMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Scanner scanner=new Scanner(System.in);
		do {
			System.out.println(" 1.for save person  \n 2.for update person \n 3.for delete person\n 4.get person\n 5.for getAll paerson");
			System.out.println("Enter your choice");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the person id");
				int id=scanner.nextInt();
				System.out.println("Enter the person name");
				String name=scanner.next();
				System.out.println("Enter the phone no");
				long phone=scanner.nextLong();
				System.out.println("Enter the  address");
				String address=scanner.next();
				
				Person person=new Person();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				
				
				System.out.println("Enter the person aid");
				int aid=scanner.nextInt();
				System.out.println("Enter the  name");
				String adharname=scanner.next();
				System.out.println("Enter the  address of person");
				String addressPerson=scanner.next();

				Aadharcard aadharcard=new Aadharcard();
				person.setAadharcard(aadharcard);
				aadharcard.setAid(aid);
				aadharcard.setAname(adharname);
				aadharcard.setAaddress(addressPerson);
				
				PersonDao personDao=new PersonDao();
				personDao.savePerson(person);
					
			}
			break;
			case 2:{
				System.out.println("Enter the id for update person");
				int id=scanner.nextInt();
				System.out.println("Enter the name");
				String name=scanner.next();
				Person person=new Person();
				
				
				PersonDao personDao=new PersonDao();
				personDao.updatePerson(id, name);
				
				}
			break;
 
			case 3:{
				System.out.println("Enter the id");
				int id=scanner.nextInt();
				Person person=new Person();
				person.setId(id);
				
				PersonDao personDao=new PersonDao();
				personDao.deletePerson(id);
			}
			break;
			
			case 4:{
				System.out.println("Enter the id for get person details");
				int id=scanner.nextInt();
				Person person=new Person();
				person.setId(id);
				
				PersonDao personDao=new PersonDao();
				System.out.println(personDao.getPersonById(id));
			}
			break;
			
			case 5:{
				PersonDao personDao=new PersonDao();
				System.out.println(personDao.getAllPerson());
			}
			break;
			}
		}
		while(flag);
		}
}
