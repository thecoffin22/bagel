package net.coffin.bagel.item;

import net.coffin.bagel.BagelMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BAGEL = registerItem("bagel", new Item(new Item.Settings().food(ModFoodComponents.BAGEL)));
    public static final Item BAKED_BAGEL = registerItem("baked_bagel", new Item(new Item.Settings().food(ModFoodComponents.BAKED_BAGEL)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BagelMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BagelMod.LOGGER.info("Registering Mod Items for " + BagelMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BAGEL);

        });
    }
}
