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
		$data = Data::find(1);
		echo '<pre>';
		var_dump($data->sensor->sensorType->dataTypes);
		echo '</pre>';
		foreach($data->sensor->sensorType->dataTypes as $dataType)
		{
			echo $dataType->name;
		}

		return View::make('hello');
	}

}
