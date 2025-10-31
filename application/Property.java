package application;

public class Property{
// declaire property variables with default values
private String propertyName;
private String city;
private double rentalPrice;
private String owner;
private Plot plot;

// No-Arg constructor with default values
public Property(){
this.propertyName="";
this.city="";
this.rentalPrice=0.0;
this.owner="";
this.plot= new Plot();
}

// constructor with 4 parameters with default plot
public Property(String propertyName, String city, double rentalPrice, String owner){
this.propertyName= propertyName;
this.city= city;
this.rentalPrice= rentalPrice;
this.owner= owner;
this.plot= new Plot(0,0,1,1);
}

// constructor with location (x,y, width, depth)
public Property(String propertyName, String city, double rentalPrice, String owner, int x, int y, int width, int depth){
this.propertyName= propertyName;
this.city= city;
this.rentalPrice= rentalPrice;
this.owner= owner;
this.plot= new Plot(x,y,width, depth);
}

// constructor accepts existing plot object
public Property(String propertyName, String city, double rentalPrice, String owner, Plot plot){
this.propertyName= propertyName;
this.city= city;
this.rentalPrice= rentalPrice;
this.owner= owner;

if(plot == null){
this.plot = new Plot();
} else{
this.plot= new Plot(plot);
}
}

// copy constructor
public Property(Property otherProperty){
this.propertyName= otherProperty.propertyName;
this.city= otherProperty.city;
this.rentalPrice= otherProperty.rentalPrice;
this.owner= otherProperty.owner;
this.plot= new Plot(otherProperty.plot);
}

//Getter
public String getPropertyName(){
return propertyName;
}

public String getCity(){
return city;
}

public double getRentAmount(){
return rentalPrice;
}

public String getOwner(){
return owner;
}

public Plot getPlot(){
return new Plot(plot);
}

//Setters
public void setPropertyName(String propertyName){
this.propertyName= propertyName;
}

public void setCity(String city){
this.city= city;
}

public void setRentalAmount(double rentalPrice){
this.rentalPrice= rentalPrice;
}

public void setOwner(String owner){
this.owner= owner;
}

public void setPlot(Plot plot){
this.plot= new Plot(plot);
}

@Override
public String toString(){
return propertyName+ ","+ city + "," + owner + "," + String.format("%.1f", rentalPrice);
}
}









