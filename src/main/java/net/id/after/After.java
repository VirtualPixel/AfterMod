package net.id.after;

import net.fabricmc.api.*;
import net.id.after.blocks.AfterBlocks;
import net.id.after.client.rendering.block.AfterBlockRenderers;
import net.id.after.entities.AfterEntityTypes;
import net.id.after.items.AfterItems;
import net.id.after.util.AfterSoundEvents;
import net.id.after.world.AfterDimension;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class After implements ModInitializer, ClientModInitializer, DedicatedServerModInitializer {

	public static final String MOD_ID = "the_after";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier locate(String location) {
		if (location.contains(":")) {
			return new Identifier(location);
		} else {
			return new Identifier(MOD_ID, location);
		}
	}

	@Override
	public void onInitialize() {
		//GeckoLib.initialize();
		AfterSoundEvents.init();
		AfterItems.init();
		AfterBlocks.init();
		AfterDimension.init();
		AfterEntityTypes.init();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void onInitializeClient() {
		AfterBlockRenderers.init();
		//AfterModelLayers.initClient();
		//AfterEntityRenderers.initClient();
	}

	@Override
	public void onInitializeServer() {

	}
}
