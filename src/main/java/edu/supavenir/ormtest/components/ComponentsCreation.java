package edu.supavenir.ormtest.components;

import java.io.IOException;

import io.github.jeemv.springboot.vuejs.components.VueComponent;

public class ComponentsCreation {

	public static void main(String[] args) throws IOException {
		
		VueComponent button = new VueComponent("button-msg");
		button.addData("message", "Cliquer sur le bouton...");
		button.addProp("type", "success");
		button.setDefaultTemplateFile();
		//button.createFile(false);
		
		VueComponent list = new VueComponent("list-item");
		list.addPropRaw("list", "[]");
		//list.addProp("name", "name");
		list.setDefaultTemplateFile();
		//list.createFile(false);
		
		VueComponent.globalJs("button-msg.js", "list-item.js");
	}
}
