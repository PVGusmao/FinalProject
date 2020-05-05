package panel;

import java.util.Locale;
import java.util.Scanner;

class teste {
 
    @SuppressWarnings("null")
	public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	Locale.setDefault(Locale.US);
    	
    	double h, r, dff, subconductorDistance, tension, pointPtoA, pointPtoB, pointPtoC, t ;
    	int n, option, exit;
    
    	
    	System.out.println("Escolha a configuração da linha:\n 1-Flat\n 2-Delta\n 3-Vertical");
    	option = sc.nextInt();
    	
    	if (option == 1) {
    		System.out.println("Digite o valor da razão entre a altura da fase B em relação a fase A e o espaçamento.");
    		t = sc.nextDouble();
        	
    		System.out.println("Digite o valor da altura fase-solo em metros.");
    		h = sc.nextDouble();
        	
        	System.out.println("Digite o valor do raio do condutor em metros.");
        	r = sc.nextDouble();
        	
        	System.out.println("Digite o valor do espaçamento entre fases em metros.");
        	dff = sc.nextDouble();
        	
        	System.out.println("Digite o número de fases.");
        	n = sc.nextInt();
        	
        	System.out.println("Digite a ditância entre subcondutores em metros.");
        	subconductorDistance = sc.nextDouble();
        	
        	System.out.println("Digite o valor da tensão fase-fase da linha em kV.");
        	tension = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase A em metros.");
        	pointPtoA = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase B em metros.");
        	pointPtoB = sc.nextDouble();

        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase C em metros.");
        	pointPtoC = sc.nextDouble();
        	
        	double[][] matrix = createMatrixFlat(h, r, dff, n, subconductorDistance, t);
        	displayProduct(matrix);
        	double invertedMatrix[][] = invert(matrix);
        	double rMatrix[] = realVoltage(tension, 120, n); 
            double iMatrix[] = imaginaryVoltage(tension, 120, n);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n);
            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n);
            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            System.out.printf("The module of the elctric field at ground is: %.2f Newtons/Coulombs \n", polarValue[0]);
            System.out.printf("The angle of the elctric field at ground at degree is: %.2f graus", polarValue[1]);
            
            System.out.println("Digite exit para encerrar o programa.");
            exit = sc.nextInt();
            
    	} else if (option == 2) {
    		
    		System.out.println("Digite o valor da altura da fase A ao solo em metros.");
        	h = sc.nextDouble();
        	
        	System.out.println("Digite o valor da razão entre a altura da fase B em relação a fase A e o espaçamento.");
        	t = sc.nextDouble();
        	
        	System.out.println("Digite o valor do raio do condutor em metros.");
        	r = sc.nextDouble();
        	
        	System.out.println("Digite o valor do espaçamento entre fases em metros.");
        	dff = sc.nextDouble();
        	
        	System.out.println("Digite o número de fases.");
        	n = sc.nextInt();
        	
        	System.out.println("Digite a ditância entre subcondutores em metros.");
        	subconductorDistance = sc.nextDouble();
        	
        	System.out.println("Digite o valor da tensão fase-fase da linha em kV.");
        	tension = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase A em metros.");
        	pointPtoA = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase B em metros.");
        	pointPtoB = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase C em metros.");
        	pointPtoC = sc.nextDouble();
        	
        	double[][] matrix = createMatrixDelta(h , r , dff, n, subconductorDistance, t);
        	double invertedMatrix[][] = invert(matrix);
            double rMatrix[] = realVoltage(tension, 120, n);   
            double iMatrix[] = imaginaryVoltage(tension, 120, n);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n);
            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, dff, t);
            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, dff, t);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            System.out.printf("The module of the elctric field at ground is: %.2f Newtons/Coulombs \n", polarValue[0]);
            System.out.printf("The angle of the elctric field at ground at degree is: %.2f graus", polarValue[1]);
            
            System.out.println("Digite exit para encerrar o programa.");
            exit = sc.nextInt();
            
    	} else if (option == 3) {
    		
    		System.out.println("Digite o valor da altura da fase A ao solo em metros.");
        	h = sc.nextDouble();
        	
        	System.out.println("Digite o valor da razão entre a altura da fase B em relação a fase A e o espaçamento.");
        	t = sc.nextDouble();
        	
        	System.out.println("Digite o valor do raio do condutor em metros.");
        	r = sc.nextDouble();
        	
        	System.out.println("Digite o valor do espaçamento entre fases em metros.");
        	dff = sc.nextDouble();
        	
        	System.out.println("Digite o número de fases.");
        	n = sc.nextInt();
        	
        	System.out.println("Digite a ditância entre subcondutores em metros.");
        	subconductorDistance = sc.nextDouble();
        	
        	System.out.println("Digite o valor da tensão fase-fase da linha em kV.");
        	tension = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase A em metros.");
        	pointPtoA = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase B em metros.");
        	pointPtoB = sc.nextDouble();
        	
        	System.out.println("Digite o valor da distância horizontal do ponto P no solo até a fase C em metros.");
        	pointPtoC = sc.nextDouble();
        	
        	double[][] matrix = createMatrixVertical(h , r , dff, n, subconductorDistance, t);
        	displayProduct(matrix);
        	double invertedMatrix[][] = invert(matrix);
            double rMatrix[] = realVoltage(tension, 120, n);  
            double iMatrix[] = imaginaryVoltage(tension, 120, n);
            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n);
            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n);
            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, dff);
            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, dff);
            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
            System.out.printf("The module of the elctric field at ground is: %.2f Newtons/Coulombs \n", polarValue[0]);
            System.out.printf("The angle of the elctric field at ground at degree is: %.2f graus", polarValue[1]);
            
            System.out.println("Digite 1 para encerrar o programa.");
            exit = sc.nextInt();
            
    	}
        sc.close();
    }
    
    protected static double angle(double t, double dff) {
    	return Math.acos(dff/Math.sqrt(Math.pow(t*dff, 2) + Math.pow(dff, 2))) + degreeToRad(90);
    }
 
    protected static double[][] createMatrixFlat (double h, double r, double dff, int n, double counductorDistance, double t) {
        double matrix[][] = new double[n][n];
           
        for (int i = 0; i < n; i++) {
           
            for (int j = 0; j < n; j++) {
               
                if (i == j) {
                	matrix[i][j] = epsilon * Math.log(2 * (h / calcRc(counductorDistance, r, n))); 
                } else if (i - j == 1 || j - i == 1){
                	matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2*h,2) + Math.pow(dff, 2))/ dff);
                } else if (i - j == 2 || j - i == 2) {
                	matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2*h,2) + Math.pow(2*dff, 2))/ (2*dff));
                }
            }
        }
        return matrix;
    }

    protected static double[][] createMatrixDelta (double h, double r, double dff, int n, double counductorDistance, double t) {
        double matrix[][] = new double[n][n];
           
        for (int i = 0; i < n; i++) {
           
            for (int j = 0; j < n; j++) {
               
                if (i == 0 && j == 0) {
                	matrix[i][j] = epsilon * Math.log(2 * (h / calcRc(counductorDistance, r, n))); 
                } else if ( i == 1 && j == 1) {
                	matrix[i][j] = epsilon * Math.log((2*(h + t*dff)) / calcRc(counductorDistance, r, n));
                } else if ( i == 2 && j == 2 ) {
                	matrix[i][j] = epsilon * Math.log(2 * (h / calcRc(counductorDistance, r, n))); 
                } else if ( i - j == 1 || j - i == 1) {
                	matrix[i][j] = epsilon * Math.log((Math.sqrt(Math.pow(dff, 2) + Math.pow(2*h+dff, 2))/Math.sqrt(Math.pow(dff, 2) + Math.pow(dff*t, 2))));
                }  else if ( i - j == 2 || j - i == 2) {
                	matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2*h,2) + Math.pow(2*dff, 2))/ (2*dff));
                }
            }
        }
        return matrix;
    } 
    
    protected static double[][] createMatrixVertical (double h, double r, double dff, int n, double counductorDistance, double t) {
        double matrix[][] = new double[n][n];
           
        for (int i = 0; i < n; i++) {
           
            for (int j = 0; j < n; j++) {
               
                if (i == 0 && j == 0) {
                	matrix[i][j] = epsilon * Math.log(2 * (h / calcRc(counductorDistance, r, n))); 
                } else if ( i == 1 && j == 1) {
                	matrix[i][j] = epsilon * Math.log((2*(h + dff)) / calcRc(counductorDistance, r, n));
                } else if ( i == 2 && j == 2 ) {
                	matrix[i][j] = epsilon * Math.log(2 * (h + 2*dff) / calcRc(counductorDistance, r, n)); 
                } else if ( i == 0 && j == 1 || i == 1 && j == 0) {
                	matrix[i][j] = epsilon * Math.log((2*h + dff) / dff);
                } else if (i - j == 2 || j - i == 2) {
                	matrix[i][j] = epsilon * Math.log((2*h + 2*dff) / (2*dff));            
                } else if ( i == 1 && j == 2 || i == 2 && j == 1) {
                	matrix[i][j] = epsilon * Math.log((2*h + 3*dff) / dff);
                }
            }
        }
        return matrix;
    }
    
    protected static double calcRc(double counductorDistance, double r, double n) {
    	double base = r * Math.pow(counductorDistance, 2);
    	return Math.pow(Math.E, Math.log(base)/n);
        
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
 
    public static double[] realVoltage (double tension, double angle, int n){ 
    	double[] rMatrix= new double [n];
    	    	
    	for (int i = 0; i < n; i++) {
    		double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * i));
    		rMatrix[i] = faseReal;
    	  } 
    	return rMatrix;
    }
    
    public static double[] imaginaryVoltage (double tension, double angle, int n){ 	
    	double[] iMatrix= new double [n]; 				
    		
    	for (int i = 0; i < n; i++) {
    		double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * i));
    		iMatrix[i] = faseImaginary;
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

    public static double[][] multiplyMatrix(double[][] firstMatrix, double[] secondMatrix, int n) {
        
    	double[][] product = new double[n][1];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < n; k++) {
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
    
    public static double groundFieldFormulaFlat(double a[][], double dh1, double dh2, double dh3, double h, int n) {
    	double GroundValue = 0;
    	double[] dh = {dh1, dh2, dh3};
    	int j = 0;
    	for(int i = 0; i < n; i++) {
    		GroundValue += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
    	}
    	return GroundValue;
    }
    
    public static double groundFieldFormulaDelta(double a[][], double dh1, double dh2, double dh3, double h, int n, double dff, double t) {
    	double GroundValue0 = 0;
    	double GroundValue1 = 0;
    	double GroundValue2 = 0;
    	double[] dh = {dh1, dh2, dh3};
    	int j = 0;
    	for(int i = 0; i < n; i++) {
    		if (i == 0) {
    			GroundValue0 = epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
    		} else if ( i == 1) {
    			GroundValue1 = epsilon * 2 * ((a[i][j] * (h + (dff * t))/(Math.pow(dh[i], 2) + Math.pow((h + (dff * t)), 2))));
    		} else if (i == 2) {
    			GroundValue2 = epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
    		}
    	}
    	return (GroundValue0 + GroundValue1 + GroundValue2);
    }
    
    public static double groundFieldFormulaVertical(double a[][], double dh1, double dh2, double dh3, double h, int n, double dff) {
    	double GroundValue0 = 0;
    	double GroundValue1 = 0;
    	double GroundValue2 = 0;
    	double[] dh = {dh1, dh2, dh3};
    	int j = 0;
    	for(int i = 0; i < n; i++) {
    		if ( i == 0 ) {
    			GroundValue0 = epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
    		} else if ( i == 1 ) {
    			GroundValue1 = epsilon * 2 * ((a[i][j] * (h + dff)/(Math.pow(dh[i], 2) + Math.pow(h + dff, 2))));
    		}else if ( i == 2 ) {
    			GroundValue2 = epsilon * 2 * ((a[i][j] * (h + (2 *dff))/(Math.pow(dh[i], 2) + Math.pow(h + (2 * dff), 2))));
    		}
    	}
    	return GroundValue0 + GroundValue1 + GroundValue2;
    }
    
    public static double[] rectangularToPolar(double a, double b) {
    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
    	double angle = Math.atan(b/a);
    	double[] value = {module, radToDegree(angle)};
    	
    	return value;
    }
    
    protected static double epsilon = 18 * Math.pow(10, 9);
    
}