package fr.univrouen.cv21.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.univrouen.cv21.model.CV21;

@Repository
public interface CVRepository extends MongoRepository<CV21,Long>{
	

}
