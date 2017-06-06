/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.api;

import com.mmocore.MMOCore;
import com.mmocore.constants.uPosition;
import com.mmocore.module.GameEvent.GameEvent;
import com.mmocore.module.GameEvent.events.QuestLocationEvent;
import com.mmocore.module.data.AbstractDictionary;

/**
 *
 * @author draks
 */
public class EventAPI extends AbstractAPI<EventAPI> {
    
    public static GameEvent getRegistered(String name) {
        if (AbstractDictionary.getEvents().isEmpty()) AbstractDictionary.loadGameEvents();
        for (GameEvent e : MMOCore.getGameEventRegistry().getRegistered().values()) {
            if (e.getIdentifier().equals(name)) return e;
        }
        for (GameEvent e : AbstractDictionary.getEvents()) {
            if (e.getIdentifier().equals(name)) {
                MMOCore.getGameEventRegistry().register(e);
                return e;
            }
        }
        return null;
    }
    
    public static boolean isAreaProtected(uPosition position) {
        for (GameEvent event : MMOCore.getGameEventRegistry().getRegisteredReadOnly().values()) {
            if (event instanceof QuestLocationEvent) {
                QuestLocationEvent location = (QuestLocationEvent)event;
                if (location.isProtected() && location.containsPosition(position)) return true;
            }
        }
        return false;
    }
}
