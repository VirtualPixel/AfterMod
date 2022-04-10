package net.id.after.world.biome;


import net.id.after.world.gen.AfterChunkGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import static net.id.after.After.MOD_ID;

public class AfterBiomes {
    public static final RegistryKey<Biome> AFTER_BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "after_biome"));
    private static Biome AFTER;

    public static void init(){
        Registry.register(Registry.CHUNK_GENERATOR, new Identifier("the_after", "the_after"), AfterChunkGenerator.CODEC);

        Registry.register(BuiltinRegistries.BIOME, AFTER_BIOME_KEY.getValue(), AFTER);
    }

}
