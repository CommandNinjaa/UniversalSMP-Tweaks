package me.commandninja.universaltweaks.mixin;

import mc.mian.lifesteal.common.item.custom.HeartCrystalItem;
import mc.mian.lifesteal.common.item.custom.ReviveCrystalItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public class MixinItemEntity {


    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.is(DamageTypes.CACTUS)) {
            ItemStack stack = ((ItemEntity)(Object)this).getItem();
            if (stack.getItem() instanceof ReviveCrystalItem){
                cir.setReturnValue(false);
                cir.cancel();
            }

            if (stack.getItem() instanceof HeartCrystalItem){
                cir.setReturnValue(false);
                cir.cancel();
            }

        }
    }
}

