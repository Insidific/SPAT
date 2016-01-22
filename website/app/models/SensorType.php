<?php

class SensorType extends \Eloquent {
	protected $table = 'sensor_types';
	protected $primaryKey = 'sensor_type_id';
	protected $fillable = [];

	public function sensors()
	{
		return $this->belongsToMany('Sensor');
	}

	public function dataTypes()
	{
		return $this->belongsToMany('DataType', 'data_types_sensor_types', 'sensor_type_id', 'data_type_id');
	}
}