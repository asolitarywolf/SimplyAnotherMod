package asolitarywolf.sam.handler;


import asolitarywolf.sam.reference.Reference;
import asolitarywolf.sam.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile){

        // Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
            LogHelper.info("ConfigurationHandler Init Complete");
        }


    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){

            loadConfiguration();
            LogHelper.info("onConfigurationChangedEvent Complete");

        }
    }

    private static void loadConfiguration(){

        testValue = configuration.getBoolean("configValue", configuration.CATEGORY_GENERAL, false, "This is an example configuration value");

        if (configuration.hasChanged()){
            configuration.save();
            LogHelper.info("loadConfiguration Complete");
        }
    }
}