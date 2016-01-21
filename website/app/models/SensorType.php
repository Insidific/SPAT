<?php

class SensorType extends \Eloquent {
	protected $fillable = [];

	public function Sensor() {
		return $this->belongsToMany('Sensor', 'sensors');
	}

	public function DataType() {
		return $this->hasMany('DataType', 'data_types', 'data_types_sensor_types', 'data_type_id', 'sensor_type_id');
	}
}