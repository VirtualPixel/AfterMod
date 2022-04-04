package net.id.after.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.id.after.After;
import net.id.after.blocks.decorative.MarrowBlock;
import net.id.after.blocks.overworld.RefinedSoulSand;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AfterBlocks {

    public static final RefinedSoulSand REFINED_SOUL_SAND = (RefinedSoulSand) registerBlock("refined_soul_sand",
            new RefinedSoulSand(FabricBlockSettings.of(Material.AGGREGATE).strength(2f).requiresTool().luminance(20).velocityMultiplier(0.4f).sounds(BlockSoundGroup.TUFF)), ItemGroup.BUILDING_BLOCKS);

    public static final ScreamingBlock PHANTONIUM_ORE = (ScreamingBlock) registerBlock("phantonium_ore",
            new ScreamingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().nonOpaque().collidable(false)), ItemGroup.BUILDING_BLOCKS);

    public static final MarrowBlock MARROW_BLOCK = (MarrowBlock) registerBlock("marrow_block",
            new MarrowBlock(FabricBlockSettings.of(Material.METAL).strength(1.0f).requiresTool().nonOpaque()), ItemGroup.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItems(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(After.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block, ItemGroup group){
        Registry.register(Registry.ITEM, new Identifier(After.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void init(){
        After.LOGGER.info("Registering After Blocks for " + After.MOD_ID);
    }

}
