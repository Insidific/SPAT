<?php

class Data extends \Eloquent {
	protected $fillable = [];

	public function dataType()	{
		return $this->hasOne('DataType', 'data_types');
	}

	public function Sensor()	{
		return $this->hasOne('Sensor', 'sensors');
	}

	public function TheSession() {
		return $this->hasOne('TheSession', 'sessions');
	}
}
