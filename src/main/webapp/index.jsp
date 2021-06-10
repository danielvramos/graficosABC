<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gráficos</title>
        <!-- --------------------------------------------------------------- -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>

        <script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
        <!-- --------------------------------------------------------------- -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
        <script type="text/javascript">
            function abrirGrafico() {
                var grafico = document.getElementById('grafico');
                var src = "linha?dataIni=" + $('#dataIni').val() + "&dataFim=" + $('#dataFim').val();
                grafico.src = src;
            }
            $(function () {
                $('#datetimepicker1').datetimepicker({
                    format: 'YYYY-MM-DD'
                });
            });
            $(function () {
                $('#datetimepicker2').datetimepicker({
                    format: 'YYYY-MM-DD'
                });
            });

        </script>
    </head>
    <body>
        <h1>Gráficos</h1>
        <hr />
        <div class="form-group">
            <label class="control-label col-sm-2" for="dataValidade">Data inicial:</label>
            <div class="col-sm-3">

                <div class='input-group date' id='datetimepicker1' >
                    <input type='text' class="form-control" name="dataIni" id="dataIni" value="2011-05-02"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>

            </div>

            <label class="control-label col-sm-2" for="dataValidade">Data Final:</label>
            <div class="col-sm-3">

                <div class='input-group date' id='datetimepicker2' >
                    <input type='text' class="form-control" name="dataFim" id="dataFim" value="2020-04-14"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>

            </div>

            <div class="col-sm-2">
                <input type="button" onclick="abrirGrafico()" class="btn btn-default" value="Gerar Gráfico"/>
            </div>
        </div>

        <img id="grafico"  />
    </body>
</html>
