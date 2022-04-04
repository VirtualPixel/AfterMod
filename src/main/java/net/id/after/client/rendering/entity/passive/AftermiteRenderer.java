package net.id.after.client.rendering.entity.passive;


import net.id.after.client.model.AfterModelLayers;
import net.id.after.client.model.entity.AftermiteModel;
import net.id.after.entities.passive.AftermiteEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AftermiteRenderer extends MobEntityRenderer<AftermiteEntity, AftermiteModel> {

    public AftermiteRenderer(EntityRendererFactory.Context context) {
        super(context, new AftermiteModel(context.getPart(AfterModelLayers.AFTERMITE)), 0.5f);
    }

    @Override
    public Identifier getTexture(AftermiteEntity entity) {
        return new Identifier("the_after", "textures/entity/aftermite/aftermite.png");
    }
}

