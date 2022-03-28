/*package net.after.client.model;


import net.after.entity.AftermiteEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

public class AftermiteEntityModel extends EntityModel<AftermiteEntity> {
    private final ModelPart head;
    private final ModelPart body;
    public <EnterEntityNameHere>(ModelPart rootModelPart) {
        this.head = modelPartBase.getChild(<EntityModelPartName here>);
        this.body = modelPartBase.getChild(<EntityModelPartName here>);

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData md = new ModelData();
        ModelPartData head = md.getRoot();
//head
        ModelPartData head = head.addChild(<EntityModelPartName here>, ModelPartBuilder.create().uv(0, 0).cuboid((-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0);
//body
        ModelPartData body = body.addChild(<EntityModelPartName here>, ModelPartBuilder.create().uv(0, 0).cuboid((-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0);
        return TexturedModelData.of(md, 16, 16);
    }

    @Override
    public void setAngles(<EnterEntityNameHere> entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        ImmutableList.of(this.root).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay);
        });
    }

    public static ModelTransform createModelTransform(float pivotX, float pivotY, float pivotZ, float pitch, float yaw, float roll) {
        float px = pivotX;
        float py = pivotY;
        float pz = pivotZ;
        float x = pitch;
        float y = yaw;
        float z = roll;
        return ModelTransform.of(px, py, pz, x, y, z);
    }
}
*/