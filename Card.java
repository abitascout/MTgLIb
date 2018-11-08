public class Card{

private String name, Type, CMC;
private double Price;
private boolean inStock, typeFirst;

public Card(String name,String cmc,String type, Double price, boolean typeF, boolean instock){
	this.setName(name);
	this.setCmc(cmc);
	this.setType(type);
	this.setPrice(price);
	this.typeFirst = typeF;
	this.inStock = instock;
	
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
public String printCard()
{
	return this.name+"\t"+this.Type+"\t"+this.CMC+"\t"+this.Price+"\t"+this.inStock;
}
public String toString()
{
	if(this.typeFirst)
	{
		return this.name.toLowerCase().charAt(0)+"";
	}
	else
	{
		return this.Type.toLowerCase().charAt(0)+"";
	}
}
}