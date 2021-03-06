package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		// TODO Auto-generated constructor stub
		this.spitterRepository = spitterRepository;
	}

	public SpitterController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter,Errors errors,RedirectAttributes model) {//使用RedirectAttributes保存对象至会话，实现重定向复杂数据传递
		if(errors.hasErrors()) {
			return "registerForm";
		}
		try {
			profilePicture.transferTo(new File("/data/spittr/"+profilePicture.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spitterRepository.save(spitter);
		model.addAttribute("username",spitter.getUsername());
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable String username,Model model) {
		if(!model.containsAttribute("spitter")) {
			Spitter spitter = spitterRepository.findByUsername(username);
			model.addAttribute(spitter);
		}
		return "profile";
	}
	@RequestMapping(value="/me",method=RequestMethod.GET)
	public String showMineInfo(@RequestParam(value="username",defaultValue="apollo") String username,Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
