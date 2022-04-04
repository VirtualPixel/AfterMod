package net.id.after.client.rendering.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.id.after.blocks.AfterBlocks;
import net.minecraft.client.render.RenderLayer;

public class AfterBlockRenderers {
    public static void init(){
        BlockRenderLayerMap.INSTANCE.putBlock(AfterBlocks.PHANTONIUM_ORE, RenderLayer.getTranslucent());
    }
}
