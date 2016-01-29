<?php

class SensorsController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 * GET /sensors
	 *
	 * @return Response
	 */
	public function index()
	{
		$sensors = Sensor::get();

		return View::make("sensors", ['sensors' => $sensors]);
	}

	/**
	 * Display the specified resource.
	 * GET /sensors/{id}
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		$sensor = Sensor::find($id);
		return View::make("viewSensor", ['sensor' => $sensor]);
	}

	/**
	 * Show the form for editing the specified resource.
	 * GET /sensors/{id}/edit
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
	 * PUT /sensors/{id}
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
	 * DELETE /sensors/{id}
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		//
	}

}