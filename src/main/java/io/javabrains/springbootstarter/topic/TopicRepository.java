package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//my custom repository will extend the built in crud repository for Crud operations
//@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
	
	//get all topics
	//get topic given
	//updateTopic(id)
	//deleteTopic(id)

}
