package org.example;

import java.util.Scanner;

import org.kie.api.KieBase;
import org.kie.api.KieServices;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;



/**
 * This is a sample class to launch a rule.
 */
public class Measurement {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	    KieBase kBase1 = kContainer.getKieBase("rules");
    	    KieSession kieSession1 = kContainer.newKieSession("ksession-rules");
            Calculator calc=new Calculator();
            calc.setOperator();
            calc.setNumber1(9);
            calc.setNumber2(10);
           FactHandle demo= kieSession1.insert(calc);
           System.out.println(demo);
           int rulesfired= kieSession1.fireAllRules();
           System.out.println(rulesfired);
          
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public static class Calculator{
    	  private String operator;
    	  private  int number1;
    	  private  int number2;
    	  Scanner ip = new Scanner(System.in);
    	public  String getOperator() {
			return operator;
		}
		public  void setOperator() {
			System.out.println("Enter the operation to be performed (+ or - or * or /  )");
			String operator = ip.next();
			this.operator=operator;

			
		}
		public  int getNumber1() {
			return number1;
		}
		public  void setNumber1(int number1) {
			this.number1 = number1;
		}
		public  int getNumber2() {
			return number2;
		}
		public  void setNumber2(int number2) {
			this.number2 = number2;
		}
		
    	
    	
    	
    }
    

}
