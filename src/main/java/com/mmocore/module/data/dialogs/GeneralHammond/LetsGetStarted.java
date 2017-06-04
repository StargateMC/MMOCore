/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore.module.data.dialogs.GeneralHammond;

import com.mmocore.api.QuestAPI;
import com.mmocore.constants.QuestAvailability;
import com.mmocore.module.Dialog.RegisterableDialog;
import com.mmocore.module.Dialog.options.DialogActionOptions;
import com.mmocore.module.Dialog.options.DialogAvailabilityOptions;
import com.mmocore.module.Dialog.options.DialogBaseOptions;
import com.mmocore.module.Quest.RegisterableQuest;
import com.mmocore.module.data.AbstractDictionary;
import java.util.HashMap;

/**
 *
 * @author draks
 */
public class LetsGetStarted extends RegisterableDialog {
    
    public LetsGetStarted() {
        super("Janet Fraser Welcome", "Tutorial");
        DialogBaseOptions options = this.getBaseOptions();
        options.setText(
                "Cant you see I am busy here? What can I do for you? Quickly?\n "
        );
        this.setBaseOptions(options);
        DialogAvailabilityOptions opts = this.getAvailabilityOptions();
        HashMap<RegisterableQuest, QuestAvailability> availability = new HashMap<RegisterableQuest, QuestAvailability>();
        availability.put(AbstractDictionary.getQuestByName("Visiting The Infirmary", "Tutorial"), QuestAvailability.After);
        availability.put(AbstractDictionary.getQuestByName("Visiting The Infirmary", "Tutorial"), QuestAvailability.During);
        opts.setQuestAvailability(availability);
        this.setAvailabilityOptions(opts);
    }
    
}