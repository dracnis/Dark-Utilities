package net.darkhax.darkutils.libs;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Utilities {
    
    /**
     * Calculates the distance between two entities. This is done by getting the square root of
     * the entities positions.
     * 
     * @param firstEntity: The first entity to use.
     * @param secondEntity: The second entity to use.
     * @return double: The distance between the two entities passed.
     */
    public static double getDistanceBetweenEntities (Entity firstEntity, Entity secondEntity) {
        
        double distanceX = firstEntity.posX - secondEntity.posX;
        double distanceY = firstEntity.posY - secondEntity.posY;
        double distanceZ = firstEntity.posZ - secondEntity.posZ;
        
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }
    
    public static double getDistaceFromPos (Entity entity, BlockPos pos) {
        
        double distanceX = entity.posX - pos.getX();
        double distanceY = entity.posY - pos.getY();
        double distanceZ = entity.posZ - pos.getZ();
        
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }
    
    /**
     * Pushes an entity towards another one.
     * 
     * @param entityToMove: The entity that should be pushed towards the other entity.
     * @param destination: The destination entity, that the entity to move should be pushed
     *            towards.
     * @param force: The amount of force to push the entityToMove with.
     */
    public static void pushTowards (Entity entityToMove, Entity destination, double force) {
        
        double distanceX = destination.posX - entityToMove.posX;
        double distanceY = destination.posY - entityToMove.posY;
        double distanceZ = destination.posZ - entityToMove.posZ;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
        
        if (distance > 0) {
            
            entityToMove.motionX = distanceX / distance * force;
            entityToMove.motionY = distanceY / distance * force;
            entityToMove.motionZ = distanceZ / distance * force;
        }
    }
    
    public static void pushTowards (Entity entityToMove, EnumFacing direction, double force) {
        
        pushTowards(entityToMove, entityToMove.getPosition().offset(direction.getOpposite(), 1), force);
    }
    
    public static void pushTowards (Entity entityToMove, BlockPos pos, double force) {
        
        BlockPos entityPos = entityToMove.getPosition();
        double distanceX = pos.getX() - entityPos.getX();
        double distanceY = pos.getY() - entityPos.getY();
        double distanceZ = pos.getZ() - entityPos.getZ();
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
        
        if (distance > 0) {
            
            entityToMove.motionX = distanceX / distance * force;
            entityToMove.motionY = distanceY / distance * force;
            entityToMove.motionZ = distanceZ / distance * force;
        }
    }
    
    /**
     * Checks if two entities are close enough together.
     * 
     * @param firstEntity: The first entity to check.
     * @param secondEntity: The second entity to check.
     * @param maxDistance: The maximum distance that the entities can be apart.
     * @return boolean: True if the distance between the entities are within range of the
     *         maxDistance.
     */
    public static boolean areEntitiesCloseEnough (Entity firstEntity, Entity secondEntity, double maxDistance) {
        
        return getDistanceBetweenEntities(firstEntity, secondEntity) < (maxDistance * maxDistance);
    }
}