package net.coffin.bagel.datagen;

import net.coffin.bagel.item.ModItems;
import net.coffin.bagel.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.SMOKED_BAKED_BAGEL)
                .add(ModItems.BAGEL);

        getOrCreateTagBuilder(ModTags.Items.SMOKED_BURNT_BAGEL)
                .add(ModItems.BAKED_BAGEL);

        getOrCreateTagBuilder(ModTags.Items.CRAFT_GOLDEN_BAGEL)
                .add(ModItems.BAGEL)
                .add(ModItems.BAKED_BAGEL);

        getOrCreateTagBuilder(ModTags.Items.CRAFT_BAGEL_BOOTS)
                .add(ModItems.BAGEL)
                .add(ModItems.BAKED_BAGEL);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BAGEL_BOOTS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.BAGEL_BOOTS);

    }
}