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

Route::get('/sessions',array('uses' => 'SessionsController@index'));
Route::get('/sessions/{id}',array('uses' => 'SessionsController@show'));
Route::get('/sessions/{id}/edit',array('uses' => 'SessionsController@edit'));
Route::get('/sessions/{id}/update',array('uses' => 'SessionsController@update'));
Route::get('/sessions/{id}/delete',array('uses' => 'SessionsController@destroy'));