/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmocore;
import com.mmocore.api.ForgeAPI;
import com.mmocore.core.Dialog.DialogRegistry;
import com.mmocore.core.Dimension.DimensionRegistry;
import com.mmcore.core.Galaxy.GalaxyRegistry;
import com.mmocore.core.Gui.GuiRegistry;
import com.mmcore.core.Listener.ListenerRegistry;
import com.mmcore.core.Npc.NpcRegistry;
import com.mmocore.core.NpcFaction.NpcFactionRegistry;
import com.mmocore.core.Player.PlayerRegistry;
import com.mmocore.core.Quest.QuestRegistry;
import com.mmocore.core.Stargate.StargateRegistry;
import com.mmocore.constants.ConsoleMessageType;
import com.mmocore.constants.IntegratedMod;
import com.mmocore.network.DataChannel;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author Drakster
 */

@Mod(modid=MMOCore.MODID, name=MMOCore.MODNAME, version=MMOCore.MODVER, dependencies = "before:SGCraft, afterY:IC2, after:DefenseTech, after:CustomNpcs", acceptableRemoteVersions = "*")

public class MMOCore {
    
   @Instance(value = MMOCore.MODID)
   public static MMOCore instance;
    
   public static final String MODID = "mmocore";
   public static final String MODNAME = "MMOCore";
   public static final String MODVER = "1.0.0";

   private GuiRegistry guiRegistry;
   private DimensionRegistry dimensionRegistry;
   private ListenerRegistry listenerRegistry;
   private PlayerRegistry playerRegistry;
   private DialogRegistry dialogRegistry;
   private GalaxyRegistry galaxyRegistry;
   private NpcFactionRegistry npcFactionRegistry;
   private NpcRegistry npcRegistry;
   
   
   private DataChannel channel;
   
   private StargateRegistry stargateRegistry;
   private QuestRegistry questRegistry;
   
   public GalaxyRegistry getGalaxyRegistry() {
       if (galaxyRegistry == null) galaxyRegistry = new GalaxyRegistry();
       return galaxyRegistry;
   }
   public GuiRegistry getGuiRegistry() {
       if (guiRegistry == null) guiRegistry = new GuiRegistry();
       return guiRegistry;
   }
   public PlayerRegistry getPlayerRegistry() {
       if (playerRegistry == null) playerRegistry = new PlayerRegistry();
       return playerRegistry;
   }
   public DimensionRegistry getDimensionRegistry() {
       if (dimensionRegistry == null) dimensionRegistry = new DimensionRegistry();
       return dimensionRegistry;
   }
   public NpcRegistry getNpcRegistry() {
       if (npcRegistry == null) npcRegistry = new NpcRegistry();
       return npcRegistry;
   }
   public ListenerRegistry getListenerRegistry() {
       if (listenerRegistry == null)  listenerRegistry = new ListenerRegistry();
       return listenerRegistry;
   }
   
   public StargateRegistry getStargateRegistry() {
       if (stargateRegistry == null)  stargateRegistry = new StargateRegistry();
       return stargateRegistry;
   }
   
   public DialogRegistry getDialogRegistry() {
       if (dialogRegistry == null)  dialogRegistry = new DialogRegistry();
       return dialogRegistry;
   }
   
   public QuestRegistry getQuestRegistry() {
       if (questRegistry == null)  questRegistry = new QuestRegistry();
       return questRegistry;
   }
   
   public NpcFactionRegistry getNpcFactionRegistry() {
       if (npcFactionRegistry == null) npcFactionRegistry = new NpcFactionRegistry();
       return npcFactionRegistry;
   }
   
   public DataChannel getChannel() {
       return this.channel;
   }
   
   @Mod.EventHandler
   public void preLoad(FMLPreInitializationEvent event) {
       ForgeAPI.sendConsoleEntry("Starting " + MODNAME + " v" + MODVER, ConsoleMessageType.FINE);
       channel = new DataChannel(MMOCore.MODID);
   }
   
   @Mod.EventHandler
   public void load(FMLInitializationEvent event) {
       ForgeAPI.sendConsoleEntry("Loading " + MODNAME + " v" + MODVER, ConsoleMessageType.FINE);
   }
   
   @Mod.EventHandler
   public void postLoad(FMLPostInitializationEvent event) {
       ForgeAPI.sendConsoleEntry("Initialising " + MODNAME + " v" + MODVER, ConsoleMessageType.FINE);
       MMOCore.getInstance().getGuiRegistry().initialise();
       MMOCore.getInstance().getDimensionRegistry().initialise();
       MMOCore.getInstance().getGalaxyRegistry().initialise();
       MMOCore.getInstance().getPlayerRegistry().initialise();
       MMOCore.getInstance().getListenerRegistry().initialise();
       if (ForgeAPI.isModLoaded(IntegratedMod.CustomNpcs)) MMOCore.getInstance().getDialogRegistry().initialise();
       if (ForgeAPI.isModLoaded(IntegratedMod.SGCraft)) MMOCore.getInstance().getStargateRegistry().initialise();
       if (ForgeAPI.isModLoaded(IntegratedMod.CustomNpcs)) MMOCore.getInstance().getQuestRegistry().initialise();
       if (ForgeAPI.isModLoaded(IntegratedMod.CustomNpcs)) MMOCore.getInstance().getNpcFactionRegistry().initialise();
       if (ForgeAPI.isModLoaded(IntegratedMod.CustomNpcs)) MMOCore.getInstance().getNpcRegistry().initialise();
   }
   
   public static MMOCore getInstance() {
       return MMOCore.instance;
   }
}