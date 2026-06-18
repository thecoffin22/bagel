package net.coffin.bagel.item;

import net.coffin.bagel.BagelMod;
import net.coffin.bagel.item.custom.EnchantedGoldenBagelItem;
import net.coffin.bagel.item.custom.TotemFulfillmentItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
    public static final Item BAGEL = registerItem("bagel", setting -> new Item(setting.food(ModFoodComponents.BAGEL)));
    public static final Item BAKED_BAGEL = registerItem("baked_bagel", setting -> new Item(setting.food(ModFoodComponents.BAKED_BAGEL, ModFoodComponents.BAKED_BAGEL_EFFECT)));
    public static final Item BURNT_BAGEL = registerItem("burnt_bagel", setting -> new Item(setting.food(ModFoodComponents.BURNT_BAGEL, ModFoodComponents.BURNT_BAGEL_EFFECT)
            .fireproof()));
    public static final Item GOLDEN_BAGEL = registerItem("golden_bagel", setting -> new Item(setting.food(ModFoodComponents.GOLDEN_BAGEL, ModFoodComponents.GOLDEN_BAGEL_EFFECT)));
    public static final Item ENCHANTED_GOLDEN_BAGEL = registerItem( "enchanted_golden_bagel", setting -> new EnchantedGoldenBagelItem(setting.food(ModFoodComponents.ENCHANTED_GOLDEN_BAGEL, ModFoodComponents.ENCHANTED_GOLDEN_BAGEL_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item TOTEM_FULFILLMENT = registerItem( "totem_fulfillment", setting -> new TotemFulfillmentItem(setting
            .maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item BAGEL_BOOTS = registerItem("bagel_boots",
            setting -> new ArmorItem(ModArmorMaterials.BAGEL_ARMOR, EquipmentType.BOOTS, setting
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(4))));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(BagelMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BagelMod.MOD_ID, name)))));
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
