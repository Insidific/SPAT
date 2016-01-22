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
		$allSessions = TheSession::get();
		$sessions = array();
		$session = new TheSession();
		foreach($allSessions as $session) {
			$array = array();
			$array["result"] = $session;
			$array["sensors"] = DB::select(DB::raw('Select DISTINCT `sensors`.*, `data`.`session_id` FROM `sensors` INNER JOIN `data` ON `data`.`sensor_id` = `sensors`.`sensor_id` WHERE `data`.`session_id` = '.$session->session_id));
			$sessions[] = $array;
		}

		return View::make('sessions', ['sessions' => $sessions]);
	}

}
