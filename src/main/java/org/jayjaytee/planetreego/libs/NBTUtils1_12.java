/*
 * Copyright (c) 2020. UltraDev
 */

package org.jayjaytee.planetreego.libs;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NBTUtils1_12 extends NBTUtil {
    @NotNull
    public net.minecraft.server.v1_12_R1.ItemStack convertToNMS(@NotNull ItemStack item) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        if (!nmsItem.hasTag()) {
            nmsItem.setTag(new NBTTagCompound());
        }
        return nmsItem;
    }

    @NotNull
    private ItemStack convertToBukkit(net.minecraft.server.v1_12_R1.ItemStack item) {
        return CraftItemStack.asBukkitCopy(item);
    }

    @NotNull
    public ItemStack setInt(ItemStack item, String key, int value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setInt(key, value);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setDouble(ItemStack item, String key, double value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setDouble(key, value);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setLong(ItemStack item, String key, long value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setLong(key, value);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setString(ItemStack item, String key, String value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setString(key, value);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setBigDecimal(ItemStack item, String key, @NotNull BigDecimal value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setString(key, value.toString());
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setBigInteger(ItemStack item, String key, @NotNull BigInteger value) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setString(key, value.toString());
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public Integer getInt(ItemStack item, String key) throws IllegalArgumentException {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag().getInt(key);
    }

    @NotNull
    public Double getDouble(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag().getDouble(key);
    }

    @NotNull
    public ItemStack setByteArray(ItemStack item, String key, byte[] bytes) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().setByteArray(key, bytes);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    @Override
    public byte[] getByteArray(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag().getByteArray(key);
    }

    @NotNull
    public Long getLong(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag().getLong(key);
    }

    public String getString(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        if (!nmsItem.getTag().hasKey(key)) {
            return null;
        }
        return nmsItem.getTag().getString(key);
    }

    @Contract("_, _ -> new")
    @NotNull
    public BigDecimal getBigDecimal(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return new BigDecimal(nmsItem.getTag().getString(key));
    }

    @Contract("_, _ -> new")
    @NotNull
    public BigInteger getBigInteger(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return new BigInteger(nmsItem.getTag().getString(key));
    }

    public boolean hasTag(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag().hasKey(key);
    }

    @NotNull
    public ItemStack remove(ItemStack item, String key) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        nmsItem.getTag().remove(key);
        return convertToBukkit(nmsItem);
    }

    @NotNull
    public ItemStack setNBT(ItemStack item, NBTTagCompound nbts) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        nmsItem.setTag(nbts);
        return convertToBukkit(nmsItem);
    }

    public boolean hasNBTCompound(ItemStack item) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        return nmsItem.hasTag();
    }

    @NotNull
    public NBTTagCompound getNBTCompound(ItemStack item) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = convertToNMS(item);
        assert nmsItem.getTag() != null;
        return nmsItem.getTag();
    }
}