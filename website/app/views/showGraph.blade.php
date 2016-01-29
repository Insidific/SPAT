@extends('templates.default')

@section('head')
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['scatter']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            @foreach($sensors as $sensor)

            var data{{$sensor->sensor_id}} = new google.visualization.DataTable();
            data{{$sensor->sensor_id}}.addColumn('number', 'Data');

            data{{$sensor->sensor_id}}.addColumn('number', 'Timestamp');

            data{{$sensor->sensor_id}}.addRows([
                    <?php $date = new Carbon\Carbon; $date->subDays($daysAgo); ?>
                @foreach($sensor->data()->where('timestamp', '>', $date->toDateTimeString())->get() as $datium)
                [{{$datium->timestamp->diffInMinutes()}}, {{$datium->data}}],
                @endforeach
        ]);

            var options{{$sensor->sensor_id}} = {
                width: 800,
                height: 500,
                chart: {
                    title: 'Sensor Data {{$daysAgo}} days ago for sensor: {{$sensor->sensor_id}} - {{{$sensor->name}}} ( {{$sensor->location}})',
                    subtitle: 'shown in time ago in minutes'
                },
                hAxis: {title: 'Time ago in minutes'},
                vAxis: {title: 'Data'}
            };

            var chart{{$sensor->sensor_id}} = new google.charts.Scatter(document.getElementById('scatterchart_material_{{$sensor->sensor_id}}'));

            chart{{$sensor->sensor_id}}.draw(data{{$sensor->sensor_id}}, google.charts.Scatter.convertOptions(options{{$sensor->sensor_id}}));
            @endforeach
            }
    </script>
@stop

@section('content')
    <a href="/graphs"><i class="fa fa-arrow-left"></i></a>
    @foreach($sensors as $sensor)
        <div id="scatterchart_material_{{$sensor->sensor_id}}" style="width: 900px; height: 500px"></div>
    @endforeach
@stop