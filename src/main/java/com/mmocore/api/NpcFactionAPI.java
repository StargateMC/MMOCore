/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.api;

import com.mmocore.MMOCore;
import com.mmocore.constants.ConsoleMessageType;
import com.mmocore.module.NpcFaction.RegisterableNpcFaction;
import com.mmocore.module.data.AbstractDictionary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;

/**
 *
 * @author draks
 */
public class NpcFactionAPI extends AbstractAPI<NpcFactionAPI> {
    
    public static Collection<Faction> getAllFactions() {
        return FactionController.getInstance().factions.values();
    }
    
    public static Collection<Faction> getAllFactionsReadOnly() {
        return new ArrayList<Faction>(FactionController.getInstance().factions.values());
    }
    
    public static Collection<RegisterableNpcFaction> getAllRegisteredFactionsReadOnly() {
        return MMOCore.getInstance().getNpcFactionRegistry().getRegisteredReadOnly().values();
    }
    
    public static RegisterableNpcFaction getRegistered(String name) {
        for (RegisterableNpcFaction f : MMOCore.getNpcFactionRegistry().getRegistered().values()) {
            if (f.getName().equals(name)) return f;
        }
        for (RegisterableNpcFaction f : AbstractDictionary.getFactions()) {
            if (f.getName().equals(name)) {
                MMOCore.getNpcFactionRegistry().register(f);
                return f;
            }
        }
        ForgeAPI.sendConsoleEntry("Something tried to reference a faction : " + name + " that did not exist.", ConsoleMessageType.FINE);
        return null;
    }
    
    public static Faction get(String name) {
        return FactionController.getInstance().getFactionFromName(name);
    }
    
    public static Faction get(int id) {
        return FactionController.getInstance().getFaction(id);
    }
    
    public static boolean isFriendly(String playerName, String factionName) {
        PlayerData data = PlayerDataController.instance.getDataFromUsername(playerName);
        Faction f = FactionController.getInstance().getFactionFromName(factionName);
        if (data != null && f != null) {
            return f.isFriendlyToPlayer(ForgeAPI.getForgePlayer(playerName));
        } else {
            return false;
        }
    }
    public static boolean isNeutral(String playerName, String factionName) {
        PlayerData data = PlayerDataController.instance.getDataFromUsername(playerName);
        Faction f = FactionController.getInstance().getFactionFromName(factionName);
        if (data != null && f != null) {
            return f.isNeutralToPlayer(ForgeAPI.getForgePlayer(playerName));
        } else {
            return false;
        }
    }
    public static boolean isHostile(String playerName, String factionName) {
        PlayerData data = PlayerDataController.instance.getDataFromUsername(playerName);
        Faction f = FactionController.getInstance().getFactionFromName(factionName);
        if (data != null && f != null) {
            return f.isAggressiveToPlayer(ForgeAPI.getForgePlayer(playerName));
        } else {
            return false;
        }
    }
    
    public static List<Faction> getHostileFactionsFor(Faction faction) {
        List<Faction> factions = new ArrayList<Faction>();
        for (int id : faction.attackFactions) {
            if (get(id) == null) continue;
            factions.add(get(id));
        }
        return factions;
    }
}
