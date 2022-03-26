package org.sid.entities;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Transaction {
	private String id ;
	private Instant instant ;
	private double price ;
	// @DBRef //     DBRef sa veut dire que je veux une reference vers un object societe ki va etre stoker dans une otre collection 
	// @JsonProperty(access = Access.WRITE_ONLY)
	Societe societe ;
}
