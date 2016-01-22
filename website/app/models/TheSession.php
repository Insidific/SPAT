<?php

class TheSession extends \Eloquent {
	protected $table = 'sessions';
	protected $primaryKey = 'session_id';
	protected $fillable = [];

	public function data()
	{
		return $this->hasMany('Data');
	}

}