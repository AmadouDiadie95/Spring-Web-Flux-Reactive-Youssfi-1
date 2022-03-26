package org.sid.web;

import org.sid.dao.SocieteRepository;
import org.sid.dao.TransactionRepository;
import org.sid.entities.Societe;
import org.sid.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TransactionReactiveRestController {
	@Autowired
	private TransactionRepository transactionRepository ;
	
	@GetMapping(value = "/transactions")
	public Flux<Transaction> findAll(){
		return transactionRepository.findAll() ;
	}
	
	@GetMapping(value = "/transactions/{id}")
	public Mono<Transaction> GetOne(@PathVariable String id){
		return transactionRepository.findById(id) ;
	}
	
	@PostMapping("/transactions")
	public Mono<Transaction> save(@RequestBody Transaction societe) {
		return transactionRepository.save(societe) ;
	}
	
	@DeleteMapping(value = "/transactions/{id}")
	public Mono<Void> deleteOne(@PathVariable String id){
		return transactionRepository.deleteById(id) ;
	}
	
	@PutMapping("/transactions/{id}")
	public Mono<Transaction> update(@RequestBody Transaction societe, @PathVariable String id) {
		societe.setId(id);
		return transactionRepository.save(societe) ;
	}
	
	@GetMapping(value = "/streamTransactions", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Transaction> streamTransactions(){
		return transactionRepository.findAll() ;
	}
	
	@GetMapping(value = "/transactionsBySociete/{id}")
	public Flux<Transaction> TransactionsBySociete(@PathVariable String id){
		Societe societe = new Societe() ;
		societe.setId(id);
		return transactionRepository.findBySociete(societe) ;
	}
}
