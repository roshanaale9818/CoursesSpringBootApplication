package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//my custom repository will extend the built in crud repository for Crud operations
//@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	
	//get all topics
	//get topic given
	//updateTopic(id)
	//deleteTopic(id)
	
	
	public List<Course> findByTopicId(String topicId);
//	public List<Course> findByName(String name);

}
