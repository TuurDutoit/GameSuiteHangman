package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, DriehoekTest.class,
		LijnStukTest.class, TekeningTest.class, OmhullendeTest.class, HintLetterTest.class, HintWoordTest.class })

public class AllTests {

}
