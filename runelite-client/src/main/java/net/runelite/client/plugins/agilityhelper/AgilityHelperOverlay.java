package net.runelite.client.plugins.agilityhelper;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;


class AgilityHelperOverlay extends Overlay {

    private final Client client;
    private final AgilityHelperConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private AgilityHelperOverlay(Client client, AgilityHelperConfig config)
    {
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();
        String overlayTitle = "Agility Helper";

        // Build overlay title
        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle)
                .color(Color.GREEN)
                .build());

        // Set the size of the overlay (width)
        panelComponent.setPreferredSize(new Dimension(
                graphics.getFontMetrics().stringWidth(overlayTitle) + 30,
                0));

        // Add a line on the overlay for world number
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Running:")
                .right("unknown")
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Stop at low?:")
                .right(String.valueOf(config.stopAtLowHp()))
                .build());

        // Show world type goes here ...

        return panelComponent.render(graphics);
    }

}