package net.coffin.bagel.events;

import net.coffin.bagel.item.custom.TotemFulfillmentItem;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class TotemFulfillmentEvents {

    public static void register() {

        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, source, amount) -> {

            if (!(entity instanceof PlayerEntity player)) {
                return true;
            }

            // Main hand
            ItemStack mainHand = player.getMainHandStack();

            if (mainHand.getItem() instanceof TotemFulfillmentItem) {

                if (TotemFulfillmentItem.activateTotem(mainHand, player)) {
                    return false;
                }
            }

            // Offhand
            ItemStack offHand = player.getOffHandStack();

            if (offHand.getItem() instanceof TotemFulfillmentItem) {

                if (TotemFulfillmentItem.activateTotem(offHand, player)) {
                    return false;
                }
            }

            return true;
        });
    }
}