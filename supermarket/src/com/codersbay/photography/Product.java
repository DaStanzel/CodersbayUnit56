package com.codersbay.photography;

/**

     Im Kino seht ihr auf dem Monitor das Kinoprogramm. Dieses besteht aus verschiedensten Filmen, Uhrzeiten, einen Kinosaal und einem boolean ob das der Film ausgebucht ist.
    Erstelle eine Klasse Kinoprogramm und eine Klasse Film und erzeuge mindestens 4 Filme aus dem aktuellen Kinoprogramm welche du abbilden m�chtest
 * @author Codersbay
 *
 */
public class Product {
	private String name;
	private int stock;
	private double price;
	private String color;
	/**
	 * The Product in the card
	 * @param name
	 * @param price
	 * @param color
	 */
	public Product(String name, int stock, double price, String color) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.color = color;
	}
	public Product(Product p) {
		this(p.name,p.stock,p.price,p.color);
	}
	@Override
	public String toString() {
		return "Product [name=" + this.name + ", stock=" + this.stock + ", price=" + this.price + ", color=" + this.color + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
