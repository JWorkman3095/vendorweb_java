package com.maxtrain.bootcamp.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
//sending and receiving json
@RestController
@RequestMapping("/api/invoices") 

public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invRepo;
	
	@GetMapping // ALL
	public ResponseEntity<Iterable<Invoice>> getInvoice() {
		var invoice = invRepo.findAll();
		return new ResponseEntity<Iterable<Invoice>>(invoice, HttpStatus.OK);
	}
	
	@GetMapping("{id}") // PK
	public ResponseEntity<Invoice> getInvoice(@PathVariable int id) {
		var Invoice = invRepo.findById(id);
		if(Invoice.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Invoice>(Invoice.get(), HttpStatus.OK);
	}
	@PostMapping // ADD POST
	public ResponseEntity<Invoice> postInvoice(@RequestBody Invoice invoice) {
		if (invoice == null || invoice.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var inv = invRepo.save(invoice);
		return new ResponseEntity<Invoice>(inv, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}") // Add PUT
	public ResponseEntity putInvoice(@PathVariable int id, @RequestBody Invoice invoice) {
		if (invoice == null || invoice.getId() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var inv = invRepo.findById(invoice.getId());
		if(inv.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		invRepo.save(invoice);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteInvoice(@PathVariable int id) {
		var invoice = invRepo.findById(id);
		if (invoice.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		invRepo.delete(invoice.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
