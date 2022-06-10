package me.permafreez.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.md_5.bungee.api.ChatColor;

public class Save implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> coords = new ArrayList<>();

		Player senderPlayer = null;
		if (sender instanceof Player) {
			senderPlayer = (Player) sender;
		} else {
			sender.sendMessage(
					ChatColor.RED.toString() + ChatColor.BOLD.toString() + "You have to be a player to use this.");
			return true;
		}

		if (args.length < 2) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "You have to specify a boundary box for the terrain!");

			return true;
		}

		int[] args1int = new int[3];
		try {
			String[] args1 = args[0].split(";");
			for (int i = 0; i < 3; i++) {
				args1int[i] = Integer.parseInt(args1[i]);
			}
		} catch (Exception e) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "There was a problem with the coordinates you gave");

			return false;
		}

		int[] args2int = new int[3];
		try {
			String[] args2 = args[1].split(";");
			for (int i = 0; i < 3; i++) {
				args2int[i] = Integer.parseInt(args2[i]);
			}
		} catch (Exception e) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "There was a problem with the coordinates you gave");

			return false;
		}

		Location playerLoc = senderPlayer.getLocation();
		if (!(playerLoc.getBlockX() < args1int[0] && playerLoc.getBlockX() > args2int[0]
				|| playerLoc.getBlockX() > args1int[0] && playerLoc.getBlockX() < args2int[0])) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "You are not in the boundary box you defined!");

			return true;
		}
		if (!(playerLoc.getBlockY() < args1int[1] && playerLoc.getBlockY() > args2int[1]
				|| playerLoc.getBlockY() > args1int[1] && playerLoc.getBlockY() < args2int[1])) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "You are not in the boundary box you defined!");

			return true;
		}
		if (!(playerLoc.getBlockZ() < args1int[2] && playerLoc.getBlockZ() > args2int[2]
				|| playerLoc.getBlockZ() > args1int[2] && playerLoc.getBlockZ() < args2int[2])) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "You are not in the boundary box you defined!");

			return true;
		}

		Block mainBlock = playerLoc.add(new Location(senderPlayer.getWorld(), 0, -1, 0)).getBlock();
		if (!mainBlock.getType().equals(Material.IRON_BLOCK)) {
			senderPlayer.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString()
					+ "You have to be standing on an iron block to use this!");

			return true;
		}

		// This stuff is disgusting af. I'm really sorry but I couldn't think of
		// anything better, than this terrible tree.
		if (args1int[0] < args2int[0]) {
			for (int i = args1int[0]; i < args2int[0]; i++) {
				if (args1int[1] < args2int[1]) {
					for (int i1 = args1int[1]; i1 < args2int[1]; i1++) {
						if (args1int[2] < args2int[2]) {
							for (int i2 = args1int[2]; i2 < args2int[2]; i2++) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						} else {
							for (int i2 = args1int[2]; i2 > args2int[2]; i2--) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						}
					}
				} else {
					for (int i1 = args1int[1]; i1 > args2int[1]; i1--) {
						if (args1int[2] < args2int[2]) {
							for (int i2 = args1int[2]; i2 < args2int[2]; i2++) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						} else {
							for (int i2 = args1int[2]; i2 > args2int[2]; i2--) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = args1int[0]; i > args2int[0]; i--) {
				if (args1int[1] < args2int[1]) {
					for (int i1 = args1int[1]; i1 < args2int[1]; i1++) {
						if (args1int[2] < args2int[2]) {
							for (int i2 = args1int[2]; i2 < args2int[2]; i2++) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						} else {
							for (int i2 = args1int[2]; i2 > args2int[2]; i2--) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						}
					}
				} else {
					for (int i1 = args1int[1]; i1 > args2int[1]; i1--) {
						if (args1int[2] < args2int[2]) {
							for (int i2 = args1int[2]; i2 < args2int[2]; i2++) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						} else {
							for (int i2 = args1int[2]; i2 > args2int[2]; i2--) {
								if (senderPlayer.getWorld().getBlockAt(i, i1, i2).getType()
										.equals(Material.IRON_BLOCK)) {
									int a = i - mainBlock.getLocation().getBlockX();
									int b = i1 - mainBlock.getLocation().getBlockY();
									int c = i2 - mainBlock.getLocation().getBlockZ();
									coords.add(a + ", " + b + ", " + c);
								}
							}
						}
					}
				}
			}
		}

		ItemStack writableBook = new ItemStack(Material.WRITABLE_BOOK);
		BookMeta bookMeta = (BookMeta) writableBook.getItemMeta();

		int pages = (int) (Math.floor(coords.size() / 14) + 1);

		for (int i = 0; i < pages; i++) {
			String page = "";
			bookMeta.addPage("");
			
			for (int i1 = 0; i1 < 14; i1++) {
				try {
					page = page + coords.get(i * 14 + i1) + "\n";
				} catch (Exception e) {
					break;
				}
			}

			bookMeta.setPage(i + 1, page);
		}

		writableBook.setItemMeta(bookMeta);

		senderPlayer.getInventory().addItem(writableBook);

		return true;
	}
}
