public class Card{

private String name, Type, CMC;
private double Price;
private boolean inStock;

public Card(String name,String cmc,String type, Double price){
	this.setName(name);
	this.setCmc(cmc);
	this.setType(type);
	this.setPrice(price);
	inStock = true;
	
}
public void setName(String n)
{
	this.name = n;
}
public String getName()
{
	return this.name;
}

public void setType(String n)
{
	this.Type = n;
}
public String getType()
{
	return this.Type;
}
public void setCmc(String n)
{
	this.CMC = n;
}
public String getCmc()
{
	return this.CMC;
}

public void setPrice(double n)
{
	this.Price = n;
}
public double getPrice()
{
	return this.Price;
}
public void setStock(boolean n)
{
	this.inStock = n;
}
public boolean getStock()
{
	return this.inStock;
}
public String compareType()
{
	return this.Type +"\t" + this.name + "\t" + this.CMC + "\t" + this.Price + "\t" + this.inStock;
}
public String compareName()
{
	return this.name +"\t"+ this.Type +"\t"+ this.CMC +"\t$"+ this.Price +"\t"+ this.inStock;
}
public String toString()
{
	String temp = this.name +"\t"+ this.Type +"\t"+ this.CMC +"\t$"+ this.Price +"\t"+ this.inStock;
	return temp;
}
}