//Shabes Vyacheslav,9a class
//Sets
//02.03.2018 11:27
public class Complex {
		double r;
		double i;

		public Complex(double r, double i) {
			this.r = r;
			this.i = i;
		}

		public static double abs(Complex z) {
			return Math.sqrt(z.r * z.r + z.i * z.i);
		}

		public static Complex add(Complex z1, Complex z2) {
			double real = z1.r + z2.r;
			double imaginary = z1.i + z2.i;
			return new Complex(real, imaginary);
		}

		public static Complex multiply(Complex z1, Complex z2) {
			double real = z1.r * z2.r - z1.i * z2.i;
			double imaginary = z1.r * z2.i + z2.r * z1.i;
			return new Complex(real, imaginary);
		}
	}