/*
 *  Copyright (C) 2017 Zombie_Striker
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU General Public License as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program;
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307 USA
 */
package me.zombie_striker.pluginconstructor;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 * Created by Zombie_Striker on 3/30/2016
 **/
public class RGBBlockColor {

	public static Map<MaterialData, RGBBlockValue> materialValue = new HashMap<>();

	public static RGBValue getRGBFromMatData(MaterialData m) {
		return getRGBFromMatData(m, false);
	}

	public static RGBValue getRGBFromMatData(MaterialData m, boolean topView) {
		for (MaterialData h : materialValue.keySet()) {
			if (h.getMaterial() == m.getMaterial() && h.getData() == m.getData())
				return materialValue.get(h);
		}
		return null;
	}

	public static void activateBlocks() {

		new RGBBlockValue(new Color(109, 73, 44), "WORKBENCH", true);

		new RGBBlockValue(new Color(228, 206, 207), "CAKE_BLOCK", true);
		new RGBBlockValue(new Color(133, 118, 96), "DAYLIGHT_DETECTOR", true);
		new RGBBlockValue(new Color(105, 109, 113), "DAYLIGHT_DETECTOR_INVERTED", true);
		new RGBBlockValue(new Color(84, 111, 91), "ENDER_PORTAL_FRAME", true);
		new RGBBlockValue(new Color(100, 100, 100), "FURNACE", true);
		new RGBBlockValue(new Color(107, 73, 55), "JUKEBOX", true);
		new RGBBlockValue(new Color(150, 152, 37), "MELON_BLOCK", true);
		new RGBBlockValue(new Color(111, 100, 106), "MYCEL", true);
		new RGBBlockValue(new Color(70, 44, 27), "REDSTONE_LAMP_OFF");
		// new RGBBlockValue(new Color(119, 89, 55), "REDSTONE_LAMP_ON"); // ==
		new RGBBlockValue(new Color(216, 208, 157), "SANDSTONE", true);

		// TODO: This is the auto-generated section. Do not modify these values.

		new RGBBlockValue(new Color(123, 224, 218), new Color(117, 223, 217), new Color(117, 222, 216),
				new Color(111, 219, 214), "BEACON");
		new RGBBlockValue(new Color(86, 86, 86), new Color(81, 81, 81), new Color(76, 76, 76), new Color(94, 94, 94),
				"BEDROCK");
		new RGBBlockValue(new Color(225, 221, 201), new Color(225, 221, 201), new Color(225, 221, 200),
				new Color(225, 221, 201), "BONE_BLOCK");
		new RGBBlockValue(new Color(108, 96, 69), new Color(107, 90, 49), new Color(116, 71, 42),
				new Color(102, 98, 71), "BOOKSHELF");
		new RGBBlockValue(new Color(146, 100, 87), new Color(147, 101, 88), new Color(147, 100, 87),
				new Color(148, 101, 88), "BRICK");
		new RGBBlockValue(new Color(130, 165, 151), new Color(130, 160, 147), new Color(130, 161, 148),
				new Color(130, 154, 142), "COMMAND_CHAIN");
		new RGBBlockValue(new Color(159, 165, 177), new Color(159, 165, 177), new Color(159, 165, 177),
				new Color(159, 165, 177), "CLAY");
		new RGBBlockValue(new Color(20, 20, 20), new Color(22, 22, 22), new Color(18, 18, 18), new Color(17, 17, 17),
				"COAL_BLOCK");
		new RGBBlockValue(new Color(117, 117, 117), new Color(117, 117, 117), new Color(117, 117, 117),
				new Color(113, 113, 113), "COAL_ORE");
		new RGBBlockValue(new Color(125, 125, 125), new Color(122, 122, 122), new Color(123, 123, 123),
				new Color(124, 124, 124), "COBBLESTONE");
		new RGBBlockValue(new Color(104, 124, 104), new Color(104, 121, 104), new Color(106, 122, 106),
				new Color(103, 121, 103), "MOSSY_COBBLESTONE");
		new RGBBlockValue(new Color(178, 135, 108), new Color(173, 133, 109), new Color(174, 134, 109),
				new Color(166, 129, 109), "COMMAND");
		new RGBBlockValue(new Color(8, 10, 15), new Color(9, 11, 16), new Color(9, 11, 16), new Color(9, 11, 16),
				"CONCRETE", 15);
		new RGBBlockValue(new Color(45, 47, 144), new Color(45, 47, 144), new Color(45, 47, 144),
				new Color(45, 47, 144), "CONCRETE", 11);
		new RGBBlockValue(new Color(97, 60, 32), new Color(97, 60, 32), new Color(97, 60, 32), new Color(97, 60, 32),
				"CONCRETE", 12);
		new RGBBlockValue(new Color(22, 119, 136), new Color(22, 120, 137), new Color(22, 119, 136),
				new Color(22, 119, 136), "CONCRETE", 9);
		new RGBBlockValue(new Color(55, 58, 62), new Color(55, 58, 62), new Color(55, 58, 62), new Color(55, 58, 62),
				"CONCRETE", 7);
		new RGBBlockValue(new Color(74, 92, 37), new Color(74, 92, 37), new Color(74, 92, 37), new Color(74, 92, 37),
				"CONCRETE", 13);
		new RGBBlockValue(new Color(36, 137, 199), new Color(36, 137, 199), new Color(36, 138, 199),
				new Color(36, 137, 199), "CONCRETE", 3);
		new RGBBlockValue(new Color(95, 169, 25), new Color(94, 169, 25), new Color(95, 169, 25),
				new Color(95, 169, 25), "CONCRETE", 5);
		new RGBBlockValue(new Color(170, 49, 160), new Color(169, 49, 159), new Color(170, 49, 160),
				new Color(170, 49, 160), "CONCRETE", 2);
		new RGBBlockValue(new Color(225, 98, 1), new Color(225, 98, 1), new Color(225, 97, 1), new Color(225, 97, 1),
				"CONCRETE", 1);
		new RGBBlockValue(new Color(214, 101, 143), new Color(214, 101, 143), new Color(214, 101, 143),
				new Color(214, 102, 143), "CONCRETE", 6);
		new RGBBlockValue(new Color(114, 91, 56), new Color(110, 91, 63), new Color(118, 98, 66),
				new Color(121, 103, 73), "WORKBENCH", false);
		new RGBBlockValue(new Color(102, 219, 214), new Color(98, 220, 215), new Color(117, 225, 220),
				new Color(75, 214, 207), "DIAMOND_BLOCK");
		new RGBBlockValue(new Color(132, 140, 144), new Color(127, 135, 138), new Color(126, 132, 135),
				new Color(133, 154, 158), "DIAMOND_ORE");
		new RGBBlockValue(new Color(136, 98, 69), new Color(134, 96, 66), new Color(133, 96, 66),
				new Color(135, 98, 68), "DIRT");
		new RGBBlockValue(new Color(104, 231, 139), new Color(75, 216, 112), new Color(82, 220, 119),
				new Color(65, 203, 100), "EMERALD_BLOCK");
		new RGBBlockValue(new Color(107, 133, 116), new Color(116, 124, 119), new Color(111, 131, 118),
				new Color(106, 128, 114), "EMERALD_ORE");
		new RGBBlockValue(new Color(227, 233, 173), new Color(224, 230, 168), new Color(227, 233, 172),
				new Color(226, 230, 171), "END_BRICKS");
		new RGBBlockValue(new Color(220, 223, 164), new Color(223, 225, 167), new Color(222, 225, 166),
				new Color(221, 224, 165), "ENDER_STONE");
		new RGBBlockValue(new Color(127, 175, 255), new Color(125, 173, 255), new Color(122, 172, 255),
				new Color(128, 175, 255), "PACKED_ICE");
		new RGBBlockValue(new Color(96, 96, 96), new Color(96, 96, 96), new Color(133, 133, 133),
				new Color(130, 130, 130), "FURNACE", false);
		new RGBBlockValue(new Color(88, 37, 40), new Color(64, 22, 23), new Color(65, 22, 23), new Color(55, 41, 44),
				"BLACK_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(49, 69, 143), new Color(46, 61, 135), new Color(47, 61, 134),
				new Color(50, 70, 147), "BLUE_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(149, 103, 65), new Color(114, 111, 97), new Color(114, 111, 97),
				new Color(104, 102, 86), "BROWN_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(61, 130, 133), new Color(34, 112, 122), new Color(56, 101, 111),
				new Color(59, 133, 137), "CYAN_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(89, 96, 99), new Color(72, 81, 85), new Color(79, 88, 92), new Color(94, 98, 101),
				"GRAY_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(146, 162, 120), new Color(108, 138, 48), new Color(108, 138, 49),
				new Color(107, 133, 54), "GREEN_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(69, 140, 196), new Color(98, 169, 211), new Color(96, 152, 202),
				new Color(117, 200, 228), "LIGHT_BLUE_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(138, 196, 48), new Color(179, 198, 60), new Color(180, 199, 62),
				new Color(156, 199, 52), "LIME_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(205, 97, 187), new Color(205, 98, 188), new Color(212, 103, 196),
				new Color(213, 105, 198), "MAGENTA_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(190, 152, 78), new Color(164, 138, 77), new Color(164, 134, 75),
				new Color(102, 168, 140), "ORANGE_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(232, 155, 180), new Color(239, 157, 185), new Color(239, 153, 182),
				new Color(232, 155, 181), "PINK_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(124, 63, 167), new Color(102, 44, 142), new Color(102, 44, 141),
				new Color(113, 43, 161), "PURPLE_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(169, 47, 43), new Color(177, 54, 49), new Color(192, 70, 61),
				new Color(192, 70, 61), "RED_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(163, 172, 175), new Color(142, 162, 164), new Color(108, 157, 159),
				new Color(166, 175, 177), "SILVER_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(237, 232, 178), new Color(194, 216, 208), new Color(194, 216, 207),
				new Color(131, 187, 220), "WHITE_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(251, 217, 114), new Color(240, 197, 82), new Color(241, 197, 81),
				new Color(206, 159, 79), "YELLOW_GLAZED_TERRACOTTA");
		new RGBBlockValue(new Color(150, 122, 74), new Color(149, 123, 72), new Color(144, 120, 72),
				new Color(133, 109, 62), "GLOWSTONE");
		new RGBBlockValue(new Color(248, 238, 80), new Color(249, 239, 73), new Color(251, 242, 92),
				new Color(250, 228, 71), "GOLD_BLOCK");
		new RGBBlockValue(new Color(144, 142, 129), new Color(138, 135, 124), new Color(135, 133, 123),
				new Color(158, 150, 126), "GOLD_ORE");
		new RGBBlockValue(new Color(128, 125, 123), new Color(127, 124, 123), new Color(130, 127, 126),
				new Color(125, 122, 120), "GRAVEL");
		new RGBBlockValue(new Color(151, 93, 67), new Color(151, 93, 67), new Color(150, 92, 66),
				new Color(152, 94, 68), "HARD_CLAY");
		new RGBBlockValue(new Color(37, 23, 17), new Color(37, 23, 17), new Color(37, 23, 17), new Color(38, 24, 17),
				"STAINED_CLAY", 15);
		new RGBBlockValue(new Color(75, 60, 92), new Color(75, 60, 92), new Color(74, 60, 91), new Color(75, 61, 92),
				"STAINED_CLAY", 11);
		new RGBBlockValue(new Color(77, 51, 36), new Color(78, 52, 36), new Color(77, 51, 36), new Color(78, 52, 36),
				"STAINED_CLAY", 12);
		new RGBBlockValue(new Color(87, 91, 91), new Color(87, 92, 92), new Color(86, 91, 91), new Color(88, 92, 92),
				"STAINED_CLAY", 9);
		new RGBBlockValue(new Color(58, 43, 36), new Color(58, 43, 36), new Color(58, 42, 36), new Color(59, 43, 36),
				"STAINED_CLAY", 7);
		new RGBBlockValue(new Color(76, 83, 43), new Color(77, 84, 43), new Color(76, 83, 43), new Color(77, 84, 43),
				"STAINED_CLAY", 13);
		new RGBBlockValue(new Color(114, 109, 138), new Color(114, 109, 138), new Color(113, 109, 138),
				new Color(115, 109, 139), "STAINED_CLAY", 3);
		new RGBBlockValue(new Color(104, 118, 53), new Color(104, 118, 53), new Color(103, 118, 53),
				new Color(105, 119, 53), "STAINED_CLAY", 5);
		new RGBBlockValue(new Color(150, 88, 109), new Color(150, 89, 109), new Color(149, 88, 108),
				new Color(150, 89, 109), "STAINED_CLAY", 2);
		new RGBBlockValue(new Color(162, 84, 38), new Color(162, 84, 38), new Color(161, 84, 38),
				new Color(163, 85, 38), "STAINED_CLAY", 1);
		new RGBBlockValue(new Color(162, 79, 79), new Color(162, 79, 79), new Color(162, 78, 79),
				new Color(163, 79, 79), "STAINED_CLAY", 6);
		new RGBBlockValue(new Color(119, 71, 86), new Color(119, 71, 87), new Color(118, 70, 86),
				new Color(120, 71, 87), "STAINED_CLAY", 10);
		new RGBBlockValue(new Color(144, 61, 47), new Color(144, 61, 47), new Color(143, 61, 47),
				new Color(144, 62, 48), "STAINED_CLAY", 14);
		new RGBBlockValue(new Color(135, 107, 98), new Color(135, 107, 98), new Color(135, 107, 98),
				new Color(136, 108, 98), "STAINED_CLAY", 8);
		new RGBBlockValue(new Color(210, 178, 162), new Color(210, 178, 162), new Color(209, 178, 162),
				new Color(211, 179, 162), "STAINED_CLAY");
		new RGBBlockValue(new Color(187, 133, 36), new Color(187, 134, 36), new Color(186, 133, 35),
				new Color(187, 134, 36), "STAINED_CLAY", 4);
		new RGBBlockValue(new Color(158, 116, 18), new Color(160, 117, 18), new Color(157, 118, 19),
				new Color(158, 117, 19), "HAY_BLOCK");
		new RGBBlockValue(new Color(222, 222, 222), new Color(218, 218, 218), new Color(222, 222, 222),
				new Color(217, 217, 217), "IRON_BLOCK");
		new RGBBlockValue(new Color(137, 132, 128), new Color(132, 128, 126), new Color(130, 127, 124),
				new Color(145, 136, 131), "IRON_ORE");
		new RGBBlockValue(new Color(40, 76, 151), new Color(38, 67, 138), new Color(40, 65, 137),
				new Color(39, 62, 126), "LAPIS_BLOCK");
		new RGBBlockValue(new Color(104, 115, 139), new Color(114, 118, 129), new Color(100, 109, 132),
				new Color(93, 107, 139), "LAPIS_ORE");
		new RGBBlockValue(new Color(137, 67, 25), new Color(128, 62, 26), new Color(140, 68, 25),
				new Color(136, 66, 26), "MAGMA");
		new RGBBlockValue(new Color(138, 144, 35), new Color(143, 147, 37), new Color(143, 148, 37),
				new Color(144, 147, 37), "MELON_BLOCK", false);
		new RGBBlockValue(new Color(101, 88, 89), new Color(97, 80, 76), new Color(131, 95, 67), new Color(127, 92, 65),
				"MYCEL", false);
		new RGBBlockValue(new Color(118, 61, 59), new Color(108, 50, 49), new Color(108, 50, 49),
				new Color(112, 57, 54), "NETHERRACK");
		new RGBBlockValue(new Color(46, 23, 27), new Color(45, 23, 27), new Color(45, 23, 27), new Color(44, 23, 27),
				"NETHER_BRICK");
		new RGBBlockValue(new Color(117, 7, 8), new Color(120, 8, 8), new Color(115, 6, 7), new Color(119, 7, 7),
				"NETHER_WART_BLOCK");
		new RGBBlockValue(new Color(101, 67, 50), new Color(101, 68, 51), new Color(102, 69, 52),
				new Color(101, 68, 51), "NOTE_BLOCK");
		new RGBBlockValue(new Color(21, 19, 31), new Color(21, 19, 31), new Color(20, 18, 29), new Color(20, 18, 30),
				"OBSIDIAN");
		new RGBBlockValue(new Color(120, 112, 97), new Color(113, 105, 91), new Color(99, 99, 99),
				new Color(94, 94, 94), "PISTON_BASE", 1);
		new RGBBlockValue(new Color(170, 92, 51), new Color(170, 92, 51), new Color(171, 93, 52),
				new Color(170, 92, 51), "WOOD", 4);
		new RGBBlockValue(new Color(61, 40, 19), new Color(61, 40, 19), new Color(62, 40, 19), new Color(61, 40, 19),
				"WOOD", 5);
		new RGBBlockValue(new Color(196, 179, 123), new Color(196, 180, 124), new Color(197, 181, 124),
				new Color(196, 179, 123), "WOOD", 2);
		new RGBBlockValue(new Color(154, 110, 77), new Color(154, 111, 78), new Color(156, 112, 79),
				new Color(154, 110, 77), "WOOD", 3);
		new RGBBlockValue(new Color(157, 128, 79), new Color(157, 128, 79), new Color(159, 129, 80),
				new Color(157, 127, 79), "WOOD");
		new RGBBlockValue(new Color(104, 78, 47), new Color(104, 78, 47), new Color(106, 79, 48),
				new Color(103, 78, 47), "WOOD", 1);
		new RGBBlockValue(new Color(103, 163, 146), new Color(103, 163, 145), new Color(101, 161, 143),
				new Color(95, 155, 140), "PRISMARINE", 1);
		new RGBBlockValue(new Color(60, 87, 75), new Color(61, 88, 76), new Color(60, 87, 74), new Color(60, 89, 77),
				"PRISMARINE", 2);
		new RGBBlockValue(new Color(105, 169, 148), new Color(110, 172, 151), new Color(105, 168, 149),
				new Color(109, 173, 157), "PRISMARINE");
		new RGBBlockValue(new Color(167, 122, 167), new Color(165, 121, 165), new Color(168, 124, 168),
				new Color(168, 123, 168), "PURPUR_BLOCK");
		new RGBBlockValue(new Color(170, 127, 170), new Color(170, 127, 170), new Color(171, 127, 171),
				new Color(171, 127, 171), "PURPUR_PILLAR");
		new RGBBlockValue(new Color(233, 230, 222), new Color(232, 228, 220), new Color(233, 229, 221),
				new Color(232, 228, 219), "QUARTZ_BLOCK", 1);
		new RGBBlockValue(new Color(232, 228, 220), new Color(232, 228, 220), new Color(232, 228, 220),
				new Color(232, 228, 220), "QUARTZ_BLOCK", 2);
		new RGBBlockValue(new Color(238, 236, 229), new Color(237, 234, 227), new Color(236, 233, 226),
				new Color(234, 231, 224), "QUARTZ_BLOCK");
		new RGBBlockValue(new Color(135, 97, 91), new Color(123, 84, 79), new Color(125, 82, 78),
				new Color(119, 77, 73), "QUARTZ_ORE");
		new RGBBlockValue(new Color(171, 28, 10), new Color(171, 28, 10), new Color(174, 28, 10),
				new Color(171, 28, 10), "REDSTONE_BLOCK");
		new RGBBlockValue(new Color(70, 5, 7), new Color(67, 6, 9), new Color(71, 4, 6), new Color(67, 4, 7),
				"RED_NETHER_BRICK");
		new RGBBlockValue(new Color(167, 85, 30), new Color(167, 85, 30), new Color(166, 85, 30),
				new Color(165, 84, 30), "RED_SANDSTONE");
		new RGBBlockValue(new Color(219, 211, 160), new Color(218, 210, 158), new Color(217, 210, 157),
				new Color(216, 209, 155), "SANDSTONE", false);
		new RGBBlockValue(new Color(173, 201, 191), new Color(174, 201, 192), new Color(171, 199, 190),
				new Color(173, 201, 192), "SEA_LANTERN");
		new RGBBlockValue(new Color(121, 201, 102), new Color(121, 201, 100), new Color(123, 202, 104),
				new Color(119, 198, 100), "SLIME_BLOCK");
		new RGBBlockValue(new Color(243, 252, 252), new Color(240, 251, 251), new Color(239, 251, 251),
				new Color(240, 251, 251), "SNOW_BLOCK");
		new RGBBlockValue(new Color(82, 62, 49), new Color(84, 64, 51), new Color(88, 68, 55), new Color(86, 65, 53),
				"SOUL_SAND");
		new RGBBlockValue(new Color(194, 195, 84), new Color(197, 197, 86), new Color(195, 196, 85),
				new Color(195, 196, 86), "SPONGE");
		new RGBBlockValue(new Color(159, 158, 63), new Color(160, 159, 62), new Color(162, 161, 64),
				new Color(161, 160, 66), "SPONGE", 1);
		new RGBBlockValue(new Color(125, 125, 125), new Color(125, 125, 125), new Color(125, 125, 125),
				new Color(128, 128, 128), "STONE");
		new RGBBlockValue(new Color(126, 126, 126), new Color(118, 118, 118), new Color(119, 119, 119),
				new Color(126, 126, 126), "SMOOTH_BRICK");
		new RGBBlockValue(new Color(124, 124, 124), new Color(119, 119, 119), new Color(119, 119, 119),
				new Color(114, 114, 114), "SMOOTH_BRICK", 3);
		new RGBBlockValue(new Color(121, 121, 121), new Color(117, 117, 117), new Color(116, 116, 116),
				new Color(122, 122, 122), "SMOOTH_BRICK", 2);
		new RGBBlockValue(new Color(119, 124, 109), new Color(112, 117, 103), new Color(109, 115, 99),
				new Color(120, 122, 114), "SMOOTH_BRICK", 1);
		new RGBBlockValue(new Color(129, 130, 130), new Color(131, 131, 131), new Color(134, 134, 134),
				new Color(131, 131, 132), "STONE", 5);
		new RGBBlockValue(new Color(142, 143, 143), new Color(133, 134, 135), new Color(134, 134, 136),
				new Color(124, 124, 126), "STONE", 6);
		new RGBBlockValue(new Color(179, 179, 181), new Color(179, 179, 181), new Color(180, 180, 183),
				new Color(183, 183, 186), "STONE", 3);
		new RGBBlockValue(new Color(193, 193, 195), new Color(185, 185, 188), new Color(184, 184, 186),
				new Color(173, 173, 175), "STONE", 4);
		new RGBBlockValue(new Color(155, 116, 101), new Color(153, 113, 97), new Color(151, 112, 97),
				new Color(156, 117, 101), "STONE", 1);
		new RGBBlockValue(new Color(171, 126, 109), new Color(160, 115, 98), new Color(159, 114, 97),
				new Color(150, 106, 91), "STONE", 2);
		new RGBBlockValue(new Color(160, 160, 160), new Color(159, 159, 159), new Color(159, 159, 159),
				new Color(162, 162, 162), "DOUBLE_STEP", 8);
		new RGBBlockValue(new Color(89, 74, 89), new Color(90, 76, 91), new Color(89, 74, 89), new Color(90, 75, 91),
				"STRUCTURE_BLOCK");

		int log_index = 12;
		int log2_index = 12;
		new RGBBlockValue(new Color(105, 99, 89), new Color(108, 102, 91), new Color(104, 98, 88),
				new Color(106, 100, 90), "LOG_2", 0 + log2_index);
		new RGBBlockValue(new Color(52, 40, 24), new Color(54, 42, 25), new Color(51, 40, 23), new Color(53, 41, 24),
				"LOG_2", 1 + log2_index);
		new RGBBlockValue(new Color(199, 198, 193), new Color(215, 215, 210), new Color(213, 213, 208),
				new Color(201, 200, 195), "LOG", 2 + log_index);
		new RGBBlockValue(new Color(88, 69, 27), new Color(88, 68, 27), new Color(86, 67, 27), new Color(87, 69, 27),
				"LOG", 3 + log_index);
		new RGBBlockValue(new Color(101, 80, 50), new Color(106, 84, 52), new Color(100, 80, 49),
				new Color(103, 82, 50), "LOG", 0 + log_index);
		new RGBBlockValue(new Color(45, 28, 12), new Color(48, 31, 14), new Color(45, 28, 12), new Color(47, 30, 13),
				"LOG", 1 + log_index);

		new RGBBlockValue(new Color(210, 177, 125), new Color(210, 144, 102), new Color(210, 177, 125),
				new Color(205, 173, 122), "HUGE_MUSHROOM_2");
		if (!isVersionHigherThan(1, 12)) {
			new RGBBlockValue(new Color(137, 101, 77), new Color(137, 108, 84), new Color(139, 103, 79),
					new Color(153, 117, 93), "HUGE_MUSHROOM_2", 14);
			new RGBBlockValue(new Color(183, 31, 29), new Color(183, 28, 26), new Color(181, 29, 27),
					new Color(189, 37, 35), "HUGE_MUSHROOM_1", 14);
			new RGBBlockValue(new Color(190, 187, 178), new Color(190, 209, 198), new Color(196, 193, 183),
					new Color(214, 211, 200), "HUGE_MUSHROOM_1", 10);
		}

		if (!isVersionHigherThan(1, 12)) {
			new RGBBlockValue(new Color(23, 19, 19), "WOOL", DyeColor.BLACK);
			new RGBBlockValue(new Color(43, 53, 133), "WOOL", DyeColor.BLUE);
			new RGBBlockValue(new Color(76, 48, 30), "WOOL", DyeColor.BROWN);
			new RGBBlockValue(new Color(49, 116, 143), "WOOL", DyeColor.CYAN);
			new RGBBlockValue(new Color(61, 61, 61), "WOOL", DyeColor.GRAY);
			new RGBBlockValue(new Color(55, 72, 28), "WOOL", DyeColor.GREEN);
			new RGBBlockValue(new Color(113, 143, 203), "WOOL", DyeColor.LIGHT_BLUE);
			new RGBBlockValue(new Color(66, 180, 58), "WOOL", DyeColor.LIME);
			new RGBBlockValue(new Color(184, 83, 193), "WOOL", DyeColor.MAGENTA);
			new RGBBlockValue(new Color(221, 129, 67), "WOOL", DyeColor.ORANGE);
			new RGBBlockValue(new Color(210, 128, 158), "WOOL", DyeColor.PINK);
			new RGBBlockValue(new Color(130, 62, 188), "WOOL", DyeColor.PURPLE);
			new RGBBlockValue(new Color(157, 56, 51), "WOOL", DyeColor.RED);
			new RGBBlockValue(new Color(162, 168, 168), "WOOL", DyeColor.SILVER);
			new RGBBlockValue(new Color(232, 231, 231), "WOOL", DyeColor.WHITE);
			new RGBBlockValue(new Color(188, 176, 42), "WOOL", DyeColor.YELLOW);
		} else {
			new RGBBlockValue(new Color(21, 22, 26), new Color(20, 21, 26), new Color(21, 22, 26),
					new Color(21, 22, 26), "WOOL", 15);
			new RGBBlockValue(new Color(54, 58, 158), new Color(53, 57, 157), new Color(53, 58, 158),
					new Color(53, 58, 158), "WOOL", 11);
			new RGBBlockValue(new Color(115, 72, 41), new Color(114, 72, 40), new Color(115, 73, 41),
					new Color(115, 72, 41), "WOOL", 12);
			new RGBBlockValue(new Color(22, 139, 146), new Color(22, 137, 145), new Color(22, 139, 146),
					new Color(22, 138, 146), "WOOL", 9);
			new RGBBlockValue(new Color(64, 69, 72), new Color(63, 68, 71), new Color(63, 69, 72),
					new Color(63, 69, 72), "WOOL", 7);
			new RGBBlockValue(new Color(85, 110, 28), new Color(85, 109, 28), new Color(85, 110, 27),
					new Color(86, 110, 28), "WOOL", 13);
			new RGBBlockValue(new Color(59, 176, 218), new Color(57, 174, 217), new Color(59, 177, 219),
					new Color(58, 175, 218), "WOOL", 3);
			new RGBBlockValue(new Color(113, 186, 26), new Color(112, 185, 26), new Color(113, 186, 26),
					new Color(113, 186, 26), "WOOL", 5);
			new RGBBlockValue(new Color(190, 70, 181), new Color(189, 68, 179), new Color(191, 70, 181),
					new Color(190, 69, 180), "WOOL", 2);
			new RGBBlockValue(new Color(242, 119, 21), new Color(240, 117, 19), new Color(242, 119, 21),
					new Color(241, 118, 20), "WOOL", 1);
			new RGBBlockValue(new Color(239, 143, 174), new Color(237, 140, 171), new Color(238, 143, 174),
					new Color(238, 141, 173), "WOOL", 6);
			new RGBBlockValue(new Color(123, 43, 174), new Color(121, 42, 172), new Color(122, 42, 172),
					new Color(122, 43, 173), "WOOL", 10);
			new RGBBlockValue(new Color(162, 40, 35), new Color(160, 39, 35), new Color(162, 40, 35),
					new Color(161, 40, 35), "WOOL", 14);
			new RGBBlockValue(new Color(143, 143, 136), new Color(142, 142, 134), new Color(143, 143, 136),
					new Color(142, 142, 135), "WOOL", 8);
			new RGBBlockValue(new Color(234, 237, 238), new Color(233, 236, 236), new Color(235, 238, 238),
					new Color(234, 237, 237), "WOOL");
			new RGBBlockValue(new Color(249, 199, 40), new Color(249, 197, 39), new Color(249, 199, 40),
					new Color(249, 198, 40), "WOOL", 4);
		}
		try {
			// Attempts to add doors.
			// new RGBBlockValue(new Color(157,90,56),new Color(153,87,55),new
			// Color(156,90,55),new Color(157,88,55),"ACACIA_DOOR",0,BlockFace.EAST);
			// TOO MANY SPACE
			/*
			 * new RGBBlockValue(new Color(217, 207, 162), new Color(214, 205, 162), new
			 * Color(196, 184, 124), new Color(194, 181, 123), "BIRCH_DOOR", 0,
			 * BlockFace.EAST); new RGBBlockValue(new Color(69, 47, 26), new Color(65, 43,
			 * 21), new Color(68, 46, 27), new Color(64, 42, 22), "DARK_OAK_DOOR", 0,
			 * BlockFace.EAST); new RGBBlockValue(new Color(190, 190, 190), new Color(179,
			 * 179, 179), new Color(146, 146, 146), new Color(141, 141, 141),
			 * "IRON_DOOR_BLOCK", 0, BlockFace.EAST); new RGBBlockValue(new Color(157, 115,
			 * 83), new Color(155, 113, 81), new Color(148, 107, 78), new Color(146, 106,
			 * 76), "JUNGLE_DOOR", 0, BlockFace.EAST); new RGBBlockValue(new Color(102, 77,
			 * 49), new Color(102, 81, 56), new Color(94, 74, 49), new Color(93, 72, 46),
			 * "SPRUCE_DOOR", 0, BlockFace.EAST); new RGBBlockValue(new Color(142, 109, 55),
			 * new Color(134, 101, 50), new Color(134, 103, 53), new Color(128, 95, 47),
			 * "WOODEN_DOOR", 0, BlockFace.EAST);
			 */
			// Can't do doors, as they break when there is more than 2 stack above
			// eachother.
		} catch (Exception | Error e4) {

		}
		{

			new RGBBlockValue(new Color(71, 71, 71), new Color(73, 73, 73), new Color(83, 83, 83),
					new Color(86, 86, 86), "FURNACE", 0, BlockFace.EAST);
			new RGBBlockValue(new Color(71, 71, 71), new Color(73, 73, 73), new Color(179, 135, 99),
					new Color(178, 131, 98), "BURNING_FURNACE", 0, BlockFace.EAST);
			new RGBBlockValue(new Color(68, 66, 66), new Color(69, 67, 67), new Color(69, 67, 67),
					new Color(70, 68, 68), "OBSERVER", 0, BlockFace.WEST);
			new RGBBlockValue(new Color(91, 90, 90), new Color(88, 87, 87), new Color(117, 117, 117),
					new Color(115, 115, 115), "OBSERVER", 0, BlockFace.EAST);

			new RGBBlockValue(new Color(62, 60, 60), new Color(64, 62, 62), new Color(63, 61, 61),
					new Color(63, 62, 62), "OBSERVER", 0, BlockFace.NORTH);

			// new RGBBlockValue(new Color(103, 103, 103), new Color(93, 93, 93), new
			// Color(105, 105, 105),
			// new Color(89, 89, 89), "OBSERVER", 0,BlockFace.UP);

			new RGBBlockValue(new Color(150, 84, 16), new Color(142, 77, 12), new Color(141, 76, 11),
					new Color(137, 73, 12), "PUMPKIN", 0, BlockFace.EAST);
			new RGBBlockValue(new Color(187, 135, 31), new Color(187, 135, 29), new Color(181, 125, 25),
					new Color(188, 140, 30), "JACK_O_LANTERN", 0, BlockFace.EAST);
			new RGBBlockValue(new Color(203, 126, 27), new Color(195, 119, 23), new Color(195, 118, 21),
					new Color(199, 122, 24), "PUMPKIN", 0, BlockFace.WEST);
			new RGBBlockValue(new Color(152, 129, 89), new Color(155, 131, 92), new Color(154, 130, 89),
					new Color(156, 131, 91), "PISTON_BASE", 0, BlockFace.UP);
			new RGBBlockValue(new Color(139, 144, 99), new Color(143, 146, 101), new Color(143, 150, 102),
					new Color(145, 146, 100), "PISTON_STICKY_BASE", 0, BlockFace.UP);
			new RGBBlockValue(new Color(96, 96, 96), new Color(96, 96, 96), new Color(98, 98, 98),
					new Color(96, 96, 96), "PISTON_BASE", 0, BlockFace.WEST);

		}

		// TODO: Due to 1.12s change to remove 'all bark' logs, changing all
		// variables to standing up (0+n)

		/*
		 * new RGBBlockValue(new Color(210, 177, 125), new Color(210, 144, 102), new
		 * Color(210, 177, 125), new Color(205, 173, 122), "HUGE_MUSHROOM_1", 0); if
		 * (!isVersionHigherThan(1, 12)) { // TODO: Removing from 1.12 since these
		 * revert to insides. new RGBBlockValue(new Color(137, 101, 77), new Color(137,
		 * 108, 84), new Color(139, 103, 79), new Color(153, 117, 93),
		 * "HUGE_MUSHROOM_1", 1); new RGBBlockValue(new Color(183, 31, 29), new
		 * Color(183, 28, 26), new Color(181, 29, 27), new Color(189, 37, 35),
		 * "HUGE_MUSHROOM_2", 1); } new RGBBlockValue(new Color(190, 187, 178), new
		 * Color(190, 209, 198), new Color(196, 193, 183), new Color(214, 211, 200),
		 * "HUGE_MUSHROOM_2", 0);
		 */
		/**
		 * Depending on which way you choose (north-south or east-west), the sides and
		 * colors may be drastically different (one side is all dark gray the other has
		 * a light gray stip in the middle). Removing for now since I cannot determine
		 * which side a user chooses.
		 */

	}

	public static void printOutLineFor(File texture, Material material, int data) {
		if (texture.getName().endsWith("png") || texture.getName().endsWith("jpg")) {
			try {
				BufferedImage bi = ImageIO.read(texture);
				bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getWidth());
				bi = RGBBlockColor.resize(bi, 2, 2);

				Pixel[][] pixels = convertTo2DWithoutUsingGetRGB(bi);
				MaterialData md = new MaterialData(material, (byte) data);

				Bukkit.getLogger().info("new RGBBlockValue(new Color(" + pixels[0][0].r + "," + pixels[0][0].g + ","
						+ pixels[0][0].b + "),new Color(" + pixels[0][1].r + "," + pixels[0][1].g + "," + pixels[0][1].b
						+ "),new Color(" + pixels[1][0].r + "," + pixels[1][0].g + "," + pixels[1][0].b + "),new Color("
						+ pixels[1][1].r + "," + pixels[1][1].g + "," + pixels[1][1].b + "),\""
						+ md.getMaterial().name() + "\"," + md.getData() + "," + false + ");");
			} catch (IOException e) {
				System.out
						.println("File " + texture.getName() + " was not an image. Remove this file from the folder.");
			}
		}
	}

	public static void loadResourcepackTextures(File file) {
		for (File f : file.listFiles()) {
			if (f.getName().endsWith("png") || f.getName().endsWith("jpg")) {
				try {
					BufferedImage bi = ImageIO.read(f);
					bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getWidth());
					bi = RGBBlockColor.resize(bi, 2, 2);

					Pixel[][] pixels = convertTo2DWithoutUsingGetRGB(bi);
					MaterialData md = FileNameToMaterialUtil
							.getMaterialData(f.getName().substring(0, f.getName().length() - 4));

					if (md == null) {
						// System.out.println("dead bug!");
						continue;
					}
					Bukkit.getConsoleSender()
							.sendMessage(("new RGBBlockValue(new Color(" + pixels[0][0].r + ", " + pixels[0][0].g + ", "
									+ pixels[0][0].b + ")," + "new Color(" + pixels[0][1].r + ", " + pixels[0][1].g
									+ ", " + pixels[0][1].b + ")," + "new Color(" + pixels[1][0].r + ", "
									+ pixels[1][0].g + ", " + pixels[1][0].b + ")," + "new Color(" + pixels[1][1].r
									+ ", " + pixels[1][1].g + ", " + pixels[1][1].b + "), \"" + md.getMaterial().name()
									+ "\"," + "								" + md.getData() + ");"));
					boolean needsFalse = false;
					if (MaterialData.getMatDataByTypes(md.getMaterial(), md.getData()) != null) {
						MaterialData existing = MaterialData.getMatDataByTypes(md.getMaterial(), md.getData());
						if ((materialValue.get(existing).hasFaces()))
							needsFalse = true;
						if ((!materialValue.get(existing).hasFaces()) || (!materialValue.get(existing).isTop())) {
							System.out.println(
									"Existing value for " + existing.getMaterial().name() + " found. Overriding.");
							materialValue.remove(existing);
						}
					}

					if (needsFalse) {
						new RGBBlockValue(new Color(pixels[0][0].r, pixels[0][0].g, pixels[0][0].b),
								new Color(pixels[0][1].r, pixels[0][1].g, pixels[0][1].b),
								new Color(pixels[1][0].r, pixels[1][0].g, pixels[1][0].b),
								new Color(pixels[1][1].r, pixels[1][1].g, pixels[1][1].b), md.getMaterial().name(),
								md.getData(), false,md.getDirection());

					} else {
						new RGBBlockValue(new Color(pixels[0][0].r, pixels[0][0].g, pixels[0][0].b),
								new Color(pixels[0][1].r, pixels[0][1].g, pixels[0][1].b),
								new Color(pixels[1][0].r, pixels[1][0].g, pixels[1][0].b),
								new Color(pixels[1][1].r, pixels[1][1].g, pixels[1][1].b), md.getMaterial().name(),
								md.getData(),md.getDirection());
					}
				} catch (IOException e) {
					System.out.println("File " + f.getName() + " was not an image. Remove this file from the folder.");
				}
			}
		}
	}

	private static final String SERVER_VERSION;

	static {
		String name = Bukkit.getServer().getClass().getName();
		name = name.substring(name.indexOf("craftbukkit.") + "craftbukkit.".length());
		name = name.substring(0, name.indexOf("."));
		SERVER_VERSION = name;
	}

	/**
	 * This checks if the the server is running on a version higher or equal to the
	 * one specified. Useage: upToDate(1,8) will check if the version is greater
	 * than or equal to 1.8
	 * 
	 * @param The
	 *            first value (will most likely only be 1 )
	 * @param The
	 *            second value (The 8 in 1.8.3 )
	 * @return if the server version is greater than or equal to specified version.
	 */
	public static boolean isVersionHigherThan(int mainVersion, int secondVersion) {
		String firstChar = SERVER_VERSION.substring(1, 2);
		int fInt = Integer.parseInt(firstChar);
		if (fInt < mainVersion)
			return false;
		StringBuilder secondChar = new StringBuilder();
		for (int i = 3; i < 10; i++) {
			if (SERVER_VERSION.charAt(i) == '_' || SERVER_VERSION.charAt(i) == '.')
				break;
			secondChar.append(SERVER_VERSION.charAt(i));
		}
		int sInt = Integer.parseInt(secondChar.toString());
		if (sInt < secondVersion)
			return false;
		return true;
	}

	/**
	 * Used for debugging: Finds the value with the highest addition of all rgb
	 * blocks colors.
	 * 
	 * @return
	 */
	public static int getFurthestColor() {

		int furthestPoint = 0;
		for (int r = 0; r < 256; r += 2) {
			for (int g = 0; g < 256; g += 2) {
				for (int b = 0; b < 256; b += 2) {
					MaterialData md = getClosestBlockValue(new Color(r, g, b), false);
					RGBBlockValue rgb = materialValue.get(md);
					int tr = r - rgb.r[0];
					int tg = g - rgb.g[0];
					int tb = b - rgb.b[0];
					int tr2 = r - rgb.r[2];
					int tg2 = g - rgb.g[2];
					int tb2 = b - rgb.b[2];
					if (tr < 0)
						tr = -tr;
					if (tg < 0)
						tg = -tg;
					if (tb < 0)
						tb = -tb;
					if (tr2 < 0)
						tr2 = -tr2;
					if (tg2 < 0)
						tg2 = -tg2;
					if (tb2 < 0)
						tb2 = -tb2;

					if (tr + tg + tb > furthestPoint)
						if (tr2 + tg2 + tb2 > furthestPoint)
							furthestPoint = Math.max(tr + tb + tg, tr2 + tg2 + tb2);
				}
			}
		}
		return furthestPoint;
	}

	/**
	 * This will return the Material and durability that has the closest color to
	 * Color "c".
	 * 
	 * @param c
	 *            - The color value
	 * @return The closest material and durability.
	 */
	public static MaterialData getClosestBlockValue(Color c, boolean topView) {
		Color[] color = { c, c, c, c };
		return getClosestBlockValue(color, topView, false);
	}

	/**
	 * This will return the Material and durability that has the closest color to
	 * Color "c".
	 * 
	 * @param c
	 *            - The color value
	 * @return The closest material and durability.
	 */
	public static MaterialData getClosestBlockValue(Color[] c, boolean topView) {
		return getClosestBlockValue(c, topView, false);
	}

	/**
	 * This will return the Material and durability that has the closest color to
	 * Color "c".
	 * 
	 * @param c
	 *            - The color value
	 * @return The closest material and durability.
	 */
	public static MaterialData getClosestBlockValue(Color c, boolean topView, boolean supportTransparent) {
		Color[] color = { c, c, c, c };
		return getClosestBlockValue(color, topView, supportTransparent);
	}

	/**
	 * Returns if the color is transparent (if the image supports it) or black (for
	 * non-transparent images)
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isBlackTransparent(Color c) {
		return c.getBlue() == 0 && c.getRed() == 0 && c.getGreen() == 0;
	}

	/**
	 * The color value of the four closest colors. Use this if you want to preserve
	 * hard edges in images. For the array, you need four color values. Use the
	 * following chart to understand which pixel should be at which index:
	 * 
	 * | 0 | 1 |
	 * 
	 * | 2 | 3 |
	 * 
	 * @param c
	 *            - The color value
	 * @return The closest material and durability.
	 */
	public static MaterialData getClosestBlockValue(Color c[], boolean topView, boolean supportTransparent) {
		return getClosestBlockValue(c, topView, supportTransparent, null);
	}

	/**
	 * The color value of the four closest colors. Use this if you want to preserve
	 * hard edges in images. For the array, you need four color values. Use the
	 * following chart to understand which pixel should be at which index:
	 * 
	 * | 0 | 1 |
	 * 
	 * | 2 | 3 |
	 * 
	 * @param c
	 *            - The color value
	 * @return The closest material and durability.
	 */
	public static MaterialData getClosestBlockValue(Color c[], boolean topView, boolean supportTransparent,
			Material[] supportedMaterials) {

		int[] r = new int[4];
		int[] b = new int[4];
		int[] g = new int[4];
		for (int i = 0; i < c.length; i++) {
			r[i] = c[i].getRed();
			b[i] = c[i].getBlue();
			g[i] = c[i].getGreen();
		}
		if (supportTransparent) {
			if (isBlackTransparent(c[0]) && isBlackTransparent(c[1]) & isBlackTransparent(c[2])
					&& isBlackTransparent(c[3]))
				return new MaterialData(Material.AIR);
		}

		// double cR = 1000000;
		// double cB = 1000000;
		// double cG = 1000000;
		// TODO: It does not matter the difference for specific colors. Look for
		// difference in ALL colours.
		double difference = Double.MAX_VALUE;

		MaterialData closest = null;

		double[] tR = new double[4];
		double[] tG = new double[4];
		double[] tB = new double[4];
		for (Entry<MaterialData, RGBBlockValue> entry : materialValue.entrySet()) {
			if (supportedMaterials != null) {
				boolean good = false;
				for (Material k : supportedMaterials)
					if (k == entry.getKey().getMaterial()) {
						good = true;
						break;
					}
				if (!good)
					continue;
			}
			for (int i = 0; i < 4; i++) {
				tR[i] = entry.getValue().r[i] - r[i];
				tG[i] = entry.getValue().g[i] - g[i];
				tB[i] = entry.getValue().b[i] - b[i];
				if (tR[i] < 0)
					tR[i] = -tR[i];
				if (tG[i] < 0)
					tG[i] = -tG[i];
				if (tB[i] < 0)
					tB[i] = -tB[i];
			}
			// Distance (terrible)
			/*
			 * if ((tR[0] * tR[0]) + (tG[0] * tG[0]) + (tB[0] * tB[0]) + (tR[1] * tR[1]) +
			 * (tG[1] * tG[1]) + (tB[1] * tB[1]) + (tR[2] * tR[2]) + (tG[2] * tG[2]) +
			 * (tB[2] * tB[2]) + (tR[3] * tR[3]) + (tG[3] * tG[3]) + (tB[3] * tB[3]) <
			 * cB+cR+cG) {
			 */
			// Distance (total closest favored)

			// Changing += to *=. Big differences will now stack.

			double diffs = 1;
			for (int i = 0; i < 4; i++) {
				diffs *= 1 + Math.sqrt((tR[i] * tR[i]) + (tG[i] * tG[i]) + (tB[i] * tB[i]));
			}

			/*
			 * double diffs = 0; for (int i = 0; i < 4; i++) { diffs += Math.sqrt((tR[i] *
			 * tR[i]) + (tG[i] * tG[i]) + (tB[i] * tB[i])); }
			 */

			if (diffs < difference) {

				if (entry.getValue().hasFaces()) {
					if (entry.getValue().isTop() != topView)
						continue;
				}
				/*
				 * cR = 0; cB = 0; cG = 0; for (int i = 0; i < 4; i++) { cR += (tR[i] * tR[i]);
				 * cB += (tB[i] * tB[i]); cG += (tG[i] * tG[i]); }
				 */
				difference = diffs;
				closest = entry.getKey();
			}
		}
		return closest;
	}

	/**
	 * Creates a resized version of an image. Since this takes 2x2 pixels to turn
	 * into 1 block, you can resize this by 2 if you want a 1-1 scale image.
	 * 
	 * @param originalImage
	 * @param scaledHeight
	 * @param preserveAlpha
	 * @return
	 */
	@Deprecated
	public static BufferedImage createResizedCopy(BufferedImage originalImage, int scaledHeight,
			boolean preserveAlpha) {
		int imageType = BufferedImage.TYPE_INT_RGB;
		int WIDTH = (int) (((double) originalImage.getWidth()) * (((double) scaledHeight) / originalImage.getHeight()));
		int HEIGHT = scaledHeight;
		BufferedImage scaledBI = new BufferedImage(WIDTH, HEIGHT, imageType);
		Graphics2D g = scaledBI.createGraphics();
		if (preserveAlpha) {
			g.setComposite(AlphaComposite.Src);
		}
		g.drawImage(originalImage, 0, 0, (int) scaledBI.getWidth(), scaledBI.getHeight(), null);
		g.dispose();
		return scaledBI;
	}

	/**
	 * From:
	 * 
	 */

	public static BufferedImage resize(BufferedImage image, int areaWidth, int areaHeight) {
		float scaleX = (float) areaWidth / image.getWidth();
		float scaleY = (float) areaHeight / image.getHeight();
		float scale = Math.min(scaleX, scaleY);
		int w = Math.round(image.getWidth() * scale);
		int h = Math.round(image.getHeight() * scale);

		int type = image.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;

		boolean scaleDown = scale < 1;

		if (scaleDown) {
			// multi-pass bilinear div 2
			int currentW = image.getWidth();
			int currentH = image.getHeight();
			BufferedImage resized = image;
			while (currentW > w || currentH > h) {
				currentW = Math.max(w, currentW / 2);
				currentH = Math.max(h, currentH / 2);

				BufferedImage temp = new BufferedImage(currentW, currentH, type);
				Graphics2D g2 = temp.createGraphics();
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.drawImage(resized, 0, 0, currentW, currentH, null);
				g2.dispose();
				resized = temp;
			}
			return resized;
		} else {
			Object hint = scale > 2 ? RenderingHints.VALUE_INTERPOLATION_BICUBIC
					: RenderingHints.VALUE_INTERPOLATION_BILINEAR;

			BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resized.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(image, 0, 0, w, h, null);
			g2.dispose();
			return resized;
		}
	}

	/**
	 * This gets all the pixel values for an image. Use this to get all the pixels
	 * for an image.
	 * 
	 * The first array stores the Row value (e.g. MC's "Y" value), and the second
	 * array stores the Columb value (MC's X or Z)
	 * 
	 * For example: If you want to get the pixel at the top left of an image, use
	 * convertTo2DWithoutUsingGetRGB(Image)[HEIGHT][0]
	 * 
	 * For example: If you want to get the pixel at the bottom right of an image,
	 * use convertTo2DWithoutUsingGetRGB(Image)[0][WIDTH]
	 * 
	 * @param image
	 * @return
	 */
	public static Pixel[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {
		if (image.getRaster().getDataBuffer() instanceof DataBufferByte) {
			final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			final int width = image.getWidth();
			final int height = image.getHeight();
			final boolean hasAlphaChannel = image.getAlphaRaster() != null;

			Pixel[][] result = new Pixel[height][width];
			int pixelLength = 0;
			int offset = 0;
			if (hasAlphaChannel) {
				pixelLength = 4;
				offset = 1;
			} else {
				pixelLength = 3;
			}

			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
				int r = 0;
				int b = 0;
				int g = 0;
				// argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
				b += ((int) pixels[pixel + offset] & 0xff); // blue
				g += (((int) pixels[pixel + offset + 1] & 0xff) /* << 8 */); // green
				r += (((int) pixels[pixel + offset + 2] & 0xff) /* << 16 */); // red
				// System.out.println(row+" c"+col);
				result[row][col] = new Pixel(r, g, b);
				col++;
				if (col == width) {
					col = 0;
					row++;
					if (row == height)
						break;
				}
			}

			return result;
		} else if (image.getRaster().getDataBuffer() instanceof DataBufferInt) {
			final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
			final int width = image.getWidth();
			final int height = image.getHeight();
			final boolean hasAlphaChannel = image.getAlphaRaster() != null;

			Pixel[][] result = new Pixel[height][width];
			if (hasAlphaChannel) {
				final int pixelLength = 1;// 4;
				for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
					int r = 0;
					int b = 0;
					int g = 0;
					/*
					 * // argb += (((int) pixels[pixel] & 0xff) << 24); // alpha b += ((int)
					 * pixels[pixel + 1] & 0xff); // blue g += (((int) pixels[pixel + 2] & 0xff) /*
					 * << 8 *); // green r += (((int) pixels[pixel + 3] & 0xff) /* << 16 *); // red
					 */

					r = (pixels[pixel] >> 16) & 0xFF;
					g = (pixels[pixel] >> 8) & 0xFF;
					b = pixels[pixel] & 0xFF;

					result[row][col] = new Pixel(r, g, b);
					col++;
					if (col == width) {
						col = 0;
						row++;
					}
				}
			} else {
				final int pixelLength = 1;
				for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
					int r = 0;
					int b = 0;
					int g = 0;
					int rgb = pixels[pixel];
					r = (rgb >> 16) & 0xFF;
					g = (rgb >> 8) & 0xFF;
					b = rgb & 0xFF;
					result[row][col] = new Pixel(r, g, b);
					col++;
					if (col == width) {
						col = 0;
						row++;
					}
				}
			}

			return result;
		}
		return null;
	}

	/**
	 * Creates a file with an image where each pixel represense the colorcode for a
	 * block
	 * 
	 * @param output
	 *            file
	 * @param bottomLeft
	 *            corner of the image
	 * @param topRight
	 *            corner of the image
	 */
	@SuppressWarnings("deprecation")
	public void createImageFromBlocks(File output, Location bottomLeft, Location topRight) {
		boolean isX = bottomLeft.getBlockZ() == topRight.getBlockZ();
		MaterialData[][] blocks = new MaterialData[topRight.getBlockY() - bottomLeft.getBlockY()][isX
				? Math.max(topRight.getBlockX(), bottomLeft.getBlockX())
						- Math.min(topRight.getBlockX(), bottomLeft.getBlockX())
				: Math.max(topRight.getBlockZ(), bottomLeft.getBlockZ())
						- Math.min(topRight.getBlockZ(), bottomLeft.getBlockZ())];
		for (int y = bottomLeft.getBlockY(); y < topRight.getBlockY(); y++) {
			if (isX) {
				for (int x = Math.min(topRight.getBlockX(), bottomLeft.getBlockX()); x < Math.max(topRight.getBlockX(),
						bottomLeft.getBlockX()); x++) {
					Block t = new Location(topRight.getWorld(), x, y, topRight.getBlockZ()).getBlock();
					blocks[y - bottomLeft.getBlockY()][x
							- Math.min(topRight.getBlockX(), bottomLeft.getBlockX())] = MaterialData
									.getMatDataByTypes(t.getType(), t.getData());
				}
			} else {
				for (int z = Math.min(topRight.getBlockZ(), bottomLeft.getBlockZ()); z < Math.max(topRight.getBlockZ(),
						bottomLeft.getBlockZ()); z++) {
					Block t = new Location(topRight.getWorld(), topRight.getBlockX(), y, z).getBlock();
					blocks[y - bottomLeft.getBlockY()][z
							- Math.min(topRight.getBlockZ(), bottomLeft.getBlockZ())] = MaterialData
									.getMatDataByTypes(t.getType(), t.getData());
				}
			}
		}
		createImageFromBlocks(output, blocks);
	}

	/**
	 * Creates a file with an image where each pixel represense the colorcode for a
	 * block
	 * 
	 * @param output
	 *            file
	 * @param the
	 *            material data for each block. first array being the Y, the second
	 *            being the X or Z;
	 */
	public void createImageFromBlocks(File output, MaterialData[][] blocks) {
		BufferedImage canvas = new BufferedImage(blocks[0].length, blocks.length, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				for (MaterialData rgb : materialValue.keySet()) {
					if (rgb.getMaterial() == blocks[y][x].getMaterial() && rgb.getData() == blocks[y][x].getData()) {
						int col = (materialValue.get(rgb).r[0] << 16) | (materialValue.get(rgb).g[0] << 8)
								| materialValue.get(rgb).b[0];
						canvas.setRGB(x, y, col);
					}
				}
			}
		}
		try {
			ImageIO.write(canvas, "jpg", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class Pixel {
		public int r;
		public int b;
		public int g;

		public Pixel(int r, int g, int b) {
			this.r = r;
			this.b = b;
			this.g = g;
		}
	}

}

class RGBValue {
	protected int[] r = new int[4];
	protected int[] b = new int[4];
	protected int[] g = new int[4];

	public RGBValue(Color c) {
		init(c, c, c, c);
	}

	public RGBValue(Color c, Color c2, Color c3, Color c4) {
		init(c, c2, c3, c4);
	}

	private void init(Color c, Color c2, Color c3, Color c4) {
		this.r[0] = c.getRed();
		this.g[0] = c.getGreen();
		this.b[0] = c.getBlue();
		// /
		this.r[1] = c2.getRed();
		this.g[1] = c2.getGreen();
		this.b[1] = c2.getBlue();
		// /
		this.r[2] = c3.getRed();
		this.g[2] = c3.getGreen();
		this.b[2] = c3.getBlue();
		// /
		this.r[3] = c4.getRed();
		this.g[3] = c4.getGreen();
		this.b[3] = c4.getBlue();
	}
}

class RGBBlockValue extends RGBValue {

	private boolean hasFaces = false;
	private boolean isTop = false;

	public boolean isTop() {
		return isTop;
	}

	public boolean hasFaces() {
		return hasFaces;
	}

	public RGBBlockValue(Color c, String mat) {
		super(c);
		if (Material.matchMaterial(mat) == null)
			return;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) 0), this);

	}

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String m) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(m) == null)
			return;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(m), (byte) 0), this);
	}

	public RGBBlockValue(Color c, String m, byte d) {
		super(c);
		if (Material.matchMaterial(m) == null)
			return;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(m), d), this);
	}

	public RGBBlockValue(Color c, String mat, int d) {
		super(c);
		if (Material.matchMaterial(mat) == null)
			return;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) d), this);
	}

	public RGBBlockValue(Color c, String mat, int d, boolean isTop) {
		super(c);
		if (Material.matchMaterial(mat) == null)
			return;
		this.isTop = isTop;
		this.hasFaces = true;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) d), this);
	}

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, int d) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(mat) == null)
			return;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) d), this);
	}

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, boolean isTop) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(mat) == null)
			return;
		this.hasFaces = true;
		this.isTop = isTop;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) 0), this);
	}

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, int d, boolean isTop) {
		this(c,c2,c3,c4,mat,d,isTop,null);
	}
	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, int d, boolean isTop, BlockFace face) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(mat) == null)
			return;
		this.hasFaces = true;
		this.isTop = isTop;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) d,face), this);
	}

	/**
	 * Door variables
	 */

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, int d, BlockFace direction) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(mat) == null)
			return;
		this.hasFaces = true;
		this.isTop = false;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) d, direction), this);
	}

	public RGBBlockValue(Color c, Color c2, Color c3, Color c4, String mat, BlockFace direction) {
		super(c, c2, c3, c4);
		if (Material.matchMaterial(mat) == null)
			return;
		this.hasFaces = true;
		this.isTop = false;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) 0, direction), this);
	}

	public RGBBlockValue(Color c, String mat, boolean isTop) {
		super(c);
		if (Material.matchMaterial(mat) == null)
			return;
		this.hasFaces = true;
		this.isTop = isTop;
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), (byte) 0), this);
	}

	public RGBBlockValue(Color c, String mat, DyeColor d) {
		super(c);
		if (Material.matchMaterial(mat) == null)
			return;
		byte dyecolor = -1;
		if ((ReflectionUtil.isVersionHigherThan(1, 10)))
			dyecolor = (byte) ReflectionUtil.invokeMethod(d, "getWoolData", null);
		else
			dyecolor = (byte) ReflectionUtil.invokeMethod(d, "getData", null);
		RGBBlockColor.materialValue.put(new MaterialData(Material.matchMaterial(mat), dyecolor), this);
	}
}
