package net.id.after.world.dimension;

import net.id.after.After;
import net.id.after.blocks.AfterBlocks;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

import static net.id.after.After.MOD_ID;
import static net.id.after.After.locate;

public class AfterDimension {
    public static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(MOD_ID, "the_after"));
    public static final RegistryKey<World> AFTER_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY,
            DIMENSION_KEY.getValue());
    public static final RegistryKey<DimensionType> DIMENSION_TYPE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(MOD_ID, "the_after"));

    public static void init(){
        After.LOGGER.info("Registering custom portal for" + MOD_ID);

        CustomPortalBuilder.beginPortal()
                .frameBlock(AfterBlocks.REFINED_SOUL_SAND)
                .lightWithItem(Items.TOTEM_OF_UNDYING)
                .destDimID(locate(MOD_ID))
                .tintColor(0, 0, 0)
                .onlyLightInOverworld()
                .registerPortal();
    }
}
