package com.stackroute.propertyownerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * This is the Entiity class that stores the auto generated sequence and updates it
 * whenever new property is added
 *
 */

@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

    //No-Arg Constructor
    
    public DatabaseSequence() {
    	
    }
    
    // Getter and Setter Methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
	}
}
