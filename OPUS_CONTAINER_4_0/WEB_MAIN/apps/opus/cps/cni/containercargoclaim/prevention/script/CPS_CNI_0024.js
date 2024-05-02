/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0024.js 
*@FileTitle  : Prevention-View
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/08/18
=========================================================*/
/**
 * [CPS_CNI_0024] Prevention
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
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
//    initControl();
	var clmPrveNo=frm.clm_prve_no.value;		
	if (!ComIsNull(clmPrveNo) && clmPrveNo.length > 10) {
		doActionIBSheet(SEARCHLIST02);		
	} 
	var usrId=frm.usr_id.value;
	setRollBtnCtlPrevention(usrId, "btn1_Print");
    //초기 focus();
	frm.clm_prve_no.focus();
}
/**
* registering initial event 
*/
function initControl() {
	//axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
	//axon_event.addListener('keyup', 'keypressClmPrveNo', 'clm_prve_no');	
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
			        var HeadTitle1="|Seq.|File Name|Contents|ID|Date|Download|clm_file_seq|file_path|file_sav_id";
			        var headCount=ComCountHeadTitle(HeadTitle1);
		
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
		
			        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_file_dp_seq" },
			               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"file_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
			               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"file_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"file_download",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_file_seq" },
			               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_path" },
			               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_sav_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
		
			        SetEditable(0);
			        SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetShowButtonImage(1);
	                SetSheetHeight(120);


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
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				if(ComGetLenByByte(frm.clm_prve_no.value) <11){
					var msg =ComGetMsg('COM12174', "PRV No.",11);
					ComShowMessage(msg);
				}else{
				doActionIBSheet(SEARCHLIST02);			
				}
			}
			break;
		case "btn1_close":
			ComClosePopup(); 
			break;		
		case "btn1_Print":
			var clmPrveNo=frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				doActionIBSheet(PRINT);
			} 
			break;			
	    case "btn1_New":	    	
    		ComResetAll();
    		frm.clm_prve_no.value="";    		
	    	break;				
	}
}
/**
 * HTML Control KeyPress event
 */
function keypressClmPrveNo() {
 	var obj=event.srcElement;
    switch(ComGetEvent("name")) {    
    case "clm_prve_no":
    	if (obj.value.length == 11) {
    		doActionIBSheet(SEARCHLIST02);    		
    	}
    	break;
	}
}
//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj=event.srcElement;
   if(obj.dataformat == null) return;
   window.defaultStatus=obj.dataformat;
   switch(ComGetEvent("name")) {
       case "clm_prve_no":
       	ComKeyOnlyAlphabet('uppernum');
    	break;          	
   }
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} row     	sheet 선택된 row
 * @param {ibsheet} col     	sheet 선택된 col
 * @param {String} 	value     	파일명
 **/
function sheet1_OnClick(sheet,row,col,value){
	if (sheet.ColSaveName(col)!= "file_download" ||
sheet.GetRowStatus(row)=="I") {
		return;
	}
	if(sheet.GetCellText(row, "file_sav_id") == "") {
		return;
	}
	var frm1=document.form1;
	frm1.action="/opuscntr/FileDownload?key="+sheet.GetCellText(row, "file_sav_id");
	frm1.submit();
	return;
}
/**
 * 파일 다운받기 
 * The function called when OnDbClick event on Sheet1 triggered 
 * @param {ibsheet} sheetObj Mandatory HTML Tag Object   
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
 	if (sheet.ColSaveName(col)!= "file_nm" ||
sheet.GetRowStatus(row)=="I") {
 		return;
 	}
 	if(sheet.GetCellText(row, "file_sav_id") == "") {
 		return;
 	}
 	var frm1=document.form1;
 	frm1.action="/opuscntr/FileDownload?key="+sheet.GetCellText(row, "file_sav_id");
 	frm1.submit();
 	return;
 }
/**
 * Occurs when the mouse moves on the sheet <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} Button     	sheet 선택된 Button
 * @param {ibsheet} Shift     	sheet 선택된 Shift
 * @param {int} 	X     		X coordinates
 * @param {int} 	Y     		Y coordinates
 **/
function sheet1_OnMouseMove(sheet, Button, Shift, X, Y){
	var row=sheet.MouseRow();
	var col=sheet.MouseCol();
	if (row < sheet.HeaderRows()|| col < 0) {
		return;
	}
	var saveName=sheet.ColSaveName(col);
	if (saveName!= "file_nm" && saveName!="file_download") {
		return;
	}
var status=sheet.GetRowStatus(row);
	if (saveName=="file_nm") {
		sheet.SetMousePointer((status=="I")?"Hand":"Default");
	} else if (saveName=="file_download") {
		sheet.SetMousePointer((status=="I")?"Default":"Hand");
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST02) {		
		frm.f_cmd.value=SEARCHLIST02;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0023GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0 ) {
			var list=SheetXml2ListMap(arrXml[0]);			
			if (list.length == 0) {
				//msgs["CNI00013"] = "There is no related data!";
				ComShowCodeMessage("CNI00013");
				ComResetAll();
	    		frm.clm_prve_no.value="";
				frm.clm_prve_no.focus();
				return;
			}
			if (list.length > 0) {
				var vo=list[0];
				frm.clm_prve_no.value=vo["clm_prve_no"];							
				var effDt=vo["eff_dt"];
				frm.eff_dt.value=fmDate(vo["eff_dt"]);
				frm.exp_dt.value=fmDate(vo["exp_dt"]);
				frm.clm_prve_div_nm.value=vo["clm_prve_div_nm"];
				frm.cre_ofc_cd.value=vo["cre_ofc_cd"];
				frm.clm_prve_subj_nm.value=vo["clm_prve_subj_nm"];
				frm.clm_prve_desc.value=vo["clm_prve_desc"];			
				frm.cre_usr_id.value=vo["cre_usr_id"];			
				frm.clm_area_cd.value=vo["clm_area_cd"];
			}
		}
		if (arrXml.length > 1 ) {
			sheet1.LoadSearchData(arrXml[1],{Sync:1} );
		}
	} else if (sAction == PRINT) {		
		frm.f_cmd.value=PRINT;		
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0093.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
//		var rv="";
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value="Prevention-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/prevention/report/CPS_CNI_0093.mrd";
		var feature="resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}
