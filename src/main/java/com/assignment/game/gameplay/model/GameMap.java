package com.assignment.game.gameplay.model;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * @author Aditya
 *
 * {@link GameMap} Class defining game canvas area and keeping track of all visited areas in map.
 */
public final class GameMap {
	private int width;
	private int height;

	private boolean[][] canvas;

	public GameMap(int width, int height) {
		this.width = width;
		this.height = height;
		this.canvas = new boolean[height][width];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean[][] getCanvas() {
		return Arrays.copyOf(this.canvas, canvas.length);
	}

	public void setVisited(int x, int y){
		canvas[x][y] = true;
	}

	public void drawGameMap(){
		/**
		 * Draws canvas and its contents on console.
		 */
		this.drawHorizontalBorder();
		for(int h = 0; h < canvas.length; h++){
			System.out.print(String.format("%3d", h + 1));
			for(int w = 0; w < canvas[h].length; w++){
				System.out.print(String.format("%3s",canvas[h][w] ? "X" : " "));
			}
			System.out.println(String.format("%3d", h + 1));
		}

		this.drawHorizontalBorder();
		System.out.println();
		System.out.println("X - Visited Co-Orinate");
	}

	/**
	 * Draws an horizontal border with character "-"
	 */
	private void drawHorizontalBorder() {
		System.out.print("  *");
		IntStream.rangeClosed(1, this.width).forEach(i -> System.out.print(String.format("%3d", i)));
		System.out.println("  *");
	}
}
