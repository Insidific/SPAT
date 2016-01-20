<?php

class Sensor extends \Eloquent {
	protected $fillable = [];

	public function phone()	{
		return $this->hasOne('SensorType');
	}

	public function Data() {
		return $this->belongsTo('Data');
	}
}