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
import sbnz.integracija.example.facts.UserInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class bmi_test {
	
	@Autowired
    private KieContainer kieContainer;
	
	
	private KieSession prepSessionWithFacts(UserInfo userInfo) {

		KieSession testSession = kieContainer.newKieSession("HWTestSession");

		testSession.insert(userInfo);

		testSession.getAgenda().getAgendaGroup("processing").setFocus();

		return testSession;
	}
	
	
	private UserInfo createUser(double weight, double height) {

        UserInfo uInfo = new UserInfo();
        uInfo.setWeight(weight);
        uInfo.setHeight(height);

        return uInfo;
    }
		

	@Test
	public void testBMILow() {
		UserInfo uInfo = this.createUser(50, 200);
		KieSession testSession = this.prepSessionWithFacts(uInfo);
		 
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("testBMILow");
		System.out.println("Weight: " + uInfo.getWeight() + " , height: " + uInfo.getHeight());
		System.out.println("Bmi calculated:" + uInfo.getBMI());
		
		assertTrue(uInfo.getBMI() == BMICategory.MALNOURISHED);
	     
		testSession.dispose();
	}
	
	@Test
	public void testBMINormal() {
		UserInfo uInfo = this.createUser(73, 180);
		KieSession testSession = this.prepSessionWithFacts(uInfo);
		 
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("testBMINormal");
		System.out.println("Weight: " + uInfo.getWeight() + " , height: " + uInfo.getHeight());
		System.out.println("Bmi calculated:" + uInfo.getBMI());
		
		assertTrue(uInfo.getBMI() == BMICategory.NORMAL);
	     
		testSession.dispose();
	}
	
	@Test
	public void testBMIHigh() {
		UserInfo uInfo = this.createUser(130, 160);
		KieSession testSession = this.prepSessionWithFacts(uInfo);
		 
		int rulesFired = testSession.fireAllRules();
		assertEquals(1, rulesFired);
		 
		System.out.println("\n");
		System.out.println("=======================");
		System.out.println("testBMIHigh");
		System.out.println("Weight: " + uInfo.getWeight() + " , height: " + uInfo.getHeight());
		System.out.println("Bmi calculated:" + uInfo.getBMI());
		
		assertTrue(uInfo.getBMI() == BMICategory.OBESE);
	     
		testSession.dispose();
	}

}
