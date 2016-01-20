<?php

class TheSession extends \Eloquent {
	protected $fillable = [];

	public function Data() {
		return $this->belongsToMany('Data', 'data');
	}
}