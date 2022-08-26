package filipeex.fapi.util;

import filipeex.fapi.FAPI;
import org.bukkit.Bukkit;

public class Output {

    public static void log(String msg) {

        String log = Chat.color(FAPI.internalPrefix + "&b " + msg);
        Bukkit.getConsoleSender().sendMessage(log);

    }

    public static void warn(String msg) {

        String warn = Chat.color(FAPI.internalPrefix + "&x&F&B&6&1&0&B " + msg);
        Bukkit.getConsoleSender().sendMessage(warn);

    }

    public static void err(String msg) {

        String err = Chat.color(FAPI.internalPrefix + "&x&D&A&1&2&1&2 " + msg);
        Bukkit.getConsoleSender().sendMessage(err);

    }

}
