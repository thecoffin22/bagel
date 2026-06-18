package net.coffin.bagel.item;

import net.coffin.bagel.BagelMod;
import net.coffin.bagel.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static EquipmentModel BAGEL_ARMOR_MATERIAL = EquipmentModel.builder().addHumanoidLayers(Identifier.of(BagelMod.MOD_ID, "bagel")).build();

    public static final ArmorMaterial BAGEL_ARMOR = new ArmorMaterial(10, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0,0, ModTags.Items.CRAFT_BAGEL_BOOTS,
            Identifier.of(BagelMod.MOD_ID, "bagel"));
}