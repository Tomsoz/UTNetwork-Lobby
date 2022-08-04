package tk.utnetwork.utnetworklobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class GameModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gmc") || cmd.getName().equalsIgnoreCase("gms") || cmd.getName().equalsIgnoreCase("gma") || cmd.getName().equalsIgnoreCase("gmsp")) {
            if (cmd.getName().equalsIgnoreCase("gmc")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (args.length == 0) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + p.getName() + "&3."));
                    } else if (args.length == 1) {
                        if (p.hasPermission("staff.gamemode.creative.others")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage(Utils.chat("&3Your game mode has been updated to &bcreative&3."));
                                if (target != p) {
                                    p.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + target.getName() + "&3."));
                                }
                            } else {
                                p.sendMessage(Utils.chat("&cUsage: /gmc [player]"));
                            }
                        }
                    } else {
                        p.sendMessage(Utils.chat("&cUsage: /gmc [player]"));
                    }
                } else {
                    if (args.length > 0) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bcreative&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gmc <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gmc <player>"));
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("gms")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (args.length == 0) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + p.getName() + "&3."));
                    } else if (args.length == 1){
                        if (p.hasPermission("staff.gamemode.survival.others")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage(Utils.chat("&3Your game mode has been updated to &bsurvival&3."));
                                if (target != p) {
                                    p.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + target.getName() + "&3."));
                                }
                            } else {
                                p.sendMessage(Utils.chat("&cUsage: /gms [player]"));
                            }
                        }
                    } else {
                        p.sendMessage(Utils.chat("&cUsage: /gms [player]"));
                    }
                } else {
                    if (args.length > 0) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bsurvival&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gms <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gms <player>"));
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("gma")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (args.length == 0) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + p.getName() + "&3."));
                    } else if (args.length == 1){
                        if (p.hasPermission("staff.gamemode.adventure.others")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage(Utils.chat("&3Your game mode has been updated to &badventure&3."));
                                if (target != p) {
                                    p.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + target.getName() + "&3."));
                                }
                            } else {
                                p.sendMessage(Utils.chat("&cUsage: /gma [player]"));
                            }
                        }
                    } else {
                        p.sendMessage(Utils.chat("&cUsage: /gma [player]"));
                    }
                } else {
                    if (args.length > 0) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &badventure&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gma <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gma <player>"));
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("gmsp")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (args.length == 0) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + p.getName() + "&3."));
                    } else if (args.length == 1){
                        if (p.hasPermission("staff.gamemode.spectator.others")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage(Utils.chat("&3Your game mode has been updated to &bspectator&3."));
                                if (target != p) {
                                    p.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + target.getName() + "&3."));
                                }
                            } else {
                                p.sendMessage(Utils.chat("&cUsage: /gmsp [player]"));
                            }
                        }
                    } else {
                        p.sendMessage(Utils.chat("&cUsage: /gmsp [player]"));
                    }
                } else {
                    if (args.length > 0) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bspectator&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gmsp <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gmsp <player>"));
                    }
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")) {

            if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") ) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("staff.gamemode.creative")) {
                        if (args.length == 1) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + p.getName() + "&3."));
                        } else if (args.length == 2){
                            if (p.hasPermission("staff.gamemode.creative.others")) {
                                Player target = Bukkit.getPlayer(args[0]);
                                if (target != null) {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(Utils.chat("&3Your game mode has been updated to &bcreative&3."));
                                    if (target != p) {
                                        p.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + target.getName() + "&3."));
                                    }
                                } else {
                                    p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                                }
                            }
                        } else {
                            p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                        }
                    }
                } else {
                    if (args.length > 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bcreative&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bcreative &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                    }
                }
            } else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("staff.gamemode.survival")) {
                        if (args.length == 1) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + p.getName() + "&3."));
                        } else if (args.length == 2){
                            if (p.hasPermission("staff.gamemode.survival.others")) {
                                Player target = Bukkit.getPlayer(args[0]);
                                if (target != null) {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage(Utils.chat("&3Your game mode has been updated to &bsurvival&3."));
                                    if (target != p) {
                                        p.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + target.getName() + "&3."));
                                    }
                                } else {
                                    p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                                }
                            }
                        } else {
                            p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                        }
                    }
                } else {
                    if (args.length > 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bsurvival&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bsurvival &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                    }
                }
            } else if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("staff.gamemode.adventure")) {
                        if (args.length == 1) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + p.getName() + "&3."));
                        } else if (args.length == 2){
                            if (p.hasPermission("staff.gamemode.adventure.others")) {
                                Player target = Bukkit.getPlayer(args[0]);
                                if (target != null) {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage(Utils.chat("&3Your game mode has been updated to &badventure&3."));
                                    if (target != p) {
                                        p.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + target.getName() + "&3."));
                                    }
                                } else {
                                    p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                                }
                            }
                        } else {
                            p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                        }
                    }
                } else {
                    if (args.length > 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &badventure&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &badventure &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                    }
                }
            } else if (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("staff.gamemode.spectator")) {
                        if (args.length == 1) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + p.getName() + "&3."));
                        } else if (args.length == 2){
                            if (p.hasPermission("staff.gamemode.spectator.others")) {
                                Player target = Bukkit.getPlayer(args[0]);
                                if (target != null) {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage(Utils.chat("&3Your game mode has been updated to &bspectator&3."));
                                    if (target != p) {
                                        p.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + target.getName() + "&3."));
                                    }
                                } else {
                                    p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                                }
                            }
                        } else {
                            p.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> [player]"));
                        }
                    }
                } else {
                    if (args.length > 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(Utils.chat("&3Your game mode has been updated to &bspectator&3."));
                            sender.sendMessage(Utils.chat("&3Set game mode &bspectator &3for &b" + target.getName() + "&3."));
                        } else {
                            sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cUsage: /gamemode <game mode> <player>"));
                    }
                }
            }
        }
        return false;
    }
}

