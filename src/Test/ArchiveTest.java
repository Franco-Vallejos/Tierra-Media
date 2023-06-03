package Test;
import resourcesAndClasses.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;


public class ArchiveTest {

	@Test
	public void testAtracciones() {
		ReadArchive atracciones = new ReadArchive();
		
		Sight miAtraccion = new Sight("Namekusei",200,1,100,Preferency.COMBATE);
		Sight miAtraccion2 = new Sight("Tierra",300,1,100,Preferency.ACADEMICO);
		Sight miAtraccion3 = new Sight("Universo6",500,1,100,Preferency.COMBATE);
		Sight miAtraccion4 = new Sight("Vegita",200,1,100,Preferency.BANQUETE);
		Sight miAtraccion45 = new Sight("TacosDelTioNacho",300,1,100,Preferency.BANQUETE);
		Sight miAtraccion5 = new Sight("Marte",500,1,100,Preferency.COMBATE);
		Sight miAtraccion6 = new Sight("Inframundo",700,1,100,Preferency.COMBATE);		
		Sight miAtraccion25 = new Sight("UNLAM",400,1,100,Preferency.ACADEMICO);
		
		ArrayList<Sight> miListaDeAtracciones = new ArrayList<Sight>();
		miListaDeAtracciones.add(miAtraccion);
		miListaDeAtracciones.add(miAtraccion2);
		miListaDeAtracciones.add(miAtraccion3);
		miListaDeAtracciones.add(miAtraccion4);
		miListaDeAtracciones.add(miAtraccion45);
		miListaDeAtracciones.add(miAtraccion5);
		miListaDeAtracciones.add(miAtraccion6);
		miListaDeAtracciones.add(miAtraccion25);
		
		ArrayList<Sight> myAtraccionList = atracciones.ReadSights("archive/Atracciones.in.txt");
		
		//System.out.println(miListaDeAtracciones);
		//System.out.println(myAtraccionList);
		
		Assert.assertEquals(miListaDeAtracciones, myAtraccionList);	
	}
	
	@Test
	public void testUser() {
		ReadArchive UserArchive = new ReadArchive();
		
		User goku = new User("GOKU",500, 9, Preferency.COMBATE);
		User veggeta = new User("VEGETTA",700,10,Preferency.ACADEMICO);
		User trunks = new User("TRUNKS",200,15,Preferency.BANQUETE);
		User piccolo = new User("PICCOLO",100,23,Preferency.COMBATE);
		
		ArrayList<User> UserList = new ArrayList<User>();
		UserList.add(goku);
		UserList.add(veggeta);
		UserList.add(trunks);
		UserList.add(piccolo);
		ArrayList<User> ArchiveUserList = UserArchive.ReadUsers("archive/Usuarios.in.txt");
		
		//System.out.println(ArchiveUserList);
		//System.out.println(UserList);
		
		Assert.assertEquals(UserList, ArchiveUserList);
	}
	
	@Test
	public void testPromotion() {
		ReadArchive PromotionArchive = new ReadArchive();

		Sight miAtraccion = new Sight("Namekusei",200,1,100,Preferency.COMBATE);
		Sight miAtraccion2 = new Sight("Tierra",300,1,100,Preferency.ACADEMICO);
		Sight miAtraccion25 = new Sight("UNLAM",300,1,100,Preferency.ACADEMICO);
		Sight miAtraccion3 = new Sight("Universo6",500,1,100,Preferency.COMBATE);
		Sight miAtraccion45 = new Sight("TacosDelTioNacho",200,1,100,Preferency.BANQUETE);
		Sight miAtraccion4 = new Sight("Vegita",200,1,100,Preferency.BANQUETE);
		Sight miAtraccion5 = new Sight("Marte",500,1,100,Preferency.COMBATE);
		Sight miAtraccion6 = new Sight("Inframundo",700,1,100,Preferency.COMBATE);		
		
		ArrayList<Sight> miListaDeAtracciones = new ArrayList<Sight>();
		miListaDeAtracciones.add(miAtraccion);
		miListaDeAtracciones.add(miAtraccion2);
		miListaDeAtracciones.add(miAtraccion25);
		miListaDeAtracciones.add(miAtraccion3);
		miListaDeAtracciones.add(miAtraccion4);
		miListaDeAtracciones.add(miAtraccion45);
		miListaDeAtracciones.add(miAtraccion5);
		miListaDeAtracciones.add(miAtraccion6);
		/*
		LinkedList<Promotion> MyPromotionListOriginal = new LinkedList<Promotion>();
		
		PromotionPercentual promotionPer = new PromotionPercentual(Preferency.ACADEMICO, 20);
		promotionPer.loadSight("Tierra", miListaDeAtracciones);
		promotionPer.loadSight("UNLAM", miListaDeAtracciones);
		MyPromotionListOriginal.add(promotionPer);
		
		PromotionAbsolute promotionAbs = new PromotionAbsolute(Preferency.BANQUETE, 200);
		promotionAbs.loadSight("TacosDelTioNacho", miListaDeAtracciones);
		promotionAbs.loadSight("Vegita", miListaDeAtracciones);
		MyPromotionListOriginal.add(promotionAbs);
		
		PromotionFreeSights promotionFreeSight = new PromotionFreeSights(Preferency.COMBATE);
		promotionFreeSight.loadSight("Namekusei", miListaDeAtracciones);
		promotionFreeSight.loadSight("Marte", miListaDeAtracciones);
		promotionFreeSight.loadSight("Inframundo", miListaDeAtracciones);
		MyPromotionListOriginal.add(promotionFreeSight);
		*/
		//System.out.println(MyPromotionListOriginal);
		
		LinkedList<Promotion> MyPromotionList = PromotionArchive.ReadPromotion("archive/Paquetes.in.txt", miListaDeAtracciones);
		
		//System.out.println(MyPromotionList);
		
		//Assert.assertEquals(MyPromotionListOriginal, MyPromotionList);
		
	}
}
