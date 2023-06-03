package resourcesAndClasses;

public class PromotionPercentual extends Promotion {
	
	private double percentual;
	
	public PromotionPercentual(Preferency type, int percentual) {
		super(type);
		this.percentual = percentual;
		// TODO Auto-generated constructor stub
	}


	@Override
	public double getDiscount() {
		return this.getCost() * (this.percentual/100);
	}
	
	public void setDiscount(int discount) {
		this.percentual = discount;
	}
	
	

}
