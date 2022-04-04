package net.id.after.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.id.after.After;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class AfterItems {

    private static final Item PHANTONIUM_INGOT = registerItem("phantonium_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    private static final Item RAW_PHANTONIUM = registerItem("raw_phantonium", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(After.MOD_ID, name), item);
    }

    public static void init(){
        After.LOGGER.info("Registering Mod items for " + After.MOD_ID);
    }

}
