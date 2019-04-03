package spittr.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count",defaultValue="20") int count) {
		return spittleRepository.findSpittles(max,count);
	}
	
	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
	public String spittles(@PathVariable long spittleId,Model model) {
		Spittle spittle = spittleRepository.findOne(spittleId);
		//999Ê±Å×³ö
		if(spittle==null) {
			throw new SpittleNotFoundException();
		}
		model.addAttribute(spittle);
		return "spittle";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(@Valid Spittle spittle,Errors errors) {
		if(errors.hasErrors()) {
			return "newSpittle";
		}
		spittleRepository.save(spittle);
		return "redirect:/spittles";
	}
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newSpittle(Model model) {
		model.addAttribute(new Spittle());
		return "newSpittle";
	}
}
