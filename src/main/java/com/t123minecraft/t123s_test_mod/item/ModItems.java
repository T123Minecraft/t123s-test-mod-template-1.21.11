package com.t123minecraft.t123s_test_mod.item;

import com.t123minecraft.t123s_test_mod.T123sTestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item createItem() {
        Identifier identifier = Identifier.of(T123sTestMod.MOD_ID, "test_item");
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), identifier);
        return new Item(new Item.Settings().registryKey(key));
    }
    private static void addItemToItemGroup(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(TEST_ITEM);
    }

    public static final Item TEST_ITEM = createItem();

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToItemGroup);
        Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(),
                Identifier.of(T123sTestMod.MOD_ID, "test_item")), TEST_ITEM);
    }
}
