/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : rdReport.js
*@FileTitle  : Common RD page
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/05
=========================================================*/	

var rdObjects=new Array();
var rdCnt=0;

function Save_OnClick() {
	rdObjects[0].SaveAsDialog();
}

function Print_OnClick() {
	rdObjects[0].PrintDialog();
}

function First_OnClick() {
	rdObjects[0].FirstPage();
}

function Prev_OnClick() {
	rdObjects[0].PrevPage();
}

function Next_OnClick() {
	rdObjects[0].NextPage();
}

function Last_OnClick() {
	rdObjects[0].LastPage();
}

function ZoomIn_OnClick() {
	rdObjects[0].ZoomIn();
}

function ZoomOut_OnClick() {
	rdObjects[0].ZoomOut();
}

function Close_OnClick() {
	ComClosePopup();
}

function rdOpen() {
	var Rdviewer=rdObjects[0];   
	var sXml = "";
	var sheetObj = new Array();
	var frmObj = new Array();
	var etcObj = "";
	sheetObj = parmModalObj[4] ;
	frmObj = parmModalObj[5] ;
	etcObj = parmModalObj[6] ;
	
	// 복수개의 sheet, form object 를 배열로 받아서 처리
	sXml = "<?xml version='1.0' ?><SHEET>" ;

	sheetCnt = 1 ;
	for ( i= 0 ; i < sheetObj.length ; i++){
		sheetCnt = i + 1 ;
		if( sheetObj[i].RowCount() == 0){
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for(j=0; j<= sheetObj[i].LastCol() ; j++){
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET"+ sheetCnt +">";
		}else{
			sXml += RD_GetDataSearchXml(sheetObj[i], sheetCnt);
		}
	}
	sXml += "</SHEET>" ;
	
	var	mrdPath = parmModalObj[3];
	
	var formParam = "/rv "  ;
	for ( k = 0 ; k < frmObj.length ; k++){
		formParam += RD_FormQueryString(frmObj[k], k+1);
	}

	if( etcObj != undefined ) {
	     if( etcObj.length > 0 ) {
	        formParam = formParam + etcObj;
	    }
	}

	Rdviewer.AutoAdjust = false;
	Rdviewer.ZoomRatio = 90;
	Rdviewer.HideToolBar(); 
	Rdviewer.SetBackgroundColor(255,255,255);
	Rdviewer.SetPageScroll(0);
	Rdviewer.ApplyLicense("0.0.0.0");
	Rdviewer.SetRData(sXml);
	Rdviewer.FileOpen(mrdPath, RDServer + formParam);
}