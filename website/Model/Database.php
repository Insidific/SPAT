<?php
    Class Database {
       private static $_instance = null;
        private $_pdo;

       private Function __Construct() {
           try {
               $this->_pdo = new PDO('mysql:dbname=stb391_spat;host=stb391.edu.csesalford.com', 'stb391', 'password@1');
           } catch (PDOException $e) {
               die($e->getMessage());
           }
       }

        public static function getInstance() {
            if(!isset(self::$_instance)) {
                self::$_instance = new Database();
            }
            return self::$_instance;
        }
    }

?>