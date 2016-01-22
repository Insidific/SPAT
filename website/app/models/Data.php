<?php

class Data extends \Eloquent {
	protected $table = 'data';
	protected $primaryKey = 'data_id';
	protected $fillable = [];

	public function sensor()
	{
		return $this->belongsTo('Sensor', 'sensor_id');
	}

	public function session()
	{
		return $this->belongsTo('Session', 'session_id');
	}

	public function dataType()
	{
		return $this->hasOne('DataType', 'data_type_id');
	}
}
