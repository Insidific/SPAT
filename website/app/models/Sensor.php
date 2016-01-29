<?php

class Sensor extends \Eloquent {
	protected $table = 'sensors';
	protected $primaryKey = 'sensor_id';
	protected $fillable = [];

	public function sensorType()
	{
		return $this->hasOne('SensorType','sensor_type_id');
	}

	public function data()
	{
		return $this->hasMany('Data');
	}
}