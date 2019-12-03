package hello;

public class HelloService {
    HelloRepository helloRepository = new HelloRepository();

    public String get() {
        return helloRepository.get();
    }
}
