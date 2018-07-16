package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello Pipeline, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("Greeting called with value:" + name);



        if ("oom".equals( name)){
            this.createArrays();
        }

        
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }



    private void createArrays()
	{
		int arraySize = 20;

		// Create arrays in an infinite loop
		while (true)
		{
			System.out.println("Available memory (in bytes): " + Runtime.getRuntime().freeMemory());
			int[] fillMemory = new int[arraySize];
			arraySize = arraySize * 5;
		}
	}

}
