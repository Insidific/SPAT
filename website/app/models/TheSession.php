<?php

class TheSession extends \Eloquent {
	protected $table = 'sessions';
	protected $primaryKey = 'session_id';
	protected $fillable = [];

	public function Data() {
		return $this->belongsToMany('Data', 'session_id');
	}

	public function Sensors() {
		return $this->hasManyThrough('Sensor', 'Data', 'session_id', 'sensor_id');
	}
}