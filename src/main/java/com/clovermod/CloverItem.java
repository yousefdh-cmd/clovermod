package com.clovermod;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/** A clover that gives potion effects on right click and is consumed. */
public class CloverItem extends Item {

    /** @param level the effect level as players see it (1 = level I). */
    public record Effect(Holder<MobEffect> effect, int seconds, int level) {}

    private final List<Effect> effects;

    public CloverItem(Properties properties, List<Effect> effects) {
        super(properties);
        this.effects = effects;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            for (Effect e : effects) {
                player.addEffect(new MobEffectInstance(e.effect(), e.seconds() * 20, e.level() - 1));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP,
                    SoundSource.PLAYERS, 1.0F, 1.0F);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
