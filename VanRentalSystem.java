import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VanRentalSystem {
	
	public static void Location(String location, String cv_name, String transmission) {
		System.out.println("Location: "+ location + cv_name + transmission);
	}

	public static void Request(String id, 
			String f_h, String f_m, String f_d,
			String t_h, String t_m, String t_d,
			String t1_num, String t1_type) {
		System.out.println("Request: " + id + f_h + f_m + f_d+ t_h + t_m + t_d + t1_num + t1_type);
		
		
	}

	public static void Change(String id, 
			String f_h, String f_m, String f_d,
			String t_h, String t_m, String t_d,
			String t1_num, String t1_type) {
		System.out.println("Change: " + id + f_h + f_m + f_d+ t_h + t_m + t_d + t1_num + t1_type);
		
		
	}
	
	public static void Cancel(String id) {
		System.out.println("Cancel: " + id);
	}

	public static void Print(String location) {
		System.out.println("Location: " + location);
	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(args[0]));	/* args[0] is the first command line argument */
			// scan through and parse then execute each line in the txt file
			while(sc.hasNext()) {
				String nextToken = sc.nextLine();
				String query[] = parseCMD(nextToken);
				if (query.length > 0) {
					switch (query[0]) {
						case "Location":
							Location(query[1], query[2], query[3]);
							break;
						case "Request":
							Request(query[1], query[2], query[3], 
									query[4], query[5], query[6], 
									query[7], query[8], query[9]);
							break;
						case "Change":
							Change(query[1], query[2], query[3], 
									query[4], query[5], query[6], 
									query[7], query[8], query[9]);
							break;
						case "Cancel":
							Cancel(query[1]);
							break;
						case "Print":
							Print(query[1]);
							break;
						default:
							throw new IllegalArgumentException("Invalid command: " + query[0]);
					}
				}
			}			
		}
		catch (FileNotFoundException e) {}
		finally {
			if (sc != null) sc.close();
		}
	}

	private static String[] parseCMD(String cmd) {
		String[] preQuery = cmd.split("\\s+");
		List<String> postQuery = new ArrayList<String>();
		String[] postArray = null;
		
		int i = 0; 
		while (i != preQuery.length) {
			if (preQuery[i].equals("#") 
				| preQuery.length == 0 
				| preQuery[0].equals("")) {
				break;
			} else {
				postQuery.add(preQuery[i]);		
			}
			i++;
		}
		
		postArray = new String[ postQuery.size() ];
		postQuery.toArray( postArray );
		
		return postArray;
	}


}
