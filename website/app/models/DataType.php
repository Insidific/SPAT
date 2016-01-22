<?php

class DataType extends \Eloquent {
	protected $table = 'data_types';
	protected $primaryKey = 'data_type_id';
	protected $fillable = [];

	public function SensorTypes() {
		return $this->belongsToMany('DataType', 'data_types_sensor_types', 'data_type_id', 'sensor_type_id');
	}

	public function Data() {
		return $this->belongsToMany('Data', 'data');
	}
}