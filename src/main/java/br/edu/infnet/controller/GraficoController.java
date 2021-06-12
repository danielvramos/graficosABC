package br.edu.infnet.controller;

import br.edu.infnet.domain.Tabela;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class GraficoController {
  
@RequestMapping("/linha")
    public void obterGraficoLinha2(HttpServletResponse response, HttpServletRequest request) throws Exception  {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        Tabela tabela = new Tabela();
        Date dataIni =  formato.parse(request.getParameter("dataIni"));
        Date dataFim =  formato.parse(request.getParameter("dataFim"));
        try {
            tabela.carregarDadosBasicos(dataIni, dataFim);
            tabela.carregarMediasMoveis();
            
            for (int i = 0; i < tabela.getListaDatas().size(); i++) {
           ds.addValue(tabela.getListaPrecoVenda().get(i),
                   "Preço fechamento",
                   formatoBrasileiro.format(formato.parse(tabela.getListaDatas().get(i)))); 
           ds.addValue(tabela.getListaEMA9().get(i),
                   "EMA 9",
                   formatoBrasileiro.format(formato.parse(tabela.getListaDatas().get(i)))); 
           ds.addValue(tabela.getListaEMA12().get(i),
                   "EMA 12",
                   formatoBrasileiro.format(formato.parse(tabela.getListaDatas().get(i)))); 
           ds.addValue(tabela.getListaEMA26().get(i),
                   "EMA 26",
                   formatoBrasileiro.format(formato.parse(tabela.getListaDatas().get(i)))); 
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraficoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         //----------------------------------------------------------------------
        JFreeChart chart = ChartFactory.createLineChart(
                "Grafico de preço da Ação MGLU3",
                "Data", "Preço da açao",
                ds,
                PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(ChartColor.white);
        plot.setRangeGridlinePaint(ChartColor.white);
        CategoryAxis caxis = plot.getDomainAxis();
        caxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        
        //----------------------------------------------------------------------
        try {

            ServletOutputStream out = response.getOutputStream();
            response.setContentType("image/png");
            ChartUtilities.writeChartAsPNG(out, chart, 2000, 600);
            out.flush();
            out.close();

        } catch (Exception e) {
        }

    }
}
