<?php

class Data extends \Eloquent {
	protected $table = 'data';
	protected $primaryKey = 'data_id';
	protected $fillable = [];

	public function DataType()	{
		return $this->hasMany('DataType', 'data_type_id');
	}

	public function Sensor(){
		return $this->hasOne('Sensor', 'sensor_id');
	}

	public function Session() {
		return $this->hasOne('TheSession', 'session_id');
	}
}
