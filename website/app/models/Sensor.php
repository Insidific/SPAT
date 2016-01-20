<?php

class Sensor extends \Eloquent {
	protected $fillable = [];

	public function SensorType() {
		return $this->hasOne('SensorType', 'sensor_types');
	}

	public function Data() {
		return $this->belongsToMany('Data', 'data');
	}
}