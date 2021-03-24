package org.jayjaytee.planetreego.libs;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.stream.Collectors;

public class TextUtils {
    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static List<String> color(List<String> strs) {
        return strs.stream()
                .map(TextUtils::color)
                .collect(Collectors.toList());
    }

    public static void send(CommandSender sender, String str) {
        sender.sendMessage(color(str));
    }
}