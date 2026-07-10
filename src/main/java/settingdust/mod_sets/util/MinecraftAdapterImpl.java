package settingdust.mod_sets.util;

import net.minecraft.resources.ResourceLocation;

public class MinecraftAdapterImpl implements MinecraftAdapter {
    @Override
    public ResourceLocation id(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }
}
