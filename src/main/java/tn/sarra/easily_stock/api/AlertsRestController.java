package tn.sarra.easily_stock.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.sarra.easily_stock.business.EntrepotServices;


@RestController
@RequestMapping("/alerts")
public class AlertsRestController {
	
		@Autowired
		private EntrepotServices entrepotServices;
	
	 	@GetMapping("/entrepots-capacity")
	    @ResponseBody
	    public List<String> findEntrepotsWithCapacityAlert()
	    {
	        return entrepotServices.getEntrepotsWithCapacityAlert();
	    }
}
