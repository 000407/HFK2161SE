public class DependencyInjectionDemo {
	public static void main(String[] args) {
		Car car = new Car();
	}
}

class Car {
	private Engine engine;

	public Car() {
		this.engine = new Engine();
		System.out.println(this.engine.getOilPump());
	}
}

class Engine {
	private OilPump oilPump;

	public void setOilPump(OilPump pump) {
		this.oilPump = pump;
	}

	public OilPump getOilPump() {
		return this.oilPump;
	}
}
