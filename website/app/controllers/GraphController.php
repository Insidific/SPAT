<?php

class GraphController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 * GET /graph
	 *
	 * @return Response
	 */
	public function index()
	{
		return View::make("graphs",[]);
	}

	public function show($daysAgo)
	{
		$date = new Carbon\Carbon;
		$date->subDays($daysAgo);
		$sensors = Sensor::findMany( Data::where('timestamp', '>', $date->toDateTimeString() )->distinct('sensor_id')->get(array('sensor_id'))->toArray());
		$timestamps = Data::where('timestamp', '>', $date->toDateTimeString() )->distinct('timestamp')->get(array('timestamp'));

		return View::make("showGraph",["daysAgo" => $daysAgo, "sensors" => $sensors, "timestamps" => $timestamps]);
	}
}