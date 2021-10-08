//Script generated with VueComponent at Fri Oct 08 08:57:31 CEST 2021
Vue.component('button-msg',{
	"props":{
		type:{
			"default":"success"
			}
		}
	,"data":function() {
		 return {
			"message":"Cliquer sur le bouton..."
			}
		;
		}
	,"template":"<div>    <v-btn primary @click='message=\"Hello\"'>        Afficher Message    </v-btn>        <v-alert :type=\"type\">        {{message}}    </v-alert></div>"
	}
);