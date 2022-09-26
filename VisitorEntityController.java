package com.demo.controller;

import java.util.List;

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
import com.demo.entities.VisitorEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.VisitorService;

@RestController // Handle the request
@RequestMapping(value = "/visitorentity") // map specific request path
public class VisitorEntityController {

	@Autowired
	VisitorService visitorService;

	// http://localhost:8080/UserApp/visitorentity/show
	@GetMapping(value = "/show", produces = "application/json")
	List<VisitorEntity> showVisitorEntity() {
		System.out.println("Visitor entity controller");
		List<VisitorEntity> visitorList = visitorService.showVisitorEntity();
		return visitorList;
	}

	// http://localhost:8080/UserApp/deliveryentity
	@GetMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<VisitorEntity> findById(@RequestBody VisitorEntity visitor) throws RecordNotFoundException {

		VisitorEntity Id = visitorService.findById(visitor);

		if (Id == null) {
			throw new RecordNotFoundException("VisitorEntity with this Id" + visitor.getId() + " does not Exist");

		}

		else
			return ResponseEntity.ok(Id);
	}

	// http://localhost:8080/UserApp/visitorentity
	@PostMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<VisitorEntity> add(@RequestBody VisitorEntity visitor) throws DuplicateRecordException {
		VisitorEntity Id = visitorService.add(visitor);
		if (Id.getId() == 0) {
			System.out.println("Before exception");
			throw new DuplicateRecordException("VisitorEntity with this id already Exist");
		}

		System.out.println("Visitor Entity name in controller is " + Id);
		return ResponseEntity.ok(Id);

	}

	// http://localhost:8080/UserApp/visitorentity
	@PutMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<VisitorEntity> update(@RequestBody VisitorEntity visitor) throws RecordNotFoundException {
		VisitorEntity Id = visitorService.update(visitor);
		if (Id == null) {
			throw new RecordNotFoundException("VisitorEntity with this name " + visitor.getId() + "does not Exist");

		}
		System.out.println("VisitorEntity name in controller is " + Id);
		return ResponseEntity.ok(Id);
	}

	// http://localhost:8080/UserApp/visitorentity/show2/Id
	@DeleteMapping(value = "/show2/{VisitorId}", produces = "application/json")
	public ResponseEntity<VisitorEntity> deleteVisitorById(@PathVariable("VisitorId") long VisitorId) {
		visitorService.deleteVisitorById(VisitorId);
		return new ResponseEntity<VisitorEntity>(HttpStatus.OK);
	}
}