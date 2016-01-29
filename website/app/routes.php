<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', function()
{
	return View::make('hello');
});

<<<<<<< HEAD
Route::get('/sessions',array('uses' => 'HomeController@showSessions'));

// Sensor routes
Route::get('/sensors',array('uses' => 'SensorsController@index'));
Route::get('/sensors/{id}',array('uses' => 'SensorsController@show'));
Route::get('/sensors/{id}/edit',array('uses' => 'SensorsController@edit'));
Route::post('/sensors/{id}/update',array('uses' => 'SensorsController@update'));
Route::post('/sensors/{id}/destroy',array('uses' => 'SensorsController@destroy'));

Route::get('/graphs',array('uses' => 'GraphController@index'));
Route::get('/graphs/{day}',array('uses' => 'GraphController@show'));
=======
Route::get('/sessions',array('uses' => 'SessionsController@index'));
Route::get('/sessions/{id}',array('uses' => 'SessionsController@show'));
Route::get('/sessions/{id}/edit',array('uses' => 'SessionsController@edit'));
Route::get('/sessions/{id}/update',array('uses' => 'SessionsController@update'));
Route::get('/sessions/{id}/delete',array('uses' => 'SessionsController@destroy'));
>>>>>>> origin/Website
