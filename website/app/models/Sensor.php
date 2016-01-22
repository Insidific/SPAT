<?php

class Sensor extends \Eloquent {
	protected $table = 'sensors';
	protected $primaryKey = 'sensor_id';
	protected $fillable = [];

	public function SensorType() {
		return $this->hasOne('SensorType', 'sensor_type_id');
	}

	public function Data() {
		return $this->belongsToMany('Data', 'data');
	}
}