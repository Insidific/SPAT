<?php

class SensorType extends \Eloquent {
	protected $table = 'sensor_types';
	protected $primaryKey = 'sensor_type_id';
	protected $fillable = [];

	public function Sensor() {
		return $this->belongsToMany('Sensor', 'sensor_id');
	}

	public function DataTypes() {
		return $this->belongsToMany('SensorType', 'data_types_sensor_types', 'sensor_type_id', 'data_type_id');
	}
}