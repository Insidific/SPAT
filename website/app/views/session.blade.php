@extends('templates.default')

@section('content')

    <div class="container">
        <h2>Session - {{$id}}</h2>
        <p>Some information about the Sensor maybe...</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Sensor</th>
                <th>Location</th>
            </tr>
            </thead>
            <tbody>
            @foreach($session["sensors"] as $sensor)
                <tr>
                    <td>{{$sensor->name}}</td>
                    <td>{{$sensor->location}}</td>
                </tr>
            @endforeach
            </tbody>
        </table>
    </div>
@stop