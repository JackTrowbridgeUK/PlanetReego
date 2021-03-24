package org.jayjaytee.planetreego.libs;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class NBTUtil {
    @NotNull
    public abstract ItemStack setInt(ItemStack item, String key, int value);

    @NotNull
    public abstract ItemStack setDouble(ItemStack item, String key, double value);

    @NotNull
    public abstract ItemStack setLong(ItemStack item, String key, long value);

    @NotNull
    public abstract ItemStack setString(ItemStack item, String key, String value);

    @NotNull
    public abstract ItemStack setBigDecimal(ItemStack item, String key, @NotNull BigDecimal value);

    @NotNull
    public abstract ItemStack setBigInteger(ItemStack item, String key, @NotNull BigInteger value);

    @NotNull
    public abstract Integer getInt(ItemStack item, String key) throws IllegalArgumentException;

    @NotNull
    public abstract Double getDouble(ItemStack item, String key);

    @NotNull
    public abstract Long getLong(ItemStack item, String key);

    public abstract String getString(ItemStack item, String key);

    @Contract("_, _ -> new")
    @NotNull
    public abstract BigDecimal getBigDecimal(ItemStack item, String key);

    @Contract("_, _ -> new")
    @NotNull
    public abstract BigInteger getBigInteger(ItemStack item, String key);

    public abstract boolean hasTag(ItemStack item, String key);

    @NotNull
    public abstract ItemStack remove(ItemStack item, String key);

    @NotNull
    public abstract ItemStack setByteArray(ItemStack item, String key, byte[] bytes);

    @NotNull
    public abstract byte[] getByteArray(ItemStack item, String key);

    public abstract boolean hasNBTCompound(ItemStack item);
}