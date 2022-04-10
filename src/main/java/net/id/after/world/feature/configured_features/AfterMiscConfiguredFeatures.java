package net.id.after.world.feature.configured_features;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

import static net.id.after.blocks.AfterBlocks.PHANTONIUM_ORE;

public class AfterMiscConfiguredFeatures extends AfterConfiguredFeatures{

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_PHANTONIUM = register("phantonium_ore", Feature.ORE, Configs.ore(PHANTONIUM_ORE, 14));

    private static class Configs extends AfterConfiguredFeatures.Configs{

        private static OreFeatureConfig ore(Block ore, int size){
            return new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.COAL_ORE), ore.getDefaultState())), size);
        }
    }

    public static void init(){}
}
