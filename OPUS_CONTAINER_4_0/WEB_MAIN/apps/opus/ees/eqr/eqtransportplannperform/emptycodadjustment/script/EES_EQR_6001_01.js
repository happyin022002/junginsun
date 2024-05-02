/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6001_01.js
*@FileTitle  : MTY COD Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class EES_EQR_6001 : business script for EES_EQR_6001
 */
// common static variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var currentSheet="";
var sheetObjects=new Array();
var sheetCnt=0;
var keyId="";
var findVvdMaxCount=50;

var strHidTpSz = "";

var hidD2YN = 0;
var hidD4YN = 0;
var hidD5YN = 0;
var hidD7YN = 0;
var hidR2YN = 0;
var hidR5YN = 0;
var hidO2YN = 0;
var hidS2YN = 0;
var hidO4YN = 0;
var hidS4YN = 0;
var hidF2YN = 0;
var hidA2YN = 0;
var hidF4YN = 0;
var hidA4YN = 0;
var hidF5YN = 0;

// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		// case "btn_mainretrieve":
		// searchVvd(document.form.searchvvd.value,document.form.searchvvd);
		// break;
		case "btn_s1retrieve":
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
			break;
		case "btn_s2retrieve":
			searchLane(sheetObjects[1], document.form.lane2.value, document.form.lane2);
			break;
		case "btn_s3retrieve":
			searchLane(sheetObjects[2], document.form.lane3.value, document.form.lane3);
			break;
		case "btn_s4retrieve":
			searchLane(sheetObjects[3], document.form.lane4.value, document.form.lane4);
			break;
		case "btn_s5retrieve":
			searchLane(sheetObjects[4], document.form.lane5.value, document.form.lane5);
			break;
/*		case "btn_s1add":
			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
			break;
		case "btn_s2add":
			doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
			break;
		case "btn_s3add":
			doActionIBSheet(sheetObjects[4], document.form, IBINSERT);
			break;
		case "btn_s4add":
			doActionIBSheet(sheetObjects[6], document.form, IBINSERT);
			break;
		case "btn_s5add":
			doActionIBSheet(sheetObjects[8], document.form, IBINSERT);
			break;
		case "btn_s1del":
			doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
			break;
		case "btn_s2del":
			doActionIBSheet(sheetObjects[2], document.form, IBDELETE);
			break;
		case "btn_s3del":
			doActionIBSheet(sheetObjects[4], document.form, IBDELETE);
			break;
		case "btn_s4del":
			doActionIBSheet(sheetObjects[6], document.form, IBDELETE);
			break;
		case "btn_s5del":
			doActionIBSheet(sheetObjects[8], document.form, IBDELETE);
			break;
*/
		// case "btn_remark":
		// remarkPop();
		// break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR90004");
		} else {
			alert(e);
		}
	}
}
/**
 * calling REMARK POPUP
 * @return
 */
function remarkPop() {
var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane=" + sheetObjects[10].GetCellValue(Row, "lane")
+ "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision=" + sheetObjects[10].GetCellValue(Row, "weekdivision")
+ "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 410, true);
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	strHidTpSz = hidtpszallCode;
	
	if(strHidTpSz.indexOf("D2") > -1) { hidD2YN = 1; }
    if(strHidTpSz.indexOf("D4") > -1) { hidD4YN = 1; }
    if(strHidTpSz.indexOf("D5") > -1) { hidD5YN = 1; }
    if(strHidTpSz.indexOf("D7") > -1) { hidD7YN = 1; }
    if(strHidTpSz.indexOf("R2") > -1) { hidR2YN = 1; }
    if(strHidTpSz.indexOf("R5") > -1) { hidR5YN = 1; }
    if(strHidTpSz.indexOf("O2") > -1) { hidO2YN = 1; }
    if(strHidTpSz.indexOf("S2") > -1) { hidS2YN = 1; }
    if(strHidTpSz.indexOf("O4") > -1) { hidO4YN = 1; }
    if(strHidTpSz.indexOf("S4") > -1) { hidS4YN = 1; }
    if(strHidTpSz.indexOf("F2") > -1) { hidF2YN = 1; }
    if(strHidTpSz.indexOf("A2") > -1) { hidA2YN = 1; }
    if(strHidTpSz.indexOf("F4") > -1) { hidF4YN = 1; }
    if(strHidTpSz.indexOf("A4") > -1) { hidA4YN = 1; }
    if(strHidTpSz.indexOf("F5") > -1) { hidF5YN = 1; }
    
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1,'');
		ComEndConfigSheet(sheetObjects[i]);
	}
	radio_click();
	var frmObj=document.form;
	//axon_event.addListener('click', 'radio_click', 'tpsz');		// handling radio button CLICK event.
	//axon_event.addListenerForm('keypress', 'obj_keypress', frmObj);	// handling key press event
	initControl();
}


/**
 * initializing script
 * 
 * @return
 */
function initControl() {
/*
	ComBtnDisable("btn_s1add");
	ComBtnDisable("btn_s2add");
	ComBtnDisable("btn_s3add");
	ComBtnDisable("btn_s4add");
	ComBtnDisable("btn_s5add");
	ComBtnDisable("btn_s1del");
	ComBtnDisable("btn_s2del");
	ComBtnDisable("btn_s3del");
	ComBtnDisable("btn_s4del");
	ComBtnDisable("btn_s5del");
*/
	ComBtnDisable("btn_s1retrieve");
	ComBtnDisable("btn_s2retrieve");
	ComBtnDisable("btn_s3retrieve");
	ComBtnDisable("btn_s4retrieve");
	ComBtnDisable("btn_s5retrieve");
	parent.ComBtnDisable_frameLayer0("btn_remark");
	parent.ComBtnDisable_frameLayer0("btn_mainretrieve");
	this.scroll(324, 0);
	
}
function hideCursorBar(){
	sheetObjects[0].SetSelectRow(0);
	sheetObjects[1].SetSelectRow(0);
	sheetObjects[2].SetSelectRow(0);
	sheetObjects[3].SetSelectRow(0);
	sheetObjects[4].SetSelectRow(0);
	sheetObjects[5].SetSelectRow(0);
	sheetObjects[6].SetSelectRow(0);
	sheetObjects[7].SetSelectRow(0);
	sheetObjects[8].SetSelectRow(0);
	sheetObjects[9].SetSelectRow(0);
}
/**
 * searchLane
 * 
 * @param sheetObj
 * @param lane
 * @return
 */
function searchLane(sheetObj, lane, laneObj) {
	if (lane == "" || lane == null) {
		ComShowCodeMessage("EQR90196");
		laneObj.focus();
		return;
	}
	var flag=sheetObj.FindText(1, lane);
	if (flag == -1) {
		ComShowCodeMessage("EQR90197");
		laneObj.value="";
		laneObj.focus();
		return;
	} else {
		// focusing same lane on SHEET
		hideCursorBar();
		sheetObj.SelectCell(flag, 1, false);
	}
	laneObj.value="";
}
/**
 * searchVvd
 * 
 * @param vvd
 * @return
 */
function searchVvd(vvd, vvdObj) {
	if (vvd == "" || vvd == null) {
		ComShowCodeMessage("EQR90198");
		vvdObj.focus();
		return;
	}
	var flag=sheetObjects[11].FindText(4, vvd);
	if (flag == -1) {
		ComShowCodeMessage("EQR90199");
		vvdObj.value="";
		vvdObj.focus();
		return;
	} else {		
		
		// focusing same vvd on sheet
		var weekDivision=sheetObjects[11].GetCellValue(flag, 1);
		if (weekDivision == 1) {
			weekDivision=parseInt(weekDivision) -1;
			this.scroll(0, 0);
		} else if (weekDivision == 2) {
			weekDivision=parseInt(weekDivision) -1;
			this.scroll(0, 0);
		} else if (weekDivision == 3) {
			weekDivision=parseInt(weekDivision) -1;
			this.scroll(324, 0);
		} else if (weekDivision == 4) {
			weekDivision=parseInt(weekDivision) -1;
			this.scroll(900, 0);
		} else if (weekDivision == 5) {
			weekDivision=parseInt(weekDivision) -1;
			this.scroll(900, 0);
		}
		hideCursorBar();
		var Row=sheetObjects[weekDivision].FindText(2, vvd);
		sheetObjects[weekDivision].SetFocus();
		sheetObjects[weekDivision].SelectCell(Row, 2, false);
		sheetObjects[weekDivision].SetSelectRow(Row, false);
	}
	vvdObj.value="";
}
/**
 * handling key press event
 * 
 * @return
 */
function obj_keypress() {
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	switch (event.srcElement.name) {
	case "lane1":
		ComKeyOnlyAlphabet('uppernum');// upper case + number
		if (keyValue == 13) {
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
		}
		break;
	case "lane2":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[2], document.form.lane2.value, document.form.lane2);
		}
		break;
	case "lane3":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[4], document.form.lane3.value, document.form.lane3);
		}
		break;
	case "lane4":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[6], document.form.lane4.value, document.form.lane4);
		}
		break;
	case "lane5":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[8], document.form.lane5.value, document.form.lane5);
		}
		break;
	}
}
/**
 * handling radio button click event
 * 
 * @return
 */
function radio_click() {
	var formObject=parent.document.form;
	var val="";
	// getting current value
	for ( var i=0; i < formObject.tpsz.length; i++) {
		if (formObject.tpsz[i].checked) {
			val=formObject.tpsz[i].value;
		}
	}
	sheetObjects[0].RenderSheet(0);
	sheetObjects[1].RenderSheet(0);
	sheetObjects[2].RenderSheet(0);
	sheetObjects[3].RenderSheet(0);
	sheetObjects[4].RenderSheet(0);
	sheetObjects[5].RenderSheet(0);
	sheetObjects[6].RenderSheet(0);
	sheetObjects[7].RenderSheet(0);
	sheetObjects[8].RenderSheet(0);
	sheetObjects[9].RenderSheet(0);
	
	// handling CNTR SZ option
	if (val == "D") { // in case of DRY option selected, showing only D2,D4,D5,D7
		for ( var i=9; i < 20; i++) {
			sheetObjects[0].SetColHidden(i,1);
			sheetObjects[1].SetColHidden(i,1);
			sheetObjects[2].SetColHidden(i,1);
			sheetObjects[3].SetColHidden(i,1);
			sheetObjects[4].SetColHidden(i,1);
		}
		for ( var i=5; i < 9; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
		}
		for ( var i=6; i < 17; i++) {
			sheetObjects[5].SetColHidden(i,1);
			sheetObjects[6].SetColHidden(i,1);
			sheetObjects[7].SetColHidden(i,1);
			sheetObjects[8].SetColHidden(i,1);
			sheetObjects[9].SetColHidden(i,1);
			
		}
		for ( var i=2; i < 6; i++) {
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	} else if (val == "S") { // in case of SPECIAL option selected, showing only R2,R5,O2,S2,O4,S4,F2,A2,F4,A4,F5 

		for ( var i=5; i < 9; i++) {
			sheetObjects[0].SetColHidden(i,1);
			sheetObjects[1].SetColHidden(i,1);
			sheetObjects[2].SetColHidden(i,1);
			sheetObjects[3].SetColHidden(i,1);
			sheetObjects[4].SetColHidden(i,1);
		}
		for ( var i=9; i < 20; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
		}
		for ( var i=2; i < 6; i++) {
			sheetObjects[5].SetColHidden(i,1);
			sheetObjects[6].SetColHidden(i,1);
			sheetObjects[7].SetColHidden(i,1);
			sheetObjects[8].SetColHidden(i,1);
			sheetObjects[9].SetColHidden(i,1);
		}
		for ( var i=6; i < 17; i++) {
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	} else { // in case of All option selected, showing all
		for ( var i=1; i < 20; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	}
	
	
	sheetObjects[9].RenderSheet(1);
	sheetObjects[8].RenderSheet(1);
	sheetObjects[7].RenderSheet(1);
	sheetObjects[6].RenderSheet(1);
	sheetObjects[5].RenderSheet(1);
	sheetObjects[4].RenderSheet(1);
	sheetObjects[3].RenderSheet(1);
	sheetObjects[2].RenderSheet(1);
	sheetObjects[1].RenderSheet(1);
	sheetObjects[0].RenderSheet(1);
}
/**
 * setting sheet initial values and header param : sheetObj ==> sheet object , sheetNo ==> sheet number
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, HeadTitle) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
		
		with (sheetObj) {
	        var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:500, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:0,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
		               {Type:"Int",       Hidden:hidD2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD7YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               
		               {Type:"Int",       Hidden:hidR2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidR5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidO2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidS2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidO4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidS4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidA2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidA4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"keyid" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"etbweekdivision" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remarkflag" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"firstetb" } ];
	         
	        InitColumns(cols);
	
			SetEditable(1);
			SetEditableColorDiff(0);
	        InitViewFormat(0, "etb", "MM-dd");
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	        ShowSubSum([{StdCol:"vvd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19",  CaptionCol:2, CaptionText:"Total"}]);
		}
		break;
	case "sheet2": // sheet2 init
		with (sheetObj) {
	        var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:500, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
		               {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:0,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
		               
		               {Type:"Int",       Hidden:hidD2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidD7YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidR2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidR5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidO2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidS2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidO4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidS4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidA2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidA4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Int",       Hidden:hidF5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"keyid" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"etbweekdivision" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remarkflag" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"firstetb" } ];
	         
	        InitColumns(cols);
			SetEditable(1);
			SetEditableColorDiff(0);
	        InitViewFormat(0, "etb", "MM-dd");
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	        ShowSubSum([{StdCol:"vvd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19", CaptionCol:2, CaptionText:"Total"}]);
			
		}
		break;
	case "sheet3": // sheet3 init
		with (sheetObj) {
	        var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:500, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:0,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
	               {Type:"Int",       Hidden:hidD2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD7YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"keyid" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"etbweekdivision" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remarkflag" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"firstetb" } ];
	        
	        InitColumns(cols);
			SetEditable(1);
			SetEditableColorDiff(0);
	        InitViewFormat(0, "etb", "MM-dd");
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	        ShowSubSum([{StdCol:"vvd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19", CaptionCol:2, CaptionText:"Total"}]);
		}
		break;
	case "sheet4": // sheet4 init
		with (sheetObj) {
	        var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:500, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:0,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
	               {Type:"Int",       Hidden:hidD2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD7YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"keyid" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"etbweekdivision" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remarkflag" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"firstetb" } ];
	         
	        InitColumns(cols);
	
			SetEditable(1);
			SetEditableColorDiff(0);
	        InitViewFormat(0, "etb", "MM-dd");
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	        ShowSubSum([{StdCol:"vvd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19",  CaptionCol:2, CaptionText:"Total"}]);
	    }
		break;
	case "sheet5": // sheet5 init
		with (sheetObj) {
	        var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:500, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
	               {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:0,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
	               {Type:"Int",       Hidden:hidD2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD7YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA2YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA4YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF5YN,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"keyid" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"etbweekdivision" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remarkflag" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"firstetb" } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
			SetEditableColorDiff(0);
	        InitViewFormat(0, "etb", "MM-dd");
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
	        ShowSubSum([{StdCol:"vvd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19",  CaptionCol:2, CaptionText:"Total"}]);
	     }
		break;
	 /*********************************************** upper grid end *************************************************************************************/
	case "sheet6": // sheet6 init
		with (sheetObj) {
	        var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	               {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD7YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
	
			SetEditable(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
		}
		break;
	case "sheet7": // sheet7 init
		with (sheetObj) {
	        var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	               {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD7YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
	
			SetEditable(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
		}
		break;
	case "sheet8": // sheet8 init
		with (sheetObj) {
	        var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	               {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD7YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
	
			SetEditable(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
		}
		break;
	case "sheet9": // sheet9 init
		with (sheetObj) {
	        var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	        if (HeadTitle != "" && HeadTitle != null) {
	        HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	               {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD7YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
			SetEditable(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
		}
		break;
	case "sheet10": // sheet10 init
		with (sheetObj) {
	        var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	        if (HeadTitle != "" && HeadTitle != null) {
	        	HeadTitle1=HeadTitle;
	        }
	
	        SetConfig( { SearchMode:2,  MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	               {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidD7YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidR5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidO4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidS4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA2YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidA4YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 },
	               {Type:"AutoSum",   Hidden:hidF5YN, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
			SetEditable(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
		}
		break;
	case "vvdTotal": // vvdTotal init
		with (sheetObj) {
	        var HeadTitle1="1|2|3|4|5|6|7|8|9|10|11";
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"weekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"week",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"div",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"remarkflag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"status" },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Left",    ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mnlinpflg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
	
			SetEditable(1);
	        SetSheetHeight(182);
		}
		break;
	case "portTotal": // portTotal init
		with (sheetObj) {
	        var HeadTitle1="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28";
	
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"keyid" },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"weekdivision",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"week",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"remarkflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"idflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etbweek",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD4YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD5YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidD7YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidR5YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidO4YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidS4YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA2YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF4YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidA4YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Int",       Hidden:hidF5YN,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
	               {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"status" },
	               {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"yardcode",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"clptindseq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
	         
	        InitColumns(cols);
	
			SetEditable(1);
	        SetSheetHeight(182);
		}
		break;
		/*********************************************** lower grid end *************************************************************************************/
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			this.scroll(324, 0);
			formObj.f_cmd.value=SEARCH01;
			formObj.week.value=parent.document.form.week.value.replace(/\/|\-|\./g, "");
			formObj.trade.value=parent.document.form.trade.value;
			initControl();
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			
			setTimeout(function () { 
			
				var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				// getting HEAD info on SHEET
				var week=ComGetEtcData(arrXml[0], "sHead");
				if(week != undefined){
					week=week.split(",");
					var week1=week[0];
					var week2=week[1];
					var week3=week[2];
					var week4=week[3];
					var week5=week[4];
					
					//alert(week1.substring(4, 6));
					// recreating sheet after making head name on SHEET 1 ~ 12----------------------------------------------------------------
					var HeadTitle1="V|LANE|WK" + week1.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
					var HeadTitle2="V|LANE|WK" + week2.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
					var HeadTitle3="V|LANE|WK" + week3.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
		
					var HeadTitle4="V|LANE|WK" + week4.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
					var HeadTitle5="V|LANE|WK" + week5.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||||";
		
					var HeadTitle6="|WK" + week1.substring(4, 6) +"("+ week1.substring(6) +")|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
					var HeadTitle7="|WK" + week2.substring(4, 6) +"("+ week2.substring(6) +")|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
					var HeadTitle8="|WK" + week3.substring(4, 6) +"("+ week3.substring(6) +")|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
					var HeadTitle9="|WK" + week4.substring(4, 6) +"("+ week4.substring(6) +")|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
					var HeadTitle10="|WK" + week5.substring(4, 6) +"("+ week5.substring(6) +")|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
		
			
					changeHeaderRow(sheetObjects[0] , 0 , HeadTitle1);
					changeHeaderRow(sheetObjects[1] , 0 , HeadTitle2);
					changeHeaderRow(sheetObjects[2] , 0 , HeadTitle3);
					changeHeaderRow(sheetObjects[3] , 0 , HeadTitle4);
					changeHeaderRow(sheetObjects[4] , 0 , HeadTitle5);
					changeHeaderRow(sheetObjects[5] , 0 , HeadTitle6);
					changeHeaderRow(sheetObjects[6] , 0 , HeadTitle7);
					changeHeaderRow(sheetObjects[7] , 0 , HeadTitle8);
					changeHeaderRow(sheetObjects[8] , 0 , HeadTitle9);
					changeHeaderRow(sheetObjects[9] , 0 , HeadTitle10);
					
					
					//------------------------------------------------------------------------------------------------------------------------------
					// loading data on SHEET 1 ~ 12 
					if (arrXml.length > 0)
						sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 1)
						sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					if (arrXml.length > 2)
						sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
					if (arrXml.length > 3)
						sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
					if (arrXml.length > 4)
						sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
					
					
					if (arrXml.length > 5)
						sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
					if (arrXml.length > 6)
						sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
					if (arrXml.length > 7)
						sheetObjects[7].LoadSearchData(arrXml[7],{Sync:1} );
					if (arrXml.length > 8)
						sheetObjects[8].LoadSearchData(arrXml[8],{Sync:1} );
					if (arrXml.length > 9)
						sheetObjects[9].LoadSearchData(arrXml[9],{Sync:1} );
					if (arrXml.length > 10)
						sheetObjects[10].LoadSearchData(arrXml[10],{Sync:1} );
					if (arrXml.length > 11)
						sheetObjects[11].LoadSearchData(arrXml[11],{Sync:1} );
		
					sheetObj.SetWaitImageVisible(1);
					ComOpenWait(false);
				}else{
					ComShowCodeMessage("EQR90224");
					sheetObj.WaitImageVisible = true;
					ComOpenWait(false);
				}
			  }
			  , 100);
			} else {
				ComSetFocus(parent.document.form.week);
				return;
			}
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=MULTI;
		var sParam1=sheetObjects[10].GetSaveString(false, true, "status");
		if (sParam1 == "") {
			ComShowCodeMessage("EQR90225");
			return;
		}
		if (!ComShowCodeConfirm("EQR90192")) return;
		/*
		 * vvd_port_master sheet Deleting logic <== in case of Hidden CNTR = 0, savign after removing
		 */
		var deleteChecks=false;
		for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
			deleteChecks=false;
			// in case of etb is null & status is inserting on hidden sheet
			if (sheetObjects[11].GetCellValue(i, "status") == "I" && (sheetObjects[11].GetCellValue(i, "etb") == "" || sheetObjects[11].GetCellValue(i, "etb") == "SKIP")) {
				for ( var j=12; j < 27; j++) {
					if (sheetObjects[11].GetCellValue(i, j) != 0) {
						deleteChecks=true;
					}
				}
				if (deleteChecks == false) { // in case of CNTR=0, saving after removing
					sheetObjects[11].SetCellValue(i, "status","D");
				}
			}
		}
		var sParam2=sheetObjects[11].GetSaveString(false);
		sParam1=ComSetPrifix(sParam1, "sub");
		sParam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("EES_EQR_6001_01GS.do", sParam);
		sheetObjects[10].LoadSaveData(sXml, false, "status");
		doActionIBSheet(sheetObjects[4], formObj, IBSEARCH);
		break;
	case IBINSERT: // inserting
		var row=sheetObj.DataInsert();
		// creating key value for comparing
		keyId=sheetObjects[10].RowCount()+ sheetObjects[11].RowCount()+ 1;
		if (sheetObj.GetSelectRow()> 1) {
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 0,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 0),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 1,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 1),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 2,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 2),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 20,keyId,0);
		} else {
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 0,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 0),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 1,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 1),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 2,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 2),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 20,keyId,0);
		}
		break;
	case IBDELETE: // removing
		if (!ComShowCodeConfirm("EQR90193"))
			return;
		var deleteCheck=false;
		var deleteNum=0;
		var num=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 21);
		// port_summary sheet Deleting logic
		if (num != "") { // removing할 SUMMARY SHEET selecting logic
			if (num == "1") {
				num="1";
			} else if (num == "2") {
				num="3";
			} else if (num == "3") {
				num="5";
			} else if (num == "4") {
				num="7";
			} else if (num == "5") {
				num="9";
			}
			for ( var i=1; i < sheetObjects[num].RowCount()+ 1; i++) {
				if (sheetObj.GetCellText(sheetObj.GetSelectRow(), 3) == sheetObjects[num].GetCellValue(i, 1)) {
					for ( var j=2; j < 17; j++) { 
						sheetObjects[num].SetCellValue(i, j,sheetObjects[num].GetCellValue(i, j) - sheetObj.GetCellValue(sheetObj.GetSelectRow(), j + 3));
						if (sheetObjects[num].GetCellValue(i, j) != 0) {
							deleteCheck=true;
						}
					}
					deleteNum=i;
					break;
				}
			}
			if (deleteCheck == false) { // in case of CNTR=0, removing automatically
				sheetObjects[num].RowDelete(deleteNum, false);
			}
		}
		// vvd_port_master sheet Delete 로직 <== Hidden
		deleteCheck=false;
		for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
			if (sheetObjects[11].GetCellValue(i, 0) == sheetObj.GetCellValue(sheetObj.GetSelectRow(), 20)) {
				for ( var j=12; j < 27; j++) {
					sheetObjects[11].SetCellValue(i, j,sheetObjects[11].GetCellValue(i, j) - sheetObj.GetCellValue(sheetObj.GetSelectRow(), j - 7),0);
					if (sheetObjects[11].GetCellValue(i, j) != 0) {
						deleteCheck=true;
					}
				}
				// sheetObjects[11].CellValue(i, "status") = "I";
				// ComDebug(sheetObjects[11].CellValue(i, "status"));
				deleteNum=i;
				deleteDetail(sheetObj, sheetObj.GetSelectRow());
			}
		}
		if (deleteCheck == false) {
			sheetObjects[11].SetCellValue(deleteNum, "status","I");
			// sheetObjects[11].RowDelete(deleteNum, false);
		}
		sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
		sheetObj.HideSubSum();
		break;
	}
}
/**
 *hidden sheet removing logic
 * 
 * @param sheetObj
 * @param Row
 * @return
 */
function deleteDetail(sheetObj, Row) {
	// var check = false;
	// vvd master sheet control
	// changing status on hidden sheetObjects[10],sheetObjects[11] 
	for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == sheetObj.GetCellValue(Row, 2)) { // in case of same VVD
			sheetObjects[10].SetCellValue(i, 6,"I",0);
			break;
		}
	}
	// vvd_port_master sheet control
	// check = false;
	for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == sheetObj.GetCellValue(Row, 2)) { // in case of same VVD
			sheetObjects[11].SetCellValue(i, 27,"I",0);
		}
	}
}
/**
 * handling sheet1_OnClick event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
	// in case of VVD & port exist 
	if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	// when POD column clicked(POD,ETB IS NULL)
	if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
	} else {
		// if it is retrieved data, POD can't be modified
		if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
var OrgValue="";
/*
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
OrgValue=sheetObj.GetCellValue(Row, Col);
} 
*/
/**
 * sheet1 : setting original value to variable befor editing
 */
function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet2 : setting original value to variable befor editing
 */
function sheet2_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet3 : setting original value to variable befor editing
 */
function sheet3_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet4 : setting original value to variable befor editing
 */
function sheet4_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet5 : setting original value to variable befor editing
 */
function sheet5_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * handling sheet1_OnChange event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD column
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			// use for twice cause except self comparing
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 21,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { // from CNTR SZ column
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet control
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
					if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);// inserting
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet control
				check=false;
				var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 20));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
				// setting status to inserting after finding POD according VVD
				var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
					if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 27,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { // in case of POD doesn't exist, creating new one
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
					sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
					sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
					sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
					sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 21),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
					sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 27,"I",0);
					for ( var i=5; i < 20; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}

				// changing values on 1~5 weeks SUMMARY POD SHEET
				if (GetCellValue(Row, 21) == '1') { // value on week -2 sheet
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
						if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							// 컨테이너 값 inserting시 modifying
							sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '2') { // value on week -1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
						if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '3') { // value on week  sheet
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
						if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '4') { // value on week +1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
						if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '5') { // value on week +2 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
						if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */
			}
		}
	}
}
/**
 * handling sheet2_OnClick event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
	if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount > 0){
		document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
		// if it is retrieved data, POD can't be modified
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * handling sheet2_OnChange event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD column
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			// use for twice cause except self comparing
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 21,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { // from CNTR SZ column
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet control
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
					if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);// inserting
						// STATUS
						check=true;
						break;
					}
				}
				// vvd_port_master sheet control
				check=false;
				var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 20));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
				var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
					if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 27,"I",0);
					}
				}
				/*
				 * // vvd_port_master sheet control check = false; for ( var i = 1;
				 * i < sheetObjects[11].RowCount + 1; i++) { if
				 * (sheetObjects[11].CellValue(i, 0) == CellValue(Row, 20)) {
				 * 
				 * sheetObjects[11].CellValue2(i, Col + 7) = Value;
				 * 
				 * check = true;
				 *  }
				 * 
				 * if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
				 * sheetObjects[11].CellValue2(i, 27) = "I";
				 *  } }
				 */
				// vvd_port_master --> AddRow
				if (check == false) {
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
					sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
					sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
					sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
					sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 21),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
					sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 27,"I",0);
					for ( var i=5; i < 20; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// re-calculating sub total
				// HideSubSum();
				if (GetCellValue(Row, 21) == '1') { // value on week -2 sheet
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
						if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '2') { // value on week -1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
						if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '3') { // value on week  sheet
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
						if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '4') { // value on week +1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
						if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '5') { // value on week +2 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
						if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * handling sheet3_OnClick event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet3_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
	if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
		document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
		// if it is retrieved data, POD can't be modified
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * handling sheet3_OnChange event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD column
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			// use for twice cause except self comparing
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 21,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { // from CNTR SZ column
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet control
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
					if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);// inserting
						// STATUS
						check=true;
						break;
					}
				}
				// vvd_port_master sheet control
				check=false;
				var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 20));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
				var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
					if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 27,"I",0);
					}
				}
				/*
				 * // vvd_port_master sheet control check = false; for ( var i = 1;
				 * i < sheetObjects[11].RowCount + 1; i++) { if
				 * (sheetObjects[11].CellValue(i, 0) == CellValue(Row, 20)) {
				 * 
				 * sheetObjects[11].CellValue2(i, Col + 7) = Value;
				 * 
				 * check = true;
				 *  }
				 * 
				 * if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
				 * sheetObjects[11].CellValue2(i, 27) = "I";
				 *  } }
				 */
				// vvd_port_master --> AddRow
				if (check == false) {
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
					sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
					sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
					sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
					sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 21),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
					sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 27,"I",0);
					for ( var i=5; i < 20; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// re-calculating sub total
				// HideSubSum();
				if (GetCellValue(Row, 21) == '1') { // value on week -2 sheet
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
						if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '2') { // value on week -1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
						if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '3') { // value on week  sheet
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
						if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '4') { // value on week +1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
						if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '5') { // value on week +2 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
						if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * handling sheet4_OnClick event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet4_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
	if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
		document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
		// if it is retrieved data, POD can't be modified
		if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * handling sheet4_OnChange event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet4_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD column
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			// use for twice cause except self comparing
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 21,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { // from CNTR SZ column
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet control
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
					if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);// inserting
						// STATUS
						check=true;
						break;
					}
				}
				// vvd_port_master sheet control
				check=false;
				var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 20));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
				var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
					if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 27,"I",0);
					}
				}
				/*
				 * // vvd_port_master sheet control check = false; for ( var i = 1;
				 * i < sheetObjects[11].RowCount + 1; i++) { if
				 * (sheetObjects[11].CellValue(i, 0) == CellValue(Row, 20)) {
				 * 
				 * sheetObjects[11].CellValue2(i, Col + 7) = Value;
				 * 
				 * check = true;
				 *  }
				 * 
				 * if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
				 * sheetObjects[11].CellValue2(i, 27) = "I";
				 *  } }
				 */
				// vvd_port_master --> AddRow
				if (check == false) {
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
					sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
					sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
					sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
					sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 21),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
					sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 27,"I",0);
					for ( var i=5; i < 20; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// re-calculating sub total
				// HideSubSum();
				if (GetCellValue(Row, 21) == '1') { // value on week -2 sheet
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
						if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '2') { // value on week -1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
						if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '3') { // value on week  sheet
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
						if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '4') { // value on week +1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
						if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '5') { // value on week +2 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
						if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * handling sheet5_OnClick event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet5_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
	if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_6001_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
	} else {
		// if it is retrieved data, POD can't be modified
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * handling sheet5_OnChange event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet5_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD column
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			// use for twice cause except self comparing
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
				/*
				 * if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") ==
				 * CellText(Row, "vvd") && CellText(i, "clptindseq") ==
				 * CellText(Row, "clptindseq")) { // same // POD code // existing
				 */
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) { // same
					// POD code
					// existing
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 21,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { // from CNTR SZ column
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet control
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
					if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);// inserting
						// STATUS
						check=true;
						break;
					}
				}
				// vvd_port_master sheet control
				check=false;
				var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 20));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
				var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
					if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 27,"I",0);
					}
				}
				/*
				 * // vvd_port_master sheet control check = false; for ( var i = 1;
				 * i < sheetObjects[11].RowCount + 1; i++) { if
				 * (sheetObjects[11].CellValue(i, 0) == CellValue(Row, 20)) {
				 * 
				 * sheetObjects[11].CellValue2(i, Col + 7) = Value;
				 * 
				 * check = true;
				 *  }
				 * 
				 * if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
				 * sheetObjects[11].CellValue2(i, 27) = "I";
				 *  } }
				 */
				// vvd_port_master --> AddRow
				if (check == false) {
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
					sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
					sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
					sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
					sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 21),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
					sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 27,"I",0);
					for ( var i=5; i < 20; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// re-calculating sub total
				// HideSubSum();
				if (GetCellValue(Row, 21) == '1') { // value on week -2 sheet
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
						if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '2') { // value on week -1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
						if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '3') { // value on week  sheet
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
						if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '4') { // value on week +1 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
						if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
				} else if (GetCellValue(Row, 21) == '5') { // value on week +2 sheet
					// modifying
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
						if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { // in case of POD doesn't exist, creating new one
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * sheet1_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// if it is retrieved data, POD can't be modified
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') { 	// in case of POD && ETB != null
				SetCellEditable(i, 3,0);// EDIT disable
			}
			if (GetCellValue(i, 22) == "Y") { // in case of REMARK registered
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);// bold
				SetCellFont("FontUnderline", i, 0,1);// under line
			}
		}
		if (sheetObj.RowCount()> 1) {
		//	ComBtnEnable("btn_s1add");
		//	ComBtnEnable("btn_s1del");
			ComBtnEnable("btn_s1retrieve");
		}
		if (sheetObjects[11].RowCount()> 1) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve"); // PARENT RemarkVVD  button activate
		}
	}
}
/**
 * sheet2_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// if it is retrieved data, POD can't be modified
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
			if (GetCellValue(i, 22) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		if (sheetObj.RowCount()> 1) {
		//	ComBtnEnable("btn_s2add");
		//	ComBtnEnable("btn_s2del");
			ComBtnEnable("btn_s2retrieve");
		}
	}
}
/**
 * sheet3_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// if it is retrieved data, POD can't be modified
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
			if (GetCellValue(i, 22) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		if (sheetObj.RowCount()> 1) {
		//	ComBtnEnable("btn_s3add");
		//	ComBtnEnable("btn_s3del");
			ComBtnEnable("btn_s3retrieve");
		}
	}
}
/**
 * sheet4_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// if it is retrieved data, POD can't be modified
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
			if (GetCellValue(i, 22) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		if (sheetObj.RowCount()> 1) {
		//	ComBtnEnable("btn_s4add");
		//	ComBtnEnable("btn_s4del");
			ComBtnEnable("btn_s4retrieve");
		}
	}
}
/**
 * sheet5_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// if it is retrieved data, POD can't be modified
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
			if (GetCellValue(i, 22) == "Y") {
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		if (sheetObj.RowCount()> 1) {
		//	ComBtnEnable("btn_s5add");
		//	ComBtnEnable("btn_s5del");
			ComBtnEnable("btn_s5retrieve");
		}
	}
}
/**
 * sheet6_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
		SetSumText(1,"TOTAL");
	}
}
/**
 * sheet7_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
		SetSumText(1,"TOTAL");
	}
}
/**
 * sheet8_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
		SetSumText(1,"TOTAL");
	}
}
/**
 * sheet9_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
		SetSumText(1,"TOTAL");
	}
}
/**
 * sheet10_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
		SetSumText(1,"TOTAL");
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
						+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 400, true);
			}
		}
		// finding same POD
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, 21);
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}
		//--------------------------------------------------------------------------------
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet2_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
						+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 400, true);
			}
		}
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, 21);
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet3_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
						+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 400, true);
			}
		}
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, 21);
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet4_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
						+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 400, true);
			}
		}
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, 21);
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet5_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_6002.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
						+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_6002", 700, 400, true);
			}
		}
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, 21);
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet6_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 1) {
					sheetObjects[11].SetCellValue(i, 29,"1",0);
				}
			}
//			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 640); 
			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 610, true); 
			// }
		}
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet7_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 2) {
					sheetObjects[11].SetCellValue(i, 29,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 610, true);
			// }
		}
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet8_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 3) {
					sheetObjects[11].SetCellValue(i, 29,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 610, true);
			// }
		}
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet9_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "pod")) > 0) {
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 4) {
					sheetObjects[11].SetCellValue(i, 29,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 610, true);
		}
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet10_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of pod value exists
		if (ComGetLenByByte(GetCellValue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 5) {
					sheetObjects[11].SetCellValue(i, 29,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_6003.do", "EES_EQR_6003", 880, 610, true);
			// }
		}
	}
}
/**
 * vvdTotal_OnSearchEnd --> hidden sheet
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function vvdTotal_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		if (sheetObjects[10].RowCount()> 0) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve");
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (parent.document.form.week.value == "") {
				ComShowCodeMessage("EQR90195");
				return false;
			}
			var w=parent.document.form.week;
			// retrieving for each week
			sVal1=w.value.replace(/\/|\-|\./g, "");
			if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
				// ComShowCodeMessage("EQR90211", "YYYYWW");
				ComSetFocus(w);
				// w.value = "";
				return false;
			}
		} else {
			// if(sheetObj)
		}
	}
	return true;
}
