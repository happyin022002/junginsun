var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

document.onclick = processButtonClick;

function processButtonClick(){
    var formObject = document.form; 
    var rdObject = rdObjects[0];
}

function loadPage() {
	//RD
	initRdConfig(rdObjects[0]);
	rdOpen(rdObjects[0], document.form);
}

function initRdConfig(rdObject){
    var Rdviewer = rdObject ;
    
	Rdviewer.AutoAdjust = true;
	//Rdviewer.HideToolbar();
//	Rdviewer.HideStatusbar();
	Rdviewer.ViewShowMode(0);

	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}

function rdOpen(rdObject,formObject){
	var Rdviewer = rdObject ;

	var rdParam = '/rp ['+queryStr+']';

    //Rdviewer.FileOpen(RD_path+'sample/rd/usingjsp/SampleFileJSP.mrd', RDServer + rdParam);
    Rdviewer.FileOpen(RD_path+'sample/rd/usingrdagentdomestic/Sample.mrd', RDServerDomestic + rdParam);
}
