/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.constants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import noppes.npcs.constants.EnumParticleType;

/**
 *
 * @author draks
 */

public enum NpcProjectile {
    RED_PLASMA("IC2", "itemDust2", 2, false, 3, 65, false, true, true, EnumParticleType.None),    
    WHITE_PLASMA("IC2", "itemDust2", 6, false, 3, 65, false, true, true, EnumParticleType.None),
    BLUE_PLASMA("IC2", "itemDust2", 12, false, 3, 65, false, true, true, EnumParticleType.None),
    GOLD_PLASMA("IC2", "itemDust2", 4, false, 3, 65, false, true, true, EnumParticleType.None),
    ARROW("minecraft", "arrow", 0, false, 3, 35, false, true, true, EnumParticleType.None),    
    PISTOL_BULLET("customnpcs", "npcBlackBullet", 0, false, 1, 45, true, false, false, EnumParticleType.None),
    SNIPER_BULLET("customnpcs", "npcBlackBullet", 0, false, 1, 100, true, false, false, EnumParticleType.None),
    MACHINEGUN_BULLET("customnpcs", "npcBlackBullet", 0, false, 1, 65, true, false, false, EnumParticleType.None);
    
    private String mod;
    private String item;
    private int damage;
    private boolean sticks;
    private int size;
    private int speed;
    private boolean affectedGravity;
    private boolean glows;
    private boolean spins;
    private EnumParticleType trail;
    
    
    
    NpcProjectile(final String mod, final String item, final int damage, final boolean sticks, final int size, final int speed, final boolean gravAffected, final boolean glows, final boolean spins, EnumParticleType trail) {
        this.mod = mod;
        this.item = item;
        this.damage = damage;
        this.sticks = sticks;
        this.size = size;
        this.speed = speed;
        this.affectedGravity = gravAffected;
        this.glows = glows;
        this.spins = spins;
        this.trail = trail;
    }
    
    public EnumParticleType getTrail() {
        return this.trail;
    }
    
    public boolean getSticks() {
        return this.sticks;
    }
    
    public boolean getSpins() {
        return this.spins;
    }
    
    public ItemStack getItem() {
        ItemStack stack = GameRegistry.findItemStack(mod, item, 1);
        stack.setItemDamage(damage);
        return stack;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getSize() {
        return this.size;
    }

    public boolean getAffectedByGravity() {
        return this.affectedGravity;
    }
}