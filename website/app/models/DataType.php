<?php

class DataType extends \Eloquent {
	protected $table = 'data_types';
	protected $primaryKey = 'data_type_id';
	protected $fillable = [];

	public function sensorTypes()
	{
		return $this->belongsToMany('SensorType', 'data_types_sensor_types', 'data_type_id', 'sensor_type_id');
	}
}