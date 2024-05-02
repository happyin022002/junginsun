function setContents(){
	alert("aaaa");
	var oldContents = parent.form.contents.value ;
	var currContents = document.form1.contents.value ;
	document.getElementById("cnts").innerHTML = oldContents + currContents;
}

function readNextFile(){
	clearContents();
	document.form1.target="_self";
    document.form1.command.value='next';
    document.form1.readbyte.value='10000';
    parent.form.contents.value = document.getElementById("cnts").innerHTML;
    document.form1.submit();
}

function readLastFile(){
	clearContents();
	document.form1.target="_self";
    document.form1.command.value='last';
    document.form1.readbyte.value='10000';
    document.form1.submit();
}

function downloadFile(){
	document.form1.target="dnld";
    document.form1.command.value='download';
    document.form1.readbyte.value='10000';
    document.form1.submit();
}

function clearContents(){
	parent.form.contents.value = "";
	document.form1.contents.value="";
	document.getElementById("cnts").innerHTML = "";
}