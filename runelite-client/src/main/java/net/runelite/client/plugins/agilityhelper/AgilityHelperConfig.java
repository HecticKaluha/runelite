package net.runelite.client.plugins.agilityhelper;

// Mandatory imports

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("agilityhelper")
public interface AgilityHelperConfig extends Config {
    @ConfigItem(
            position = 1,
            keyName = "stopAtLowHp",
            name = "Stop at low HP",
            description = "If enabled: The helper stops when your character is on low HP"
    )
    default boolean stopAtLowHp() {
        return true;
    }
}