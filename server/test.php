<?php

$myfile =fopen("newfile.txt","w");
$txt="josdibbhnfa\n";
fwrite($myfile,$txt);
fclose($myfile);
?>