package tests;

import tests.engine.*;
import tests.engine.transition.*;
import tests.world.*;
import tests.world.character.*;

public class test {

	public static void main(String[] args) {
		Mother.Initialise();
		TrickTests.AllTests();
		StageActionProviderTests.AllTests();
		SavvyCharacterCardTests.AllTests();
		CrewActionProviderTests.AllTests();
		DissolveTrickTransitionTests.AllTests();
		AddToTrickTransitionTests.AllTests();
	}

}
