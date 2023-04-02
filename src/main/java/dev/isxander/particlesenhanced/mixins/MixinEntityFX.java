package dev.isxander.particlesenhanced.mixins;

import dev.isxander.particlesenhanced.config.ParticlesEnhancedConfig;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityFX.class)
public abstract class MixinEntityFX {
    @Shadow public abstract void setAlphaF(float alpha);
    @Shadow public abstract float getAlpha();

    @Shadow protected int particleAge;
    @Shadow protected int particleMaxAge;

    @Inject(method = "renderParticle", at = @At("HEAD"))
    private void injectOpacity(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ, CallbackInfo ci) {

        if (!ParticlesEnhancedConfig.INSTANCE.getFade()) return;

        float lifeSpan = (particleAge - (particleMaxAge * (ParticlesEnhancedConfig.INSTANCE.getMinFadeTransparency() / 100f)) / (particleMaxAge - (particleMaxAge * (ParticlesEnhancedConfig.INSTANCE.getMinFadeTransparency() / 100f))));
        if (lifeSpan > ParticlesEnhancedConfig.INSTANCE.getFadeOutStart()) {
            float alpha = 1 - lifeSpan + ParticlesEnhancedConfig.INSTANCE.getFadeOutStart();
            if (getAlpha() != alpha) setAlphaF(alpha);
        }
    }

}
