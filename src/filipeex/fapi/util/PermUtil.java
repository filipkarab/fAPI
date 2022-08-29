package filipeex.fapi.util;

import filipeex.fapi.structs.Replacement;
import filipeex.fapi.structs.ReplacementSet;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermUtil {

    public static boolean hasPermission(CommandSender sender, String perm, boolean sendNoPermMessage) {

        if (!sender.hasPermission(perm) && sendNoPermMessage) {
            if (sender instanceof Player)
                Message.send((Player) sender, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            else
                Message.send(sender, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            Output.warn(sender.getName() + " tried to execute an action, which is locked under permission " + perm + " that they don't have!");
        }

        return sender.hasPermission(perm);

    }

    public static boolean hasPermission(CommandSender sender, String perm) {

        if (!sender.hasPermission(perm)) {
            if (sender instanceof Player)
                Message.send((Player) sender, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            else
                Message.send(sender, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            Output.warn(sender.getName() + " tried to execute an action, which is locked under permission " + perm + " that they don't have!");
        }

        return sender.hasPermission(perm);

    }

    public static boolean hasPermission(Player p, String perm, boolean sendNoPermMessage) {

        if (!p.hasPermission(perm) && sendNoPermMessage) {
                Message.send(p, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            Output.warn(p.getName() + " tried to execute an action, which is locked under permission " + perm + " that they don't have!");
        }

        return p.hasPermission(perm);

    }

    public static boolean hasPermission(Player p, String perm) {

        if (!p.hasPermission(perm)) {
            Message.send(p, "no-permission", new ReplacementSet(new Replacement("%permission%", perm)));
            Output.warn(p.getName() + " tried to execute an action, which is locked under permission " + perm + " that they don't have!");
        }

        return p.hasPermission(perm);

    }

}
