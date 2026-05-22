package net.coffin.bagel.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BAGEL = new FoodComponent.Builder().nutrition(5).saturationModifier(0.50f)
            .build();
    public static final FoodComponent BAKED_BAGEL = new FoodComponent.Builder().nutrition(6).saturationModifier(0.65f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,30, 2), 0.01F)
            .build();

    public static final FoodComponent BURNT_BAGEL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.30f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 25, 0), 0.75F)
            .snack().build();

    public static final FoodComponent GOLDEN_BAGEL = new FoodComponent.Builder().nutrition(5).saturationModifier(1.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20 * 30, 0), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20 * 4, 0), 0.50F)
            .alwaysEdible().build();

    public static final FoodComponent ENCHANTED_GOLDEN_BAGEL = new FoodComponent.Builder().nutrition(8).saturationModifier(0.40f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20 * 60 * 3, 2), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20 * 18, 1), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 60 * 4, 0), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20 * 60 * 4, 0), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,20 * 20, 2), 1F)
            .alwaysEdible().build();
}