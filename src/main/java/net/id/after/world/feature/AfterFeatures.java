package net.id.after.world.feature;

import net.id.after.world.feature.configured_features.AfterConfiguredFeatures;
import net.id.after.world.feature.placed_features.AfterPlacedFeatures;

public class AfterFeatures {
    public static void init(){
        AfterConfiguredFeatures.init();
        AfterPlacedFeatures.init();
    }
}
