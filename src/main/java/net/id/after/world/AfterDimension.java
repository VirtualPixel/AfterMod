package net.id.after.world;

import net.id.after.blocks.AfterBlocks;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import static net.id.after.After.MOD_ID;
import static net.id.after.After.locate;

public class AfterDimension {
    public static final RegistryKey<World> AETHER_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, locate(MOD_ID));
    public static final RegistryKey<DimensionType> DIMENSION_TYPE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, locate(MOD_ID));

    public static void init(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(AfterBlocks.REFINED_SOUL_SAND)
                .lightWithItem(Items.TOTEM_OF_UNDYING)
                .destDimID(new Identifier("the_nether"))
                .tintColor(0, 0, 0)
                .onlyLightInOverworld()
                .registerPortal();
    }
}
