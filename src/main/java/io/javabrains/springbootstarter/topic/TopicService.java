package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;	
//	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
//			new Topic("spring","spring framework","Spring framework is the best"),
//			new Topic("java","Core Java","Java is the best"),
//			new Topic("javascript","core javascript","javscript is the best")		
//			));
//	
	public List<Topic> getAllTopics(){
//		return topics;
		//we need to convert the iterable instance from database
		List <Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return	topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}
	public void updateTopic(String id , Topic topic) {
//		for(int i = 0; i < topics.size();i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//			
//		}
		topicRepository.save(topic);
	}
	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}
