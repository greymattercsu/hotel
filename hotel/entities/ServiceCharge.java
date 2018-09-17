package hotel.entities;


public class ServiceCharge {
	
	private ServiceType service;
	private double cost;

	public ServiceCharge(ServiceType service, double cost) {
		this.service = service;
		this.cost = cost;
	}

	public ServiceType getType() {
		return service;
	}

	public double getCost() {
		return cost;
	}

	public String getDescription() {
		return service.getDescription();
	}

	public String toString(){
		return cost + " added to " + service;
	}


}
