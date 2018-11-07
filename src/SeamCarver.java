import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
	private int width, height;
	private double energy[][];
	private int RGB[][];

	public SeamCarver(Picture picture) {
		// create a seam carver object based on the given picture;
		this.width = picture.width();
		this.height = picture.height();
		this.energy = new double[this.width][this.height];

		this.RGB = new int[this.width][this.height];
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				this.RGB[i][j] = picture.getRGB(i, j);
			}
		}
	}

	public Picture picture() {
		Picture picture = new Picture(this.width, this.height);
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				picture.setRGB(i, j, this.RGB[i][j]);
			}
		}
		return picture;
	}

	public int width() {
		// width of current picture;
		return this.width;
	}

	public int height() {
		// height of current picture;
		return this.height;
	}

	private boolean isTrivialEnergy(int x, int y) {
		if (0 == x || 0 == y || x == this.width - 1 || y == this.height - 1) {
			return true;
		} else {
			return false;
		}
	}

	private double xEnergy(int x, int y) {
		int r1 = (this.RGB[x - 1][y] >> 16) & 0xFF;
		int g1 = (this.RGB[x - 1][y] >> 8) & 0xFF;
		int b1 = (this.RGB[x - 1][y] >> 0) & 0xFF;

		int r2 = (this.RGB[x + 1][y] >> 16) & 0xFF;
		int g2 = (this.RGB[x + 1][y] >> 8) & 0xFF;
		int b2 = (this.RGB[x + 1][y] >> 0) & 0xFF;

		return Math.pow(r1 - r2, 2) + Math.pow(g1 - g2, 2) + Math.pow(b1 - b2, 2);
	}

	private double yEnergy(int x, int y) {
		int r1 = (this.RGB[x][y - 1] >> 16) & 0xFF;
		int g1 = (this.RGB[x][y - 1] >> 8) & 0xFF;
		int b1 = (this.RGB[x][y - 1] >> 0) & 0xFF;

		int r2 = (this.RGB[x][y + 1] >> 16) & 0xFF;
		int g2 = (this.RGB[x][y + 1] >> 8) & 0xFF;
		int b2 = (this.RGB[x][y + 1] >> 0) & 0xFF;

		return Math.pow(r1 - r2, 2) + Math.pow(g1 - g2, 2) + Math.pow(b1 - b2, 2);
	}

	public double energy(int x, int y) {
		if (this.isTrivialEnergy(x, y)) {
			return 1000;
		}
		return Math.sqrt(this.xEnergy(x, y) + this.yEnergy(x, y));
	}

	public int[] findHorizontalSeam() {
		// sequence of indices for horizontal seam
		return null;
	}

	public int[] findVerticalSeam() {
		// sequence of indices for vertical seam
		return null;
	}

	public void removeHorizontalSeam(int[] seam) {
		// remove horizontal seam from current picture
	}

	public void removeVerticalSeam(int[] seam) {
		// remove vertical seam from current picture
	}

	public static void main(String[] args) {

	}

}