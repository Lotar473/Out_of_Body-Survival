package org.enteras.project_lostar;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class InventoryChangeCommandExecutor implements CommandExecutor {

    private final InventoryChangePlugin plugin;

    public InventoryChangeCommandExecutor(InventoryChangePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (plugin == null) {
            sender.sendMessage(ChatColor.RED + "플러그인이 초기화되지 않았거나 로드되지 않았습니다.");
            return true;
        }

        if (label.equalsIgnoreCase("inventorychange") && sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("4732")) {
                    if (!plugin.isInventoryChangeEnabled()) {
                        plugin.setInventoryChangeEnabled(true);
                        sender.sendMessage(ChatColor.GREEN + "무언가가 활성화되었습니다.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f);
                    } else {
                        sender.sendMessage("무언가가 이미 켜져 있습니다.");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.8f, 0.5f);

                    }
                } else if (args[0].equalsIgnoreCase("0473")) {
                    if (plugin.isInventoryChangeEnabled()) {
                        plugin.setInventoryChangeEnabled(false);
                        sender.sendMessage(ChatColor.GREEN + "유체이탈 기능이 비활성화되었습니다.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f);
                    } else {
                        sender.sendMessage("무언가가 이미 꺼져 있습니다.");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.8f, 0.5f);
                    }
                }
            } else {
                sender.sendMessage("올바른 명령어 사용법: /inventorychange <password>");
            }
            return true;
        }
        return false;
    }
}
