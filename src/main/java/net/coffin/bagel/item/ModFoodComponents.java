package net.coffin.bagel.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BAGEL = new FoodComponent.Builder().nutrition(5).saturationModifier(0.20f)
            .build();
    public static final FoodComponent BAKED_BAGEL = new FoodComponent.Builder().nutrition(6).saturationModifier(0.35f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,20 * 1, 0), 0.1F)
            .build();
}