<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Sensored</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <li {{ (Request::is('/') ? 'class="active"' : '') }}><a href="/">Start</a></li>
                <li {{ (Request::is('sessions/') ? 'class="active"' : '') }}><a href="sessions/">Sessions</a></li>
                <li {{ (Request::is('sensor/') ? 'class="active"' : '') }}><a href="sensor/">Sensor Database</a></li>
                <li {{ (Request::is('graphs/') ? 'class="active"' : '') }}><a href="graphs/">Graphs</a></li>
            </ul>
        </div>
    </div>
</div>