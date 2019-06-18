package com.codersbay.photography;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Random r=new Random();
	double pocket_money =100.;
	Product[] products;
	Cinema cinema;
	public static int min(int...values) {
		int min=values[0];
		for(int i=1;i<values.length;i++)
			if(min<values[i]) {
				min=values[i];
				System.out.println("ERROR: The list must equals length!!!!");
		}
		return min;
	}
	public Main() {
		/**
		 * superMarket has Products
		 */
		String[] articleNamens= {"Shirt", "Hose", "Wachskerzen"};
		int[] articleStock= {4,2,7};
		double[] price= {33.40, 24.30,3.5};
		String[] articleColors= {"red","black","white"};
		products=new Product[min(articleNamens.length,articleStock.length,price.length,articleColors.length)];
		for(int i=0;i<products.length;i++)
			products[i]=new Product(articleNamens[i],articleStock[i],price[i],articleColors[i]);
		/**
		 * Cinema
		 */
		//Generation Movie
		Object[][] omovies = new Object[][] {
			//{String titlename,double duration
			{2.2,"James Bond: Golden egg"},
			{1.5,"Star Trek: cannot find carpet"},
			{0.5,"Amigo: Episode1: We are too light"},
			{0.5,"Landessort: Episode1: We are too light"},
			{2.5,"Die Sendung mit der Maus: Stahlerzeugung"}
		};
		Movie[] movies=new Movie[omovies.length];
		for(int m_i=0;m_i<omovies.length;m_i++) {
			movies[m_i]=new Movie((String)omovies[m_i][1],((Number)omovies[m_i][0]).doubleValue());
		}
		String movieRoomsName[] = {"1A","2A","1E","2E","3E","4E"};
		MovieRoom movieRooms[] = new MovieRoom[movieRoomsName.length];
		for(int mr_i=0;mr_i<movieRooms.length;mr_i++) {
			int hour=r.nextInt(8);
			int minute=r.nextInt(60);
			List<Movie> movies_onplay=new ArrayList<>();
			for(int n=0,s=((hour*60)+minute)*60;s<23*60*60;s+=n) {
				Movie m=movies[r.nextInt(movies.length)];
				movies_onplay.add(m);
				n=(int)Math.round(m.duration_per_hour*60*60);
			}
			Movie[] templet=new Movie[movies_onplay.size()];
			boolean[] checkedOut=new boolean[templet.length];
			for(int i=0;i<checkedOut.length;i++)
				checkedOut[i]=r.nextBoolean();
			movieRooms[mr_i]=new MovieRoom(
				LocalTime.of(hour, minute),
				movieRoomsName[mr_i],
				movies_onplay.toArray(templet),
				checkedOut
			);
		}
		cinema = new Cinema(movies,movieRooms);
	}
	public void goShopping(Scanner s) {
		ShoppingCart c;
		c=new ShoppingCart();
		String choice;
		do {
			System.out.println(String.format("POKET MONEY=  %4.2f EUR", pocket_money));
			if (pocket_money<0)
				break;
			for(int i=0;i<products.length;i++) {
				System.out.println("["+i+"]"+products[i]);
			}
			System.out.println("[Q] Bye and Quit");
			choice=s.nextLine();
			try {
				int i=Integer.parseInt(choice);
				if(i<products.length) {
					if(products[i].getStock()>0) {
						pocket_money -=products[i].getPrice();
						c.addArticle(products[i]);
					}else
						System.out.println("The product "+products[i].getName()+" is empty");
				}
					
			} catch (Exception e) {
				choice=choice.toUpperCase();
				if(choice.equals("")||choice.equals("Q")) {
					break;
				}else {
					System.out.println("You entry is invalid");
				}
			}
			
		}while(true);
		c.rechnungsDatenAusgeben();
	}
	public void goCinema() {
		int hour=11;// 5+r.nextInt(13);
		int minute=15;//r.nextInt(60);
		System.out.println("-------- [ cinema ] [time: "+String.format("%02d:%02d",hour,minute)+"] -----");
		cinema.printMovieGuide(LocalTime.of(hour, minute),10);
	}
	public static void main(String arg[]) {
		Main m = new Main();
		Scanner s = new Scanner(System.in);
		m.goShopping(s);
		m.goCinema();
		s.close();
		System.out.println("Thanks, Test");
	}
}
