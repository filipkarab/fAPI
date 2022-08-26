package filipeex.fapi;

import org.bukkit.plugin.java.JavaPlugin;

public class FAPI {

    public static JavaPlugin i;
    public static String internalPrefix;
    public static int resourceId;

    public static void initialize(JavaPlugin main, String builtInPrefix, Integer spigotResourceId) {

        i = main;
        internalPrefix = builtInPrefix;
        resourceId = spigotResourceId;

    }

}
