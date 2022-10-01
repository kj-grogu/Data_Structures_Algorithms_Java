// Currency Exchange
// Programming challenge description:
// Given

// A list of foreign exchange rates
// A selected curreny
// A target currency
// Your goal is to calculate the max amount of the target currency to 1 unit of the selected currency through the FX transactions. Assume all transations are free and done immediately. If you cannot finish the exchange, return -1.0.

// Input:
// You will be provided a list of fx rates, a selected currency, and a target currency.

// For example:

// FX rates list: 
//   USD to JPY 1 to 109 
//   USD to GBP 1 to 0.71 
//   GBP to JPY 1 to 155
// Original currency: USD 
// Target currency : JPY
// Output:
// Calculated the max target currency will can get.

// For example:

// USD to JPY -> 109
// USD to GBP to JPY = 0.71 * 155 = 110.05 > 109, 
// so the max value will be 110.05

// Test 1
// Test Input
// Download Test 1 Input
// USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155
// USD
// JPY
// Expected Output
// Download Test 1 Output
// 110.05
// Test 2
// Test Input
// Download Test 2 Input
// USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921
// USD
// CNY
// Expected Output
// Download Test 2 Output
// -1.0

//Input For Test:
// [
//      {
//            company_name: (BlackRock)
//            ticker: (BLK)
//            stock_price: {
//                 2022-04-03: ($930)
//                 2022-04-02: ($932)
//            }
//      },
//      {
//         company_name: (Apple)
//         ticker: (APPL)
//         stock_price: {
//             2022-04-03: ($175)
//             2022-04-02: ($178)
//         }
//     }
// ]


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class CurrenyExch {
  /**
   * Iterate through each line of input.
   */
  
  public static class Tuple{
    String curr;
    Double val;
    public Tuple(String s, double d){
      curr = s;
      val = d;
    }
  }
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line, src, dst;
    src = dst = "";
    Map<String, Map<String, Double>> adjMap = new HashMap<>();
    int i = 0;
    double res = Double.MIN_VALUE;
    
    while ((line = in.readLine()) != null) {
      //System.out.println(line);
      if(i == 1){
        src = line;
      }
      else if(i == 2){
        dst = line;
      }
      if(i == 0){
        String [] arr = line.split(";");
        for(String a : arr){
          String [] brr = a.split(",");
          //System.out.println(Arrays.toString(brr));
          String from = brr[0];
          String to = brr[1];
          Double val = Double.parseDouble(brr[2]);

          if(!adjMap.containsKey(from))
            adjMap.put(from, new HashMap<>());

          adjMap.get(from).put(to, val);
        }
      }
      
      i++;
    }
    //System.out.println(adjMap);
    Queue<Tuple> que = new LinkedList<>();
    que.offer(new Tuple(src, 1.0));
    
    while(!que.isEmpty()){
      int size = que.size();
      for(int j = 0; j < size; j++){
        Tuple t = que.poll();
        //System.out.println("BFS : " + t.curr + " | " + t.val);
        if(t.curr.equals(dst)){
          res = Math.max(res, t.val);  
        }
        
        Map<String, Double> nbors = adjMap.getOrDefault(t.curr, new HashMap<>());
        
        for(String k : nbors.keySet()){
          que.offer(new Tuple(k, t.val * nbors.get(k)));
        }
        
      }
    }
    
    res = res == Double.MIN_VALUE ? -1.0 : res;
    //System.out.println(src +"|"+dst);
    System.out.println(res);
    
  }
}
