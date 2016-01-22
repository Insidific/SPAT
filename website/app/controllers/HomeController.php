<?php

class HomeController extends BaseController {

	/*
	|--------------------------------------------------------------------------
	| Default Home Controller
	|--------------------------------------------------------------------------
	|
	| You may wish to use controllers instead of, or in addition to, Closure
	| based routes. That's great! Here is an example controller method to
	| get you started. To route to this controller, just add the route:
	|
	|	Route::get('/', 'HomeController@showWelcome');
	|
	*/

	public function showWelcome()
	{

		return View::make('hello');
	}

	public function showSessions() {
		$data = TheSession::get();
		foreach($data as $session) {
			var_dump(Data::find(5)->sensor);
			foreach($session->sensors as $sensor) {
				var_dump($sensor);
			}
		}

		echo '<pre>';
		var_dump(DB::getQueryLog());
		echo '</pre>';

		return View::make('sessions', ['data' => $data]);
	}

}
