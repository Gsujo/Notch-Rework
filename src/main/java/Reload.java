import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Main.getInstance().reloadConfig();
        Main.getInstance().registerRecipe();
        sender.sendMessage(ChatColor.GREEN + "Reloaded notch config!");
        return true;
    }
}