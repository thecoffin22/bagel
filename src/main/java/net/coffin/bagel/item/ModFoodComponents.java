package net.coffin.bagel.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodComponent BAGEL = new FoodComponent.Builder().nutrition(5).saturationModifier(0.50f)
            .build();
    public static final FoodComponent BAKED_BAGEL = new FoodComponent.Builder().nutrition(6).saturationModifier(0.65f).build();
    public static final ConsumableComponent BAKED_BAGEL_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 0), 0.01f)).build();

    public static final FoodComponent BURNT_BAGEL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.30f).build();
    public static final ConsumableComponent BURNT_BAGEL_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 8, 0), 0.75f)).build();

    public static final FoodComponent GOLDEN_BAGEL = new FoodComponent.Builder().nutrition(5).saturationModifier(0.9f)
            .alwaysEdible().build();
    public static final ConsumableComponent GOLDEN_BAGEL_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 20, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 4, 0), 0.5f))
            .build();

    public static final FoodComponent ENCHANTED_GOLDEN_BAGEL = new FoodComponent.Builder().nutrition(8).saturationModifier(0.9f)
            .alwaysEdible().build();
    public static final ConsumableComponent ENCHANTED_GOLDEN_BAGEL_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 60 * 4, 2), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 22, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 60 * 4, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 60 * 4, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20 * 10, 2), 1f))
            .build();
}