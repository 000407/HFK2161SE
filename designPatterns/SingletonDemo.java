public class SingletonDemo {
    public static void main(String[] args) {
        Provider p1 = Provider.getInstance();
        p1.provide("Hello");
        
        Provider p2 = Provider.getInstance();
        p2.provide("Hi");
        
        Provider p3 = Provider.getInstance();
        p3.provide("Ola");
    }
}

class Provider implements Iterable<String> {
    private static Provider instance;
    
    public static Provider getInstance() {
        if (instance == null) {
            instance = new Provider();
        }
        
        return instance;
    }
    
    private Provider() {
        
    }
    
    public void provide(String value) {
        System.out.println("Provider provides with value: " + value);
        System.out.println("Provider Instance ID: " + instance);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        System.out.println("Customization");
        super.forEach(action);
    }
}
