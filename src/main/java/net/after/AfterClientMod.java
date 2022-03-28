package net.after;

import net.after.client.model.AftermiteEntityModelBAK;
import net.after.client.renderer.AftermiteEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class AfterClientMod implements ClientModInitializer {

    //Mob Model Layer Initialization
    public static final EntityModelLayer MODEL_AFTERMITE_LAYER = new EntityModelLayer(new Identifier("after", "aftermite"), "main");

    @Override
    public void onInitializeClient() {
        //Block Rendering
        BlockRenderLayerMap.INSTANCE.putBlock(AfterMod.PHANTONIUM_ORE, RenderLayer.getTranslucent());

        EntityRendererRegistry.register(AfterMod.AFTERMITE, AftermiteEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_AFTERMITE_LAYER, AftermiteEntityModelBAK::getTexturedModelData);
    }
}
