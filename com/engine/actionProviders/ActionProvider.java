package com.engine.actionProviders;

import java.util.List;
import com.engine.actions.*;

public abstract class ActionProvider {

	public abstract List<GameAction> GetAvailableActions();

}
