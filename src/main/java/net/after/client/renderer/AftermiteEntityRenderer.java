package net.after.client.renderer;


import net.after.AfterClientMod;
import net.after.client.model.AftermiteEntityModelBAK;
import net.after.entity.AftermiteEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AftermiteEntityRenderer extends MobEntityRenderer<AftermiteEntity, AftermiteEntityModelBAK> {

    public AftermiteEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AftermiteEntityModelBAK(context.getPart(AfterClientMod.MODEL_AFTERMITE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(AftermiteEntity entity) {
        return new Identifier("the_after", "textures/entity/aftermite/aftermite.png");
    }
}

