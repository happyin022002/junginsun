/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0022.js
*@FileTitle  : [CPS_CNI_0022] Prevention
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/**
 * [CPS_CNI_0022] Prevention
 * @extends
 * @class Prevention 대상 검색 및 금액 입력화면
 */
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var combo1=null;
// html form
var frm=null;
// Main Code Inquiry 팝업 타입
var type="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/*
 * registering IBCombo Object as list
 * @param comboObj
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++]=comboObj;
}  
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    combo1=comboObjects[0];
	// IBMultiComboinitializing
	comboCnt=comboObjects.length;	
	for (var j=0; j<comboCnt; j++) {
		initCombo(comboObjects[j]);
	}    
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
    initControl();
    var sXml=frm.sXml.value;    
    var arrXml=sXml.split("|$$|");
	var arrCombo = new Array();//=SheetXml2ListMap(arrXml[0]);
	var arrLstMap = SheetXml2ListMap(arrXml[0]);
	if (arrLstMap != null && arrLstMap != undefined) {
		for(var i = 0; i < arrLstMap.length; i++){
			if (arrLstMap[i] != undefined) {
				arrCombo.push(arrLstMap[i]);
			}
		}		
	}
	combo1.InsertItem(0,"ALL","ALL");		
	var k=1;
	for(var i=0 ; i < arrCombo.length ; i++ ) {			
		var code = arrCombo[i];
		// 읽기 사용자는 CCC리스트 제외 
		if (code["code"] == "C" ) {
//			if (equalsRole("CNI42") || equalsRole("CNI41") || equalsRole("CNI93")) {					
				combo1.InsertItem( k ,code["name"],code["code"]);
				k++
//			}
		} else {				
			combo1.InsertItem( k ,code["name"],code["code"]);
			k++
		} 
	}		
	combo1.SetSelectCode("ALL");
	//var listmap=SheetXml2ListMap(arrXml[1]);
	var arrCombo1 = new Array();
	var listmap=SheetXml2ListMap(arrXml[1]);
	var combo=frm.clm_area_cd;	
	if (listmap != null && listmap != undefined) {
		for(var i = 0; i < listmap.length; i++){
			if (listmap[i] != undefined) {
				arrCombo1.push(listmap[i]);
			}
		}		
	}
	ComAddComboItem(combo ,"ALL" , "");	
	for(var i=0 ; i < arrCombo1.length; i++) {
		var code=arrCombo1[i];
		ComAddComboItem(combo ,code["code"] , code["code"]);		
	}
	ComBtnDisable("btn1_Delete");
	//초기 focus();
	//frm.cond_search_text.focus();
	doActionIBSheet(SEARCHLIST01);	
}
/**
* registering initial event 
*/
function initControl() {
	//axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    //axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}
/**
* Combobox Initialize, Header Definition 
* @param {object} comboObj Mandatory, IBMultiCombo Object
* @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
**/
function initCombo(comboObj) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetColAlign(0, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	    comboObj.SetBackColor("#FFFFFF");
	}
} 
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
        case "sheet1":
           
            //no support[check again]CLT 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            var HeadTitle1="|Seq.|Class|PRV No.|Subject|DORG|A|RGOFC|Register|Att.|View|";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"clm_prve_div_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_prve_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:360,  Align:"Left",    ColMerge:1,   SaveName:"clm_prve_subj_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Image",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"file_cnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"clm_prve_read_knt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_prve_desc" } ];
             
            InitColumns(cols);
            SetSheetHeight(250);
			SetEditable(0);
            SetImageList(0,"img/ico_attach.gif");
            InitViewFormat(0, "cre_dt", "yyyy-mm-dd");
            SetShowButtonImage(1);
            break;


		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
	    case "btn2_Search":
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);			
			}
			break;
		case "btns_cre_dt_start":			
			var vCal=new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.cre_dt_start, "yyyy-MM-dd");			
			break;
		case "btns_cre_dt_end":
			var vCal=new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.cre_dt_end, "yyyy-MM-dd");
			break;
		case "btng_plus":
			popupPreventionRegister("");
			break;
		case "btn1_New":
			ComResetAll();
			combo1.SetSelectCode("ALL");
			break;			
		case "btn1_Delete":
			// msgs["CNI00018"] = "Please select {?msg1}";
			if (sheet1.GetSelectRow()< 1) {
				ComShowCodeMessage("CNI00013" , "row");
				return;
			}
			// msgs["CNI00016"] = "Do you want to delete it?";
			if (ComShowCodeConfirm("CNI00016")) {
				doActionIBSheet(REMOVE);
			}
			break;
	}
}
 /**
  * HTML Control KeyDown event
  */
 function keydownEnter() {
 	if (event.keyCode != 13) {
 		return;
 	}
 	var obj=event.srcElement;
    switch(ComGetEvent("name")) {    
    case "cre_ofc_cd":
    case "cre_usr_id":    	
    case "cond_search_text":    	
    	if (obj == null || 
    			obj.value.length < 1 ) {
    		return;
    	}
		doActionIBSheet(SEARCHLIST01);
		focusOut();
    	break;       
	}	  
 } 
  /**
   * HTML Control Foucs in
   */
  function obj_activate(){
      ComClearSeparator(event.srcElement);    
  }
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {
  	switch (event.srcElement.name) {
  	case "cre_dt_start":  		
  	case "cre_dt_end":  		
  		ComChkObjValid(event.srcElement);
  		break;
  	}
  }  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {  		
	doActionIBSheet(SEARCHLIST01);
} 
/**
* Calling Function in case of OnChange event
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
* @param {string} value Changed value, the value when saving, to which format is not applied
*/
function sheet1_OnClick(sheet , row, col, value) {	
	var clm_prve_desc=sheet.GetCellValue(row , "clm_prve_desc");
	frm.clm_prve_desc.value=clm_prve_desc;
	var creUsrId=sheet.GetCellValue(row, "cre_usr_id");
	setRollBtnCtlPrevention(creUsrId, "btn1_Delete");
} 
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}	
	var clmPrveNo=sheet.GetCellValue(row, "clm_prve_no");
	var creUsrId=sheet.GetCellValue(row, "cre_usr_id");
	var usrId=frm.usr_id.value;
	if (!ComIsNull(clmPrveNo)) {
		setRollBtnCtlPrevention(creUsrId, "btn1_Delete");
		if (usrId == creUsrId ) {				
			popupPreventionRegister(clmPrveNo);	
		} else {
			popupPreventionView(clmPrveNo);
		}
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value=SEARCHLIST01;
		//이전선택 내용 삭제
		frm.clm_prve_desc.value="";
		var cls=combo1.GetSelectCode();
		if (cls == "ALL") {
			cls="";
		}
		frm.clm_prve_div_cd.value=cls;
		var sXml=sheet1.GetSearchData("CPS_CNI_0022GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:0} );
		sheet1.SetSelectRow(0);
	} else if(sAction == REMOVE) {
		var param="f_cmd="+REMOVE+"&clm_prve_no=" + sheet1.GetCellValue(sheet1.GetSelectRow(),"clm_prve_no");
		var sXml=sheet1.GetSearchData("CPS_CNI_0023GS.do", param);
		sheet1.LoadSearchData(sXml,{Sync:0} );
		doActionIBSheet(SEARCHLIST01);
	}
}
