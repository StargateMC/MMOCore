/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.module.Player;

import com.mmocore.module.AbstractRegistry;
import java.util.UUID;

/**
 *
 * @author draks
 */
public class PlayerRegistry extends AbstractRegistry<PlayerRegistry, UUID, RegisterablePlayer> {

    @Override
    public void initialise() {
        // Not required.
    }

    @Override
    public void finalise() {
        // No code required, yet.
    }

    @Override
    public boolean canBeEnabled() {
        return true;
    }

}
