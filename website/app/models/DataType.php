<?php

class DataType extends \Eloquent {
	protected $fillable = [];

	public function SensorType() {
		return $this->belongsTo('SensorType');
	}

	public function Data() {
		return $this->belongsTo('Data');
	}
}