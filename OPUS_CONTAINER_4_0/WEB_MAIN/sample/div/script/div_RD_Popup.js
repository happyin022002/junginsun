/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : div_Default.js
*@FileTitle  : Default div sample page
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/22
=========================================================*/

var rdObjects=new Array();
var rdCnt=0;

function loadPage() {
	initRdConfig();
}

function initRdConfig(){
	rdObjects[0].AutoAdjust=1;
	rdObjects[0].ViewShowMode(0);
	rdObjects[0].SetPageLineColor(128,128,128);
	rdObjects[0].SetBackgroundColor(255,255,255);
	rdObjects[0].ApplyLicense("0.0.0.0");
	rdObjects[0].FileOpen(RDServerIP + "/sample/rd/mrdSample/TESTWithCI.mrd", "");
} 