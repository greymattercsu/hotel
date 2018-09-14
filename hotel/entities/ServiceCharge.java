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

	/* override equal method, so that .equals method comare value instead of refrence */
	@Override
    public boolean equals(Object o) {
        if (!(o instanceof ServiceCharge))
            return false;
        ServiceCharge other = (ServiceCharge) o;
        return other.service.equals(this.service)&&
               other.cost == this.cost;
    }

}
