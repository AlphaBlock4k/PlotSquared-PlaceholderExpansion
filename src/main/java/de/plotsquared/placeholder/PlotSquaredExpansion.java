package de.plotsquared.placeholder;

import com.plotsquared.bukkit.util.BukkitUtil;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.flag.PlotFlag;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PlaceholderAPI Expansion for PlotSquared
 * Checks if a player is standing on their own plot and checks plot flags
 *
 * @author AlphaBlock4k
 * @version 1.0.0
 */
public class PlotSquaredExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "plotowner";
    }

    @Override
    public @NotNull String getAuthor() {
        return "AlphaBlock4k";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.1";
    }

    @Override
    public @NotNull String getDescription() {
        return "Checks if a player is standing on their own plot and checks plot flags";
    }

    @Override
    public @NotNull String getRequiredPlugin() {
        return "PlotSquared";
    }

    @Override
    public boolean canRegister() {
        return getPlaceholderAPI().getServer().getPluginManager().getPlugin(getRequiredPlugin()) != null;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }

        if (params.equalsIgnoreCase("on_own_plot")) {
            return String.valueOf(isPlayerOnOwnPlot(player));
        }

        // Check if the parameter starts with "on_own_plot_" for flag checking
        if (params.toLowerCase().startsWith("on_own_plot_")) {
            String flagName = params.substring("on_own_plot_".length());
            return String.valueOf(isPlotFlagSet(player, flagName));
        }

        return null;
    }

    /**
     * Checks if the player is standing on their own plot
     *
     * @param player The player to check
     * @return true if the player is the owner of the current plot, false otherwise
     */
    private boolean isPlayerOnOwnPlot(Player player) {
        try {
            PlotPlayer<?> plotPlayer = BukkitUtil.adapt(player);
            Plot currentPlot = plotPlayer.getCurrentPlot();

            if (currentPlot == null) {
                return false;
            }

            return currentPlot.isOwner(plotPlayer.getUUID());

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if a specific flag is set on the plot where the player is standing
     *
     * @param player The player to check
     * @param flagName The name of the flag to check
     * @return true if the flag is set on the current plot, false otherwise
     */
    private boolean isPlotFlagSet(Player player, String flagName) {
        try {
            PlotPlayer<?> plotPlayer = BukkitUtil.adapt(player);
            Plot currentPlot = plotPlayer.getCurrentPlot();

            if (currentPlot == null) {
                return false;
            }

            // Get all flags from the plot
            for (PlotFlag<?, ?> flag : currentPlot.getFlags()) {
                if (flag.getName().equalsIgnoreCase(flagName)) {
                    return true;
                }
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }
}