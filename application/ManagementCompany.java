package application;

// management company class has array of property object and manage total rent and management fee
public class ManagementCompany{
//constants
public static final int MAX_PROPERTY = 5;
public static final int MG_WIDTH= 10;
public static final int MG_DEPTH= 10;

//attributes
private String name;
private String taxID;
private double feePercent;
private Property[] properties;
private Plot plot;
private int propertyNum;

//no-arg constructor with default values
public ManagementCompany(){
name="";
taxID= "";
feePercent = 0.0;
properties= new Property[MAX_PROPERTY];
plot = new Plot(0, 0, MG_WIDTH, MG_DEPTH);
propertyNum=0;
}

// Constructor with name, taxID, fee
public ManagementCompany(String name, String taxID, double feePercent){
this.name= name;
this.taxID= taxID;
this.feePercent = feePercent;
properties= new Property[MAX_PROPERTY];
plot = new Plot(0, 0, MG_WIDTH, MG_DEPTH);
propertyNum=0;
}

// Constructor with name, taxID, fee, plot coordinates
public ManagementCompany(String name, String taxID, double feePercent, int x, int y, int width, int depth){
this.name= name;
this.taxID= taxID;
this.feePercent = feePercent;
properties= new Property[MAX_PROPERTY];
plot = new Plot(x, y, width, depth);
propertyNum=0;
}

// Copy Constructor 
public ManagementCompany(ManagementCompany other){
this.name= other.name;
this.taxID= other.taxID;
this.feePercent = other.feePercent;
this.plot = new Plot(other.plot);
this.properties= new Property[MAX_PROPERTY];

for (int i=0; i< other.propertyNum; i++){
this.properties[i] = new Property(other.properties[i]);
}
this.propertyNum= other.propertyNum;
}

// add new property and return negative number if something went wrong
public int addProperty(Property property){
if(property== null){
return -2;
}
if(propertyNum >= MAX_PROPERTY){
return -1;
}
if(!plot.encompasses(property.getPlot())){
return -3;
}
for(int i=0; i< propertyNum; i++){
if(property.getPlot().overlaps(properties[i].getPlot())){
return -4;
}
}

properties[propertyNum]= new Property(property);
propertyNum= propertyNum+1;

return propertyNum-1;
}

// add property with coordinates
public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth){
Property property = new Property(propertyName, city, rent, owner, x, y, width, depth);
return addProperty(property);
}

//add property with plot
public int addProperty(String propertyName, String city, double rent, String owner, Plot plot){
Property property = new Property(propertyName, city, rent, owner, plot);
return addProperty(property);
}

// calculate rent payment
public double getTotalRent(){
double total=0;
for(int i=0; i < propertyNum; i++){
total+= properties[i].getRentAmount();
}
return total;
}

// get highest rent property
public Property getHighestRentPropperty(){
if(propertyNum==0){
return null;
}

Property highest = properties[0];
for(int i= 1; i< propertyNum; i++){
if(properties[i].getRentAmount()> highest.getRentAmount())
highest= properties[i];
}
return new Property(highest);
}

// remove last property
public void removeLastProperty(){
if(propertyNum>0){
properties[propertyNum-1]=null;
propertyNum--;
}
}

//check if array is full
public boolean isPropertiesFull(){
return propertyNum== MAX_PROPERTY;
}
// Count properties
public int getPropertiesCount(){
return propertyNum;
}

// validate fee
public boolean isManagementFeeValid(){
return feePercent >=0 && feePercent<= 100;
}

//getter and setters
public String getName(){
return name;
}
public String getTaxID(){
return taxID;
}
public double getMgmtFeePercentage(){
return feePercent;
}
public Plot getPlot(){
return new Plot(plot);
}
public Property[] getProperties() {
	return properties;
}
@Override
public String toString(){
	String result = "List of the Properties for "+ name + ", taxID: "+ taxID +"\n";
	result +="__________________________________\n";
	
	for (int i=0; i< propertyNum; i++) {
		if(properties[i] != null) {
			result+= properties[i].toString()+ "\n";
		}
	}
	result +="__________________________________\n";
	result +="total management Fee: "+ (getTotalRent()* feePercent/100);
return result;
}
}
