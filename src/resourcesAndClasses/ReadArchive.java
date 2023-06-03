package resourcesAndClasses;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadArchive {
	Scanner scanner = null;
	
	public ReadArchive() {}
	
	//READ THE ATTRACTION LIST
	public ArrayList<Sight> ReadSights(String path){
		ArrayList<Sight> MyAtraccionList = new ArrayList<Sight>();
		try {
			File file = new File(path);
			scanner = new Scanner(file);

			while(scanner.hasNextLine()) {
				String name = scanner.next();
				Double price = scanner.nextDouble();
				Double time = scanner.nextDouble();
				int quota = scanner.nextInt();
				String StringPreferency = scanner.next();
				
				//TURN THE STRING INTO A PREFECENCY
				Preferency preferency = Preferency.valueOf(StringPreferency);
				
				Sight Data = new Sight(name, price, time, quota, preferency);
				MyAtraccionList.add(Data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			scanner.close();
		}
		return MyAtraccionList;
	}
	
	public ArrayList<User> ReadUsers(String path){
		ArrayList<User> MyUserList = new ArrayList<User>();
		
		try {
			File file = new File(path);
			scanner = new Scanner(file);

			while(scanner.hasNextLine()) {
				String name = scanner.next();
				Double totalMount = scanner.nextDouble();
				Double totalTime = scanner.nextDouble();
				String StringPreferency = scanner.next();
				
				//TURN THE STRING INTO A PREFECENCY
				Preferency preferency = Preferency.valueOf(StringPreferency);
				
				User Data = new User(name, totalMount, totalTime, preferency);
				
				MyUserList.add(Data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			scanner.close();
		}
		return MyUserList;
	}
	

	public LinkedList<Promotion> ReadPromotion(String path, ArrayList<Sight> MyAtraccionList){
		LinkedList<Promotion> MyPromotionList = new LinkedList<Promotion>();
		
		try {
			File file = new File(path);
			scanner = new Scanner(file);

			while(scanner.hasNextLine()) {
				String type = scanner.next();
				char charType = type.charAt(0);
				
				if(charType == 'A') {
					int percentage = scanner.nextInt();
					String StringPreferency = scanner.next();
					
					//TURN THE STRING INTO A PREFECENCY
					Preferency preferency = Preferency.valueOf(StringPreferency);
					
					PromotionPercentual promotion = new PromotionPercentual(preferency, percentage);
					scanner.next();
					String Attraction = scanner.next();
					
					while(Attraction.charAt(0) != ']') {
						System.out.println(Attraction);
						promotion.loadSight(Attraction, MyAtraccionList);
						Attraction = scanner.next();
					}
					
					MyPromotionList.add(promotion);
				}
				
				else if(charType == 'B') {
					double price = scanner.nextInt();
					String StringPreferency = scanner.next();
					
					//TURN THE STRING INTO A PREFECENCY
					Preferency preferency = Preferency.valueOf(StringPreferency);
					
					PromotionAbsolute promotion = new PromotionAbsolute(preferency, price);
					scanner.next();
					String Attraction = scanner.next();
					
					while(Attraction.charAt(0) != ']') {
						promotion.loadSight(Attraction, MyAtraccionList);
						Attraction = scanner.next();
					}
					
					MyPromotionList.add(promotion);
				}
				
				else if(charType == 'C') {
					String StringPreferency = scanner.next();
					
					//TURN THE STRING INTO A PREFECENCY
					Preferency preferency = Preferency.valueOf(StringPreferency);
					
					PromotionFreeSights promotion = new PromotionFreeSights(preferency);
					scanner.next();
					String Attraction = scanner.next();
					promotion.addFreeSight(Attraction, MyAtraccionList);
					
					Attraction = scanner.next();

					while(Attraction.charAt(0) != ']') {
						promotion.loadSight(Attraction, MyAtraccionList);
						Attraction = scanner.next();
					}
					
					MyPromotionList.add(promotion);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			scanner.close();
		}
		return MyPromotionList;
	}
	
}
