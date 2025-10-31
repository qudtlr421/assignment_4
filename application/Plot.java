package application;

//reprecent rectangular area defined by upper left corner coordinates, width, depth. 

public class Plot {

// Declare fields with default values
private int x=0;
private int y=0;
private int width=1;
private int depth=1;

/**parameterized constructor: constructor: set all values
*@param x the x-coordinate of upper-left corner.
*@param y the y-coordinate of upper-left corner.
*@param width the horizontal extent
*@param depth the vertical extent
*/
public Plot(int x, int y, int width, int depth){
this.x=x;
this.y=y;
this.width= width;
this.depth = depth;
}

// copy constructor: to ease copy from another plot
public Plot(Plot other){
this.x= other.x;
this.y= other.y;
this.width = other.width;
this.depth = other.depth;
}

// getters 
public int getX(){
return x;
}

public int getY(){
return y;
}

public int getWidth(){
return width;
}

public int getDepth(){
return depth;
}

// setter
public void setX(int x){
this.x= x;
}

public void setY(int y){
this.y= y;
}

public void setWidth(int width){
this.width= width;
}

public void setDepth(int depth){
this.depth= depth;
}

/**
* check if plot overlaps with existing plots
*@param plot the plot object to be checked for overlap.
*@return true if plots overlap
*/
public boolean overlaps(Plot other){
    if (this.x+ this.width<= other.x || other.x+ other.width<= this.x)
        return false;

if (this.y+ this.depth<= other.y ||other.y + other.depth<= this.y)
        return false;
return true;
}

/**
* check if current plot encompass given plot or is the plot fully inside this one?
*@param plot to check the plot object if it is contained. 
*@return true if current plot fully contain given plot 
*/
public boolean encompasses(Plot other){
boolean containLeft= other.x >= this.x;
boolean containRight= other.x + other.width <= this.x + this.width;
boolean containTop= other.y >= this.y;
boolean containBottom= other.y + other.depth <= this.y + this.depth;

return containLeft && containRight && containTop && containBottom;
}

@Override
public String toString(){
return x + "," + y + "," + width + "," + depth;
}
}