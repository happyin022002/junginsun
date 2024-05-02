/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EAD_EAS_COM_0001.js
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/

function ESD_EAS_COM_0001() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}	

/* Global variables  */
var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

/**
 * IBSheet Object array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing Sheet 
 * onLoad  body tag
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//initializing html controller
	initControl();
	
	goSoOfficeCode(sheetObjects[0]);
}

function initControl() {

}

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {

	var sheetObject = sheetObjects[0];

	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_apply":
				goApply();
			break;
			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

 /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
 
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
                style.height = 280; 
				SheetWidth = mainTable.clientWidth; 
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); 
				MergeSheet = msHeaderOnly; 
				Editable = true; 
				
				InitRowInfo( 1, 1, 9, 100); //setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(3, 0, 0, true); //setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false,false) // setting function handling header
				

				var HeadTitle = "Seq|Office code";

				//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 50, daCenter, false, "seq", false, "", dfNone,0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "ofc_cd_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daLeft, true, "ofc_cd", false, "", dfNone, 0, false, false);
			}
		break;
	}
}

// Retrieve Data by button click event 
function sheet_OnChange(sheetObj, Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk1" ) {
		if( Value == "1" ) {
			sheetObj.RowStatus(Row) = "I";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	}
	
}

function sheet_OnClick(sheetObj, row, col, newPos){

    selRow = row;
    selCol = col;
    selOfc = sheetObj.CellValue(row, "ofc_cd");
        
}


function sheet_OnDblClick(sheetObj, row, col ){

    selRow = row;
    selCol = col;
    selOfc = sheetObj.CellValue(row, "ofc_cd");
	goApply();

}


function goApply() {

	if( selOfc != "" ) {
		opener.rtn_office_code(selOfc);
		window.close();
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH: 
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_EAS_COM_0001GS.do", EasFrmQryString(formObj));
		break;
	}
}

function goSoOfficeCode(sheetObj) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/**
 * Handling Error Result
 * IBSheetConfig.js - define DataSheetObject.prototype.event_OnSearchEnd
*/
function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		ComShowCodeMessage(errMsg);
	}
	var lv_ofc = document.form.ctrl_ofc_cd.value;
	var lv_row = sheetObj.FindText("ofc_cd", lv_ofc, 0, -1, false);
	sheetObj.SelectCell(lv_row, "ofc_cd_name", false);
}


/**
 *  Customer Code Open Common Pop-up Screen(sheet)
 * 
 * @param sheetObj IBSheet Object
 * @param row Row
 * @param multi check
 * @param ofcCd Office Code
 * @param ofcNm Office Name
 * @param callType Call TYpe
 * @param ofcLev Office Level
 * @param ofcPtsCd Parent Office
 */
function openOfcPopSheet(sheetObj, row, multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	ofcLevFld   = ofcLev ;
	ofcPtsCdFld = ofcPtsCd ;
	ofcCdFld    = ofcCd ;
	ofcNmFld    = ofcNm ;
	callTypeFld = callType ;
	multiChkYN  = multi ;
	sheetRow    = row ;	
	sheetObject = sheetObj ;	
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
	param += getURLParam(multi, "CallType",   callType, "2") ;
	
	comPopup('/opuscntr/COM_ENS_0071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
}

/**
 * Get display
 * 
 * @param multi select option
 *              true : multi select, false : Single select
 */
function getCommPopDisplay(multi){
 	var display = multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
 	return display ;
}

/**
 * Get classId
 */
function getCommPopClassId(){
	var url = document.location.href ;
	var classId = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
	return classId ;
}

