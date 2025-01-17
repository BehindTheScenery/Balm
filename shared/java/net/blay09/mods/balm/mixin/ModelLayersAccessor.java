package net.blay09.mods.balm.mixin;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;
import java.util.stream.Collectors;

@Mixin(ModelLayers.class)
public interface ModelLayersAccessor {
    @Accessor("ALL_MODELS")
    static Set<ModelLayerLocation> getAllModels() {
        return ModelLayers.getKnownLocations().collect(Collectors.toSet());
    }
}
