<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Printer List</title>
<script type="text/javascript">
//<![CDATA[
function searchPrinterList() {
    var printers = new Array();
    
    //var wsn = new ActiveXObject("WScript.Network");
    var wsn = GetObject("WScript.Network");
    var printerConnections = wsn.EnumPrinterConnections();
    
    for(var i = j = 0; i < printerConnections.length; i += 2) {
//          alert("Port " + printerConnections.Item(i) + " = " + printerConnections.Item(i + 1));
      printers[j++] = printerConnections.Item(i + 1);
    }
    
    return printers;
}

function showPrintersOnLocalPc() {
  var printers = searchPrinterList();
  var msg = "";
  for (var i = 0; i < printers.length; i++) {
    msg = msg + "[" + i + "] " + printers[i] + "\n"
  }
  
  alert(msg);
}
//]]>
</script>
</head>
<body>
<input type="button" value="search Printer List" onClick="showPrintersOnLocalPc();">
</body>
</html>