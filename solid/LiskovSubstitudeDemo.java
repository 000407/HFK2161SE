public class LiskovSubstitudeDemo {
	public staic void doSomethingWithADuck(Duck duck) {
		// Do something
		if (duck.getPowerSource() == PowerSource.FOOD) {
			System.out.println("This won't be done without PowerSource.FOOD");
		}
	}

	public static void main(String[] args) {
		Duck realDuck = new RealDuck();
		Duck toyDuck = new ToyDuck();

		doSomethingWithADuck(realDuck);
		doSomethingWithADuck(toyDuck);
	}
}

interface IDuck {
	PowerSource getPowerSource();
}

class LiveDuck extends IDuck {
	private PowerSource powerSource;

	public LiveDuck() {
		this.powerSource = PowerSource.FOOD;
	}

	public PowerSource getPowerSource() {
		return this.powerSource;
	}
}

class ToyDuck extends IDuck {
	private PowerSource powerSource;

	public ToyDuck() {
		this.powerSource = PowerSource.BATTERY;
	}

	public PowerSource getPowerSource() {
		return this.powerSource;
	}
}

enum PowerSource {
	FOOD,
	BATTERY;
}

interface IDog {
	void bark();
}

class GermanSheperd implements IDog {
	public void bark() {
		System.out.println("Woof!");
	}
}

class HotDog implements IDog {
	public void bark() {
		System.out.println("WTH!");
	}
}