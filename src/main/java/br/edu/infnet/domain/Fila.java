package br.edu.infnet.domain;

public class Fila {

    private double lista[];
    private int fimLista;

    private int tamanho;

    //tem que criar as caracteristicas da classe fifo tipo oque ela é 
    Fila(int tamanho) {
        this.lista = new double[tamanho];
        this.fimLista = -1;
        this.tamanho = tamanho;

    }

    public boolean taCheia() {
        return this.fimLista == this.tamanho - 1;
    }

    public double SMA() {
        double total = 0.0;
        for (int x = 0; x < this.tamanho; x++) {
            total += this.lista[x];
        }
        return total/this.tamanho;
    }

    public double multiplicador() {

        return (2.0 / (this.tamanho + 1.0));
    }

  

    public void adicionar(double valor) {
        if (this.taCheia()) {
            for (int x = 0; x < this.tamanho; x++) {
                if (this.fimLista == x) {
                    this.lista[x] = valor;
                } else {
                    this.lista[x] = this.lista[x + 1];
                }
            }
        } else {
            this.fimLista++;
            this.lista[this.fimLista] = valor;
        }

    }

    //mostrar o array
    public void mostrar() {
        for (int x = 0; x < lista.length; x++) {
            System.out.println("posicao " + (x + 1) + " = " + lista[x]);
        }
    }
}
