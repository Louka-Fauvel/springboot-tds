package edu.supavenir.ormtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.supavenir.ormtest.models.Organization;
import edu.supavenir.ormtest.repositories.OrgaRepository;
import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;

@Controller
@RequestMapping("/org")
public class OrganizationsController {
	
	@Autowired
	private VueJS vue;
	
	@Autowired
	private OrgaRepository orgaRepository;
	
	@ModelAttribute(name = "vue")
    private VueJS getVue() {
        return this.vue;
    }
	
	@GetMapping
	public String indexAction() {
		
		vue.addData("message", "Hello World !");
		vue.addData("orgas", orgaRepository.findAll());
		vue.addMethod("remove", "let self=this;" + Http.delete("'/rest/orgas/'+ orga.id", JsArray.remove("this.orgas", "orga")), "orga");
		
		return "vueOrgas";
	}
	
	@GetMapping("/dataTable")
	public String indexDataTable() {
		
		vue.addData("orgas", orgaRepository.findAll());
		//vue.addData("headers", new String[] {"id", "name", "aliases", "domain", "actions"});
		vue.addDataRaw("headers", "[{text:'id', value:'id'}, {text:'nom', value:'name'}, {text:'aliases', value:'aliases'}, {text:'domain', value:'domain'}, {text:'actions', value:'actions'}]");
		vue.addData("dialog", false);
		vue.addData("dialogDelete", false);
		vue.addData("editedIndex", -1);
		vue.addData("editedItem", new Organization());
		
		vue.addComputed("formTitle", "return this.editedIndex === -1 ? 'Nouvelle organisation' : 'Modification'");
		
		vue.addWatcher("dialog", "val || this.close()");
		vue.addWatcher("dialogDelete", "val || this.closeDelete()");
		
		vue.addMethod("remove", "let self=this;" + Http.delete("'/rest/orgas/'+ orga.id", JsArray.remove("self.orgas", "orga")), "orga");
		vue.addMethod("close", "this.dialog=false; this.editedIndex=-1;");
		vue.addMethod("save", "");
		vue.addMethod("closeDelete", "");
		vue.addMethod("deleteItemComfirm", "");
		vue.addMethod("editItem", "this.editedIndex = this.desserts.indexOf(item)\r\n"
				+ "        this.editedItem = Object.assign({}, item)\r\n" + "        this.dialog = true");
		
		return "dataTable";
	}
	
}
