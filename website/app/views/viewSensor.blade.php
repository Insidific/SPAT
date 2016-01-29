@extends('templates.default')

@section('content')
    <h1>Sensor Details</h1>
    <h2>Details</h2>
    <ul>
        <li>Name: {{$sensor->name}}</li>
        <li>Location: {{$sensor->location}}</li>
        @if($sensor->sensorType != null)
        <li>Sensor Type: {{$sensor->sensorType->name}}</li>
            @foreach($sensor->sensorType->dataTypes as $dataType)
                <ul>
                    <li>{{$dataType->name}}</li>
                </ul>
            @endforeach
        @endif
    </ul>
    <a href="/sensors/{{$sensor->sensor_id}}/edit">Edit Information</a>

    <h2>Data</h2>
    @foreach($sensor->data as $data)
        <ul>
            <li>({{$data->session->session_id }}) {{$data->session->name}} - {{$data->data}} - {{$data->timestamp }}</li>
        </ul>
    @endforeach
@stop