<?php

class DataType extends \Eloquent {
	protected $fillable = [];

	public function SensorType() {
		return $this->belongsToMany('SensorType', 'sensor_types', 'data_types_sensor_types', 'data_type_id', 'sensor_type_id');
	}

	public function Data() {
		return $this->belongsToMany('Data', 'data');
	}
}