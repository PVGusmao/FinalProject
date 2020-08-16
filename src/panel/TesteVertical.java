package panel;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Conductor;
import model.Vetor;

public class TesteVertical {

	public static void main(String[] args) {
		
		int sub = 3;
		double h = 10.6;
		double s = 10;
		double t = 0;
		double r = 0.0165;
		int n = 3;
		double subconductorDistance = 0.45;
		double tension = 525;
		double pointPtoA = 0;
		double pointPtoB = 0;
		double pointPtoC = 0;
		double xP1 = -1000000000;
		double yP1 = 1000000000;
		double xP2 = 1000000000;
		double yP2 = 1000000000;
		double rpr = 0.00000000000000006;
		
		if (sub == 2) {
			double[][] matrix = createMatrixVerticalDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = invert(matrix);
            double rMatrix[] = realVoltage(tension, 120, n, sub);  
            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix,pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            
            String module = String.valueOf(polarValue[0]);
            String angle = String.valueOf(polarValue[1]);
            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
            JOptionPane.showMessageDialog(null, number);
            
		} else if (sub == 3) {
			double[][] matrix = createMatrixVerticalTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
			displayProduct(matrix);
			System.out.println("-------------------------invertedMatrix---------------------------");
        	double invertedMatrix[][] = invert(matrix);
        	displayProduct(invertedMatrix);
			System.out.println("----------------------------rMatrix------------------------");
            double rMatrix[] = realVoltage(tension, 120, n, sub); 
            displayProduct2(rMatrix);
			System.out.println("----------------------------iMatrix------------------------");
            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
            displayProduct2(iMatrix);
			System.out.println("------------------------RealLoadMatrix----------------------------");
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            displayProduct(RealLoadMatrix);
			System.out.println("----------------------------ImaginaryLoadMatrix------------------------");
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            displayProduct(ImaginaryLoadMatrix);
			System.out.println("----------------------------realAtGround------------------------");
            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            System.out.println(realAtGround);
			System.out.println("------------------------imaginaryAtGround----------------------------");
            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            System.out.println(imaginaryAtGround);
			System.out.println("-------------------------------polarValue---------------------");
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            displayProduct2(polarValue);
			System.out.println("----------------------------------------------------");
            
            String module = String.valueOf(polarValue[0]);
            String angle = String.valueOf(polarValue[1]);
            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
            JOptionPane.showMessageDialog(null, number);
            
		} else if (sub == 4) {
			double[][] matrix = createMatrixVerticalQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = invert(matrix);
            double rMatrix[] = realVoltage(tension, 120, n, sub);  
            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            
            String module = String.valueOf(polarValue[0]);
            String angle = String.valueOf(polarValue[1]);
            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
            JOptionPane.showMessageDialog(null, number);
		
		}else if (sub == 5) {
			double[][] matrix = createMatrixVerticalCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = invert(matrix);
            double rMatrix[] = realVoltage(tension, 120, n, sub);  
            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub, xP1, xP2, s, yP1, yP2);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            
            String module = String.valueOf(polarValue[0]);
            String angle = String.valueOf(polarValue[1]);
            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
            JOptionPane.showMessageDialog(null, number);
		}
	}	

	 public static double angle(double t, double dff) {
	     return Math.acos(dff/Math.sqrt(Math.pow(t*dff, 2) + Math.pow(dff, 2))) + degreeToRad(90);
	}
	 
	 public static Vetor rotacao(double ang, Vetor a, double d) {
		 Vetor resp = new Vetor();
			 
		 resp.x = (a.x * Math.cos(ang) + a.y * (-Math.sin(ang)));
		 resp.y = (a.x * Math.sin(ang) + a.y * Math.cos(ang));
		 return resp; 
	}
		 
	 public static Conductor[] distribuiVertical (int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2, double t) {
	 		
		 Conductor condutor[] = new Conductor[n * sub+2];
 		 for (int i = 0; i<(n *sub+2); i++) {
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
		 for (int m = (sub*n); m < (sub*n+2); m++) {
			 if (m == (sub*n) ) {
				 condutor[m].x = xP1;
				 condutor[m].y = yP1;
				 } else {
					 condutor[m].x = xP2;
	    			 condutor[m].y = yP2;
				 }
		 }
		 return condutor;
	 }
	 
	 public static double[][] createMatrixVerticalCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/rpr); 
		 			} else {
			 			double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
		 				if (condutor[j].x == condutor[i].x) {
		 					double distPontoImagem = 2 * condutor[i].y + dxy;
			 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				} else {
		 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
		 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
		 					double distPontoImagem = Math.sqrt(parc1 + parc2);
			 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				}
			 		}
		 		}
		 	}
		 	return matrix;
		 }
	 
	 public static double[][] createMatrixVerticalQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/rpr); 
		 			} else {
		 			double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
		 				if (condutor[j].x == condutor[i].x) {
		 					double distPontoImagem = 2 * condutor[i].y + dxy;
		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				} else {
		 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
		 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
		 					double distPontoImagem = Math.sqrt(parc1 + parc2);
		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				}
		 			}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 public static double[][] createMatrixVerticalTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						System.out.println(condutor[j].y);
						System.out.println(r);
		 				matrix[i][j] = epsilon * Math.log((2 * condutor[j].y)/r);
		 				System.out.println(matrix[0][0]);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/rpr); 
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
	 
	 public static double[][] createMatrixVerticalDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	    double matrix[][] = new double[sub * n+2][sub * n+2];
	           
	    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/rpr); 
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
	    	double[] rMatrix= new double [n * sub+2];
	    	    	
	    	for (int i = 0; i < (sub * n+2); i++) {
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
	    	double[] iMatrix= new double [n * sub +2]; 				
	    		
	    	for (int i = 0; i < (sub *n+2); i++) {
	    		if (i < sub) {
	    			int d = 0;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if ( i >= sub && i < 2*sub) {
	    			int d = 1;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if (i >= 2*sub && i < 3*sub) {
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
	        
	    	double[][] product = new double[((sub * n) +2)][1];
	        for(int i = 0; i < ((sub * n) +2); i++) {
	            for (int j = 0; j < 1; j++) {
	                for (int k = 0; k < ((sub * n) +2); k++) {
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
		 
		 public static double groundFieldFormulaVertical(double a[][], double dh1, double dh2,  double dh3, double h, int n, double dff, int sub, double xP1, double xP2, double s, double yP1, double yP2) {			 	
			 	double GroundValue = 0;
		    	double[] dh = new double [sub * n+2];
		    	for (int c = 0; c <( sub * n+2); c++) {
		    		if ( c < sub ) {
		    			dh[c] = dh1;
		    		} else if (c >= sub && c < 2*sub) {
		    			dh[c] = dh2;
		    		} else if (c >=2*sub && c < n*sub ) {
		    			dh[c] = dh3;
		    		} else if (c == n*sub) {
		    			dh[c] = xP1;
		    		} else if (c == n*sub +1) {
		    			dh[c] = xP2;
		    		}
		    	}
		    	int j = 0;
		    	for(int i = 0; i < (sub * n+2); i++) {
		    		if (i < sub) {
		    			GroundValue += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
		    		} else if (i >=sub && i < 2*sub) {
		    			GroundValue += epsilon * 2 * ((a[i][j] * (h + s))/(Math.pow(dh[i], 2) + Math.pow((h + s), 2)));	
		    		} else if ( i >= 2*sub && i < 3*sub) {
			    		GroundValue += epsilon * 2 * ((a[i][j] * (h + 2*s))/(Math.pow(dh[i], 2) + Math.pow((h + 2*s), 2)));
		    		} else if (i == 3*sub) {
		    			GroundValue += epsilon * 2 * ((a[i][j] * yP1)/(Math.pow(dh[i], 2) + Math.pow(yP1, 2)));
		    		} else if (i == 3*sub+1) {
		    			GroundValue += epsilon * 2 * ((a[i][j] * yP2)/(Math.pow(dh[i], 2) + Math.pow(yP2, 2)));
		    		}
		    }
		    	return GroundValue;
		    	
		}
		
		 public static double[] rectangularToPolar(double a, double b) {
		    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
		    	double angle = Math.atan(b/a);
		    	double[] value = {module, radToDegree(angle)};
		    	
		    	return value;
		    }

		 public static void wait(int ms){
			        try
			        {
			            Thread.sleep(ms);
			        }
			        catch(InterruptedException ex)
			        {
			            Thread.currentThread().interrupt();
			        }
			    }
			 
		 public static double epsilon = 18 * Math.pow(10, 9);

		 
}
