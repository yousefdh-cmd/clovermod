package com.clovermod;

import java.util.List;

import com.clovermod.CloverItem.Effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CloverMod.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CloverMod.MOD_ID);

    private static final int MIN = 60;

    // 3 leaves: Speed I (10 s)
    public static final DeferredItem<CloverItem> THREE_LEAF_CLOVER = ITEMS.registerItem("three_leaf_clover",
            p -> new CloverItem(p, List.of(
                    new Effect(MobEffects.MOVEMENT_SPEED, 10, 1))));

    // 4 leaves: Luck I + Hero I (30 min) + Haste I (5 min)
    public static final DeferredItem<CloverItem> FOUR_LEAF_CLOVER = ITEMS.registerItem("four_leaf_clover",
            p -> new CloverItem(p, List.of(
                    new Effect(MobEffects.LUCK, 30 * MIN, 1),
                    new Effect(MobEffects.HERO_OF_THE_VILLAGE, 30 * MIN, 1),
                    new Effect(MobEffects.DIG_SPEED, 5 * MIN, 1))));

    // 5 leaves (531,441 seeds): Luck II + Hero I (30 min), Regeneration I (5 min), Absorption VI (5 min),
    //   Speed II (5 min), Haste II (10 min), Strength I (5 min), Resistance I (5 min)
    public static final DeferredItem<CloverItem> FIVE_LEAF_CLOVER = ITEMS.registerItem("five_leaf_clover",
            p -> new CloverItem(p, List.of(
                    new Effect(MobEffects.LUCK, 30 * MIN, 2),
                    new Effect(MobEffects.HERO_OF_THE_VILLAGE, 30 * MIN, 1),
                    new Effect(MobEffects.REGENERATION, 5 * MIN, 1),
                    new Effect(MobEffects.ABSORPTION, 5 * MIN, 6),
                    new Effect(MobEffects.MOVEMENT_SPEED, 5 * MIN, 2),
                    new Effect(MobEffects.DIG_SPEED, 10 * MIN, 2),
                    new Effect(MobEffects.DAMAGE_BOOST, 5 * MIN, 1),
                    new Effect(MobEffects.DAMAGE_RESISTANCE, 5 * MIN, 1))));

    // 6 leaves (43,046,721 seeds): Luck III + Hero II (30 min), Regeneration II (5 min), Absorption XII (5 min),
    //   Speed II + Haste III + Strength II + Resistance II (10 min), Fire Resistance + Night Vision (15 min)
    public static final DeferredItem<CloverItem> SIX_LEAF_CLOVER = ITEMS.registerItem("six_leaf_clover",
            p -> new CloverItem(p, List.of(
                    new Effect(MobEffects.LUCK, 30 * MIN, 3),
                    new Effect(MobEffects.HERO_OF_THE_VILLAGE, 30 * MIN, 2),
                    new Effect(MobEffects.REGENERATION, 5 * MIN, 2),
                    new Effect(MobEffects.ABSORPTION, 5 * MIN, 12),
                    new Effect(MobEffects.MOVEMENT_SPEED, 10 * MIN, 2),
                    new Effect(MobEffects.DIG_SPEED, 10 * MIN, 3),
                    new Effect(MobEffects.DAMAGE_BOOST, 10 * MIN, 2),
                    new Effect(MobEffects.DAMAGE_RESISTANCE, 10 * MIN, 2),
                    new Effect(MobEffects.FIRE_RESISTANCE, 15 * MIN, 1),
                    new Effect(MobEffects.NIGHT_VISION, 15 * MIN, 1))));

    // 7 leaves (3,486,784,401 seeds): Luck IV + Hero III (30 min), Regeneration III (10 min), Absorption XX (10 min),
    //   Speed III + Haste IV + Strength III + Resistance III (15 min),
    //   Fire Resistance + Water Breathing + Night Vision (30 min)
    public static final DeferredItem<CloverItem> SEVEN_LEAF_CLOVER = ITEMS.registerItem("seven_leaf_clover",
            p -> new CloverItem(p, List.of(
                    new Effect(MobEffects.LUCK, 30 * MIN, 4),
                    new Effect(MobEffects.HERO_OF_THE_VILLAGE, 30 * MIN, 3),
                    new Effect(MobEffects.REGENERATION, 10 * MIN, 3),
                    new Effect(MobEffects.ABSORPTION, 10 * MIN, 20),
                    new Effect(MobEffects.MOVEMENT_SPEED, 15 * MIN, 3),
                    new Effect(MobEffects.DIG_SPEED, 15 * MIN, 4),
                    new Effect(MobEffects.DAMAGE_BOOST, 15 * MIN, 3),
                    new Effect(MobEffects.DAMAGE_RESISTANCE, 15 * MIN, 3),
                    new Effect(MobEffects.FIRE_RESISTANCE, 30 * MIN, 1),
                    new Effect(MobEffects.WATER_BREATHING, 30 * MIN, 1),
                    new Effect(MobEffects.NIGHT_VISION, 30 * MIN, 1))));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CLOVER_TAB = TABS.register("clovers",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.clovermod"))
                    .icon(() -> new ItemStack(FOUR_LEAF_CLOVER.get()))
                    .displayItems((params, output) -> {
                        output.accept(THREE_LEAF_CLOVER.get());
                        output.accept(FOUR_LEAF_CLOVER.get());
                        output.accept(FIVE_LEAF_CLOVER.get());
                        output.accept(SIX_LEAF_CLOVER.get());
                        output.accept(SEVEN_LEAF_CLOVER.get());
                    })
                    .build());
}
