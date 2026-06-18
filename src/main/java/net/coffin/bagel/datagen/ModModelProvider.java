package net.coffin.bagel.datagen;

import net.coffin.bagel.BagelMod;
import net.coffin.bagel.item.ModArmorMaterials;
import net.coffin.bagel.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BAGEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKED_BAGEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNT_BAGEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_BAGEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_BAGEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOTEM_FULFILLMENT, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.BAGEL_BOOTS, Identifier.of(BagelMod.MOD_ID, "bagel"),
                ModArmorMaterials.BAGEL_ARMOR_MATERIAL, EquipmentSlot.FEET
        );
    }
}