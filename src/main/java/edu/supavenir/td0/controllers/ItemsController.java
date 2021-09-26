package edu.supavenir.td0.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.supavenir.td0.models.Element;
import edu.supavenir.td0.technics.CssMessage;

@Controller
@SessionAttributes("items")
public class ItemsController {
	
	private Element getElementByName(String nom, List<Element> items) {
		int index = items.indexOf(new Element(nom));
		return items.get(index);
	}
	
	@ModelAttribute("items")
	public List<Element> getItems() {
		return new ArrayList<>();
	}
	
	@GetMapping("/")
	public String itemsAction() {
		return "items";
	}
	
	/*@GetMapping("/testAdd")
	public RedirectView add(@SessionAttribute List<Element> items) {
		
		Element elm = new Element();
		elm.setNom("bop");
		
		if(!items.contains(elm)) {
			items.add(elm);
		}
		
		return new RedirectView("/");
	}*/
	
	@GetMapping("/items/new")
	public String itemsNew() {
		return "form";
	}
	
	@PostMapping("/items/addNew")
	public RedirectView add(Element elm, @SessionAttribute List<Element> items, RedirectAttributes attrs) {
		
		if(!items.contains(elm)) {
			items.add(elm);
			attrs.addFlashAttribute("msg", CssMessage.SuccessMessage("Elément <b>" + elm + "</b> ajouté."));
		} else {
			attrs.addFlashAttribute("msg", CssMessage.ErrorMessage("Cet élément <b>" + elm + "</b> existe déjà."));
		}
		
		
		return new RedirectView("/");
	}
	
	@GetMapping("items/inc/{nom}")
	public RedirectView incAction(@PathVariable String nom, @SessionAttribute List<Element> items) {
		
		getElementByName(nom, items).inc();
		return new RedirectView("/");
	}
	
	@GetMapping("items/dec/{nom}")
	public RedirectView decAction(@PathVariable String nom, @SessionAttribute List<Element> items) {
		
		getElementByName(nom, items).dec();
		return new RedirectView("/");
	}
	
	@GetMapping("items/delete/{nom}")
	public RedirectView deleteAction(@PathVariable String nom, @SessionAttribute List<Element> items) {
		
		System.out.println(nom);
		
		for (Element el : items) {
			if (nom.equals(el.getNom())) {
				
				items.remove(el);
				return new RedirectView("/");
				
			}
		}
		
		return new RedirectView("/");
	}
}
