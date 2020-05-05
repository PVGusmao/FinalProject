package panel;

import java.util.Locale;
import java.util.Scanner;

public class testeteste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		double h, r, s, subconductorDistance, tension, pointPtoA, pointPtoB, pointPtoC, t ;
		int n, option, exit;
		
		System.out.println("Digite o valor da altura da fase A ao solo em metros.");
//    	h = sc.nextDouble();
    	h = 10;
    	System.out.println("Digite o valor da razão entre a altura da fase B em relação a fase A e o espaçamento.");
//    	t = sc.nextDouble();
    	t = 0;
    	System.out.println("Digite o valor do raio do condutor em metros.");
//    	r = sc.nextDouble();
    	r = 0.045;
    	System.out.println("Digite o valor do espaçamento entre fases em metros.");
//    	s = sc.nextDouble();
    	s = 10;
    	System.out.println("Digite o número de fases.");
//    	n = sc.nextInt();
    	n = 3;
    	System.out.println("Digite a ditância entre subcondutores em metros.");
//    	subconductorDistance = sc.nextDouble();
    	subconductorDistance = 0.45;
    	System.out.println("Digite o valor da tensão fase-fase da linha em kV.");
//    	tension = sc.nextDouble();
    	tension = 525;
    	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase A em metros.");
//    	pointPtoA = sc.nextDouble();
    	pointPtoA = 0;
    	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase B em metros.");
//    	pointPtoB = sc.nextDouble();
    	pointPtoB = 0;
    	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase C em metros.");
//    	pointPtoC = sc.nextDouble();
    	pointPtoC = 0;
    	
		int sub = 3;
		double[][] matrix = createMatrixVerticalTres(h, r, s, n, subconductorDistance, t, sub);
//		displayProduct(matrix);
    	double invertedMatrix[][] = invert(matrix);
//    	displayProduct(invertedMatrix);
        double rMatrix[] = realVoltage(tension, 120, n, sub);  
//        displayProduct2(rMatrix);
        double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
//        displayProduct2(iMatrix);
        double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
//        displayProduct(RealLoadMatrix);
        double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
//        displayProduct(ImaginaryLoadMatrix);
        double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
        System.out.println(realAtGround);
        double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
        System.out.println(imaginaryAtGround);
        if (imaginaryAtGround < 0.01) {
        	imaginaryAtGround = 0;
        }
	}
	
	 protected static double angle(double t, double dff) {
	    	return Math.acos(dff/Math.sqrt(Math.pow(t*dff, 2) + Math.pow(dff, 2))) + degreeToRad(90);
	    }
	 
	 public static Vetor rotacao(double ang, Vetor a, double d) {
		 Vetor resp = new Vetor();
		 
		 resp.x = (a.x * Math.cos(ang) + a.y * (-Math.sin(ang)));
		 resp.y = (a.x * Math.sin(ang) + a.y * Math.cos(ang));
		 return resp; 
	 }
	 
	 protected static Conductor[] distribui(int n, int sub, double d, double h, double r, double s, double t) {
	 		
		 Conductor condutor[] = new Conductor[n * sub];
		 for (int i = 0; i<(n *sub); i++) {
			condutor[i] = new Conductor();
		 }
		 
		 Vetor roda = new Vetor();
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<(n); j++) {
			 if (j == 1) {
				 condutor[c].x = p;
				 condutor[c].y = h + s;
				 condutor[c].r = r;
				 c++;
				 roda.x = d;
				 roda.y = 0; 
			 } else if (j == 2) {
				 	condutor[c].x = p;
				 	condutor[c].y = h + 2*s;
				 	condutor[c].r = r;
				 	c++;
				 	roda.x = d;
				 	roda.y = 0;
			 } else {
				 	condutor[c].x = p;
				 	condutor[c].y = h;
				 	condutor[c].r = r;
				 	c++;
				 	roda.x = d;
				 	roda.y = 0; 
				 
			 }
 		 for (int i = 1; i<(sub); i++) {
				 condutor[c].x = condutor[c-1].x + roda.x;
				 condutor[c].y = condutor[c-1].y + roda.y;
				 condutor[c].r = condutor[c-1].r;
				 roda = rotacao(a, roda, d);
				 c++;
 		}
 		 
 	 }
//		 for (int m = (sub*n); m < (sub*n+2); m++) {
//			 if (m == (sub*n) ) {
//				 condutor[m].x = xP1;
//				 condutor[m].y = yP1;
//				 } else {
//					 condutor[m].x = xP2;
//	    			 condutor[m].y = yP2;
//				 }
//		 }
		 return condutor;
	 }
	 
	 protected static double[][] createMatrixVerticalTres (double h, double r, double s, int n, double d, double t, int sub) {
		    double matrix[][] = new double[sub * n][sub * n];
		           
		    Conductor condutor[] = distribui(n, sub, d, h, r, s, t);
			 
		 	for (int i = 0; i<n*sub; i++) {
		 		for (int j = 0; j<n*sub; j++) {
		 			if (i == j) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else {
		 				double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
			 			double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
			 			double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
			 			double distPontoImagem = Math.sqrt(parc1 + parc2);
	    		 		matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
			 				
				 	}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 public static double[][] invert(double a[][]) {
	        int n = a.length;
	        double x[][] = new double[n][n];
	        double b[][] = new double[n][n];
	        int index[] = new int[n];
	        for (int i=0; i<n; ++i) 
	            b[i][i] = 1;
	 
	        gaussian(a, index);
	 
	        for (int i=0; i<n-1; ++i)
	            for (int j=i+1; j<n; ++j)
	                for (int k=0; k<n; ++k)
	                    b[index[j]][k]
	                    	    -= a[index[j]][i]*b[index[i]][k];
	        
	        for (int i=0; i<n; ++i) {
	            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
	            for (int j=n-2; j>=0; --j) {
	                x[j][i] = b[index[j]][i];
	                
	                for (int k=j+1; k<n; ++k) {
	                    x[j][i] -= a[index[j]][k] * x[k][i];
	                }
	                x[j][i] /= a[index[j]][j];
	            }

	        }
	        return x;
	    }

	    public static void gaussian(double a[][], int index[]) {
	        int n = index.length;
	        double c[] = new double[n];
	 
	        for (int i=0; i<n; ++i) 
	            index[i] = i;
	 
	        for (int i=0; i<n; ++i) 
	        {
	            double c1 = 0;
	            for (int j=0; j<n; ++j) 
	            {
	                double c0 = Math.abs(a[i][j]);
	                if (c0 > c1) c1 = c0;
	            }
	            c[i] = c1;
	        }

	        int k = 0;
	        for (int j=0; j<n-1; ++j) 
	        {
	            double pi1 = 0;
	            for (int i=j; i<n; ++i) 
	            {
	                double pi0 = Math.abs(a[index[i]][j]);
	                pi0 /= c[index[i]];
	                if (pi0 > pi1) 
	                {
	                    pi1 = pi0;
	                    k = i;
	                }
	            }
	 
	            int itmp = index[j];
	            index[j] = index[k];
	            index[k] = itmp;
	            for (int i=j+1; i<n; ++i) 	
	            {
	                double pj = a[index[i]][j]/a[index[j]][j];
	 
	                a[index[i]][j] = pj;
	 
	                for (int l=j+1; l<n; ++l)
	                    a[index[i]][l] -= pj*a[index[j]][l];
	            }
	        }
	    }
	 
	    public static double[] realVoltage (double tension, double angle, int n, int sub){ 
	    	double[] rMatrix= new double [n * sub ];
	    	    	
	    	for (int i = 0; i < (sub * n); i++) {
	    		if (i < sub) {
	    			int d = 0;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if ( i >= sub && i < 2*sub) {
	    			int d = 1;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if (i >= 2*sub && i < 3*sub) {
	    			int d = 2;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if (i >= 3*sub) {
	    			rMatrix[i] = 0;
	    		}
	    		
	    	  } 
	    	return rMatrix;
	    }
	    
	    public static double[] imaginaryVoltage (double tension, double angle, int n, int sub){ 	
	    	double[] iMatrix= new double [n * sub]; 				
	    		
	    	for (int i = 0; i < (sub *n); i++) {
	    		if (i < sub) {
	    			int d = 0;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if ( i >= sub && i < 2*sub) {
	    			int d = 1;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if (i >= 2*sub) {
	    			int d = 2;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if (i >= 3*sub) {
	    			iMatrix[i] = 0;
	    		}
	    		
	    	  } 
	    	return iMatrix;
	    }
	    
	    public static double degreeToRad (double angleInDegree) {

	    	double angleInRad = angleInDegree / 57.32484076433121019108;
	    	return angleInRad;
	    }
	    
	    public static double radToDegree (double angleInRad) {

	    	double angleInDegree = angleInRad * 57.32484076433121019108; 
	    	return angleInDegree;
	    }

public static double[][] multiplyMatrix(double[][] firstMatrix, double[] secondMatrix, int n, int sub) {
	        
	    	double[][] product = new double[(sub *n)][1];
	        for(int i = 0; i < (sub *n); i++) {
	            for (int j = 0; j < 1; j++) {
	                for (int k = 0; k < (sub *n); k++) {
	                    product[i][j] += firstMatrix[i][k] * secondMatrix[k];
	                }
	            }
	        }
	        return product;
	    }

	    public static void displayProduct(double[][] product) {

	        System.out.println("Product of two matrices is: ");
	        for(double[] row : product) {
	            for (double column : row) {
	                System.out.print(column + "    ");
	            }
	            System.out.println();
	        }
	    }
	    
	    public static void displayProduct2(double [] realAtGround) {

	        System.out.println("Product of two matrices is: ");
	        for(double column : realAtGround) {
	                System.out.print(column + "    ");
	            
	            System.out.println();
	        }
	    }
	      
	    public static double groundFieldFormulaVertical(double a[][], double dh1, double dh2,  double dh3, double h, int n, double dff, int sub) {
	    	double GroundValue = 0;
	    	double[] dh = new double [sub * n];
	    	for (int c = 0; c <( sub * n); c++) {
	    		if ( c < sub || c == (sub*n)) {
	    			dh[c] = dh1;
	    		} else if (c >= sub && c < 2*sub) {
	    			dh[c] = dh2;
	    		} else if (c >=2*sub && c < n*sub || c == (sub*n+1)) {
	    			dh[c] = dh3;
	    		}
	    	}
	    	int j = 0;
	    	for(int i = 0; i < (sub * n); i++) {
	    		GroundValue += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    	}
	    	return GroundValue;
	    }
	    
	    public static double[] rectangularToPolar(double a, double b) {
	    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
	    	double angle = Math.atan(b/a);
	    	double[] value = {module, radToDegree(angle)};
	    	
	    	return value;
	    }

	    protected static double epsilon = 18 * Math.pow(10, 9);
	    
}

