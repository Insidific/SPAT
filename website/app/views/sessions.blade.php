@extends('templates.default')

@section('content')
    <div class="panel-group">
        <div class="panel panel-default">
            <?php $i =0;?>
    @foreach($sessions as $session)
        <?php $i++; ?>
                <div class="panel-heading">
                    <h4 class="panel-title" Style="padding: 10px;">
                        <div class="col-md-3"><a data-toggle="collapse" href="#collapse{{$i}}">{{$session["result"]->session_id}} </a></div><div class="col-md-6"></div><div class="col-md-3"><button type="button" class="btn btn-primary btn-sm">View</button> <button type="button" class="btn btn-primary btn-sm">Edit</button> <button type="button" class="btn btn-primary btn-sm">Deletesessions.blade.php</button></div>
                    </h4>
                </div>
                <div id="collapse{{$i}}" class="panel-collapse collapse">
                    <ul class="list-group">
                @foreach($session["sensors"] as $sensor)
                            <li class="list-group-item">{{$sensor->name}}</li>
                @endforeach
                    </ul>
                </div>
    @endforeach
        </div>
    </div>
@stop