package net.runelite.client.plugins.agilityhelper;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Agility Helper",
        description = "An agility helper, sssht...",
        tags = {"agility", "laps", "course", "rooftop", "grace"},
        loadWhenOutdated = true,
        enabledByDefault = false
)
public class AgilityHelperPlugin extends Plugin{

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private AgilityHelperConfig config;

    @Inject AgilityHelperOverlay overlay;

    private Boolean running;

    @Provides
    AgilityHelperConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(AgilityHelperConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
        this.running = true;
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        this.running = false;
    }
}