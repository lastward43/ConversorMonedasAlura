package com.conversormonedas;

public class Conversor {
	   private double tasaDolar = 0.011; // Tasa de conversión de pesos argentinos a dólares
	    private double tasaEuro = 0.009;  // Tasa de conversión de pesos argentinos a euros
	    private double tasaLibra = 0.007; // Tasa de conversión de pesos argentinos a libras esterlinas
	    private double tasaYen = 1.19;   // Tasa de conversión de pesos argentinos a yenes japoneses
	    private double tasaWon = 12.55;  // Tasa de conversión de pesos argentinos a wones surcoreanos

	    public double convertirPesosADolar(double pesos) {
	        return pesos * tasaDolar;
	    }

	    public double convertirPesosAEuro(double pesos) {
	        return pesos * tasaEuro;
	    }

	    public double convertirPesosALibra(double pesos) {
	        return pesos * tasaLibra;
	    }

	    public double convertirPesosAYen(double pesos) {
	        return pesos * tasaYen;
	    }

	    public double convertirPesosAWon(double pesos) {
	        return pesos * tasaWon;
	    }

	    public double convertirDolarAPesos(double dolares) {
	        return dolares / tasaDolar;
	    }

	    public double convertirEuroAPesos(double euros) {
	        return euros / tasaEuro;
	    }

	    public double convertirLibraAPesos(double libras) {
	        return libras / tasaLibra;
	    }

	    public double convertirYenAPesos(double yenes) {
	        return yenes / tasaYen;
	    }

	    public double convertirWonAPesos(double wones) {
	        return wones / tasaWon;
	    }
}
