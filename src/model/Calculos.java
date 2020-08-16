package model;

public class Calculos {

	 public double angle(double t, double dff) {
    	return Math.acos(dff/Math.sqrt(Math.pow(t*dff, 2) + Math.pow(dff, 2))) + degreeToRad(90);
    }
 
	 public Vetor rotacao(double ang, Vetor a, double d) {
		 Vetor resp = new Vetor();
		 
		 resp.x = (a.x * Math.cos(ang) + a.y * (-Math.sin(ang)));
		 resp.y = (a.x * Math.sin(ang) + a.y * Math.cos(ang));
		 return resp; 
	 }
	 
	//--------> Criação dos condutores da configuração HORIZONTAL.
	 
	 public Conductor[] distribuiHorizontal (int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2, double rpr) {
		
		 Conductor condutor[] = new Conductor[n * sub +2];
 		 for (int i = 0; i<(n *sub+2); i++) {
 			condutor[i] = new Conductor();
 		 }
 		 
		 Vetor roda = new Vetor();
		
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<n; j++) {
			 condutor[c].x = p;
			 condutor[c].y = h;
			 condutor[c].r = r;
			 c++;
			 roda.x = d;
			 roda.y = 0;
			 
    		 for (int i = 1; i<(sub); i++) {
				 condutor[c].x = condutor[c-1].x + roda.x;
				 condutor[c].y = condutor[c-1].y + roda.y;
				 condutor[c].r = condutor[c-1].r;
				 roda = rotacao(a, roda, d);
				 c++;
				 
    		}
    		 p += s;
    	 }
		 
		 for (int m = (sub*n); m < (sub*n+2); m++) {
			 if (m == (sub*n) ) {
				 condutor[m].r = rpr;
				 condutor[m].x = xP1;
				 condutor[m].y = yP1;
			 } else {
				 condutor[m].r = rpr;
				 condutor[m].x = xP2;
    			 condutor[m].y = yP2;
			 }
		 }
		 
		 return condutor;
	 }

	//--------> Termin da criação dos condutores da configuração HORIZONTAL.
	 
	//--------> Criação dos condutores da configuração DELTA.
	 
	 public Conductor[] distribuiDelta (int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2, double t, double rpr) {
			
		 Conductor condutor[] = new Conductor[n * sub +2];
		 for (int i = 0; i<(n *sub+2); i++) {
			condutor[i] = new Conductor();
		 }
		 
		 Vetor roda = new Vetor();
		
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<n; j++) {
			 if (j == 1) {
				 condutor[c].x = p;
				 condutor[c].y = h + s*t;
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
   		 p += s;
   	 }
		 for (int m = (sub*n); m < (sub*n+2); m++) {
			 if (m == (sub*n) ) {
			 condutor[m].r = rpr;
			 condutor[m].x = xP1;
			 condutor[m].y = yP1;
			 } else {
				 condutor[m].r = rpr;
				 condutor[m].x = xP2;
    			 condutor[m].y = yP2;
			 }
		 }
		 return condutor;
	 }
	
	 //--------> Termino da criação dos condutores da configuração DELTA.
	 
	//--------> Criação dos condutores da configuração VERTICAL.
	 
	 public Conductor[] distribuiVertical (int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2, double t, double rpr) {
	 		
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
				 condutor[m].r = rpr;
				 condutor[m].x = xP1;
				 condutor[m].y = yP1;
				 } else {
					 condutor[m].r = rpr;
					 condutor[m].x = xP2;
	    			 condutor[m].y = yP2;
				 }
		 }
		 return condutor;
	 }
	 
	//--------> Termino da criação dos condutores da configuração VERTICAL.
	 
	 //--------> Criação da Matriz para a formação HORIZONTAL.
	 
	 public double[][] createMatrixFlatCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribuiHorizontal(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, rpr);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixFlatQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribuiHorizontal(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, rpr);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	
	 public double[][] createMatrixFlatTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n+2][sub * n+2];
	           
		Conductor condutor[] = distribuiHorizontal(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, rpr);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixFlatDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	    double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribuiHorizontal(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, rpr);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
	 			} else {
	 					double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
	 					double distPontoImagem = Math.sqrt(Math.pow(2 * condutor[j].y, 2) + Math.pow(dxy, 2));
		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
	 			}
	 		}
	 	}
	 	return matrix;
	 }
   
	 //--------> Termino da criação da matriz para a formação HORIZONTAL.
	 
	 //--------> Criação da Matriz para a formação DELTA.
	 
	 public double[][] createMatrixDeltaCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n+2][sub * n+2];
	           
			Conductor condutor[] = distribuiDelta(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixDeltaQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n+2][sub * n+2];
	           
			Conductor condutor[] = distribuiDelta(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixDeltaTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	        double matrix[][] = new double[sub * n+2][sub * n+2];
	           
			Conductor condutor[] = distribuiDelta(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixDeltaDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
     double matrix[][] = new double[sub * n+2][sub * n+2];
        
		Conductor condutor[] = distribuiDelta(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
	 			} else {
	 				double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
					double distPontoImagem = Math.sqrt(Math.pow(2 * condutor[j].y, 2) + Math.pow(dxy, 2));
	 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
	 			}
	 		}
	 	}
	 	return matrix;
}
	
	//--------> Termino da criação da matriz para a formação DELTA.
	 
	//--------> Criação da Matriz para a formação VERTICAL.
	 
	 public double[][] createMatrixVerticalCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixVerticalQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixVerticalTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j && i < sub*n) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else if (i == j && i >=n*sub) {
		 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	 public double[][] createMatrixVerticalDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2, double rpr) {
	    double matrix[][] = new double[sub * n+2][sub * n+2];
	           
	    Conductor condutor[] = distribuiVertical(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t, rpr);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j && i < sub*n) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else if (i == j && i >=n*sub) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/condutor[j].r); 
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
	 
	//--------> Termino da criação da matriz para a formação VERTICAL.
	 
	 public double[][] invert(double a[][]) {
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

	 public void gaussian(double a[][], int index[]) {
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
 
	 public double[] realVoltage (double tension, double angle, int n, int sub){ 
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
    
	 public double[] imaginaryVoltage (double tension, double angle, int n, int sub){ 	
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
    
	 public double degreeToRad (double angleInDegree) {

    	double angleInRad = angleInDegree / 57.32484076433121019108;
    	return angleInRad;
    }
    
	 public double radToDegree (double angleInRad) {

    	double angleInDegree = angleInRad * 57.32484076433121019108; 
    	return angleInDegree;
    }

	 public double[][] multiplyMatrix(double[][] firstMatrix, double[] secondMatrix, int n, int sub) {
        
    	double[][] product = new double[(sub * n +2)][1];
        for(int i = 0; i < (sub * n +2); i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < (sub * n +2); k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k];
                }
            }
        }
        return product;
    }

	 public void displayProduct(double[][] product) {

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
	 
	//--------> Início Fórmula para o cálculo do campo elétrico ao nível do solo para configuração HORIZONTAL.
	 
	 public double groundFieldFormulaFlat(double a[][], double dh1, double dh2, double dh3, double h, int n, double s, int sub) {
    	double GroundValue = 0;
    	double[] dh = new double [sub * n+2];
    	for (int c = 0; c <( sub * n+2); c++) {
    		if ( c < sub || c == (sub*n)) {
    			dh[c] = dh1;
    		} else if (c >= sub && c < 2*sub) {
    			dh[c] = dh2;
    		} else if (c >=2*sub && c < n*sub || c == (sub*n+1)) {
    			dh[c] = dh3;
    		}
    	}
    	int j = 0;
    	for(int i = 0; i < (sub * n +2); i++) {
    		GroundValue += epsilon * 2 * ((a[i][j] * h/(Math.pow(dh[i], 2) + Math.pow(h, 2))));
    	}
    	return GroundValue;
    }
    
	//--------> Termino do cálculo para o campo elétrico ao nível do solo para configuração HORIZONTAL.
	 
	//--------> Início Fórmula para o cálculo do campo elétrico ao nível do solo para configuração DELTA.
	 
	 public double groundFieldFormulaDelta(double a[][], double dh1, double dh2, double dh3, double h, int n, double dff, double t, int sub) {
	    	double GroundValue0 = 0;
	    	double[] dh = new double [sub * n+2];
	    	for (int c = 0; c <( sub * n+2); c++) {
	    		if ( c < sub || c == (sub*n)) {
	    			dh[c] = dh1;
	    		} else if (c >= sub && c < 2*sub) {
	    			dh[c] = dh2;
	    		} else if (c >=2*sub && c < n*sub || c == (sub*n+1)) {
	    			dh[c] = dh3;
	    		}
	    	}
	    	int j = 0;
	    	for(int i = 0; i <(sub * n + 2); i++) {
	    		if (i < sub || i == (sub*n)) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    		} else if ( i >= sub && i < 2*sub) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * (h + (dff * t))/(Math.pow(dh[i], 2) + Math.pow((h + (dff * t)), 2))));
	    		} else if (i >=2*sub && i < n*sub || i == n*sub+1) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    		}
	    	}
	    	return GroundValue0;
	    }
	 
	//--------> Termino do cálculo para o campo elétrico ao nível do solo para configuração DELTA.
	 
	//--------> Início Fórmula para o cálculo do campo elétrico ao nível do solo para configuração Vertical
	 
	 public double groundFieldFormulaVertical(double a[][], double dh1, double dh2,  double dh3, double h, int n, double dff, int sub, double xP1, double xP2, double s, double yP1, double yP2) {			 	
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
	 
	//--------> Termino do cálculo para o campo elétrico ao nível do solo para configuração VERTICAL.
	 
	 public double[] rectangularToPolar(double a, double b) {
    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
    	double angle = Math.atan(b/a);
    	double[] value = {module, radToDegree(angle)};
    	
    	return value;
    }

	 public void wait(int ms){
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
