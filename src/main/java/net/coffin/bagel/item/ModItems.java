package net.coffin.bagel.item;

import net.coffin.bagel.BagelMod;
import net.coffin.bagel.item.custom.EnchantedGoldenBagelItem;
import net.coffin.bagel.item.custom.TotemFulfillmentItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item BAGEL = registerItem("bagel", new Item(new Item.Settings().food(ModFoodComponents.BAGEL)));
    public static final Item BAKED_BAGEL = registerItem("baked_bagel", new Item(new Item.Settings().food(ModFoodComponents.BAKED_BAGEL)));
    public static final Item BURNT_BAGEL = registerItem("burnt_bagel", new Item(new Item.Settings().food(ModFoodComponents.BURNT_BAGEL)
            .fireproof()));
    public static final Item GOLDEN_BAGEL = registerItem("golden_bagel", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_BAGEL)));
    public static final Item ENCHANTED_GOLDEN_BAGEL = registerItem( "enchanted_golden_bagel", new EnchantedGoldenBagelItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_GOLDEN_BAGEL)
            .rarity(Rarity.RARE)));
    public static final Item TOTEM_FULFILLMENT = registerItem( "totem_fulfillment", new TotemFulfillmentItem(new Item.Settings()
            .maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item BAGEL_BOOTS = registerItem("bagel_boots",
            new ArmorItem(ModArmorMaterials.BAGEL_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(4))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BagelMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BagelMod.LOGGER.info("Registering Mod Items for " + BagelMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BAGEL);
            fabricItemGroupEntries.add(BAKED_BAGEL);
            fabricItemGroupEntries.add(BURNT_BAGEL);
            fabricItemGroupEntries.add(GOLDEN_BAGEL);
            fabricItemGroupEntries.add(ENCHANTED_GOLDEN_BAGEL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TOTEM_FULFILLMENT);
            fabricItemGroupEntries.add(BAGEL_BOOTS);
        });
    }
}
