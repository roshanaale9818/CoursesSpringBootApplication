package io.javabrains.springbootstarter.topic;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//we inject TopicService here declaring dependency with autowire annotation
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	//returning List of topic type importing list from java.util.List;
	public List<Topic> getAllTopics() {
		//it automatically returns response as JSON object
		return  topicService.getAllTopics();
		
	}
	
	//path variable represents the url id as string id to method which makes our job easier
	//path variable gets the parameter
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
		
	}
	
	//specify method type
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics") // this specifies post request made to /topics
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}") // this specifies post request made to /topics
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
		
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}") // this specifies delete request made to /topics
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		
	}
	
}

