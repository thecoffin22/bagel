package net.coffin.bagel.item;

import net.coffin.bagel.BagelMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BAGEL_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BagelMod.MOD_ID, "bagel_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BAGEL))
                    .displayName(Text.translatable( "itemgroup.bagel.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BAGEL);
                        entries.add(ModItems.BAKED_BAGEL);
                        entries.add(ModItems.BURNT_BAGEL);
                        entries.add(ModItems.GOLDEN_BAGEL);
                        entries.add(ModItems.ENCHANTED_GOLDEN_BAGEL);
                        entries.add(ModItems.TOTEM_FULFILLMENT);
                        entries.add(ModItems.BAGEL_BOOTS);


                    }).build());

    public static void registerItemGroups() {
        BagelMod.LOGGER.info("Registering Mod Items for " + BagelMod.MOD_ID);
    }
}
