import java.util.Arrays;
// 1603. Design Parking System
//https://leetcode.com/problems/design-parking-system/
// Easy

// 853

// 322

// Add to List

// Share
// Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

// Implement the ParkingSystem class:

// ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
// bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.
 

// Example 1:

// Input
// ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
// [[1, 1, 0], [1], [2], [3], [1]]
// Output
// [null, true, true, false, false]

// Explanation
// ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
// parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
// parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
// parkingSystem.addCar(3); // return false because there is no available slot for a small car
// parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
 

// Constraints:

// 0 <= big, medium, small <= 1000
// carType is 1, 2, or 3
// At most 1000 calls will be made to addCar
class ParkingSystem {
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        //System.out.println("Big: "+ big +" Meduim: "+ medium +" Small: "+ small);
        if(carType == 1){
            if(big >= 1){
                big-=1;
                return true;
            }
        }
        if(carType == 2){
            if(medium >= 1){
                medium-=1;
                return true;
            } 
        }
        if(carType == 3){
            if(small >= 1){
                small-=1;
                return true;
            } 
        }
        return false;
    }
public static void main(String [] args){
//["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
//[[1, 1, 0], [1], [2], [3], [1]]
String [] str = {"ParkingSystem", "addCar", "addCar", "addCar", "addCar"};
int [][] vals = {{1,1,0},{1},{2},{3},{1}};
int big = 0, medium = 0, small = 0;
String [] result = new String[str.length];
if(vals[0] != null){
	big = vals[0][0];
	medium = vals[0][1];
	small = vals[0][2];
}
ParkingSystem ps = new ParkingSystem(big,medium,small);
for(int i=0;i<str.length;i++){
	if(str[i]=="ParkingSystem")
	{
		result[i] = null;
	}
	if(i>0 && str[i] == "addCar")
	{
		if(ps.addCar(vals[i][0]) == true)
		result[i] = "true";
		else
		result[i] = "false";
	}
}
System.out.println("Result is: "+ Arrays.toString(result));
}
}