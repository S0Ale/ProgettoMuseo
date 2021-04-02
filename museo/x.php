
<?php

    if(isset($_GET["id"]) and isset($_GET["psw"])){//login
        $id = $_GET["id"];
        $psw = $_GET["psw"];
        $connessione = new mysqli("127.0.0.1","root","","museoricoale");
        if ($connessione -> connect_errno) {
             echo "Failed to connect to MySQL: " . $connessione -> connect_error;
              exit();
        }
        $select = "SELECT psw from dipendente where id =$id";
        if($risultato = $connessione -> query($select)-> fetch_array()){
            if($risultato[0] == $psw){
                session_id(rString());
                session_start();
                $_SESSION["id"] = $id;
                echo session_id();
            }
        }
    
        if(isset($_GET["logout"])){//logout
            session_id($_GET["s"]);//il campo s contiene l'id sessione
            session_start();
            session_destroy();
            echo "sei disconnesso";
        }
    }
/*
    if(isset($_GET["prova"]) and $_REQUEST["prova"] == 1){
        session_id("424513563563fdsf234256352");
        session_start();
        //echo "none";
        if(isset($_SESSION["user"]))
            echo $_SESSION["user"];
        else echo "rieseguire il login";
        $connessione = new mysqli("127.0.0.1","root","","museoricoale");
        if ($connessione -> connect_errno) {
             echo "Failed to connect to MySQL: " . $connessione -> connect_error;
              exit();
        }
        $select = "SELECT * from teca";
        if($risultato = $connessione -> query($select)){
            $i = 0;
            while(($tupla = $risultato -> fetch_assoc())){
                $a[$i++] = $tupla;
            }
            echo json_encode($a);
        }
        else
        echo "errore nella Query";
    }
*/
    function rString($length = 20) {
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        $charactersLength = strlen($characters);
        $randomString = '';
        for ($i = 0; $i < $length; $i++) {
            $randomString .= $characters[rand(0, $charactersLength - 1)];
        }
        return $randomString;
    }
?>