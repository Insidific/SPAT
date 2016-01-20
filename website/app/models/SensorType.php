<?php

class SensorType extends \Eloquent {
	protected $fillable = [];

	public function Sensor() {
		return $this->belongsTo('Sensor');
	}

	public function dataType()	{
		return $this->hasOne('DataType');
	}
}