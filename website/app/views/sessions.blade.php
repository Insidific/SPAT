@extends('templates.default')

@section('content')
    <div class="panel-group">
        <div class="panel panel-default">
            <?php $i =0;?>
    @foreach($sessions as $session)
        <?php $i++; ?>
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#collapse{{$i}}">{{$session["result"]->session_id}}</a>
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