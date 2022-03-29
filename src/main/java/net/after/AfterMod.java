package net.after;

import net.after.blocks.SoulGlass;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.after.blocks.MarrowBlock;
import net.after.blocks.PhantoniumOre;
import net.after.items.RawPhantonium;
import net.after.entity.AftermiteEntity;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;


public class AfterMod implements ModInitializer {
	//Block instances
	public static final MarrowBlock MARROW_BLOCK = new MarrowBlock(FabricBlockSettings.of(Material.METAL).strength(1.0f).requiresTool().nonOpaque().dynamicBounds());
	public static final PhantoniumOre PHANTONIUM_ORE = new PhantoniumOre(FabricBlockSettings.of(Material.STONE).strength(10.0f).requiresTool().dynamicBounds().nonOpaque());
	public static final SoulGlass SOUL_GLASS = new SoulGlass(FabricBlockSettings.of(Material.GLASS).strength(2f).requiresTool().dynamicBounds());


	//Item instances
	public static final RawPhantonium RAW_PHANTONIUM = new RawPhantonium(new FabricItemSettings().group(ItemGroup.MISC));

	//Sound instances
	public static final Identifier HIGH_PITCHED_MAN_SCREAM = new Identifier("modid:high_pitched_man_scream");
	public static SoundEvent HIGH_PITCHED_MAN_SCREAM_EVENT = new SoundEvent(HIGH_PITCHED_MAN_SCREAM);

	public static final Identifier LOW_PITCHED_MAN_SCREAM = new Identifier("modid:low_pitched_man_scream");
	public static SoundEvent LOW_PITCHED_MAN_SCREAM_EVENT = new SoundEvent(LOW_PITCHED_MAN_SCREAM);

	public static final Identifier HIGH_PITCHED_WOMAN_SCREAM = new Identifier("modid:high_pitched_woman_scream");
	public static SoundEvent HIGH_PITCHED_WOMAN_SCREAM_EVENT = new SoundEvent(HIGH_PITCHED_WOMAN_SCREAM);

	public static final Identifier LOW_PITCHED_WOMAN_SCREAM = new Identifier("modid:low_pitched_woman_scream");
	public static SoundEvent LOW_PITCHED_WOMAN_SCREAM_EVENT = new SoundEvent(LOW_PITCHED_WOMAN_SCREAM);

	//Aftermite Instance
	public static final EntityType<AftermiteEntity> AFTERMITE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("after", "aftermite"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AftermiteEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);



	@Override
	public void onInitialize() {
		//Initialize GeckoLib
		GeckoLib.initialize();

		//Register Blocks/Items
		Registry.register(Registry.BLOCK, new Identifier("after", "marrow_block"), MARROW_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("after", "marrow_block"), new BlockItem(MARROW_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("after", "phantonium_ore"), PHANTONIUM_ORE);
		Registry.register(Registry.ITEM, new Identifier("after", "phantonium_ore"), new BlockItem(PHANTONIUM_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("after", "raw_phantonium"), RAW_PHANTONIUM);
		Registry.register(Registry.BLOCK, new Identifier("after", "soul_glass"), SOUL_GLASS);
		Registry.register(Registry.ITEM, new Identifier("after", "soul_glass"), new BlockItem(SOUL_GLASS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		//Register Mobs
		FabricDefaultAttributeRegistry.register(AFTERMITE, AftermiteEntity.createMobAttributes());

		//Register Sounds
		Registry.register(Registry.SOUND_EVENT, AfterMod.HIGH_PITCHED_MAN_SCREAM, HIGH_PITCHED_MAN_SCREAM_EVENT);
		Registry.register(Registry.SOUND_EVENT, AfterMod.LOW_PITCHED_MAN_SCREAM, LOW_PITCHED_MAN_SCREAM_EVENT);
		Registry.register(Registry.SOUND_EVENT, AfterMod.HIGH_PITCHED_WOMAN_SCREAM, HIGH_PITCHED_WOMAN_SCREAM_EVENT);
		Registry.register(Registry.SOUND_EVENT, AfterMod.LOW_PITCHED_WOMAN_SCREAM, LOW_PITCHED_WOMAN_SCREAM_EVENT);
	}
}
