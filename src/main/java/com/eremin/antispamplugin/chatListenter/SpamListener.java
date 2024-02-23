package com.eremin.antispamplugin.chatListenter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpamListener implements Listener {
    private Map<Player, Long> lastChatTimeMap = new HashMap<>();
    private int cooldownSeconds = 30;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    @EventHandler
    public void PlayerChatListenter(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        executorService.execute(() -> {
            if (isChatSpamming(player)) {
                e.setCancelled(true);
                player.sendMessage("§e!!"+" §6请不要频繁发送消息 " + "§e!!");
                e.setMessage("");
            } else {
                lastChatTimeMap.put(player, System.currentTimeMillis());
            }
        });
    }
    private boolean isChatSpamming(Player player) {
        if (lastChatTimeMap.containsKey(player)) {
            long lastChatTime = lastChatTimeMap.get(player);
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - lastChatTime) / 1000;

            return elapsedTime < cooldownSeconds;
        }
        return false;
    }
}