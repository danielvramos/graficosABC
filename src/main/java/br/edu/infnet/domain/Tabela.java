package br.edu.infnet.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Tabela {

    private List<String> listaDatas = new ArrayList();
    private List<Double> listaPrecoVenda = new ArrayList();
    private List<Double> listaEMA9 = new ArrayList();
    private List<Double> listaEMA12 = new ArrayList();
    private List<Double> listaEMA26 = new ArrayList();
    private List<Double> listaMACD = new ArrayList();

    public void carregarDadosBasicos(Date dataIni, Date dataFim) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("C:\\MGLU3.SA.csv"));
//sc.useDelimiter(","); 

        List<String> dado = new ArrayList();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        sc.next();
        while (sc.hasNext()) {
            dado = Arrays.asList(sc.next().split(","));
            if ((dado.get(4).equals("null")) ||
                    (formato.parse(dado.get(0)).before(dataIni)) ||
                    (formato.parse(dado.get(0)).after(dataFim))) {
                sc.next();
            } else {
                //0 - Date,1 - Open,2 - High,3 - Low,4 - Close,5 - Adj_Close,6 - Volume
                this.listaDatas.add(dado.get(0));
                this.listaPrecoVenda.add(Double.parseDouble(dado.get(4)));
            }
        }
        sc.close();
    }

    public List<String> getListaDatas() {
        return listaDatas;
    }

    public void setListaDatas(List<String> listaDatas) {
        this.listaDatas = listaDatas;
    }

    public List<Double> getListaPrecoVenda() {
        return listaPrecoVenda;
    }

    public void setListaPrecoVenda(List<Double> listaPrecoVenda) {
        this.listaPrecoVenda = listaPrecoVenda;
    }

    public List<Double> getListaEMA9() {
        return listaEMA9;
    }

    public void setListaEMA9(List<Double> listaEMA9) {
        this.listaEMA9 = listaEMA9;
    }

    public List<Double> getListaEMA12() {
        return listaEMA12;
    }

    public void setListaEMA12(List<Double> listaEMA12) {
        this.listaEMA12 = listaEMA12;
    }

    public List<Double> getListaEMA26() {
        return listaEMA26;
    }

    public void setListaEMA26(List<Double> listaEMA26) {
        this.listaEMA26 = listaEMA26;
    }

    public List<Double> getListaMACD() {
        return listaMACD;
    }

    public void setListaMACD(List<Double> listaMACD) {
        this.listaMACD = listaMACD;
    }
}
