package net.after.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class AftermiteEntity extends PathAwareEntity {
    public AftermiteEntity(EntityType<? extends PathAwareEntity> entityType, World world){
        super(entityType, world);
    }
}
