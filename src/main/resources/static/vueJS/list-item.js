//Script generated with VueComponent at Fri Oct 08 09:54:09 CEST 2021
Vue.component('list-item',{
	"props":{
		list:{
			"default":[]
			}
		}
	,"template":"<div>    <ul>        <li v-for=\"item in list\">            <slot v-bind:item=\"item\"></slot>        </li>    </ul></div>"
	}
);