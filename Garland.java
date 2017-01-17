/**
* @author Alejandro Parana
* @date 3/12/2015
**/

import java.io.*;
import java.util.*;

import java.util.Map.Entry;

public class Garland {
    public static void main (String args[]) throws IOException {
        Map<String, Integer> tree = new TreeMap<String, Integer>();
        BufferedReader in = new BufferedReader(new FileReader("FILENAME.txt"));
        String line, str, symbols = " .,<>~!@#$%^&*()-_:;+=+[]<>?\"\\|";
        List<String> list = new ArrayList<String>();

        for (int i = 1; ((line = in.readLine()) != null); i++) {
            StringTokenizer t = new StringTokenizer(line, symbols);
            while (t.hasMoreElements()) {
                str = t.nextToken().toLowerCase();
                if ((!(Character.isDigit(str.charAt(0))) && str.length() >=2))
                    list.add(str);
            }
        }       
        for(String s : list) {
            tree.put(s, gCheck(s));
        }
        for (Entry<String, Integer> entry : tree.entrySet())
            if (entry.getValue() != 0)
                System.out.println("garland(\" " + entry.getKey() + " \") -> " + entry.getValue()); 
    }
    public static int gCheck(String str) {
        int len = str.length();
        for(int i = len-1; i >= 0; i--) {
            if(str.substring(0,i).equalsIgnoreCase(str.substring(len-i))) 
                return i;
        }
        return 0;
    }
}