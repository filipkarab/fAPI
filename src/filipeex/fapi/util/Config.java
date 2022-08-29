package filipeex.fapi.util;

import filipeex.fapi.FAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Config {

    // ░██████╗███████╗████████╗████████╗██╗███╗░░██╗░██████╗░░██████╗
    // ██╔════╝██╔════╝╚══██╔══╝╚══██╔══╝██║████╗░██║██╔════╝░██╔════╝
    // ╚█████╗░█████╗░░░░░██║░░░░░░██║░░░██║██╔██╗██║██║░░██╗░╚█████╗░
    // ░╚═══██╗██╔══╝░░░░░██║░░░░░░██║░░░██║██║╚████║██║░░╚██╗░╚═══██╗
    // ██████╔╝███████╗░░░██║░░░░░░██║░░░██║██║░╚███║╚██████╔╝██████╔╝
    // ╚═════╝░╚══════╝░░░╚═╝░░░░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░╚═════╝░

    private static HashMap<File, FileConfiguration> configurations = new HashMap<File, FileConfiguration>();

    public static FileConfiguration getConfig(String file) {
        return configurations.get(new File(FAPI.i.getDataFolder(), file));
    }

    public static boolean createConfig(String file) {
        boolean success = true;

        File configFile = new File(FAPI.i.getDataFolder(), file);
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            FAPI.i.saveResource(file, false);
        }

        FileConfiguration config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (Exception ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        configurations.put(configFile, config);

        return success;
    }

    public static boolean reloadConfig(String file) {
        boolean success = true;

        File configFile = new File(FAPI.i.getDataFolder(), file);
        FileConfiguration config = configurations.get(configFile);

        try {
            config.load(configFile);
        } catch (Exception ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        return success;
    }

    public static boolean saveConfig(String file) {
        boolean success = true;

        File configFile = new File(FAPI.i.getDataFolder(), file);
        FileConfiguration config = configurations.get(configFile);

        try {
            config.save(configFile);
        } catch (IOException ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        return success;
    }

    public static boolean unloadConfig(String file) {
        boolean success = false;

        File configFile = new File(FAPI.i.getDataFolder(), file);
        FileConfiguration config = configurations.get(configFile);

        config = new YamlConfiguration();

        return success;
    }

    public static boolean resetConfig(String file) {
        boolean success = true;

        File configFile = new File(FAPI.i.getDataFolder(), file);
        FileConfiguration config = configurations.get(configFile);

        unloadConfig(file);

        configFile = new File(FAPI.i.getDataFolder(), file);
        configFile.getParentFile().mkdirs();
        FAPI.i.saveResource(file, true);

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (Exception ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        return success;
    }


    // ██████╗░░█████╗░████████╗░█████╗░██████╗░░█████╗░░██████╗███████╗
    // ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝
    // ██║░░██║███████║░░░██║░░░███████║██████╦╝███████║╚█████╗░█████╗░░
    // ██║░░██║██╔══██║░░░██║░░░██╔══██║██╔══██╗██╔══██║░╚═══██╗██╔══╝░░
    // ██████╔╝██║░░██║░░░██║░░░██║░░██║██████╦╝██║░░██║██████╔╝███████╗
    // ╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝╚═════╝░╚══════╝

    private static HashMap<File, FileConfiguration> databases = new HashMap<File, FileConfiguration>();

    public static FileConfiguration getDatabase(String file) {
        reloadDatabase(file);
        return databases.get(new File("plugins/fDATABASE/" + file));
    }

    public static boolean createDatabase(String file) {
        boolean success = true;

        File configFile = new File("plugins/fDATABASE/" + file);
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            try {
                new YamlConfiguration().save(configFile);
            } catch (IOException e) {
                Output.err("An error occurred while trying to create the database file; " + e.getMessage());
            }
        }

        FileConfiguration config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (Exception ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        databases.put(configFile, config);

        return success;
    }

    public static boolean reloadDatabase(String file) {
        boolean success = true;

        File configFile = new File("plugins/fDATABASE/" + file);
        FileConfiguration config = databases.get(configFile);

        try {
            config.load(configFile);
        } catch (Exception ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        return success;
    }

    public static boolean saveDatabase(String file) {
        boolean success = true;

        File configFile = new File("plugins/fDATABASE/" + file);
        FileConfiguration config = databases.get(configFile);

        try {
            config.save(configFile);
        } catch (IOException ex) {
            success = false;
            Output.err(ex.getMessage());
        }

        return success;
    }

    public static boolean unloadDatabase(String file) {
        boolean success = false;

        File configFile = new File("plugins/fDATABASE/" + file);
        FileConfiguration config = databases.get(configFile);

        config = new YamlConfiguration();

        return success;
    }

}
