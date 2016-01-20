<?php

class TheSession extends \Eloquent {
	protected $fillable = [];

	public function dataType()
	{
		return $this->hasMany('Data');
	}

	public function Data() {
		return $this->belongsTo('Data');
	}
}