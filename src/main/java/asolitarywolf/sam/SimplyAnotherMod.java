package asolitarywolf.sam;

import asolitarywolf.sam.handler.ConfigurationHandler;
import asolitarywolf.sam.init.ModItems;
import asolitarywolf.sam.proxy.IProxy;
import asolitarywolf.sam.reference.Reference;
import asolitarywolf.sam.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class SimplyAnotherMod {

    @Mod.Instance(Reference.MOD_ID)
    public static SimplyAnotherMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization Complete");

        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("Post Initialization Complete");
    }

}
