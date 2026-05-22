package net.coffin.bagel.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class TotemFulfillmentItem extends Item {

    public TotemFulfillmentItem(Settings settings) {
        super(settings);
    }

    public static boolean activateTotem(ItemStack stack, PlayerEntity player) {

        if (stack.isEmpty()) {
            return false;
        }

        stack.decrement(1);

        player.setHealth(1.0F);

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20 * 35, 4));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 180, 4));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 60, 1));

        player.getWorld().sendEntityStatus(player, (byte)35);

        player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));

        return true;
    }
}