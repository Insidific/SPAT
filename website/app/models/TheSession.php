<?php

class TheSession extends \Eloquent {
	protected $table = 'sessions';
	protected $primaryKey = 'session_id';
	protected $fillable = [];

	public function Data() {
		return $this->belongsToMany('Data', 'session_id');
	}
}