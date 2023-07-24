package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	public  List<Car> getCarsList(){
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			cars.add(new Car("Car"+ i, "NM" + i, 342 + i));
		}
		return cars;
	}

	@GetMapping (value = "/cars")
	public String getCarsFor(@RequestParam(defaultValue = "5") int count, Model model){
		model.addAttribute("cars",getCarsList().stream().limit(count).toList());
		return "cars";
	}
}