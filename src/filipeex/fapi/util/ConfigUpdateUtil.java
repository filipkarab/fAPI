package filipeex.fapi.util;

import java.util.HashMap;
import java.util.Map;

public class ConfigUpdateUtil {

    public static void performConfigurationUpdate(String file) {

        HashMap<String, Object> temporaryKeyValueStorage = new HashMap<String, Object>();

        for (String s : Config.getConfig(file).getKeys(true))
            temporaryKeyValueStorage.put(s, Config.getConfig(file).get(s));

        Config.resetConfig(file);

        for (Map.Entry<String, Object> entry : temporaryKeyValueStorage.entrySet())
            if (!entry.getKey().equalsIgnoreCase("version"))
                if (entry.getValue() != null && Config.getConfig(file).contains(entry.getKey()))
                    Config.getConfig(file).set(entry.getKey(), entry.getValue());

        Config.saveConfig(file);

    }

    public static boolean doesConfigNeedConfigurationUpdate(String file, String pluginVersion) {
        boolean result = false;

        String configVersion = Config.getConfig("settings.yml").getString("version");
        if (!pluginVersion.equalsIgnoreCase(configVersion))
            result = true;

        return result;
    }

}
