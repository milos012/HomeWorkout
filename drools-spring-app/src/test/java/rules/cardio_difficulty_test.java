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

import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.facts.WorkoutInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class cardio_difficulty_test {

	
	@Autowired
    private KieContainer kieContainer;
	
	
	private KieSession prepSessionWithFacts(WorkoutInfo woInfo) {

		KieSession testSession = kieContainer.newKieSession("HWTestSession");

		testSession.insert(woInfo);

		testSession.getAgenda().getAgendaGroup("workout").setFocus();

		return testSession;
	}
	
	private WorkoutInfo createWO(int duration) {

        WorkoutInfo woInfo = new WorkoutInfo();
        woInfo.setDuration(duration);
        woInfo.setMuscleGroup(WorkoutType.CARDIO);

        return woInfo;
    }
	
	@Test
	public void test_cardio_10() {
		WorkoutInfo woInfo = this.createWO(10);
		KieSession testSession = this.prepSessionWithFacts(woInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_cardio_10");
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		System.out.println("Number of repetitions: " + woInfo.getNumberOfRepetitions());
		
		assertTrue(woInfo.getNumberOfExercises() == 10);
		assertTrue(woInfo.getNumberOfRepetitions() == 1);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_cardio_20() {
		WorkoutInfo woInfo = this.createWO(20);
		KieSession testSession = this.prepSessionWithFacts(woInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_cardio_20");
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		System.out.println("Number of repetitions: " + woInfo.getNumberOfRepetitions());
		
		assertTrue(woInfo.getNumberOfExercises() == 10);
		assertTrue(woInfo.getNumberOfRepetitions() == 2);
	     
		testSession.dispose();
	}
	
	@Test
	public void test_cardio_30() {
		WorkoutInfo woInfo = this.createWO(30);
		KieSession testSession = this.prepSessionWithFacts(woInfo);
		
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("test_cardio_30");
		System.out.println("Number of exercises: " + woInfo.getNumberOfExercises());
		System.out.println("Number of repetitions: " + woInfo.getNumberOfRepetitions());
		
		assertTrue(woInfo.getNumberOfExercises() == 15);
		assertTrue(woInfo.getNumberOfRepetitions() == 2);
	     
		testSession.dispose();
	}

}
