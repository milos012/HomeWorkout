package rules;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sbnz.integracija.example.enums.BMICategory;
import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.facts.UserInfo;
import sbnz.integracija.example.facts.WorkoutInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class exercise_rest_duration_test {
	
	@Autowired
    private KieContainer kieContainer;
	
	
	private KieSession prepSessionWithFacts(WorkoutInfo woInfo, UserInfo uInfo) {

		KieSession testSession = kieContainer.newKieSession("HWTestSession");
		

		testSession.insert(woInfo);
		testSession.insert(uInfo);

		testSession.getAgenda().getAgendaGroup("exercise_rest").setFocus();

		return testSession;
	}
	
	private WorkoutInfo createWO(WorkoutType type) {

        WorkoutInfo woInfo = new WorkoutInfo();
        woInfo.setMuscleGroup(type);

        return woInfo;
    }
	
	private UserInfo createUser(BMICategory bmi) {

        UserInfo uInfo = new UserInfo();
        uInfo.setBMI(bmi);

        return uInfo;
    }

	@Test
	public void test_malnurished_cardio() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.CARDIO);
		UserInfo uInfo = this.createUser(BMICategory.MALNOURISHED);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_malnurished_cardio");
		System.out.println("Exercise duration: " + woInfo.getExerciseDuration());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		
		assertTrue(woInfo.getExerciseDuration() == 25);
		assertTrue(woInfo.getRestBetweenExercises() == 35);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_obese_cardio() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.CARDIO);
		UserInfo uInfo = this.createUser(BMICategory.OBESE);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_obese_cardio");
		System.out.println("Exercise duration: " + woInfo.getExerciseDuration());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		
		assertTrue(woInfo.getExerciseDuration() == 30);
		assertTrue(woInfo.getRestBetweenExercises() == 30);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_normalBMI_cardio() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.CARDIO);
		UserInfo uInfo = this.createUser(BMICategory.NORMAL);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_normalBMI_cardio");
		System.out.println("Exercise duration: " + woInfo.getExerciseDuration());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		
		assertTrue(woInfo.getExerciseDuration() == 45);
		assertTrue(woInfo.getRestBetweenExercises() == 15);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_malnurished_strength() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.ABS);
		UserInfo uInfo = this.createUser(BMICategory.MALNOURISHED);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_malnurished_strength");
		System.out.println("Rest between sets: " + woInfo.getRestBetweenSets());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		//System.out.println("Repetitions: " + woInfo.getRepetitions());
		System.out.println("Number of sets: " + woInfo.getNumberOfSets());
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		
		assertTrue(woInfo.getRestBetweenSets() == 45);
		assertTrue(woInfo.getRestBetweenExercises() == 60);
		assertTrue(woInfo.getNumberOfSets() == 3);
		assertTrue(woInfo.getNumberOfExercises() == 4);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_obese_strength() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.ARMS);
		UserInfo uInfo = this.createUser(BMICategory.OBESE);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_obese_strength");
		System.out.println("Rest between sets: " + woInfo.getRestBetweenSets());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		System.out.println("Repetitions: " + woInfo.getRepetitions());
		System.out.println("Number of sets: " + woInfo.getNumberOfSets());
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		
		assertTrue(woInfo.getRestBetweenSets() == 60);
		assertTrue(woInfo.getRestBetweenExercises() == 90);
		assertTrue(woInfo.getNumberOfExercises() == 4);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_normalBMI_strength() {
		WorkoutInfo woInfo = this.createWO(WorkoutType.BACK);
		UserInfo uInfo = this.createUser(BMICategory.NORMAL);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_obese_strength");
		System.out.println("Rest between sets: " + woInfo.getRestBetweenSets());
		System.out.println("Rest between exercises: " + woInfo.getRestBetweenExercises());
		System.out.println("Repetitions: " + woInfo.getRepetitions());
		System.out.println("Number of sets: " + woInfo.getNumberOfSets());
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		
		assertTrue(woInfo.getRestBetweenSets() == 30);
		assertTrue(woInfo.getRestBetweenExercises() == 90);
		assertTrue(woInfo.getNumberOfExercises() == 6);
	     
		testSession.dispose();
	}

}
