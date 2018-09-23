import java.io.BufferedReader;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skyscraper {
	// This function is used to find max for each row in task 1.
     public static int[] findMax(int[] a){
    	 int max = a[0], maxIndex = 0;
    	 for(int i = 0; i < a.length - 1; i++){
    		if(max < a[i + 1]) {
    			max = a[i + 1];
    		    maxIndex = i + 1;
    		}
    	 }
    	 int res[] = {max, maxIndex};
    	 return res;
    }
     public static void Skyscraper1() throws IOException{
    	BufferedReader reader = null;  
 	    reader = new BufferedReader(new InputStreamReader(System.in));  
 	    String input = null; 
 	    input = reader.readLine();
 	    int tmp[] = new int[3];
 	    String[] numbersArray=input.split(" "); 
 	    for(int i = 0; i < 3; i++)
 	       tmp[i] = Integer.parseInt(numbersArray[i]);
     	int N = tmp[0], M = tmp[1], C = tmp[2];
     	int Array1[] = new int[M];
     	int Array2[] = new int[M];
     	int Array[] = new int[M];
  	    input = reader.readLine();
  	    String numbersArray1[]=input.split(" "); 
  	   for(int x = 0; x < M; x++){
 	       Array[x] = Integer.parseInt(numbersArray1[x]);
 	       if(Array[x] == C) Array1[x] = 1;
 	       else Array1[x] = 0;
 	   }
  	   int res[] = {0,0};
  	   int row = 0;
  	   for(int i = 2; i <= N; i++){
  		   input = reader.readLine();
  		   String numbersArray2[] = input.split(" ");
  		  for(int x = 0; x < M; x++){
  		       Array[x] = Integer.parseInt(numbersArray2[x]);
  		   }
  		  if(Array[0] == C) Array2[0] = 1;
  		  else Array2[0] = 0;
  		  for(int x = 1; x < M; x++){
  			  if(Array[x] == C) Array2[x] = Math.min(Array2[x - 1], Math.min(Array1[x - 1],Array1[x]))+ 1;
  			  else Array2[x] = 0;
  		  }
  		  int tem[] = findMax(Array2);
  		  if(tem[0] > res[0]){ 
  		  res = findMax(Array2);
  		  row = i;
  		  }
  		  for(int m = 0; m < M;m++)
  		  Array1[m] = Array2[m];
  	   }
  	   reader.close();
  	   int X1 = res[1] - res[0] + 2, Y1 = row - res[0] + 1, X2 = res[1] + 1, Y2 = row ;
  	   System.out.println(Y1 + " " + X1 + " " + Y2 + " " + X2);
    }
  
    // divide and conquer to find the largest rectangle for task 2
    public static int[] largestRectangleArea(int[] heights) {
    	if(heights.length == 0) {
    		int res[] = {0,0,0};
    		return res;
    	}
    	else return getArea(heights, 0, heights.length-1);
       
    }
    // helper function for divide and conquer
	public static int[] getArea(int[] heights, int left, int right) {
        if (left == right) {
           int res[] = {heights[left], left, heights[left]};
           return res;
        }
        
        int index = 0;
        int mid = (left + right) / 2;
        int hi = 0;
        // left max area
        int leftArea[] = {0,0,0}  ;
        if(mid - 1 >= left)
        leftArea = getArea(heights, left, mid-1);
        // right max area
        int rightArea[] = {0,0,0};
        if(mid + 1 <= right)
        rightArea = getArea(heights, mid+1, right);
        // mid max area, including current bar
        int i = mid, j = mid;
        int width, midArea = 0;
        int height = heights[mid];
        while (i >= left && j <= right) {
            width = j - i + 1;
            height = Math.min(height, Math.min(heights[i], heights[j]));
            if(midArea < width * height) {
            index = j;
            hi = height;
            midArea = width *height;
            }
            if (i == left) {
                j += 1;
            } else if (j == right) {
                i -= 1;
            } else if (heights[i-1] >= heights[j+1]) {
                i -= 1;
            } else {
                j += 1;
            }
        }
        
        if(midArea > leftArea[0]){
        	if(midArea > rightArea[0]){
        		int res[] = {midArea, index, hi};
        		return res;
        	}
        	else return rightArea;
        }
        else{
        	if(rightArea[0] > leftArea[0])
        		return rightArea;
        	else return leftArea;
        }
      
    }
    public static void Skyscraper2() throws IOException{
    	 BufferedReader reader = null;  
   	     reader = new BufferedReader(new InputStreamReader(System.in));  
   	     String input = null; 
   	     input = reader.readLine();
   	     int tmp[] = new int[3];
   	     String[] numbersArray=input.split(" "); 
   	     for(int i = 0; i < 3; i++)
   	         tmp[i] = Integer.parseInt(numbersArray[i]);
       	 int N = tmp[0], M = tmp[1], C = tmp[2];
       	 int h[] = new int[M];
       	
       	 int maxArea[] ={0,0,0};
       	 int row = 0;
       	 for(int ro = 1; ro <= N; ro++){
    		
    		 input = reader.readLine();
   		     String numbers[] = input.split(" ");
   		     int Array[] = new int[M];
   		     for(int x = 0; x < M; x++){
		        Array[x] = Integer.parseInt(numbers[x]);
   		     }
   		     for(int i = 0; i < M + 1; i++){
   		    	 if(i < M)
   		    		if(Array[i] == C) h[i] += 1;
   		    		else h[i] = 0;
   		         
                 
   		     }
   		  int res[] = largestRectangleArea(h);
        	 if(res[0] > maxArea[0]) {
        		 maxArea[0] = res[0];
        		 maxArea[1] = res[1] + 1;
        		 maxArea[2] = res[2];
        		 row = ro;
        	 }
    	 }
       	 int X1 = row - maxArea[2] + 1; int Y1 = maxArea[1] - maxArea[0]/maxArea[2] + 1;
       	System.out.println(X1 + " " + Y1 + " " + row + " " + maxArea[1]);
       	 reader.close();
    	
    }

    public static void Skyscraper3() throws IOException{
    	 BufferedReader reader = null;  
  	     reader = new BufferedReader(new InputStreamReader(System.in));  
  	     String input = null; 
  	     input = reader.readLine();
  	     int tmp[] = new int[3];
  	     String[] numbersArray=input.split(" "); 
  	     for(int i = 0; i < 3; i++)
  	        tmp[i] = Integer.parseInt(numbersArray[i]);
      	 int N = tmp[0], M = tmp[1], C = tmp[2];
    	 int maxarea = 0, row = 0, column = 0, length = 0, width = 0;
    	 int []h = new int[M + 1];
    	 h[0] = 0;
    	 for(int ro = 1; ro <= N; ro++){
    		 Stack<Integer> s = new Stack<Integer>();
    		 input = reader.readLine();
   		     String numbers[] = input.split(" ");
   		     int Array[] = new int[M];
   		     for(int x = 0; x < M; x++){
		        Array[x] = Integer.parseInt(numbers[x]);
   		     }
   		     for(int i = 0; i < M + 1; i++){
   		    	 if(i < M)
   		    		if(Array[i] == C) h[i] += 1;
   		    		else h[i] = 0;
   		         if (s.isEmpty()||h[s.peek()]<=h[i])
                     s.push(i);
                 else{
                     while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = 0;
                        if(s.isEmpty()) area = h[top] * i;
                        else area = h[top] * (i - s.peek() -1);
                        if (area > maxarea){
                            maxarea = area;
                            row =ro;
                            column = i;
                            length = maxarea/h[top];
                            width = h[top];
                        }
                     }
                 s.push(i);
                 }
   		     }
    	 }
    	 reader.close();
    	int X1 = column - length + 1, Y1=row - width + 1 , X2 = column , Y2 = row ;
    	System.out.println(Y1  + " " + X1 + " " + Y2 +" " + X2);

    }
    
    public static void Skyscraper4() throws IOException{
    	  BufferedReader read = null;  
         read = new BufferedReader(new InputStreamReader(System.in));  
         String input = null; 
         input = read.readLine();
         int tmp[] = new int[3];
         String[] numbersArray=input.split(" "); 
         for(int i = 0; i < 3; i++)
            tmp[i] = Integer.parseInt(numbersArray[i]);
         int N = tmp[0], M = tmp[1], C = tmp[2];

       int maxarea = 0, row = 0, column = 0, length = 0, width = 0;
       int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
       int arr[][] = new int[N][M];
       for(int i = 0; i < N; i++){
         input = read.readLine();
         numbersArray = input.split(" ");
         for(int j = 0; j < M; j++){
           arr[i][j] = Integer.parseInt(numbersArray[j]);
           if (arr[i][j] > max) max = arr[i][j];
           if( arr[i][j] < min) min = arr[i][j];
         }
       }
       if(max - C <= min) {
       	 System.out.println(1  + " " + 1 + " " + N +" " + M);
       	 return;
       }
       for(int y = min; y <= max - C; y++){
       int []h = new int[M + 1];
       h[M] = 0;
       for(int ro = 1; ro <= N; ro++){
         Stack<Integer> s = new Stack<Integer>();
           int Array[] = new int[M];
           for(int i = 0; i < M + 1; i++){
             if(i < M)
              if(arr[ro - 1][i] >= y && arr[ro - 1][i] <= y + C) h[i] += 1;
              else h[i] = 0;
               if (s.isEmpty()||h[s.peek()]<=h[i])
                     s.push(i);
                 else{
                     while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = 0;
                        if(s.isEmpty()) area = h[top] * i;
                        else area = h[top] * (i - s.peek() -1);
                        if (area > maxarea){
                            maxarea = area;
                            row =ro;
                            column = i;
                            length = maxarea/h[top];
                            width = h[top];
                        }
                     }
                 s.push(i);
                 }
           }
       }
       
       }
      
      int X1 = column - length + 1, Y1=row - width + 1 , X2 = column , Y2 = row ;
      System.out.println(Y1  + " " + X1 + " " + Y2 +" " + X2);
    }
	    
   
    public static void main(String[] args) throws IOException{
     
     
	     // check which funcition is called
      int x = Integer.parseInt(args[0]);
      if(x == 1){
	    Skyscraper1();

    }
      else if(x == 2)
        Skyscraper2();
	    else if(x == 3)
        Skyscraper3();
      else if(x == 4)
        Skyscraper4();

      
    }
}

