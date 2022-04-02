package fis.java.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.Entity.Oder;
import fis.java.com.Service.IOderService;

@RestController
@RequestMapping(value = "/oder")
class OderController {
	@Autowired
	private IOderService oderService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getOderByID(@PathVariable(name = "id") Long oderId) {
		return new ResponseEntity<Oder>(oderService.getOderById(oderId), HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<?> createOder(@RequestBody Oder oder) {

		return new ResponseEntity<String>(oderService.creatOder(oder), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateOder(@PathVariable(name = "id") Long oderId, String oderName,
			@RequestBody Oder oder) {
		oder.setOderId(oderId);
		oder.setOderName(oderName);
		oderService.updateOder(oder);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteOder(@PathVariable(name = "id") Long oderId) {
		oderService.deleteById(oderId);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
