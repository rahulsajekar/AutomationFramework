package IntegratingCucumber;

import org.junit.runner.RunWith; 
import cucumber.junit.Cucumber; 


@RunWith(Cucumber.class) 
@Cucumber.Options(format = {"pretty", "html:target/cucumber"},features="IntegratingCucumber",glue = {"IntegratingCucumber"}) 
public class RunnerClass {

	
}
