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

import java.util.List;
import me.commandninja.universaltweaks.config.UniversalTweaksCommon;
import net.minecraft.core.registries.BuiltInRegistries;




@Mixin(ItemEntity.class)
public class MixinItemEntity {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.is(DamageTypes.CACTUS)) {

     //       List<? extends String> itemIds = UniversalTweaksCommon.IMMUNE_ITEMS.get();

            ItemStack stack = ((ItemEntity)(Object)this).getItem();

     //       ((ItemEntity)(Object)this).level().players().stream()
     //               .filter(p -> p instanceof ServerPlayer)
     //               .forEach(p -> {
      //                  ServerPlayer sp = (ServerPlayer) p;
     //                   sp.sendSystemMessage(Component.literal("§a[Immun-Items gegen Kaktus:]"));
     //                   for (String id : itemIds) {
      //                      sp.sendSystemMessage(Component.literal(" - §e" + id));
    //                    }
   //                 });

        //    if (stack.getItem() instanceof ReviveCrystalItem){
        //        cir.setReturnValue(false);
        //        cir.cancel();
        //    }

        //    if (stack.getItem() instanceof HeartCrystalItem){
        //        cir.setReturnValue(false);
        //        cir.cancel();
        //    }

            List<? extends String> itemIds = UniversalTweaksCommon.IMMUNE_ITEMS.get();
            String itemId = BuiltInRegistries.ITEM.getKey(stack.getItem()).toString();

            if (itemIds.contains(itemId)) {
                cir.setReturnValue(false);
                cir.cancel();
            }


        }
    }

}
