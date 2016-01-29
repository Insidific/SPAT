@extends('templates.default')

@section('content')
    <h1>Sensor Database</h1>
    <p>This is a list of all the sensors ever used</p>
    <table id="sensors" class="dataTable" data-role="datatable" data-searching="true">
        <thead>
            <tr>
                <th>#</th>
                <th>Sensor Name</th>
                <th>Sensor Type</th>
                <th>Location</th>
                <th>More Info</th>
            </tr>
        </thead>
        <tbody>
            @foreach($sensors as $sensor)
                <tr>
                    <td>{{$sensor->sensor_id}}</td>
                    <td>{{$sensor->name}}</td>
                    @if($sensor->sensorType != null)
                        <td>{{$sensor->sensorType->name}}</td>
                    @else
                        <td>Not set</td>
                    @endif
                    <td>{{$sensor->location}}</td>
                    <td><a href="/sensors/{{$sensor->sensor_id}}">Advanced View</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>
@stop