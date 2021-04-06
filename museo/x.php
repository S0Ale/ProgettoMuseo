
<?php

    if(isset($_GET["id"]) and isset($_GET["psw"])){//è una richiesta di login
        $id = $_GET["id"];
        $psw = $_GET["psw"];
        $connessione = new mysqli("127.0.0.1","root","","museoricoale");
        if ($connessione -> connect_errno) {
             echo "Failed to connect to MySQL: " . $connessione -> connect_error;
              exit();
        }
        $select = "SELECT psw from biglietto where id =$id";
        if($risultato = $connessione -> query($select)-> fetch_array()){
            if($risultato[0] == $psw){
                session_id(rString());
                session_start();
                $_SESSION["id"] = $id;
                echo session_id();
            }
        }
    }else{
        if(isset($_GET["s"]))
            session_id($_GET["s"]);//il campo s contiene l'id sessione
        session_start();
            if(isset($_SESSION["id"])){//controllo che la sessione fosse stata stabilita mediante autenticazione precedentemente
                    //faccio robe
                if(isset($_GET["logout"])){//si tratta di una richiesta di logout
                    session_destroy();
                    echo $_GET["s"]." sei disconnesso";//comunico al client che è stato disconnesso
            }else
                if(isset($_GET["pull"])){//si tratta di una richiesta di dati
                    //compongo la query
                    try{
                        $campi = $_GET["campi"];
                        $tabelle = $_GET["tabelle"];
                        $predicato = $_GET["predicato"];
                        $altro = $_GET["altro"];
                    }catch(Exception $e){
                        echo "Eccezione: ".$e->getMessage();
                    }

                    if(!empty($predicato)) $predicato = "WHERE ".$predicato;

                    $select = "SELECT $campi from $tabelle $predicato $altro";
                    //echo $select."<br>";
                    try {
                        $conn = connect();
                        $i = 0;
                        foreach($conn -> query($select, PDO::FETCH_ASSOC) as $row){
                            echo(json_encode($row)."-");
                            //$m[$i++] = $row;
                        }
                        //echo(json_encode($m));
                    } catch(PDOException $e) {
                      echo "Error: " . $e->getMessage();
                    }
                }
            }else{
                echo "sessione non trovata";//se non trovo una sessione con quell'id mando a quel paese la richiesta
                session_destroy();// distruggo la sessione per non occupare memoria nel server ovviamente
            }
    }



    function rString($length = 20) {
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        $charactersLength = strlen($characters);
        $randomString = '';
        for ($i = 0; $i < $length; $i++) {
            $randomString .= $characters[rand(0, $charactersLength - 1)];
        }
        return $randomString;
    }

    function connect(){
        $servername = "localhost";
        $username = "root";
        $password = "";

        try{
            $conn = new PDO("mysql:host=$servername;dbname=museoricoale", $username, $password);
            // set the PDO error mode to exception
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            //echo "Connected successfully";
            return $conn;
        } catch(PDOException $e) {
          //echo "Connection failed: " . $e->getMessage();
        }
    }
?>
