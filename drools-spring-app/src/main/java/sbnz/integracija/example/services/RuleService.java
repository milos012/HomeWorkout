package sbnz.integracija.example.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.facts.UserInfo;
import sbnz.integracija.example.facts.WorkoutInfo;
import sbnz.integracija.example.models.User;


@Service
public class RuleService {
	
	private final KieContainer kieContainer;
	
	@Autowired
	public RuleService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public UserInfo getUserInfo(User u) {
		UserInfo ui = new UserInfo(u);
		ui.setBMIbroj(ui.getWeight(), ui.getHeight());
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(ui);
		kieSession.fireAllRules();
		kieSession.dispose();
		return ui;
	}
	
	public WorkoutInfo getWorkoutInfo(UserInfo ui, WorkoutType muscleGroup) {
		WorkoutInfo woi = new WorkoutInfo(muscleGroup);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(ui);
		kieSession.insert(woi);
		kieSession.fireAllRules();
		kieSession.dispose();
		return woi;
	}
	
	public WorkoutInfo getWorkoutInfoCardio(UserInfo ui, WorkoutType muscleGroup,int duration) {
		WorkoutInfo woi = new WorkoutInfo(muscleGroup,duration);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(ui);
		kieSession.insert(woi);
		kieSession.fireAllRules();
		kieSession.dispose();
		return woi;
	}

}
