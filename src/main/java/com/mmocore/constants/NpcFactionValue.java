/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.constants;

import com.mmocore.module.NpcFaction.RegisterableNpcFaction;

/**
 *
 * @author draks
 */
public class NpcFactionValue {
    
    private RegisterableNpcFaction faction;
    private AbstractScale value;
    private boolean isIncrease;
    
    public NpcFactionValue(RegisterableNpcFaction faction, AbstractScale scaledPoints, boolean isIncrease) {
        this.faction = faction;
        this.value = scaledPoints;
        this.isIncrease = isIncrease;
    }
    
    public AbstractScale getValue() {
        return this.value;
    }
    
    public RegisterableNpcFaction getFaction() {
        return this.faction;
    }
    
    public boolean isIncrease() {
        return this.isIncrease;
    }
    
    public boolean isDecrease() {
        return !this.isIncrease;
    }
}
