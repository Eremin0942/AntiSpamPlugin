package com.eremin.antispamplugin;

import com.eremin.antispamplugin.chatListenter.SpamListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private LoggerUtil loggerUtil;
    String watermark = """
             
            --------------------------------------------
             _       _   _   _____       ___   _____ \s
            | |     | | | | /  ___|     /   | /  ___/\s
            | |     | | | | | |        / /| | | |___ \s
            | |     | | | | | |       / / | | \\___  \\\s
            | |___  | |_| | | |___   / /  | |  ___| |\s
            |_____| \\_____/ \\_____| /_/   |_| /_____/\s
            
            --------------------------------------------
            version = "1.0-build";
            """;
    @Override
    public void onEnable(){
        System.out.println(watermark);
        Bukkit.getPluginManager().registerEvents(new SpamListener(), this);
    }

    @Override
    public void onDisable() {
    loggerUtil.log("AntiSpamPlugin is Shut down");
    }
}
