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

import sbnz.integracija.example.enums.PhysicalLevel;
import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.facts.UserInfo;
import sbnz.integracija.example.facts.WorkoutInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class physical_level_test {
	
	@Autowired
    private KieContainer kieContainer;
	
	
	private KieSession prepSessionWithFacts(WorkoutInfo woInfo, UserInfo uInfo) {

		KieSession testSession = kieContainer.newKieSession("HWTestSession");

		testSession.insert(woInfo);
		testSession.insert(uInfo);

		testSession.getAgenda().getAgendaGroup("pl").setFocus();

		return testSession;
	}
	
	private WorkoutInfo createWOCardio(int difficulty) {

        WorkoutInfo woInfo = new WorkoutInfo();
        woInfo.setDifficulty(difficulty);;
        woInfo.setMuscleGroup(WorkoutType.CARDIO);
        woInfo.setNumberOfExercises(10);

        return woInfo;
    }
	
	private UserInfo createUser(PhysicalLevel pl) {

        UserInfo uInfo = new UserInfo();
        uInfo.setPl(pl);

        return uInfo;
    }

	@Test
	public void test_beginner_easy_cardio() {
		WorkoutInfo woInfo = this.createWOCardio(1);
		UserInfo uInfo = this.createUser(PhysicalLevel.BEGINNER);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_beginner_easy_cardio");
		System.out.println("Total number of exercises is 10.");
		System.out.println("Number of easy exercises: " + woInfo.getNumberOfEasyExercises());
		System.out.println("Number of hard exercises: " + woInfo.getNumberOfHardExercises());
		
		assertTrue(woInfo.getNumberOfEasyExercises() == 4);
		assertTrue(woInfo.getNumberOfHardExercises() == 6);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_intermediate_easy_cardio() {
		WorkoutInfo woInfo = this.createWOCardio(1);
		UserInfo uInfo = this.createUser(PhysicalLevel.INTERMEDIATE);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_intermediate_easy_cardio");
		System.out.println("Total number of exercises is 10.");
		System.out.println("Number of easy exercises: " + woInfo.getNumberOfEasyExercises());
		System.out.println("Number of hard exercises: " + woInfo.getNumberOfHardExercises());
		
		assertTrue(woInfo.getNumberOfEasyExercises() == 3);
		assertTrue(woInfo.getNumberOfHardExercises() == 7);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_advanced_easy_cardio() {
		WorkoutInfo woInfo = this.createWOCardio(1);
		UserInfo uInfo = this.createUser(PhysicalLevel.ADVANCED);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_advanced_easy_cardio");
		System.out.println("Total number of exercises is 10.");
		System.out.println("Number of easy exercises: " + woInfo.getNumberOfEasyExercises());
		System.out.println("Number of hard exercises: " + woInfo.getNumberOfHardExercises());
		
		assertTrue(woInfo.getNumberOfEasyExercises() == 2);
		assertTrue(woInfo.getNumberOfHardExercises() == 8);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_beginner_hard_cardio() {
		WorkoutInfo woInfo = this.createWOCardio(3);
		UserInfo uInfo = this.createUser(PhysicalLevel.BEGINNER);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_beginner_hard_cardio");
		System.out.println("Total number of exercises is 10.");
		System.out.println("Number of easy exercises: " + woInfo.getNumberOfEasyExercises());
		System.out.println("Number of hard exercises: " + woInfo.getNumberOfHardExercises());
		
		assertTrue(woInfo.getNumberOfEasyExercises() == 6);
		assertTrue(woInfo.getNumberOfHardExercises() == 4);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_intermediate_hard_cardio() {
		WorkoutInfo woInfo = this.createWOCardio(3);
		UserInfo uInfo = this.createUser(PhysicalLevel.INTERMEDIATE);
		KieSession testSession = this.prepSessionWithFacts(woInfo,uInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_intermediate_hard_cardio");
		System.out.println("Total number of exercises is 10.");
		System.out.println("Number of easy exercises: " + woInfo.getNumberOfEasyExercises());
		System.out.println("Number of hard exercises: " + woInfo.getNumberOfHardExercises());
		
		assertTrue(woInfo.getNumberOfEasyExercises() == 6);
		assertTrue(woInfo.getNumberOfHardExercises() == 4);
	     
		testSession.dispose();
	}

}
