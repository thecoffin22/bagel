package net.coffin.bagel.datagen;

import net.coffin.bagel.item.ModItems;
import net.coffin.bagel.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.CookingRecipeJsonBuilder.createCampfireCooking;
import static net.minecraft.data.server.recipe.CookingRecipeJsonBuilder.createSmoking;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {




                List<ItemConvertible> BLAST_BURNT_BAGEL = List.of(ModItems.BAGEL, ModItems.BAKED_BAGEL);

                offerBlasting(BLAST_BURNT_BAGEL, RecipeCategory.MISC, ModItems.BURNT_BAGEL, 0.25f, 100, "pladium_ingot");

                createShaped(RecipeCategory.MISC, ModItems.BAGEL, 2)
                        .pattern(" R ")
                        .pattern("R R")
                        .pattern(" R ")
                        .input('R', Items.WHEAT)
                        .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                        .offerTo(exporter);

                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.BAGEL), RecipeCategory.FOOD, ModItems.BAKED_BAGEL, 0.15f, 100)
                        .criterion(hasItem(ModItems.BAGEL), conditionsFromItem(ModItems.BAGEL))
                        .offerTo(exporter, getRecipeName(ModItems.BAKED_BAGEL) + "_from_smoker");

                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.BAKED_BAGEL), RecipeCategory.FOOD, ModItems.BURNT_BAGEL, 0.15f, 100)
                        .criterion(hasItem(ModItems.BAKED_BAGEL), conditionsFromItem(ModItems.BAKED_BAGEL))
                        .offerTo(exporter, getRecipeName(ModItems.BURNT_BAGEL) + "_from_smoker");

                createShaped(RecipeCategory.MISC, ModItems.GOLDEN_BAGEL, 1)
                        .pattern("EEE")
                        .pattern("ERE")
                        .pattern("EEE")
                        .input('R', ModTags.Items.CRAFT_GOLDEN_BAGEL)
                        .input('E', Items.GOLD_NUGGET)
                        .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TOTEM_FULFILLMENT, 1)
                        .pattern(" T ")
                        .pattern("RER")
                        .pattern(" W ")
                        .input('E', Items.TOTEM_OF_UNDYING)
                        .input('T', ModItems.ENCHANTED_GOLDEN_BAGEL)
                        .input('W', ModItems.GOLDEN_BAGEL)
                        .input('R', Items.HAY_BLOCK)
                        .criterion(hasItem(Items.TOTEM_OF_UNDYING), conditionsFromItem(Items.TOTEM_OF_UNDYING))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.BAGEL_BOOTS, 1)
                        .pattern("E E")
                        .input('E', ModTags.Items.CRAFT_BAGEL_BOOTS)
                        .criterion(hasItem(ModItems.BAGEL), conditionsFromItem(ModItems.BAGEL))
                        .offerTo(exporter);
            }

        };
    }

    @Override
    public String getName() {
        return "BagelMod Recipes";
    }
}
