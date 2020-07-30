package io.javabrains.springbootstarter.course;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	//we inject TopicService here declaring dependency with autowire annotation
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	//returning List of topic type importing list from java.util.List;
	
	public List<Course> getAllCourses(@PathVariable String id) {
		//it automatically returns response as JSON object
		return  courseService.getAllCourses(id);
		
	}
	
	//path variable represents the url id as string id to method which makes our job easier
	//path variable gets the parameter
	//because of primary key i.e id we can directly get data
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}
	
	//specify method type
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses") // this specifies post request made to /topics
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}") // this specifies post request made to /topics
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course,id);
	}



	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}") // this specifies delete request made to /topics
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		
	}
	
}

