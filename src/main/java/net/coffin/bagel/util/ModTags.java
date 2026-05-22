package net.coffin.bagel.util;

import net.coffin.bagel.BagelMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> SMOKED_BAKED_BAGEL = createTag("smoked_baked_bagel");
        public static final TagKey<Item> SMOKED_BURNT_BAGEL = createTag("smoked_burnt_bagel");
        public static final TagKey<Item> CRAFT_GOLDEN_BAGEL = createTag("smoked_burnt_bagel");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BagelMod.MOD_ID, name));
        }
    }
}
