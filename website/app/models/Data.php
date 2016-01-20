<?php

class Data extends \Eloquent {
	protected $fillable = [];

	public function dataType()	{
		return $this->hasOne('DataType');
	}

	public function Sensor()	{
		return $this->hasOne('Sensor');
	}

	public function TheSession() {
		return $this->hasOne('TheSession');
		return $this->belongsTo('TheSession');
	}
}