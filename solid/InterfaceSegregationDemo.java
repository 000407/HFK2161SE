class InterfaceSegregationDemo {
	public static void main(String[] args) {
		
	}
}

abstract class Dog {
	public abstract void bark();

	public abstract void wiggleTail();

	public abstract void sniff();
}

interface IPoliceDog {
	void sniffForDrugs();

	void sniffForCriminal();
}

interface IWorkDog {
	void pull(Sled s);
}

interface IFetchDog {
	Object fetch(Object o);
}

interface Sled {

}

class HouseholdGermanSheperd extends Dog implements IFetchDog {

}

class PoliceGermanSheperd extends Dog implements IFetchDog, IPoliceDog {

}