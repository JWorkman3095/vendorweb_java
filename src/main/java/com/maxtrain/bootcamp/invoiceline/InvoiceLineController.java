package com.maxtrain.bootcamp.invoiceline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maxtrain.bootcamp.invoice.Invoice;
import com.maxtrain.bootcamp.invoice.InvoiceRepository;

@CrossOrigin
//sending and receiving json
@RestController
@RequestMapping("/api/invoicelines")
public class InvoiceLineController {
	
	@Autowired
	private InvoiceLineRepository inLiRepo;
	
	@GetMapping // ALL
	public ResponseEntity<Iterable<InvoiceLine>> getInvoiceLine() {
		var invoiceLine = inLiRepo.findAll();
		return new ResponseEntity<Iterable<InvoiceLine>>(invoiceLine, HttpStatus.OK);
	}
	@GetMapping("{id}") // PK
	public ResponseEntity<InvoiceLine> getInvoiceLine(@PathVariable int id) {
		var InvoiceLine = inLiRepo.findById(id);
		if(InvoiceLine.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<InvoiceLine>(InvoiceLine.get(), HttpStatus.OK);
	}
	@PostMapping // ADD POST
	public ResponseEntity<InvoiceLine> postInvoiceLine(@RequestBody InvoiceLine invoiceLine) {
		if (invoiceLine == null || invoiceLine.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var inv = inLiRepo.save(invoiceLine);
		return new ResponseEntity<InvoiceLine>(inv, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}") // Add PUT
	public ResponseEntity putInvoiceLine(@PathVariable int id, @RequestBody InvoiceLine invoiceLine) {
		if (invoiceLine == null || invoiceLine.getId() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var inLi = inLiRepo.findById(invoiceLine.getId());
		if(inLi.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		inLiRepo.save(invoiceLine);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteInvoiceLine(@PathVariable int id) {
		var invoiceLine = inLiRepo.findById(id);
		if (invoiceLine.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		inLiRepo.delete(invoiceLine.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
