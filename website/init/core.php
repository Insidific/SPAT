<?php
session_start();
ob_start();

date_default_timezone_set('Europe/London');

spl_autoload_register(function($class) {
    require_once 'Model/' . $class . '.php';
});