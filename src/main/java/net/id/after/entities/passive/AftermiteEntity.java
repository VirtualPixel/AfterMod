package net.id.after.entities.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class AftermiteEntity extends PathAwareEntity {
    public AftermiteEntity(EntityType<? extends PathAwareEntity> entityType, World world){
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAftermiteAttributes() {
        return createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D);
    }
}
