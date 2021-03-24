package org.jayjaytee.planetreego.libs;

import org.bukkit.Bukkit;

public class NBTUtils {
    public static NBTUtil instance;

    static {
        String name = Bukkit.getServer().getClass().getName();
        String[] parts = name.split("\\.");
        String serverVersion = parts[3];
        if (serverVersion.startsWith("v1_12"))
            instance = new NBTUtils1_12();
        /*if(serverVersion.startsWith("v1_8"))
            instance = new NBTUtils1_8();*/
    }
}