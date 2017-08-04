/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.module.data.factions;

import com.mmocore.api.NpcFactionAPI;
import com.mmocore.module.NpcFaction.RegisterableNpcFaction;
import com.mmocore.module.data.AbstractDictionary;

/**
 *
 * @author draks
 */
public class Goauld extends RegisterableNpcFaction {

    public Goauld() {
        super("Goauld");
        this.setDefaultPoints(0);
        this.setAttackedByMobs(true);
        this.addHostileFaction(NpcFactionAPI.getRegistered("Stargate Command"));
    }
    
}
