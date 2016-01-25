<?php

class SessionsController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 * GET /sessions
	 *
	 * @return Response
	 */
	public function index()
	{
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

	/**
	 * Display the specified resource.
	 * GET /sessions/{id}
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		$session = TheSession::find($id);
		$array = array();
		$array["sensors"] = DB::select(DB::raw('Select DISTINCT `sensors`.*, `data`.`session_id` FROM `sensors` INNER JOIN `data` ON `data`.`sensor_id` = `sensors`.`sensor_id` WHERE `data`.`session_id` = '.$session->session_id));


		return View::make('session', ['session' => $array, 'id' => $id]);
	}

	/**
	 * Show the form for editing the specified resource.
	 * GET /sessions/{id}/edit
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		//
	}

	/**
	 * Update the specified resource in storage.
	 * PUT /sessions/{id}
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		//
	}

	/**
	 * Remove the specified resource from storage.
	 * DELETE /sessions/{id}
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		//
	}

}